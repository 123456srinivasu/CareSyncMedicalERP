package com.medical.caresync.repository;

import com.medical.caresync.entities.PrintForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintFormRepository extends JpaRepository<PrintForm, Long> {
}
