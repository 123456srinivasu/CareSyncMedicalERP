package com.medical.caresync.service;

import com.medical.caresync.dto.WarehouseCampMedicineSentDTO;
import com.medical.caresync.dto.WarehouseCampMedicineSentItemDTO;
import com.medical.caresync.entities.*;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WarehouseCampMedicineSentService {

    @Autowired
    private WarehouseCampMedicineSentRepository sentRepository;

    @Autowired
    private WarehouseCampMedicineOrderRepository orderRepository;

    @Autowired
    private WarehouseMedicineStockRepository stockRepository;

    @Transactional
    public WarehouseCampMedicineSentDTO dispatchOrder(WarehouseCampMedicineSentDTO dto) {
        WarehouseCampMedicineOrder order = orderRepository.findById(dto.getWarehouseCampMedicineOrderId())
                .orElseThrow(() -> new BadRequestException("Original order not found with ID: " + dto.getWarehouseCampMedicineOrderId()));

        WarehouseCampMedicineSent sent = new WarehouseCampMedicineSent();
        sent.setWarehouseCampInvoiceNumber(dto.getWarehouseCampInvoiceNumber() != null ? dto.getWarehouseCampInvoiceNumber() : "INV-" + System.currentTimeMillis());
        sent.setWarehouseCampMedicineOrder(order);
        sent.setWarehouseCampOrderNumber(order.getWarehouseCampOrderNumber());
        sent.setWarehouseId(order.getWarehouseId());
        sent.setCampId(order.getCampId());
        sent.setSentDate(dto.getSentDate() != null ? dto.getSentDate() : LocalDateTime.now());
        sent.setIssuedBy(dto.getIssuedBy());
        sent.setTransportMode(dto.getTransportMode());
        sent.setVehicleNumber(dto.getVehicleNumber());
        sent.setStatus("DISPATCHED");
        
        // Billing/Financial Mapping
        sent.setCgstPercent(dto.getCgstPercent());
        sent.setSgstPercent(dto.getSgstPercent());
        sent.setDiscountAmount(dto.getDiscountAmount());
        sent.setTotalAmount(dto.getTotalAmount());
        sent.setPayableAmount(dto.getPayableAmount());
        sent.setPaidAmount(dto.getPaidAmount());
        sent.setAmountDue(dto.getAmountDue());
        sent.setPaymentStatus(dto.getPaymentStatus());
        
        sent.setCreatedBy(dto.getCreatedBy() != null ? dto.getCreatedBy() : "ADMIN");
        sent.setItems(new ArrayList<>());

        final WarehouseCampMedicineSent savedSent = sentRepository.save(sent);

        if (dto.getItems() != null) {
            for (WarehouseCampMedicineSentItemDTO itemDto : dto.getItems()) {
                // Find stock and deduct
                WarehouseMedicineStock stock = stockRepository.findByWarehouseIdAndMedicationIdAndBatchNumber(
                        order.getWarehouseId(), itemDto.getMedicationId(), itemDto.getBatchNumber())
                        .orElseThrow(() -> new BadRequestException("No stock found in Warehouse for Medication ID: " 
                                + itemDto.getMedicationId() + " Batch: " + itemDto.getBatchNumber()));

                if (stock.getQuantity() < itemDto.getSentQuantity()) {
                    throw new BadRequestException("Insufficient stock for " + itemDto.getMedicationName() + ". Requested: " 
                            + itemDto.getSentQuantity() + ", Available: " + stock.getQuantity());
                }

                // Update Stock
                stock.setQuantity(stock.getQuantity() - itemDto.getSentQuantity());
                stockRepository.save(stock);

                // Create Sent Item
                WarehouseCampMedicineSentItem sentItem = new WarehouseCampMedicineSentItem();
                sentItem.setWarehouseCampMedicineSent(savedSent);
                sentItem.setMedicationId(itemDto.getMedicationId());
                sentItem.setMedicationName(itemDto.getMedicationName());
                sentItem.setBatchNumber(itemDto.getBatchNumber());
                sentItem.setExpiryDate(itemDto.getExpiryDate());
                sentItem.setRequestedQuantity(itemDto.getRequestedQuantity());
                sentItem.setSentQuantity(itemDto.getSentQuantity());
                sentItem.setUnitPrice(itemDto.getUnitPrice());
                sentItem.setMrp(itemDto.getMrp());
                sentItem.setRemarks(itemDto.getRemarks());
                
                savedSent.getItems().add(sentItem);
            }
        }

        // Update Order to Dispatched
        order.setOrderStatus("DISPATCHED");
        orderRepository.save(order);

        return mapToDTO(sentRepository.save(savedSent));
    }

    public List<WarehouseCampMedicineSentDTO> getAllDispatches() {
        return sentRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public WarehouseCampMedicineSentDTO getDispatchById(Long id) {
        WarehouseCampMedicineSent sent = sentRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Dispatch not found with id: " + id));
        return mapToDTO(sent);
    }

    @Transactional
    public WarehouseCampMedicineSentDTO updateDispatch(Long id, WarehouseCampMedicineSentDTO dto) {
        WarehouseCampMedicineSent existingSent = sentRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Dispatch not found with id: " + id));

        existingSent.setSentDate(dto.getSentDate() != null ? dto.getSentDate() : existingSent.getSentDate());
        existingSent.setIssuedBy(dto.getIssuedBy());
        existingSent.setTransportMode(dto.getTransportMode());
        existingSent.setVehicleNumber(dto.getVehicleNumber());
        existingSent.setCgstPercent(dto.getCgstPercent());
        existingSent.setSgstPercent(dto.getSgstPercent());
        existingSent.setDiscountAmount(dto.getDiscountAmount());
        existingSent.setTotalAmount(dto.getTotalAmount());
        existingSent.setPayableAmount(dto.getPayableAmount());
        existingSent.setPaidAmount(dto.getPaidAmount());
        existingSent.setAmountDue(dto.getAmountDue());
        existingSent.setPaymentStatus(dto.getPaymentStatus());
        existingSent.setStatus(dto.getStatus() != null ? dto.getStatus() : existingSent.getStatus());

        return mapToDTO(sentRepository.save(existingSent));
    }

    private WarehouseCampMedicineSentDTO mapToDTO(WarehouseCampMedicineSent sent) {
        WarehouseCampMedicineSentDTO dto = new WarehouseCampMedicineSentDTO();
        dto.setWarehouseCampMedicineSentId(sent.getWarehouseCampMedicineSentId());
        dto.setWarehouseCampInvoiceNumber(sent.getWarehouseCampInvoiceNumber());
        dto.setWarehouseCampMedicineOrderId(sent.getWarehouseCampMedicineOrder().getWarehouseCampMedicineOrderId());
        dto.setWarehouseCampOrderNumber(sent.getWarehouseCampOrderNumber());
        dto.setWarehouseId(sent.getWarehouseId());
        dto.setCampId(sent.getCampId());
        dto.setSentDate(sent.getSentDate());
        dto.setIssuedBy(sent.getIssuedBy());
        dto.setTransportMode(sent.getTransportMode());
        dto.setVehicleNumber(sent.getVehicleNumber());
        dto.setStatus(sent.getStatus());
        dto.setCgstPercent(sent.getCgstPercent());
        dto.setSgstPercent(sent.getSgstPercent());
        dto.setDiscountAmount(sent.getDiscountAmount());
        dto.setTotalAmount(sent.getTotalAmount());
        dto.setPayableAmount(sent.getPayableAmount());
        dto.setPaidAmount(sent.getPaidAmount());
        dto.setAmountDue(sent.getAmountDue());
        dto.setPaymentStatus(sent.getPaymentStatus());
        dto.setCreatedAt(sent.getCreatedAt());
        dto.setCreatedBy(sent.getCreatedBy());

        if (sent.getItems() != null) {
            dto.setItems(sent.getItems().stream().map(item -> {
                WarehouseCampMedicineSentItemDTO itemDto = new WarehouseCampMedicineSentItemDTO();
                itemDto.setWarehouseCampMedicineSentItemId(item.getWarehouseCampMedicineSentItemId());
                itemDto.setMedicationId(item.getMedicationId());
                itemDto.setMedicationName(item.getMedicationName());
                itemDto.setBatchNumber(item.getBatchNumber());
                itemDto.setExpiryDate(item.getExpiryDate());
                itemDto.setRequestedQuantity(item.getRequestedQuantity());
                itemDto.setSentQuantity(item.getSentQuantity());
                itemDto.setUnitPrice(item.getUnitPrice());
                itemDto.setMrp(item.getMrp());
                itemDto.setRemarks(item.getRemarks());
                return itemDto;
            }).collect(Collectors.toList()));
        }
        return dto;
    }
}
