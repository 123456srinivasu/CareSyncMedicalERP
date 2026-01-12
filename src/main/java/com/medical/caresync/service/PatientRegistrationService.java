package com.medical.caresync.service;

import com.medical.caresync.dto.PatientRegistrationDTO;
import com.medical.caresync.dto.PatientAddressDTO;
import com.medical.caresync.entities.PatientRegistration;
import com.medical.caresync.entities.PatientAddress;
import com.medical.caresync.repository.PatientRegistrationRepository;
import com.medical.caresync.repository.PatientAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientRegistrationService {
    @Autowired
    private PatientRegistrationRepository patientRegistrationRepository;
    @Autowired
    private PatientAddressRepository patientAddressRepository;

    public PatientRegistrationDTO create(PatientRegistrationDTO dto) {
        PatientRegistration entity = toEntity(dto);
        // Generate unique MR number if not set
        if (entity.getMrNumber() == null || entity.getMrNumber().isEmpty()) {
            String prefix = "MR" + java.time.LocalDate.now().getYear();
            long count = patientRegistrationRepository.count() + 1;
            entity.setMrNumber(prefix + String.format("%03d", count));
        }
        PatientRegistration saved = patientRegistrationRepository.save(entity);
        return toDTO(saved);
    }

    public PatientRegistrationDTO update(Long id, PatientRegistrationDTO dto) {
        PatientRegistration entity = patientRegistrationRepository.findById(id).orElseThrow();
        // update fields
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setFatherName(dto.getFatherName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setGender(dto.getGender());
        entity.setBloodGroup(dto.getBloodGroup());
        entity.setMaritalStatus(dto.getMaritalStatus());
        entity.setPatientImage(dto.getPatientImage());
        entity.setPatientAddressesList(dto.getPatientAddressesList().stream().map(this::toAddressEntity).collect(Collectors.toList()));
        PatientRegistration saved = patientRegistrationRepository.save(entity);
        return toDTO(saved);
    }

    public void delete(Long id) {
        patientRegistrationRepository.deleteById(id);
    }

    public PatientRegistrationDTO getById(Long id) {
        return patientRegistrationRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public List<PatientRegistrationDTO> getAll() {
        return patientRegistrationRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PatientRegistrationDTO> searchByName(String name) {
        return patientRegistrationRepository.findByFirstNameContainingIgnoreCase(name).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PatientRegistrationDTO> searchByFields(Long id, String name, String mrNumber, String mobileNumber) {
        // If all params are null, return all
        if (id == null && (name == null || name.isEmpty()) && (mrNumber == null || mrNumber.isEmpty()) && (mobileNumber == null || mobileNumber.isEmpty())) {
            return getAll();
        }
        return patientRegistrationRepository
            .findByFirstNameContainingIgnoreCaseOrMrNumberOrMobileNumberOrTblPatientId(
                name != null ? name : "",
                mrNumber,
                mobileNumber,
                id
            )
            .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PatientRegistrationDTO> searchByMobileNumber(String mobileNumber) {
        return patientRegistrationRepository.findByMobileNumber(mobileNumber).stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Mapping helpers
    private PatientRegistrationDTO toDTO(PatientRegistration entity) {
        PatientRegistrationDTO dto = new PatientRegistrationDTO();
        dto.setTblPatientId(entity.getTblPatientId());
        dto.setMrNumber(entity.getMrNumber());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
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

    private PatientRegistration toEntity(PatientRegistrationDTO dto) {
        PatientRegistration entity = new PatientRegistration();
        entity.setTblPatientId(dto.getTblPatientId());
        entity.setMrNumber(dto.getMrNumber());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
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
        dto.setStateId(entity.getState() != null ? entity.getState().getStateLookupId() : null);
        dto.setDistrictId(entity.getDistrict() != null ? entity.getDistrict().getDistrictLookupId() : null);
        dto.setMandalId(entity.getMandal() != null ? entity.getMandal().getMandalLookupId() : null);
        dto.setPostalCode(entity.getPostalCode());
        return dto;
    }

    private PatientAddress toAddressEntity(PatientAddressDTO dto) {
        PatientAddress entity = new PatientAddress();
        entity.setAddressId(dto.getAddressId());
        entity.setAddressLine(dto.getAddressLine());
        entity.setCity(dto.getCity());
        // Set state, district, mandal by id if needed
        entity.setPostalCode(dto.getPostalCode());
        return entity;
    }
}
