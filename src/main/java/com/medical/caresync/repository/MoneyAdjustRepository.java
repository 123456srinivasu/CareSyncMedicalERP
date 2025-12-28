package com.medical.caresync.repository;

import com.medical.caresync.entities.MoneyAdjust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyAdjustRepository extends JpaRepository<MoneyAdjust, Long> {
}
