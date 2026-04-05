package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "warehouse_camp_medicine_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseCampMedicineOrder extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_camp_medicine_order_id")
    private Long warehouseCampMedicineOrderId;

    @Column(name = "warehouse_camp_order_number", length = 50, nullable = false, unique = true)
    private String warehouseCampOrderNumber;

    @Column(name = "warehouse_id", nullable = false)
    private Long warehouseId;

    @Column(name = "camp_id", nullable = false)
    private Long campId;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "expected_delivery_date")
    private LocalDate expectedDeliveryDate;

    @Column(name = "priority", length = 50)
    private String priority;

    @Column(name = "order_status", length = 50)
    private String orderStatus;

    @Column(name = "payment_terms", length = 100)
    private String paymentTerms;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @OneToMany(mappedBy = "warehouseCampMedicineOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WarehouseCampMedicineOrderItem> items;
}
