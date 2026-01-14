package com.medical.caresync.dto;

import com.medical.caresync.repository.UsersRepository;

import java.util.List;

public class CampUsersResponseDTO {

    private Long campId;
    private String campName;
    private List<UsersResponseDTO> users;

    public Long getCampId() {
        return campId;
    }

    public void setCampId(Long campId) {
        this.campId = campId;
    }

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public List<UsersResponseDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UsersResponseDTO> users) {
        this.users = users;
    }
}
