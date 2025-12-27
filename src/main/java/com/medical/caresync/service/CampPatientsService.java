package com.medical.caresync.service;

import com.medical.caresync.dto.CampPatientDTO;
import java.util.List;

public interface CampPatientsService {
    List<CampPatientDTO> searchPatients(String query, Integer campId);
    CampPatientDTO getPatientById(Long id);
}
