package com.medical.caresync.repository;

import com.medical.caresync.entities.TvrDonations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvrDonationsRepository extends JpaRepository<TvrDonations, Long> {
}
