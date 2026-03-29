package com.medical.caresync.util;

import com.medical.caresync.dto.UsersResponseDTO;
import com.medical.caresync.entities.Users;

public class UsersUtil {

    public static UsersResponseDTO mapToUserResponse(Users user) {

        UsersResponseDTO dto = new UsersResponseDTO();
        dto.setUserId(user.getUserId());
        dto.setFirstName(user.getFirstName());
        dto.setMiddleName(user.getMiddleName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setPhone(user.getPhone());
        dto.setActive(user.getIsActive());
        dto.setTemporary(user.getIsTemporary());
        dto.setDeleted(user.getIsDeleted());
        dto.setCity(user.getCity());
        dto.setStateLookupId(user.getStateLookupId());
        dto.setDistrictLookupId(user.getDistrictLookupId());
        dto.setMandalLookupId(user.getMandalLookupId());

        // example: first role (adjust as needed)
        dto.setRoles(
                user.getUserRoles()
                        .stream()
                        .map(ur -> ur.getRole().getRoleName()).toList()
        );

        return dto;
    }
}
