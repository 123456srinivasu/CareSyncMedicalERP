package com.medical.caresync.repository;

import com.medical.caresync.entities.PharmacySupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacySupplierRepository extends JpaRepository<PharmacySupplier, Long> {
}

