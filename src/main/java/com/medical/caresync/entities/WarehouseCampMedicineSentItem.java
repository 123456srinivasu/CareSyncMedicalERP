package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "warehouse_camp_medicine_sent_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseCampMedicineSentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_camp_medicine_sent_item_id")
    private Long warehouseCampMedicineSentItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_camp_medicine_sent_id", nullable = false)
    private WarehouseCampMedicineSent warehouseCampMedicineSent;

    @Column(name = "medication_id", nullable = false)
    private Long medicationId;

    @Column(name = "medication_name", length = 255)
    private String medicationName;

    @Column(name = "batch_number", length = 100, nullable = false)
    private String batchNumber;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "requested_quantity", nullable = false)
    private Integer requestedQuantity;

    @Column(name = "sent_quantity", nullable = false)
    private Integer sentQuantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "mrp")
    private BigDecimal mrp;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;
}
