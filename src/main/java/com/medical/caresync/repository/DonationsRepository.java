package com.medical.caresync.repository;

import com.medical.caresync.entities.Donations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationsRepository extends JpaRepository<Donations, Long> {
}
