package com.medical.caresync.repository;

import com.medical.caresync.entities.WarehouseCampMedicineSent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseCampMedicineSentRepository extends JpaRepository<WarehouseCampMedicineSent, Long> {
    List<WarehouseCampMedicineSent> findByWarehouseCampMedicineOrderWarehouseCampMedicineOrderId(Long orderId);
}
