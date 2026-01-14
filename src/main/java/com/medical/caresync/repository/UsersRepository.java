package com.medical.caresync.repository;

import com.medical.caresync.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {
    List<Users> findByIsActive(Boolean isActive);

    @Query("""
        SELECT DISTINCT u
        FROM Users u
        JOIN u.userRoles ur
        JOIN ur.role r
        WHERE r.roleId = :roleId
    """)
    List<Users> findUsersByRoleId(@Param("roleId") Long roleId);

    @Query("""
        SELECT DISTINCT u
        FROM Users u
        JOIN u.userRoles ur
        JOIN ur.role r
        WHERE r.roleName = :roleName
    """)
    List<Users> findUsersByRoleName(@Param("roleName") String roleName);

    @Query("""
        SELECT DISTINCT u
        FROM Users u
        JOIN u.userRoles ur
        JOIN ur.role r
        WHERE r.roleId = :roleId and u.isActive = true
    """
    )
    List<Users> findActiveUsersByRoleId(@Param("roleId") Long roleId);

    @Query("""
        SELECT DISTINCT u
        FROM Users u
        WHERE u.isActive = true
    """
    )
    List<Users> findActiveUsers();

}
