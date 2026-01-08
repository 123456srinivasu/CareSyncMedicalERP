package com.medical.caresync.repository;

import com.medical.caresync.entities.CampUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampUsersRepository extends JpaRepository<CampUsers, Long> {
    List<CampUsers> findByCamps_CampId(Long campId);

    List<CampUsers> findByUsers_UserId(Long userId);
}
