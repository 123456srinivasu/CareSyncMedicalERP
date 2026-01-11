package com.medical.caresync.service;

import com.medical.caresync.dto.AddressDTO;
import com.medical.caresync.dto.CampScheduleTemplateDTO;
import com.medical.caresync.dto.CampsDTO;
import com.medical.caresync.entities.*;
import com.medical.caresync.repository.CampsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CampsService {

    @Autowired
    private CampsRepository repository;

    public List<Camps> getAllCamps() {
        return repository.findAll();
    }

    public Optional<Camps> getCampById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Camps createCamp(CampsDTO campsDTO) {
        Camps camp = new Camps();
        camp.setCampName(campsDTO.getCampName());
        camp.setCampCode(campsDTO.getCampCode());
        camp.setDescription(campsDTO.getDescription());
        camp.setIsActive(true);
        camp.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        camp.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        camp.setOrganizerEmail(campsDTO.getOrganizerEmail());
        camp.setOrganizerName(campsDTO.getOrganizerName());
        camp.setOrganizerPhone(campsDTO.getOrganizerPhone());
        camp.setCreatedBy("ADMIN");
        camp.setUpdatedBy("ADMIN");
        camp.setCampEstablishmentYear(campsDTO.getEstablishmentYear());

        CampAddress campLocationAddress = new CampAddress();
        campLocationAddress.setAddressType(AddressType.LOCATION);
        campLocationAddress.setAddress(getCampAddressFromDTO(campsDTO.getLocationAddress()));
        campLocationAddress.setValidFrom(LocalDate.now());
        campLocationAddress.setCamp(camp);

        CampAddress campShippingAddress = new CampAddress();
        campShippingAddress.setAddressType(AddressType.SHIPPING);
        campShippingAddress.setAddress(getCampAddressFromDTO(campsDTO.getShippingAddress()));
        campShippingAddress.setValidFrom(LocalDate.now());
        campShippingAddress.setCamp(camp);
        camp.setCampAddresses(List.of(campLocationAddress, campShippingAddress));

        CampScheduleTemplates campScheduleTemplates = getCampScheduleTemplatesFromDTO(campsDTO.getCampScheduleTemplate());
        campScheduleTemplates.setCamps(camp);
        camp.setSchedules(List.of(campScheduleTemplates));
        return repository.save(camp);
    }

    private Address getCampAddressFromDTO(AddressDTO addressDTO) {
        Address address = new Address();
        address.setAddressLine1(addressDTO.getAddressLine1());
        address.setAddressLine2(addressDTO.getAddressLine2());
        address.setCity(addressDTO.getCity());
        address.setDistrict(new DistrictLookup(addressDTO.getDistrictId()));
        address.setMandal(new MandalLookup(addressDTO.getMandalId()));
        address.setState(new StateLookup(addressDTO.getStateId()));
        address.setPostalCode(addressDTO.getPostalCode());
        address.setCreatedAt(LocalDateTime.now());
        address.setCreatedBy("ADMIN");
        address.setUpdatedAt(LocalDateTime.now());
        address.setUpdatedBy("ADMIN");
        return address;
    }

    private CampScheduleTemplates getCampScheduleTemplatesFromDTO(CampScheduleTemplateDTO campScheduleTemplateDTO) {
        CampScheduleTemplates campScheduleTemplates = new CampScheduleTemplates();
        campScheduleTemplates.setDayOfWeek(campScheduleTemplates.getDayOfWeek());
        campScheduleTemplates.setIsActive(true);
        campScheduleTemplates.setMonthJanuary(campScheduleTemplateDTO.getJanuary());
        campScheduleTemplates.setMonthFebruary(campScheduleTemplateDTO.getFebruary());
        campScheduleTemplates.setMonthMarch(campScheduleTemplateDTO.getMarch());
        campScheduleTemplates.setMonthApril(campScheduleTemplateDTO.getApril());
        campScheduleTemplates.setMonthMay(campScheduleTemplateDTO.getMay());
        campScheduleTemplates.setMonthJune(campScheduleTemplateDTO.getJune());
        campScheduleTemplates.setMonthJuly(campScheduleTemplateDTO.getJuly());
        campScheduleTemplates.setMonthAugust(campScheduleTemplateDTO.getAugust());
        campScheduleTemplates.setMonthSeptember(campScheduleTemplateDTO.getSeptember());
        campScheduleTemplates.setMonthOctober(campScheduleTemplateDTO.getOctober());
        campScheduleTemplates.setMonthNovember(campScheduleTemplateDTO.getNovember());
        campScheduleTemplates.setMonthDecember(campScheduleTemplateDTO.getDecember());
        campScheduleTemplates.setCreatedAt(LocalDateTime.now());
        campScheduleTemplates.setCreatedBy("ADMIN");
        campScheduleTemplates.setUpdatedAt(LocalDateTime.now());
        campScheduleTemplates.setUpdatedBy("ADMIN");
        return campScheduleTemplates;
    }

    @Transactional
    public Camps updateCamp(Long id, Camps campDetails) {
        Optional<Camps> optionalCamp = repository.findById(id);
        if (optionalCamp.isPresent()) {
            Camps camp = optionalCamp.get();
            camp.setCampName(campDetails.getCampName());
            camp.setDescription(campDetails.getDescription());
            camp.setIsActive(campDetails.getIsActive());
            camp.setCampEstablishmentYear(campDetails.getCampEstablishmentYear());
            camp.setCampCode(campDetails.getCampCode());
            camp.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            camp.setUpdatedBy(campDetails.getUpdatedBy());
            return repository.save(camp);
        }
        return null;
    }

    @Transactional
    public void deleteCamp(Long id) {
        repository.deleteById(id);
    }

    public List<Camps> getActiveCamps() {
        return repository.findAllActiveCamps();
    }
}

