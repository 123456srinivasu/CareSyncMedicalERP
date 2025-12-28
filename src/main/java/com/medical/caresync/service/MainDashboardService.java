package com.medical.caresync.service;

import com.medical.caresync.dto.MainDashboardDTO;
import com.medical.caresync.entities.MainDashboard;
import com.medical.caresync.repository.MainDashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainDashboardService {

    @Autowired
    private MainDashboardRepository mainDashboardRepository;

    public List<MainDashboardDTO> getAllMainDashboards() {
        return mainDashboardRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public MainDashboardDTO createMainDashboard(MainDashboardDTO mainDashboardDTO) {
        MainDashboard mainDashboard = convertToEntity(mainDashboardDTO);
        mainDashboard = mainDashboardRepository.save(mainDashboard);
        return convertToDTO(mainDashboard);
    }

    private MainDashboardDTO convertToDTO(MainDashboard mainDashboard) {
        MainDashboardDTO dto = new MainDashboardDTO();
        dto.setId(mainDashboard.getId());
        return dto;
    }

    private MainDashboard convertToEntity(MainDashboardDTO dto) {
        MainDashboard mainDashboard = new MainDashboard();
        mainDashboard.setId(dto.getId());
        return mainDashboard;
    }
}
