package com.medical.caresync.service;

import com.medical.caresync.dto.CampPurchaseOrderRequestDTO;
import com.medical.caresync.dto.CampPurchaseOrderResponseDTO;
import com.medical.caresync.dto.SupplierOrderReviewDTO;
import com.medical.caresync.entities.*;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CampPurchaseOrderServiceImpl implements CampPurchaseOrderService {

    @Autowired
    private CampPurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private CampPurchaseOrderLineRepository orderLineRepository;

    @Autowired
    private CampsRepository campsRepository;

    @Autowired
    private PharmacySupplierRepository pharmacySupplierRepository;

    @Autowired
    private MedicineLookupNewRepository medicineLookupNewRepository;

    @Override
    @Transactional
    public List<Long> createPurchaseOrders(CampPurchaseOrderRequestDTO requestDTO) {
        // Validate camp exists
        Camps camp = campsRepository.findById(requestDTO.getCampId())
                .orElseThrow(() -> new BadRequestException("Camp not found with ID: " + requestDTO.getCampId()));

        List<Long> createdOrderIds = new ArrayList<>();

        // Create a separate purchase order for each supplier
        for (CampPurchaseOrderRequestDTO.SupplierOrderDTO supplierOrder : requestDTO.getSupplierOrders()) {
            // Validate supplier exists
            PharmacySupplier supplier = pharmacySupplierRepository.findById(supplierOrder.getSupplierId())
                    .orElseThrow(() -> new BadRequestException(
                            "Supplier not found with ID: " + supplierOrder.getSupplierId()));

            // Create purchase order
            CampPurchaseOrder purchaseOrder = new CampPurchaseOrder();
            purchaseOrder.setCamp(camp);
            purchaseOrder.setPharmacySupplier(supplier);
            purchaseOrder.setOrderStatus("CREATED");
            purchaseOrder.setRequestedAt(new Timestamp(System.currentTimeMillis()));
            purchaseOrder.setRemarks(requestDTO.getRemarks());

            // Create order lines
            List<CampPurchaseOrderLine> orderLines = new ArrayList<>();
            for (CampPurchaseOrderRequestDTO.MedicineOrderDTO medicineOrder : supplierOrder.getMedicines()) {
                // Validate medication exists
                MedicineLookupNew medication = medicineLookupNewRepository.findById(medicineOrder.getMedicationId())
                        .orElseThrow(() -> new BadRequestException(
                                "Medication not found with ID: " + medicineOrder.getMedicationId()));

                CampPurchaseOrderLine orderLine = new CampPurchaseOrderLine();
                orderLine.setPurchaseOrder(purchaseOrder);
                orderLine.setMedication(medication);
                orderLine.setRequestedQuantity(medicineOrder.getRequestedQuantity());
                orderLine.setApprovedQuantity(0);
                orderLine.setLineStatus("REQUESTED");

                orderLines.add(orderLine);
            }

            purchaseOrder.setOrderLines(orderLines);

            // Save purchase order (cascade will save order lines)
            CampPurchaseOrder savedOrder = purchaseOrderRepository.save(purchaseOrder);
            createdOrderIds.add(savedOrder.getPurchaseOrderId());
        }

        return createdOrderIds;
    }

    @Override
    @Transactional
    public CampPurchaseOrderResponseDTO updatePurchaseOrder(Long purchaseOrderId,
            CampPurchaseOrderRequestDTO requestDTO) {
        CampPurchaseOrder purchaseOrder = purchaseOrderRepository.findById(purchaseOrderId)
                .orElseThrow(() -> new BadRequestException("Purchase order not found with ID: " + purchaseOrderId));

        // Update basic fields
        purchaseOrder.setRemarks(requestDTO.getRemarks());

        // If there's only one supplier order in the request, update the order lines
        if (requestDTO.getSupplierOrders() != null && requestDTO.getSupplierOrders().size() == 1) {
            CampPurchaseOrderRequestDTO.SupplierOrderDTO supplierOrder = requestDTO.getSupplierOrders().get(0);

            // Clear existing order lines
            purchaseOrder.getOrderLines().clear();

            // Add new order lines
            List<CampPurchaseOrderLine> newOrderLines = new ArrayList<>();
            for (CampPurchaseOrderRequestDTO.MedicineOrderDTO medicineOrder : supplierOrder.getMedicines()) {
                MedicineLookupNew medication = medicineLookupNewRepository.findById(medicineOrder.getMedicationId())
                        .orElseThrow(() -> new BadRequestException(
                                "Medication not found with ID: " + medicineOrder.getMedicationId()));

                CampPurchaseOrderLine orderLine = new CampPurchaseOrderLine();
                orderLine.setPurchaseOrder(purchaseOrder);
                orderLine.setMedication(medication);
                orderLine.setRequestedQuantity(medicineOrder.getRequestedQuantity());
                orderLine.setApprovedQuantity(0);
                orderLine.setLineStatus("REQUESTED");

                newOrderLines.add(orderLine);
            }

            purchaseOrder.getOrderLines().addAll(newOrderLines);
        }

        CampPurchaseOrder updatedOrder = purchaseOrderRepository.save(purchaseOrder);
        return mapToResponseDTO(updatedOrder);
    }

    @Override
    @Transactional
    public CampPurchaseOrderResponseDTO reviewPurchaseOrder(Long purchaseOrderId, SupplierOrderReviewDTO reviewDTO) {
        CampPurchaseOrder purchaseOrder = purchaseOrderRepository.findById(purchaseOrderId)
                .orElseThrow(() -> new BadRequestException("Purchase order not found with ID: " + purchaseOrderId));

        // Update order-level fields
        purchaseOrder.setRemarks(reviewDTO.getRemarks());
        purchaseOrder.setReviewedAt(new Timestamp(System.currentTimeMillis()));

        // Track overall approval status
        boolean allApproved = true;
        boolean anyApproved = false;
        boolean anyRejected = false;

        // Update order lines
        for (SupplierOrderReviewDTO.OrderLineReviewDTO lineReview : reviewDTO.getOrderLines()) {
            CampPurchaseOrderLine orderLine = orderLineRepository.findById(lineReview.getOrderLineId())
                    .orElseThrow(() -> new BadRequestException(
                            "Order line not found with ID: " + lineReview.getOrderLineId()));

            // Verify this line belongs to the purchase order
            if (!orderLine.getPurchaseOrder().getPurchaseOrderId().equals(purchaseOrderId)) {
                throw new BadRequestException("Order line " + lineReview.getOrderLineId()
                        + " does not belong to purchase order " + purchaseOrderId);
            }

            // Update line fields
            orderLine.setApprovedQuantity(lineReview.getApprovedQuantity());
            orderLine.setApprovedUnitPrice(lineReview.getApprovedUnitPrice());
            orderLine.setLineStatus(lineReview.getLineStatus());
            orderLine.setSupplierComment(lineReview.getSupplierComment());

            // Track status for overall order status calculation
            if ("APPROVED".equals(lineReview.getLineStatus())) {
                anyApproved = true;
                if (lineReview.getApprovedQuantity() < orderLine.getRequestedQuantity()) {
                    allApproved = false; // Partial approval
                }
            } else if ("REJECTED".equals(lineReview.getLineStatus())) {
                anyRejected = true;
                allApproved = false;
            } else if ("PARTIAL".equals(lineReview.getLineStatus())) {
                anyApproved = true;
                allApproved = false;
            }

            orderLineRepository.save(orderLine);
        }

        // Calculate overall order status
        String orderStatus;
        if (allApproved && anyApproved) {
            orderStatus = "ACCEPTED";
        } else if (!anyApproved && anyRejected) {
            orderStatus = "REJECTED";
        } else {
            orderStatus = "PARTIALLY_ACCEPTED";
        }

        purchaseOrder.setOrderStatus(orderStatus);
        CampPurchaseOrder savedOrder = purchaseOrderRepository.save(purchaseOrder);

        return mapToResponseDTO(savedOrder);
    }

    @Override
    public CampPurchaseOrderResponseDTO getPurchaseOrderById(Long purchaseOrderId) {
        CampPurchaseOrder purchaseOrder = purchaseOrderRepository.findById(purchaseOrderId)
                .orElseThrow(() -> new BadRequestException("Purchase order not found with ID: " + purchaseOrderId));
        return mapToResponseDTO(purchaseOrder);
    }

    @Override
    public List<CampPurchaseOrderResponseDTO> getAllPurchaseOrders() {
        List<CampPurchaseOrder> purchaseOrders = purchaseOrderRepository.findAll();
        return purchaseOrders.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CampPurchaseOrderResponseDTO> getPurchaseOrdersByCampId(Long campId) {
        List<CampPurchaseOrder> purchaseOrders = purchaseOrderRepository.findByCampId(campId);
        return purchaseOrders.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CampPurchaseOrderResponseDTO> getPurchaseOrdersBySupplierId(Long supplierId) {
        List<CampPurchaseOrder> purchaseOrders = purchaseOrderRepository.findBySupplierId(supplierId);
        return purchaseOrders.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deletePurchaseOrder(Long purchaseOrderId) {
        if (!purchaseOrderRepository.existsById(purchaseOrderId)) {
            throw new BadRequestException("Purchase order not found with ID: " + purchaseOrderId);
        }
        purchaseOrderRepository.deleteById(purchaseOrderId);
    }

    private CampPurchaseOrderResponseDTO mapToResponseDTO(CampPurchaseOrder purchaseOrder) {
        CampPurchaseOrderResponseDTO responseDTO = new CampPurchaseOrderResponseDTO();
        responseDTO.setPurchaseOrderId(purchaseOrder.getPurchaseOrderId());
        responseDTO.setCampId(purchaseOrder.getCamp().getCampId());
        responseDTO.setCampName(purchaseOrder.getCamp().getCampName());
        responseDTO.setPharmacySupplierId(purchaseOrder.getPharmacySupplier().getPharmacySupplierId());
        responseDTO.setSupplierName(purchaseOrder.getPharmacySupplier().getSupplierName());
        responseDTO.setOrderStatus(purchaseOrder.getOrderStatus());
        responseDTO.setRequestedAt(purchaseOrder.getRequestedAt());
        responseDTO.setReviewedAt(purchaseOrder.getReviewedAt());
        responseDTO.setRemarks(purchaseOrder.getRemarks());

        // Map order lines
        List<CampPurchaseOrderResponseDTO.OrderLineDTO> orderLineDTOs = purchaseOrder.getOrderLines().stream()
                .map(this::mapToOrderLineDTO)
                .collect(Collectors.toList());
        responseDTO.setOrderLines(orderLineDTOs);

        return responseDTO;
    }

    private CampPurchaseOrderResponseDTO.OrderLineDTO mapToOrderLineDTO(CampPurchaseOrderLine orderLine) {
        CampPurchaseOrderResponseDTO.OrderLineDTO orderLineDTO = new CampPurchaseOrderResponseDTO.OrderLineDTO();
        orderLineDTO.setOrderLineId(orderLine.getOrderLineId());
        orderLineDTO.setMedicationId(orderLine.getMedication().getMedicationId());
        orderLineDTO.setMedicationName(orderLine.getMedication().getMedicationName());
        orderLineDTO.setRequestedQuantity(orderLine.getRequestedQuantity());
        orderLineDTO.setApprovedQuantity(orderLine.getApprovedQuantity());
        orderLineDTO.setApprovedUnitPrice(orderLine.getApprovedUnitPrice());
        orderLineDTO.setLineStatus(orderLine.getLineStatus());
        orderLineDTO.setSupplierComment(orderLine.getSupplierComment());
        return orderLineDTO;
    }
}
