package com.medical.caresync.service;

import com.medical.caresync.dto.PatientRegistrationDTO;
import com.medical.caresync.dto.PatientAddressDTO;
import com.medical.caresync.entities.Patient;
import com.medical.caresync.entities.PatientAddress;
import com.medical.caresync.repository.PatientRegistrationRepository;
import com.medical.caresync.repository.PatientAddressRepository;
import com.medical.caresync.util.PatientSpecs;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medical.caresync.entities.StateLookup;
import com.medical.caresync.entities.DistrictLookup;
import com.medical.caresync.entities.MandalLookup;
import com.medical.caresync.repository.StateLookupRepository;
import com.medical.caresync.repository.DistrictLookupRepository;
import com.medical.caresync.repository.MandalLookupRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientRegistrationService {

    @Autowired
    private PatientRegistrationRepository patientRegistrationRepository;
    @Autowired
    private PatientAddressRepository patientAddressRepository;

    @Autowired
    private StateLookupRepository stateLookupRepository;
    @Autowired
    private DistrictLookupRepository districtLookupRepository;
    @Autowired
    private MandalLookupRepository mandalLookupRepository;

    public PatientRegistrationDTO create(PatientRegistrationDTO dto) {
        Patient entity = toEntity(dto);
        // Generate unique MR number if not set
        if (entity.getMrNumber() == null || entity.getMrNumber().isEmpty()) {
            String prefix = "MR" + java.time.LocalDate.now().getYear();
            long count = patientRegistrationRepository.count() + 1;
            entity.setMrNumber(prefix + String.format("%03d", count));
        }
        entity.setActive(true);
        Patient saved = patientRegistrationRepository.save(entity);
        return toDTO(saved);
    }

    public PatientRegistrationDTO update(Long id, PatientRegistrationDTO dto) {
        Patient entity = patientRegistrationRepository.
                findOne(PatientSpecs.isActive().and(PatientSpecs.hasId(id))).orElseThrow(() -> new EntityNotFoundException("Active patient not found"));
        // update fields
        entity.setFirstNm(dto.getFirstName());
        entity.setLastNm(dto.getLastName());
        entity.setFatherName(dto.getFatherName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setGender(dto.getGender());
        entity.setBloodGroup(dto.getBloodGroup());
        entity.setMaritalStatus(dto.getMaritalStatus());
        entity.setPatientImage(dto.getPatientImage());
        entity.setPatientAddressesList(dto.getPatientAddressesList().stream().map(this::toAddressEntity).collect(Collectors.toList()));
        Patient saved = patientRegistrationRepository.save(entity);
        return toDTO(saved);
    }

    @Transactional
    public void delete(Long id) {
        patientRegistrationRepository.softDeleteById(id);
    }

    public PatientRegistrationDTO getById(Long id) {
        return patientRegistrationRepository.findOne(PatientSpecs.isActive().and(PatientSpecs.hasId(id))).map(this::toDTO).orElse(null);
    }

    public List<PatientRegistrationDTO> getAll() {
        return patientRegistrationRepository.findAll(PatientSpecs.isActive()).stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Mapping helpers
    private PatientRegistrationDTO toDTO(Patient entity) {
        PatientRegistrationDTO dto = new PatientRegistrationDTO();
        dto.setTblPatientId(entity.getTblPatientId());
        dto.setMrNumber(entity.getMrNumber());
        dto.setFirstName(entity.getFirstNm());
        dto.setLastName(entity.getLastNm());
        dto.setFatherName(entity.getFatherName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setMobileNumber(entity.getMobileNumber());
        dto.setGender(entity.getGender());
        dto.setBloodGroup(entity.getBloodGroup());
        dto.setMaritalStatus(entity.getMaritalStatus());
        dto.setPatientImage(entity.getPatientImage());
        dto.setPatientAddressesList(entity.getPatientAddressesList().stream().map(this::toAddressDTO).collect(Collectors.toList()));
        return dto;
    }

    private Patient toEntity(PatientRegistrationDTO dto) {
        Patient entity = new Patient();
        entity.setTblPatientId(dto.getTblPatientId());
        entity.setMrNumber(dto.getMrNumber());
        entity.setFirstNm(dto.getFirstName());
        entity.setLastNm(dto.getLastName());
        entity.setFatherName(dto.getFatherName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setGender(dto.getGender());
        entity.setBloodGroup(dto.getBloodGroup());
        entity.setMaritalStatus(dto.getMaritalStatus());
        entity.setPatientImage(dto.getPatientImage());
        entity.setPatientAddressesList(dto.getPatientAddressesList().stream().map(this::toAddressEntity).collect(Collectors.toList()));
        return entity;
    }

    private PatientAddressDTO toAddressDTO(PatientAddress entity) {
        PatientAddressDTO dto = new PatientAddressDTO();
        dto.setAddressId(entity.getAddressId());
        dto.setAddressLine(entity.getAddressLine());
        dto.setCity(entity.getCity());
        dto.setVillageName(entity.getVillageName());
        if (entity.getState() != null) {
            dto.setStateId(entity.getState().getStateLookupId() != null ? entity.getState().getStateLookupId() : null);
            PatientAddressDTO.LookupDTO stateDto = new PatientAddressDTO.LookupDTO();
            stateDto.setId(entity.getState().getStateLookupId() != null ? entity.getState().getStateLookupId() : null);
            stateDto.setName(entity.getState().getStateName());
            dto.setState(stateDto);
        }
        if (entity.getDistrict() != null) {
            dto.setDistrictId(entity.getDistrict().getDistrictLookupId() != null ? entity.getDistrict().getDistrictLookupId() : null);
            PatientAddressDTO.LookupDTO districtDto = new PatientAddressDTO.LookupDTO();
            districtDto.setId(entity.getDistrict().getDistrictLookupId() != null ? entity.getDistrict().getDistrictLookupId() : null);
            districtDto.setName(entity.getDistrict().getDistrictName());
            dto.setDistrict(districtDto);
        }
        if (entity.getMandal() != null) {
            dto.setMandalId(entity.getMandal().getMandalLookupId() != null ? entity.getMandal().getMandalLookupId() : null);
            PatientAddressDTO.LookupDTO mandalDto = new PatientAddressDTO.LookupDTO();
            mandalDto.setId(entity.getMandal().getMandalLookupId() != null ? entity.getMandal().getMandalLookupId() : null);
            mandalDto.setName(entity.getMandal().getMandalName());
            dto.setMandal(mandalDto);
        }
        dto.setPostalCode(entity.getPostalCode());
        return dto;
    }

    private PatientAddress toAddressEntity(PatientAddressDTO dto) {
        PatientAddress entity = new PatientAddress();
        entity.setAddressId(dto.getAddressId());
        entity.setAddressLine(dto.getAddressLine());
        entity.setCity(dto.getCity());
        entity.setVillageName(dto.getVillageName());
        // Set state, district, mandal by id if provided
        if (dto.getStateId() != null) {
            StateLookup state = stateLookupRepository.findById(dto.getStateId().intValue()).orElse(null);
            entity.setState(state);
        }
        if (dto.getDistrictId() != null) {
            DistrictLookup district = districtLookupRepository.findById(dto.getDistrictId().intValue()).orElse(null);
            entity.setDistrict(district);
        }
        if (dto.getMandalId() != null) {
            MandalLookup mandal = mandalLookupRepository.findById(dto.getMandalId().intValue()).orElse(null);
            entity.setMandal(mandal);
        }
        entity.setPostalCode(dto.getPostalCode());
        return entity;
    }

    public List<PatientRegistrationDTO> searchPatients(String searchPatient) {

        if (searchPatient == null || searchPatient.trim().isEmpty()) {
            return getAll();
        }

        return patientRegistrationRepository
                .findAll(PatientSpecs.isActive()
                                .and(PatientSpecs.searchPatient(searchPatient)))
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
