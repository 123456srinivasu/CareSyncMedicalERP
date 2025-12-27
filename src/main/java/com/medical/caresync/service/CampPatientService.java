package com.medical.caresync.service;

import com.medical.caresync.dto.CampPatientDTO;
import com.medical.caresync.entities.CampPatient;
import com.medical.caresync.repository.CampPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampPatientService implements CampPatientsService {

    @Autowired
    private CampPatientRepository campPatientRepository;

    @Override
    public List<CampPatientDTO> searchPatients(String query, Integer campId) {
        return campPatientRepository.searchPatients(query).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CampPatientDTO getPatientById(Long id) {
        return campPatientRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    private CampPatientDTO convertToDTO(CampPatient entity) {
        CampPatientDTO dto = new CampPatientDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setFatherName(entity.getFatherName());
        dto.setMobileNumber(entity.getMobileNumber());
        dto.setAge(entity.getAge());
        dto.setGender(entity.getGender());
        dto.setMrNumber(entity.getMrNumber());
        dto.setOldMrNumber(entity.getOldMrNumber());
        dto.setNewMrNumber(entity.getNewMrNumber());
        dto.setVillage(entity.getVillage());
        dto.setPhotoPath(entity.getPhotoPath());
        dto.setDob(entity.getDob());
        dto.setAadharNumber(entity.getAadharNumber());
        dto.setBloodGroup(entity.getBloodGroup());
        dto.setMaritalStatus(entity.getMaritalStatus());
        dto.setAddress(entity.getAddress());
        return dto;
    }
}
