package com.medical.caresync.repository;

import com.medical.caresync.entities.PrintQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintQueueRepository extends JpaRepository<PrintQueue, Long> {
}
