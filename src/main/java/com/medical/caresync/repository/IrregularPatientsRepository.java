package com.medical.caresync.repository;

import com.medical.caresync.entities.IrregularPatients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrregularPatientsRepository extends JpaRepository<IrregularPatients, Long> {
}
