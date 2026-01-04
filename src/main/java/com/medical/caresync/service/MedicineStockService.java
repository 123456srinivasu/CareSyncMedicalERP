package com.medical.caresync.service;

import com.medical.caresync.entities.MedicineStock;
import com.medical.caresync.entities.MedicineLookupNew;
import com.medical.caresync.entities.Invoice;
import com.medical.caresync.entities.Camps;
import com.medical.caresync.entities.CampMedicineStockSummary;
import com.medical.caresync.repository.MedicineStockRepository;
import com.medical.caresync.repository.MedicineLookupNewRepository;
import com.medical.caresync.repository.InvoiceRepository;
import com.medical.caresync.repository.CampsRepository;
import com.medical.caresync.repository.CampMedicineStockSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MedicineStockService {

    @Autowired
    private MedicineStockRepository repository;

    @Autowired
    private MedicineLookupNewRepository medicationRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CampsRepository campsRepository;

    @Autowired
    private CampMedicineStockSummaryRepository summaryRepository;

    public List<MedicineStock> getAllStocks() {
        return repository.findAll();
    }

    public Optional<MedicineStock> getStockById(Long id) {
        return repository.findById(id);
    }

    public List<MedicineStock> getStocksByMedication(Long medicationId) {
        return repository.findByMedication_MedicationId(medicationId);
    }

    public List<MedicineStock> getStocksByInvoice(Long invoiceId) {
        return repository.findByInvoice_InvoiceId(invoiceId);
    }

    public List<MedicineStock> getStocksByCamp(Long campId) {
        return repository.findByCamp_CampId(campId);
    }

    @Transactional
    public MedicineStock createStock(MedicineStock stock) {
        // Validate that medication exists
        if (stock.getMedication() == null || stock.getMedication().getMedicationId() == null) {
            throw new IllegalArgumentException("Medication is required");
        }
        Optional<MedicineLookupNew> medication = medicationRepository
            .findById(stock.getMedication().getMedicationId());
        if (medication.isEmpty()) {
            throw new IllegalArgumentException("Medication not found with id: " 
                + stock.getMedication().getMedicationId());
        }

        // Validate that invoice exists
        if (stock.getInvoice() == null || stock.getInvoice().getInvoiceId() == null) {
            throw new IllegalArgumentException("Invoice is required");
        }
        Optional<Invoice> invoice = invoiceRepository.findById(stock.getInvoice().getInvoiceId());
        if (invoice.isEmpty()) {
            throw new IllegalArgumentException("Invoice not found with id: " 
                + stock.getInvoice().getInvoiceId());
        }

        // Validate that camp exists
        if (stock.getCamp() == null || stock.getCamp().getCampId() == null) {
            throw new IllegalArgumentException("Camp is required");
        }
        Optional<Camps> camp = campsRepository.findById(stock.getCamp().getCampId());
        if (camp.isEmpty()) {
            throw new IllegalArgumentException("Camp not found with id: " 
                + stock.getCamp().getCampId());
        }

        // Check unique constraint: batch_number, medication_id, invoice_id
        if (stock.getBatchNumber() != null) {
            Optional<MedicineStock> existing = repository
                .findByBatchNumberAndMedication_MedicationIdAndInvoice_InvoiceId(
                    stock.getBatchNumber(), 
                    medication.get().getMedicationId(), 
                    invoice.get().getInvoiceId());
            if (existing.isPresent()) {
                throw new IllegalArgumentException("Stock with batch number '" + stock.getBatchNumber() 
                    + "' already exists for this medication and invoice combination");
            }
        }

        // Set defaults
        if (stock.getIsActive() == null) {
            stock.setIsActive(true);
        }
        if (stock.getCreatedAt() == null) {
            stock.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }
        if (stock.getUpdatedAt() == null) {
            stock.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        }

        // Set the related entities
        stock.setMedication(medication.get());
        stock.setInvoice(invoice.get());
        stock.setCamp(camp.get());

        MedicineStock savedStock = repository.save(stock);
        
        // Update camp medicine stock summary quantity
        updateCampMedicineStockSummary(camp.get().getCampId(), medication.get().getMedicationId());
        
        return savedStock;
    }

    @Transactional
    public MedicineStock updateStock(Long id, MedicineStock stockDetails) {
        Optional<MedicineStock> optionalStock = repository.findById(id);
        if (optionalStock.isPresent()) {
            MedicineStock stock = optionalStock.get();

            // Update batch number if provided and different
            if (stockDetails.getBatchNumber() != null && 
                !stockDetails.getBatchNumber().equals(stock.getBatchNumber())) {
                // Check unique constraint if batch number is being changed
                Optional<MedicineStock> existing = repository
                    .findByBatchNumberAndMedication_MedicationIdAndInvoice_InvoiceId(
                        stockDetails.getBatchNumber(),
                        stock.getMedication().getMedicationId(),
                        stock.getInvoice().getInvoiceId());
                if (existing.isPresent() && !existing.get().getMedicineStockId().equals(id)) {
                    throw new IllegalArgumentException("Stock with batch number '" 
                        + stockDetails.getBatchNumber() 
                        + "' already exists for this medication and invoice combination");
                }
                stock.setBatchNumber(stockDetails.getBatchNumber());
            }

            stock.setHsnCode(stockDetails.getHsnCode());
            stock.setManufacturingDate(stockDetails.getManufacturingDate());
            stock.setExpiryDate(stockDetails.getExpiryDate());
            stock.setQuantity(stockDetails.getQuantity());
            stock.setIsActive(stockDetails.getIsActive());
            stock.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            stock.setUpdatedBy(stockDetails.getUpdatedBy());

            // Update medication if provided
            if (stockDetails.getMedication() != null && 
                stockDetails.getMedication().getMedicationId() != null) {
                Optional<MedicineLookupNew> medication = medicationRepository
                    .findById(stockDetails.getMedication().getMedicationId());
                if (medication.isPresent()) {
                    stock.setMedication(medication.get());
                } else {
                    throw new IllegalArgumentException("Medication not found with id: " 
                        + stockDetails.getMedication().getMedicationId());
                }
            }

            // Update invoice if provided
            if (stockDetails.getInvoice() != null && 
                stockDetails.getInvoice().getInvoiceId() != null) {
                Optional<Invoice> invoice = invoiceRepository
                    .findById(stockDetails.getInvoice().getInvoiceId());
                if (invoice.isPresent()) {
                    stock.setInvoice(invoice.get());
                } else {
                    throw new IllegalArgumentException("Invoice not found with id: " 
                        + stockDetails.getInvoice().getInvoiceId());
                }
            }

            // Update camp if provided
            if (stockDetails.getCamp() != null && 
                stockDetails.getCamp().getCampId() != null) {
                Optional<Camps> camp = campsRepository.findById(stockDetails.getCamp().getCampId());
                if (camp.isPresent()) {
                    stock.setCamp(camp.get());
                } else {
                    throw new IllegalArgumentException("Camp not found with id: " 
                        + stockDetails.getCamp().getCampId());
                }
            }

            return repository.save(stock);
        }
        return null;
    }

    @Transactional
    public void deleteStock(Long id) {
        repository.deleteById(id);
    }

    public List<MedicineStock> getActiveStocks() {
        return repository.findAll().stream()
                .filter(stock -> Boolean.TRUE.equals(stock.getIsActive()))
                .toList();
    }

    @Transactional
    public List<MedicineStock> createStocks(List<MedicineStock> stocks) {
        List<MedicineStock> savedStocks = new java.util.ArrayList<>();
        for (MedicineStock stock : stocks) {
            MedicineStock savedStock = createStock(stock);
            savedStocks.add(savedStock);
            // updateCampMedicineStockSummary is already called in createStock
        }
        return savedStocks;
    }

    /**
     * Updates the quantity in camp_medicine_stock_summary for the given camp and medication.
     * Creates a new summary record if it doesn't exist.
     */
    @Transactional
    private void updateCampMedicineStockSummary(Long campId, Long medicationId) {
        // Find existing summary or create new one
        Optional<CampMedicineStockSummary> summaryOpt = summaryRepository
            .findByCamps_CampIdAndMedicineLookupNew_MedicationId(campId, medicationId);
        
        CampMedicineStockSummary summary;
        if (summaryOpt.isPresent()) {
            summary = summaryOpt.get();
        } else {
            // Create new summary
            Optional<Camps> camp = campsRepository.findById(campId);
            Optional<MedicineLookupNew> medication = medicationRepository.findById(medicationId);
            
            if (camp.isEmpty() || medication.isEmpty()) {
                return; // Skip if entities don't exist
            }
            
            summary = new CampMedicineStockSummary();
            summary.setCamps(camp.get());
            summary.setMedicineLookupNew(medication.get());
        }
        
        // Calculate total quantity from all active stocks for this camp and medication
        List<MedicineStock> stocks = repository.findAll().stream()
            .filter(s -> s.getCamp() != null && s.getCamp().getCampId().equals(campId))
            .filter(s -> s.getMedication() != null && s.getMedication().getMedicationId().equals(medicationId))
            .filter(s -> Boolean.TRUE.equals(s.getIsActive()))
            .toList();
        
        int totalQuantity = stocks.stream()
            .mapToInt(s -> s.getQuantity() != null ? s.getQuantity() : 0)
            .sum();
        
        summary.setQuantity(totalQuantity);
        summaryRepository.save(summary);
    }
}

