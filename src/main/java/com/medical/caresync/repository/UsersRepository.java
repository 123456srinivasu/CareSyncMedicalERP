package com.medical.caresync.repository;

import com.medical.caresync.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByIsActive(Boolean isActive);

    List<Users> findByRole_RoleName(String roleName);

    List<Users> findByRole_RoleId(Integer roleId);
}
