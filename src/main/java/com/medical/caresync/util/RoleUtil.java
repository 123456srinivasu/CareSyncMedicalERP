package com.medical.caresync.util;

import com.medical.caresync.dto.RoleDTO;
import com.medical.caresync.entities.Role;

public class RoleUtil {

    public static RoleDTO mapToRoleDTO(Role role) {
        if (role == null) {
            return null;
        }
        RoleDTO dto = new RoleDTO();
        dto.setRoleId(role.getRoleId());
        dto.setRoleName(role.getRoleName());
        return dto;
    }
}
