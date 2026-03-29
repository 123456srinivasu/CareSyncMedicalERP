package com.medical.caresync.repository;

import com.medical.caresync.entities.Role;
import com.medical.caresync.entities.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {

    @Query("SELECT rp.allowedRole FROM RolePermission rp WHERE rp.userRole.roleId = :userRoleId AND rp.isActive = true")
    List<Role> findAllowedRoles(@Param("userRoleId") Integer userRoleId);
}
