package com.medical.caresync.service;

import com.medical.caresync.dto.PurchaseOrderInvoicesGroupedDTO;

import com.medical.caresync.dto.WarehouseGoodsReceivedDTO;
import com.medical.caresync.dto.WarehouseGoodsReceivedItemDTO;
import com.medical.caresync.entities.WarehouseGoodsReceived;
import com.medical.caresync.entities.WarehouseGoodsReceivedItem;
import com.medical.caresync.repository.WarehouseGoodsReceivedRepository;
import com.medical.caresync.repository.WarehouseGoodsReceivedItemRepository;
import com.medical.caresync.repository.PharmacySupplierRepository;
import com.medical.caresync.repository.WarehouseMasterRepository;
import com.medical.caresync.repository.MedicineLookupNewRepository;
import com.medical.caresync.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WarehouseGoodsReceivedService {

    @Autowired
    private WarehouseGoodsReceivedRepository grnRepository;

    @Autowired
    private WarehouseGoodsReceivedItemRepository grnItemRepository;

    @Autowired
    private PharmacySupplierRepository pharmacySupplierRepository;

    @Autowired
    private WarehouseMasterRepository warehouseMasterRepository;

    @Autowired
    private MedicineLookupNewRepository medicineLookupNewRepository;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public List<WarehouseGoodsReceivedDTO> getAllGRNs() {
        return grnRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public WarehouseGoodsReceivedDTO getGRNById(Long id) {
        WarehouseGoodsReceived grn = grnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse Goods Received not found with ID: " + id));
        return convertToDTO(grn);
    }

    public List<WarehouseGoodsReceivedDTO> getInvoicesByPurchaseOrderId(Long poId) {
        return grnRepository.findByPurchaseOrderId(poId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<PurchaseOrderInvoicesGroupedDTO> getAllGroupedByPO() {
        List<WarehouseGoodsReceived> allGRNs = grnRepository.findAll();
        return allGRNs.stream()
                .collect(Collectors.groupingBy(WarehouseGoodsReceived::getPurchaseOrderId))
                .entrySet().stream()
                .map(entry -> PurchaseOrderInvoicesGroupedDTO.builder()
                        .purchaseOrderId(entry.getKey())
                        .purchaseOrderNumber(entry.getValue().get(0).getPurchaeOrderNumber())
                        .invoices(entry.getValue().stream().map(this::convertToDTO).collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    public PurchaseOrderInvoicesGroupedDTO getGroupedByPOId(Long poId) {
        List<WarehouseGoodsReceived> poGRNs = grnRepository.findByPurchaseOrderId(poId);
        if (poGRNs.isEmpty()) {
            return null;
        }
        return PurchaseOrderInvoicesGroupedDTO.builder()
                .purchaseOrderId(poId)
                .purchaseOrderNumber(poGRNs.get(0).getPurchaeOrderNumber())
                .invoices(poGRNs.stream().map(this::convertToDTO).collect(Collectors.toList()))
                .build();
    }

    public WarehouseGoodsReceivedDTO createGRN(WarehouseGoodsReceivedDTO grnDTO) {
        WarehouseGoodsReceived grn = convertToEntity(grnDTO);
        grn.setCreatedBy(grnDTO.getReceivedBy()); 
        
        WarehouseGoodsReceived savedGRN = grnRepository.save(grn);
        return convertToDTO(savedGRN);
    }

    public WarehouseGoodsReceivedDTO updateGRN(Long id, WarehouseGoodsReceivedDTO grnDTO) {
        WarehouseGoodsReceived existingGRN = grnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse Goods Received not found with ID: " + id));

        // Update Header fields
        existingGRN.setWarehouseGoodsReceivedNumber(grnDTO.getWarehouseGoodsReceivedNumber());
        existingGRN.setPurchaseOrderId(grnDTO.getPurchaseOrderId());
        existingGRN.setPurchaeOrderNumber(grnDTO.getPurchaeOrderNumber());
        existingGRN.setPharmacySupplierInvoiceNumber(grnDTO.getPharmacySupplierInvoiceNumber());
        existingGRN.setInvoiceDate(grnDTO.getInvoiceDate());
        existingGRN.setPharmacySupplierId(grnDTO.getPharmacySupplierId());
        existingGRN.setReceivedDate(grnDTO.getReceivedDate());
        existingGRN.setReceivedBy(grnDTO.getReceivedBy());
        existingGRN.setWarehouseId(grnDTO.getWarehouseId());
        existingGRN.setTransportMode(grnDTO.getTransportMode());
        existingGRN.setVehicleNumber(grnDTO.getVehicleNumber());
        existingGRN.setReceivedFrom(grnDTO.getReceivedFrom());
        existingGRN.setOverallCondition(grnDTO.getOverallCondition());
        existingGRN.setCgstPercent(grnDTO.getCgstPercent());
        existingGRN.setSgstPercent(grnDTO.getSgstPercent());
        existingGRN.setDiscountAmount(grnDTO.getDiscountAmount());
        existingGRN.setTotalAmount(grnDTO.getTotalAmount());
        existingGRN.setPayableAmount(grnDTO.getPayableAmount());
        existingGRN.setPaidAmount(grnDTO.getPaidAmount());
        existingGRN.setAmountDue(grnDTO.getAmountDue());
        existingGRN.setPaymentStatus(grnDTO.getPaymentStatus());
        existingGRN.setUpdatedBy(grnDTO.getReceivedBy());
        existingGRN.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        // Update Items
        existingGRN.getItems().clear();
        if (grnDTO.getItems() != null) {
            for (WarehouseGoodsReceivedItemDTO itemDTO : grnDTO.getItems()) {
                WarehouseGoodsReceivedItem item = convertToEntity(itemDTO);
                item.setWarehouseGoodsReceived(existingGRN);
                item.setCreatedBy(existingGRN.getCreatedBy());
                existingGRN.getItems().add(item);
            }
        }

        WarehouseGoodsReceived savedGRN = grnRepository.save(existingGRN);
        return convertToDTO(savedGRN);
    }

    public void deleteGRN(Long id) {
        if (!grnRepository.existsById(id)) {
            throw new RuntimeException("Warehouse Goods Received not found with ID: " + id);
        }
        grnRepository.deleteById(id);
    }

    // Helper methods for DTO <-> Entity conversion
    private WarehouseGoodsReceivedDTO convertToDTO(WarehouseGoodsReceived entity) {
        WarehouseGoodsReceivedDTO dto = WarehouseGoodsReceivedDTO.builder()
                .warehouseGoodsReceivedId(entity.getWarehouseGoodsReceivedId())
                .warehouseGoodsReceivedNumber(entity.getWarehouseGoodsReceivedNumber())
                .purchaseOrderId(entity.getPurchaseOrderId())
                .purchaeOrderNumber(entity.getPurchaeOrderNumber())
                .purchaseOrderDate(entity.getPurchaseOrderId() != null 
                    ? purchaseOrderRepository.findById(entity.getPurchaseOrderId()).map(po -> po.getPurchaseOrderDate()).orElse(null) 
                    : null)
                .pharmacySupplierInvoiceNumber(entity.getPharmacySupplierInvoiceNumber())
                .invoiceDate(entity.getInvoiceDate())
                .pharmacySupplierId(entity.getPharmacySupplierId())
                .receivedDate(entity.getReceivedDate())
                .receivedBy(entity.getReceivedBy())
                .warehouseId(entity.getWarehouseId())
                .transportMode(entity.getTransportMode())
                .vehicleNumber(entity.getVehicleNumber())
                .receivedFrom(entity.getReceivedFrom())
                .overallCondition(entity.getOverallCondition())
                .cgstPercent(entity.getCgstPercent())
                .sgstPercent(entity.getSgstPercent())
                .discountAmount(entity.getDiscountAmount())
                .totalAmount(entity.getTotalAmount())
                .payableAmount(entity.getPayableAmount())
                .paidAmount(entity.getPaidAmount())
                .amountDue(entity.getAmountDue())
                .paymentStatus(entity.getPaymentStatus())
                .pharmacySupplierName(entity.getPharmacySupplierId() != null 
                    ? pharmacySupplierRepository.findById(entity.getPharmacySupplierId()).map(s -> s.getSupplierName()).orElse(null) 
                    : null)
                .warehouseName(entity.getWarehouseId() != null 
                    ? warehouseMasterRepository.findById(entity.getWarehouseId()).map(w -> w.getWarehouseName()).orElse(null) 
                    : null)
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .updatedAt(entity.getUpdatedAt())
                .updatedBy(entity.getUpdatedBy())
                .build();

        if (entity.getItems() != null) {
            dto.setItems(entity.getItems().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    private WarehouseGoodsReceivedItemDTO convertToDTO(WarehouseGoodsReceivedItem entity) {
        return WarehouseGoodsReceivedItemDTO.builder()
                .warehouseGoodsReceivedItemId(entity.getWarehouseGoodsReceivedItemId())
                .medicationId(entity.getMedicationId())
                .medicationName(entity.getMedicationName())
                .medicationCode(entity.getMedicationId() != null 
                    ? medicineLookupNewRepository.findById(entity.getMedicationId()).map(m -> m.getMedicationCode()).orElse(null) 
                    : null)
                .medicineType(entity.getMedicationId() != null 
                    ? medicineLookupNewRepository.findById(entity.getMedicationId()).map(m -> m.getMedicineType()).orElse(null) 
                    : null)
                .batchNumber(entity.getBatchNumber())
                .mfgDate(entity.getMfgDate())
                .expiryDate(entity.getExpiryDate())
                .storageType(entity.getStorageType())
                .orderedQty(entity.getOrderedQty())
                .receivedQty(entity.getReceivedQty())
                .damagedQty(entity.getDamagedQty())
                .unitPrice(entity.getUnitPrice())
                .mrp(entity.getMrp())
                .qcStatus(entity.getQcStatus())
                .remarks(entity.getRemarks())
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .updatedAt(entity.getUpdatedAt())
                .updatedBy(entity.getUpdatedBy())
                .build();
    }

    private WarehouseGoodsReceived convertToEntity(WarehouseGoodsReceivedDTO dto) {
        WarehouseGoodsReceived entity = WarehouseGoodsReceived.builder()
                .warehouseGoodsReceivedNumber(dto.getWarehouseGoodsReceivedNumber())
                .purchaseOrderId(dto.getPurchaseOrderId())
                .purchaeOrderNumber(dto.getPurchaeOrderNumber())
                .pharmacySupplierInvoiceNumber(dto.getPharmacySupplierInvoiceNumber())
                .invoiceDate(dto.getInvoiceDate())
                .pharmacySupplierId(dto.getPharmacySupplierId())
                .receivedDate(dto.getReceivedDate())
                .receivedBy(dto.getReceivedBy())
                .warehouseId(dto.getWarehouseId())
                .transportMode(dto.getTransportMode())
                .vehicleNumber(dto.getVehicleNumber())
                .receivedFrom(dto.getReceivedFrom())
                .overallCondition(dto.getOverallCondition())
                .cgstPercent(dto.getCgstPercent())
                .sgstPercent(dto.getSgstPercent())
                .discountAmount(dto.getDiscountAmount())
                .totalAmount(dto.getTotalAmount())
                .payableAmount(dto.getPayableAmount())
                .paidAmount(dto.getPaidAmount())
                .amountDue(dto.getAmountDue())
                .paymentStatus(dto.getPaymentStatus())
                .items(new ArrayList<>())
                .build();

        if (dto.getItems() != null) {
            for (WarehouseGoodsReceivedItemDTO itemDTO : dto.getItems()) {
                WarehouseGoodsReceivedItem item = convertToEntity(itemDTO);
                item.setWarehouseGoodsReceived(entity);
                entity.getItems().add(item);
            }
        }
        return entity;
    }

    private WarehouseGoodsReceivedItem convertToEntity(WarehouseGoodsReceivedItemDTO dto) {
        return WarehouseGoodsReceivedItem.builder()
                .medicationId(dto.getMedicationId())
                .medicationName(dto.getMedicationName())
                .batchNumber(dto.getBatchNumber())
                .mfgDate(dto.getMfgDate())
                .expiryDate(dto.getExpiryDate())
                .storageType(dto.getStorageType())
                .orderedQty(dto.getOrderedQty())
                .receivedQty(dto.getReceivedQty())
                .damagedQty(dto.getDamagedQty())
                .unitPrice(dto.getUnitPrice())
                .mrp(dto.getMrp())
                .qcStatus(dto.getQcStatus())
                .remarks(dto.getRemarks())
                .build();
    }
}
