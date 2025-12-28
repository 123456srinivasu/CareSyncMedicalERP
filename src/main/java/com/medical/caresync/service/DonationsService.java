package com.medical.caresync.service;

import com.medical.caresync.dto.DonationsDTO;
import com.medical.caresync.entities.Donations;
import com.medical.caresync.repository.DonationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationsService {

    @Autowired
    private DonationsRepository donationsRepository;

    public List<DonationsDTO> getAllDonations() {
        return donationsRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DonationsDTO createDonations(DonationsDTO donationsDTO) {
        Donations donations = convertToEntity(donationsDTO);
        donations = donationsRepository.save(donations);
        return convertToDTO(donations);
    }

    private DonationsDTO convertToDTO(Donations donations) {
        DonationsDTO dto = new DonationsDTO();
        dto.setId(donations.getId());
        return dto;
    }

    private Donations convertToEntity(DonationsDTO dto) {
        Donations donations = new Donations();
        donations.setId(dto.getId());
        return donations;
    }
}
