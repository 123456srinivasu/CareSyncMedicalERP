package com.medical.caresync.service;

import com.medical.caresync.dto.MedicinesDTO;
import com.medical.caresync.dto.PharmacySupplierDTO;
import com.medical.caresync.dto.PurchaseOrderDTO;
import com.medical.caresync.dto.PurchaseOrderDeliveryAddressDTO;
import com.medical.caresync.dto.PurchaseOrderItemDTO;
import com.medical.caresync.dto.WarehouseMasterDTO;
import com.medical.caresync.entities.PharmacySupplier;
import com.medical.caresync.entities.PurchaseOrder;
import com.medical.caresync.entities.PurchaseOrderDeliveryAddress;
import com.medical.caresync.entities.PurchaseOrderItem;
import com.medical.caresync.entities.WarehouseMaster;
import com.medical.caresync.repository.PharmacySupplierRepository;
import com.medical.caresync.repository.PurchaseOrderRepository;
import com.medical.caresync.entities.Medicines;
import com.medical.caresync.repository.WarehouseMasterRepository;
import com.medical.caresync.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private PharmacySupplierRepository pharmacySupplierRepository;

    @Autowired
    private WarehouseMasterRepository warehouseMasterRepository;

    @Autowired
    private MedicinesRepository medicinesRepository;

    @Transactional
    public PurchaseOrderDTO createOrder(PurchaseOrderDTO dto) {
        PurchaseOrder order = new PurchaseOrder();
        
        // Map header
        order.setRawSupplierId(dto.getSupplierId());
        order.setRawWarehouseId(dto.getWarehouseId());
        
        // Lookup entities for relationship
        if (dto.getSupplierId() != null) {
            pharmacySupplierRepository.findById(dto.getSupplierId()).ifPresent(order::setSupplier);
        }
        if (dto.getWarehouseId() != null) {
            warehouseMasterRepository.findById(dto.getWarehouseId()).ifPresent(order::setWarehouse);
        }
        
        LocalDateTime poDate = parseDateTime(dto.getPurchaseOrderDate());
        order.setPurchaseOrderDate(poDate != null ? poDate : LocalDateTime.now());
        order.setExpectedDeliveryDate(dto.getExpectedDeliveryDate());
        order.setPriority(dto.getPriority());
        order.setOrderStatus(dto.getOrderStatus());
        order.setRemarks(dto.getRemarks());
        order.setPaymentTerms(dto.getPaymentTerms());
        order.setPurchaseOrderNumber(dto.getPurchaseOrderNumber());
        
        // Map metadata
        order.setCreatedBy(dto.getCreatedBy() != null ? dto.getCreatedBy() : "Admin");
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedBy(dto.getCreatedBy());

        // Map delivery address
        if (dto.getDeliveryAddress() != null) {
            PurchaseOrderDeliveryAddress addr = new PurchaseOrderDeliveryAddress();
            mapAddressDtoToEntity(dto.getDeliveryAddress(), addr);
            addr.setCreatedBy(order.getCreatedBy());
            addr.setCreatedAt(order.getCreatedAt());
            order.setDeliveryAddress(addr);
        }

        // Map items
        if (dto.getItems() != null) {
            for (PurchaseOrderItemDTO itemDto : dto.getItems()) {
                PurchaseOrderItem item = new PurchaseOrderItem();
                item.setMedicineId(itemDto.getMedicineId());
                item.setRequestedQuantity(itemDto.getRequestedQuantity());
                item.setCreatedBy(order.getCreatedBy());
                item.setCreatedAt(order.getCreatedAt());
                order.addItem(item);
            }
        }

        // Save
        PurchaseOrder savedOrder = purchaseOrderRepository.save(order);
        
        // Return mapped DTO
        return mapToDTO(savedOrder);
    }

    @Transactional
    public PurchaseOrderDTO updateOrder(Long id, PurchaseOrderDTO dto) {
        PurchaseOrder order = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase Order not found: " + id));
        
        // Update header fields
        order.setRawSupplierId(dto.getSupplierId());
        order.setRawWarehouseId(dto.getWarehouseId());

        if (dto.getSupplierId() != null) {
            pharmacySupplierRepository.findById(dto.getSupplierId()).ifPresent(order::setSupplier);
        }
        if (dto.getWarehouseId() != null) {
            warehouseMasterRepository.findById(dto.getWarehouseId()).ifPresent(order::setWarehouse);
        }
        
        LocalDateTime poDate = parseDateTime(dto.getPurchaseOrderDate());
        if (poDate != null) {
            order.setPurchaseOrderDate(poDate);
        }
        order.setExpectedDeliveryDate(dto.getExpectedDeliveryDate());
        order.setPriority(dto.getPriority());
        order.setOrderStatus(dto.getOrderStatus());
        order.setRemarks(dto.getRemarks());
        order.setPaymentTerms(dto.getPaymentTerms());
        order.setPurchaseOrderNumber(dto.getPurchaseOrderNumber());
        order.setUpdatedBy(dto.getUpdatedBy() != null ? dto.getUpdatedBy() : "Admin");

        // Update Delivery Address
        if (dto.getDeliveryAddress() != null) {
            if (order.getDeliveryAddress() == null) {
                order.setDeliveryAddress(new PurchaseOrderDeliveryAddress());
                order.getDeliveryAddress().setCreatedAt(LocalDateTime.now());
                order.getDeliveryAddress().setCreatedBy(order.getUpdatedBy());
            }
            mapAddressDtoToEntity(dto.getDeliveryAddress(), order.getDeliveryAddress());
            order.getDeliveryAddress().setUpdatedBy(order.getUpdatedBy());
        }

        // Update Items (Simple clear and re-add for this implementation)
        if (dto.getItems() != null) {
            order.getItems().clear();
            for (PurchaseOrderItemDTO itemDto : dto.getItems()) {
                PurchaseOrderItem item = new PurchaseOrderItem();
                item.setMedicineId(itemDto.getMedicineId());
                item.setRequestedQuantity(itemDto.getRequestedQuantity());
                item.setCreatedBy(order.getUpdatedBy());
                item.setCreatedAt(LocalDateTime.now());
                order.addItem(item);
            }
        }

        PurchaseOrder savedOrder = purchaseOrderRepository.save(order);
        return mapToDTO(savedOrder);
    }

    public PurchaseOrderDTO getOrderById(Long id) {
        PurchaseOrder order = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase Order not found: " + id));
        return mapToDTO(order);
    }

    public List<PurchaseOrderDTO> getAllOrders(Long warehouseId) {
        List<PurchaseOrder> orders;
        if (warehouseId != null) {
            orders = purchaseOrderRepository.findByRawWarehouseId(warehouseId);
        } else {
            orders = purchaseOrderRepository.findAll();
        }
        return orders.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private void mapAddressDtoToEntity(PurchaseOrderDeliveryAddressDTO dto, PurchaseOrderDeliveryAddress entity) {
        entity.setStateId(dto.getStateId());
        entity.setDistrictId(dto.getDistrictId());
        entity.setMandalId(dto.getMandalId());
        entity.setCity(dto.getCity());
        entity.setZipCode(dto.getZipCode());
        entity.setAddressLine1(dto.getAddressLine1());
        entity.setAddressLine2(dto.getAddressLine2());
    }

    private PurchaseOrderDTO mapToDTO(PurchaseOrder entity) {
        PurchaseOrderDTO dto = new PurchaseOrderDTO();
        dto.setPurchaseOrderId(entity.getPurchaseOrderId());
        dto.setSupplierId(entity.getRawSupplierId());
        dto.setWarehouseId(entity.getRawWarehouseId());
        
        if (entity.getSupplier() != null) {
            PharmacySupplierDTO supplierDto = new PharmacySupplierDTO();
            supplierDto.setPharmacySupplierId(entity.getSupplier().getPharmacySupplierId());
            supplierDto.setSupplierCode(entity.getSupplier().getSupplierCode());
            supplierDto.setSupplierName(entity.getSupplier().getSupplierName());
            supplierDto.setContactName(entity.getSupplier().getContactName());
            supplierDto.setContactEmail(entity.getSupplier().getContactEmail());
            supplierDto.setStreet(entity.getSupplier().getStreet());
            supplierDto.setCity(entity.getSupplier().getCity());
            supplierDto.setState(entity.getSupplier().getState());
            supplierDto.setPincode(entity.getSupplier().getPincode());
            supplierDto.setIsActive(entity.getSupplier().getIsActive());
            dto.setSupplier(supplierDto);
        }
        
        if (entity.getWarehouse() != null) {
            WarehouseMasterDTO warehouseDto = new WarehouseMasterDTO();
            warehouseDto.setId(entity.getWarehouse().getId());
            warehouseDto.setWarehouseCode(entity.getWarehouse().getWarehouseCode());
            warehouseDto.setWarehouseName(entity.getWarehouse().getWarehouseName());
            warehouseDto.setAddress(entity.getWarehouse().getAddress());
            warehouseDto.setCity(entity.getWarehouse().getCity());
            warehouseDto.setPostalCode(entity.getWarehouse().getPostalCode());
            warehouseDto.setContactPerson(entity.getWarehouse().getContactPerson());
            warehouseDto.setContactNumber(entity.getWarehouse().getContactNumber());
            warehouseDto.setEmailAddress(entity.getWarehouse().getEmailAddress());
            warehouseDto.setIsActive(entity.getWarehouse().getIsActive());
            
            if (entity.getWarehouse().getState() != null) {
                warehouseDto.setStateId(entity.getWarehouse().getState().getStateLookupId().longValue());
                warehouseDto.setStateName(entity.getWarehouse().getState().getStateName());
            }
            if (entity.getWarehouse().getDistrict() != null) {
                warehouseDto.setDistrictId(entity.getWarehouse().getDistrict().getDistrictLookupId().longValue());
                warehouseDto.setDistrictName(entity.getWarehouse().getDistrict().getDistrictName());
            }
            if (entity.getWarehouse().getMandal() != null) {
                warehouseDto.setMandalId(entity.getWarehouse().getMandal().getMandalLookupId().longValue());
                warehouseDto.setMandalName(entity.getWarehouse().getMandal().getMandalName());
            }
            
            dto.setWarehouse(warehouseDto);
        }
        
        dto.setPurchaseOrderDate(entity.getPurchaseOrderDate() != null ? entity.getPurchaseOrderDate().toString() : null);
        dto.setExpectedDeliveryDate(entity.getExpectedDeliveryDate());
        dto.setPriority(entity.getPriority());
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setRemarks(entity.getRemarks());
        dto.setPaymentTerms(entity.getPaymentTerms());
        dto.setPurchaseOrderNumber(entity.getPurchaseOrderNumber());
        
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedAt(entity.getCreatedAt() != null ? entity.getCreatedAt().toString() : null);
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt() != null ? entity.getUpdatedAt().toString() : null);
        
        if (entity.getDeliveryAddress() != null) {
            PurchaseOrderDeliveryAddressDTO addrDto = new PurchaseOrderDeliveryAddressDTO();
            PurchaseOrderDeliveryAddress addr = entity.getDeliveryAddress();
            addrDto.setDeliveryAddressId(addr.getDeliveryAddressId());
            addrDto.setStateId(addr.getStateId());
            addrDto.setDistrictId(addr.getDistrictId());
            addrDto.setMandalId(addr.getMandalId());
            addrDto.setCity(addr.getCity());
            addrDto.setZipCode(addr.getZipCode());
            addrDto.setAddressLine1(addr.getAddressLine1());
            addrDto.setAddressLine2(addr.getAddressLine2());
            dto.setDeliveryAddress(addrDto);
        }

        if (entity.getItems() != null) {
            dto.setItems(entity.getItems().stream()
                .map(item -> {
                    PurchaseOrderItemDTO itemDto = new PurchaseOrderItemDTO();
                    itemDto.setPurchaseOrderItemId(item.getPurchaseOrderItemId());
                    itemDto.setMedicineId(item.getMedicineId());
                    itemDto.setRequestedQuantity(item.getRequestedQuantity());
                    
                    if (item.getMedicines() != null) {
                        Medicines m = item.getMedicines();
                        MedicinesDTO mDto = new MedicinesDTO();
                        mDto.setId(m.getId());
                        mDto.setMedicationName(m.getMedicationName());
                        mDto.setMedicationCode(m.getMedicationCode());
                        mDto.setMedicineType(m.getMedicineType());
                        mDto.setIsActive(m.getIsActive());
                        itemDto.setMedicine(mDto);
                    }
                    
                    return itemDto;
                })
                .collect(Collectors.toList()));
        }
        
        return dto;
    }

    private LocalDateTime parseDateTime(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }
        try {
            // If it's just a date (yyyy-MM-dd)
            if (dateStr.length() == 10) {
                return LocalDate.parse(dateStr).atStartOfDay();
            }
            // If it has 'Z' or offset, use OffsetDateTime
            if (dateStr.contains("Z") || dateStr.contains("+") || (dateStr.lastIndexOf("-") > 7)) {
                try {
                    return OffsetDateTime.parse(dateStr).toLocalDateTime();
                } catch (Exception e) {
                    // fall back to ISO_DATE_TIME
                }
            }
            // Standard ISO format
            return LocalDateTime.parse(dateStr.replace(" ", "T"));
        } catch (Exception e) {
            return null;
        }
    }
}
