package com.medical.caresync.repository;

import com.medical.caresync.entities.CampPassbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CampPassbookRepository extends JpaRepository<CampPassbook, Long> {
    List<CampPassbook> findByCampId(Integer campId);
}
