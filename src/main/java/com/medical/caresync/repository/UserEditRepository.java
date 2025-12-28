package com.medical.caresync.repository;

import com.medical.caresync.entities.UserEdit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEditRepository extends JpaRepository<UserEdit, Long> {
}
