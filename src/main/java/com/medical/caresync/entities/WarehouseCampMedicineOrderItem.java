package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "warehouse_camp_medicine_order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseCampMedicineOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_camp_medicine_order_item_id")
    private Long warehouseCampMedicineOrderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_camp_medicine_order_id", nullable = false)
    private WarehouseCampMedicineOrder warehouseCampMedicineOrder;

    @Column(name = "medication_id", nullable = false)
    private Long medicationId;

    @Column(name = "medication_name", length = 255)
    private String medicationName;

    @Column(name = "batch_number", length = 100, nullable = false)
    private String batchNumber;

    @Column(name = "requested_quantity", nullable = false)
    private Integer requestedQuantity;

    @Column(name = "supplied_quantity")
    private Integer suppliedQuantity;

    @Column(name = "available_at_request")
    private Integer availableAtRequest;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
}
