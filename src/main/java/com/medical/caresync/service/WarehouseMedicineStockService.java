package com.medical.caresync.service;

import com.medical.caresync.dto.WarehouseMedicineStockSummaryDTO;
import com.medical.caresync.entities.WarehouseMedicineStock;
import com.medical.caresync.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseMedicineStockService {

    @Autowired
    private WarehouseMedicineStockRepository stockRepository;

    @Autowired
    private MedicineLookupNewRepository medicineRepository;

    @Autowired
    private WarehouseMasterRepository warehouseRepository;

    @Autowired
    private PharmacySupplierRepository supplierRepository;

    @Autowired
    private WarehouseMedicineLevelRepository levelRepository;

    public List<WarehouseMedicineStockSummaryDTO> getStockSummaryByWarehouseId(Long warehouseId) {
        List<WarehouseMedicineStock> stocks = stockRepository.findByWarehouseId(warehouseId);
        String warehouseName = warehouseRepository.findById(warehouseId).map(w -> w.getWarehouseName()).orElse("Unknown Warehouse");

        // Group by medicationId to handle summing and supplier extraction
        return stocks.stream()
                .collect(Collectors.groupingBy(WarehouseMedicineStock::getMedicationId))
                .entrySet().stream()
                .map(mapEntry -> {
                    Long medId = mapEntry.getKey();
                    List<WarehouseMedicineStock> medStocks = mapEntry.getValue();
                    
                    Long totalQty = medStocks.stream().mapToLong(WarehouseMedicineStock::getQuantity).sum();
                    
                    // Take Supplier from the actual stock records (taking first one in list for summary)
                    Long actualSupplierId = medStocks.get(0).getPharmacySupplierId();

                    WarehouseMedicineStockSummaryDTO.WarehouseMedicineStockSummaryDTOBuilder builder = WarehouseMedicineStockSummaryDTO.builder()
                            .medicationId(medId)
                            .totalQuantity(totalQty)
                            .pharmacySupplierId(actualSupplierId)
                            .warehouseName(warehouseName);

                    // Fetch Master Data
                    medicineRepository.findById(medId).ifPresent(med -> {
                        builder.medicationName(med.getMedicationName())
                                .medicationCode(med.getMedicationCode())
                                .medicineType(med.getMedicineType());
                    });

                    // Fetch Supplier Name
                    if (actualSupplierId != null) {
                        supplierRepository.findById(actualSupplierId).ifPresent(s -> {
                            builder.preferredSupplierName(s.getSupplierName());
                        });
                    }

                    // Fetch Min/Max Levels (Only for Min/Max, NOT for supplier)
                    levelRepository.findByWarehouseIdAndMedicationId(warehouseId, medId).ifPresent(level -> {
                        builder.minStockLevel(level.getMinStockQuantity())
                                .maxStockLevel(level.getMaxStockQuantity());
                    });

                    return builder.build();
                })
                .collect(Collectors.toList());
    }
}
