package com.medical.caresync.repository;

import com.medical.caresync.entities.Role;
import com.medical.caresync.entities.UserRoles;
import com.medical.caresync.entities.Users;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {
    public static Specification<Users> withFilters(
            Boolean active,
            Long roleId,
            String roleName
    ) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (active != null) {
                predicates.add(cb.equal(root.get("isActive"), active));
            }

            if (roleId != null) {
                Join<Users, UserRoles> userRoleJoin =
                        root.join("userRoles", JoinType.INNER);
                Join<UserRoles, Role> roleJoin =
                        userRoleJoin.join("role", JoinType.INNER);

                predicates.add(cb.equal(roleJoin.get("roleId"), roleId));
            }

            if (roleName != null && !roleName.isBlank()) {
                Join<Users, UserRoles> userRoleJoin =
                        root.join("userRoles", JoinType.INNER);
                Join<UserRoles, Role> roleJoin =
                        userRoleJoin.join("role", JoinType.INNER);

                predicates.add(
                        cb.equal(
                                cb.upper(roleJoin.get("roleName")),
                                roleName.toUpperCase()
                        )
                );
            }

            query.distinct(true); // IMPORTANT for many-to-many

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
