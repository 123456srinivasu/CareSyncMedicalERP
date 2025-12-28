package com.medical.caresync.service;

import com.medical.caresync.dto.DashboardForVolunteersDTO;
import com.medical.caresync.entities.DashboardForVolunteers;
import com.medical.caresync.repository.DashboardForVolunteersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardForVolunteersService {

    @Autowired
    private DashboardForVolunteersRepository dashboardForVolunteersRepository;

    public List<DashboardForVolunteersDTO> getAllDashboardForVolunteers() {
        return dashboardForVolunteersRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DashboardForVolunteersDTO createDashboardForVolunteers(DashboardForVolunteersDTO dashboardForVolunteersDTO) {
        DashboardForVolunteers dashboardForVolunteers = convertToEntity(dashboardForVolunteersDTO);
        dashboardForVolunteers = dashboardForVolunteersRepository.save(dashboardForVolunteers);
        return convertToDTO(dashboardForVolunteers);
    }

    private DashboardForVolunteersDTO convertToDTO(DashboardForVolunteers dashboardForVolunteers) {
        DashboardForVolunteersDTO dto = new DashboardForVolunteersDTO();
        dto.setId(dashboardForVolunteers.getId());
        return dto;
    }

    private DashboardForVolunteers convertToEntity(DashboardForVolunteersDTO dto) {
        DashboardForVolunteers dashboardForVolunteers = new DashboardForVolunteers();
        dashboardForVolunteers.setId(dto.getId());
        return dashboardForVolunteers;
    }
}
