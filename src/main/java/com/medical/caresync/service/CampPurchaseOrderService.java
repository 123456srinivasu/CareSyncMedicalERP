package com.medical.caresync.service;

import com.medical.caresync.dto.CampPurchaseOrderRequestDTO;
import com.medical.caresync.dto.CampPurchaseOrderResponseDTO;

import java.util.List;

public interface CampPurchaseOrderService {

    List<Long> createPurchaseOrders(CampPurchaseOrderRequestDTO requestDTO);

    CampPurchaseOrderResponseDTO updatePurchaseOrder(Long purchaseOrderId, CampPurchaseOrderRequestDTO requestDTO);

    CampPurchaseOrderResponseDTO getPurchaseOrderById(Long purchaseOrderId);

    List<CampPurchaseOrderResponseDTO> getAllPurchaseOrders();

    List<CampPurchaseOrderResponseDTO> getPurchaseOrdersByCampId(Long campId);

    List<CampPurchaseOrderResponseDTO> getPurchaseOrdersBySupplierId(Long supplierId);

    void deletePurchaseOrder(Long purchaseOrderId);
}
