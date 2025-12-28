package com.medical.caresync.repository;

import com.medical.caresync.entities.CampInvoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampInvoicesRepository extends JpaRepository<CampInvoices, Long> {
}
