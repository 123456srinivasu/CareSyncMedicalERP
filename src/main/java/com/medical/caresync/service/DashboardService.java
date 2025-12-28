package com.medical.caresync.service;

import com.medical.caresync.dto.DashboardDTO;
import com.medical.caresync.entities.Dashboard;
import com.medical.caresync.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    public List<DashboardDTO> getAllDashboards() {
        return dashboardRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DashboardDTO createDashboard(DashboardDTO dashboardDTO) {
        Dashboard dashboard = convertToEntity(dashboardDTO);
        dashboard = dashboardRepository.save(dashboard);
        return convertToDTO(dashboard);
    }

    private DashboardDTO convertToDTO(Dashboard dashboard) {
        DashboardDTO dto = new DashboardDTO();
        dto.setId(dashboard.getId());
        return dto;
    }

    private Dashboard convertToEntity(DashboardDTO dto) {
        Dashboard dashboard = new Dashboard();
        dashboard.setId(dto.getId());
        return dashboard;
    }
}
