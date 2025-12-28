package com.medical.caresync.repository;

import com.medical.caresync.entities.WarehouseToCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseToCompanyRepository extends JpaRepository<WarehouseToCompany, Long> {
}
