package com.medical.caresync.service;

import com.medical.caresync.dto.WarehouseCampMedicineOrderDTO;
import com.medical.caresync.dto.WarehouseCampMedicineOrderItemDTO;
import com.medical.caresync.entities.WarehouseCampMedicineOrder;
import com.medical.caresync.entities.WarehouseCampMedicineOrderItem;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.repository.CampsRepository;
import com.medical.caresync.repository.MedicineLookupNewRepository;
import com.medical.caresync.repository.WarehouseCampMedicineOrderItemRepository;
import com.medical.caresync.repository.WarehouseCampMedicineOrderRepository;
import com.medical.caresync.repository.WarehouseMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WarehouseCampMedicineOrderService {

    @Autowired
    private WarehouseCampMedicineOrderRepository orderRepository;

    @Autowired
    private WarehouseCampMedicineOrderItemRepository itemRepository;

    @Autowired
    private WarehouseMasterRepository warehouseRepository;

    @Autowired
    private CampsRepository campsRepository;

    @Autowired
    private MedicineLookupNewRepository medicineRepository;

    public WarehouseCampMedicineOrderDTO createOrder(WarehouseCampMedicineOrderDTO dto) {
        WarehouseCampMedicineOrder order = WarehouseCampMedicineOrder.builder()
                .warehouseCampOrderNumber(generateOrderNumber())
                .warehouseId(dto.getWarehouseId())
                .campId(dto.getCampId())
                .orderDate(dto.getOrderDate() != null ? dto.getOrderDate() : LocalDate.now())
                .expectedDeliveryDate(dto.getExpectedDeliveryDate())
                .priority(dto.getPriority())
                .orderStatus("PENDING")
                .paymentTerms(dto.getPaymentTerms())
                .remarks(dto.getRemarks())
                .build();
        
        order.setCreatedBy(dto.getCreatedBy() != null ? dto.getCreatedBy() : "ADMIN");

        final WarehouseCampMedicineOrder savedOrder = orderRepository.save(order);

        if (dto.getItems() != null) {
            List<WarehouseCampMedicineOrderItem> items = dto.getItems().stream().map(itemDto -> {
                return WarehouseCampMedicineOrderItem.builder()
                        .warehouseCampMedicineOrder(savedOrder)
                        .medicationId(itemDto.getMedicationId())
                        .medicationName(itemDto.getMedicationName())
                        .batchNumber(itemDto.getBatchNumber())
                        .requestedQuantity(itemDto.getRequestedQuantity())
                        .suppliedQuantity(0)
                        .availableAtRequest(itemDto.getAvailableAtRequest())
                        .expiryDate(itemDto.getExpiryDate())
                        .build();
            }).collect(Collectors.toList());
            itemRepository.saveAll(items);
            savedOrder.setItems(items);
        }

        return mapToDTO(savedOrder);
    }

    public List<WarehouseCampMedicineOrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public WarehouseCampMedicineOrderDTO getOrderById(Long id) {
        WarehouseCampMedicineOrder order = orderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Order not found with id: " + id));
        return mapToDTO(order);
    }

    @Transactional
    public WarehouseCampMedicineOrderDTO updateOrder(Long id, WarehouseCampMedicineOrderDTO dto) {
        WarehouseCampMedicineOrder existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Order not found with id: " + id));

        // Update Header fields
        existingOrder.setOrderDate(dto.getOrderDate() != null ? dto.getOrderDate() : existingOrder.getOrderDate());
        existingOrder.setExpectedDeliveryDate(dto.getExpectedDeliveryDate());
        existingOrder.setPriority(dto.getPriority());
        existingOrder.setPaymentTerms(dto.getPaymentTerms());
        existingOrder.setRemarks(dto.getRemarks());
        existingOrder.setUpdatedBy(dto.getUpdatedBy() != null ? dto.getUpdatedBy() : "ADMIN");

        // Clear existing items and re-add new ones
        existingOrder.getItems().clear();
        
        if (dto.getItems() != null) {
            List<WarehouseCampMedicineOrderItem> newItems = dto.getItems().stream().map(itemDto -> {
                WarehouseCampMedicineOrderItem item = new WarehouseCampMedicineOrderItem();
                item.setWarehouseCampMedicineOrder(existingOrder);
                item.setMedicationId(itemDto.getMedicationId());
                item.setMedicationName(itemDto.getMedicationName());
                item.setBatchNumber(itemDto.getBatchNumber());
                item.setRequestedQuantity(itemDto.getRequestedQuantity());
                item.setSuppliedQuantity(itemDto.getSuppliedQuantity() != null ? itemDto.getSuppliedQuantity() : 0);
                item.setAvailableAtRequest(itemDto.getAvailableAtRequest());
                item.setExpiryDate(itemDto.getExpiryDate());
                return item;
            }).collect(Collectors.toList());
            
            existingOrder.getItems().addAll(newItems);
        }

        return mapToDTO(orderRepository.save(existingOrder));
    }

    private WarehouseCampMedicineOrderDTO mapToDTO(WarehouseCampMedicineOrder order) {
        WarehouseCampMedicineOrderDTO dto = WarehouseCampMedicineOrderDTO.builder()
                .warehouseCampMedicineOrderId(order.getWarehouseCampMedicineOrderId())
                .warehouseCampOrderNumber(order.getWarehouseCampOrderNumber())
                .warehouseId(order.getWarehouseId())
                .warehouseName(warehouseRepository.findById(order.getWarehouseId()).map(w -> w.getWarehouseName()).orElse(null))
                .campId(order.getCampId())
                .campName(campsRepository.findById(order.getCampId()).map(c -> c.getCampName()).orElse(null))
                .orderDate(order.getOrderDate())
                .expectedDeliveryDate(order.getExpectedDeliveryDate())
                .priority(order.getPriority())
                .orderStatus(order.getOrderStatus())
                .paymentTerms(order.getPaymentTerms())
                .remarks(order.getRemarks())
                .createdAt(order.getCreatedAt())
                .createdBy(order.getCreatedBy())
                .updatedAt(order.getUpdatedAt())
                .updatedBy(order.getUpdatedBy())
                .build();

        if (order.getItems() != null) {
            dto.setItems(order.getItems().stream().map(item -> {
                return WarehouseCampMedicineOrderItemDTO.builder()
                        .warehouseCampMedicineOrderItemId(item.getWarehouseCampMedicineOrderItemId())
                        .medicationId(item.getMedicationId())
                        .medicationCode(medicineRepository.findById(item.getMedicationId()).map(m -> m.getMedicationCode()).orElse(null))
                        .medicationName(item.getMedicationName())
                        .batchNumber(item.getBatchNumber())
                        .requestedQuantity(item.getRequestedQuantity())
                        .suppliedQuantity(item.getSuppliedQuantity())
                        .availableAtRequest(item.getAvailableAtRequest())
                        .expiryDate(item.getExpiryDate())
                        .build();
            }).collect(Collectors.toList()));
        }

        return dto;
    }

    private String generateOrderNumber() {
        return "CMO-" + System.currentTimeMillis();
    }
}
