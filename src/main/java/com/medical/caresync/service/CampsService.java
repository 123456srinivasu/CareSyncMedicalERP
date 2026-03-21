package com.medical.caresync.service;

import com.medical.caresync.dto.*;
import com.medical.caresync.entities.*;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.repository.CampSpecification;
import com.medical.caresync.repository.CampsRepository;
import com.medical.caresync.repository.UsersRepository;
import com.medical.caresync.util.CampRunStatus;
import com.medical.caresync.util.CampScheduleUtil;
import com.medical.caresync.util.PageMapper;
import com.medical.caresync.util.UsersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CampsService {

    @Autowired
    private CampsRepository repository;
    @Autowired
    private UsersRepository usersRepository;

    public PageResponse<CampsListDTO> getAllCamps(String status, Long stateId, Long districtId
            , Long mandalId, String campName, String cityName, Pageable pageable) {
        Specification<Camps> spec = Specification
                .where(CampSpecification.hasStatus(status))
                .and(CampSpecification.hasCampName(campName))
                .and(
                        CampSpecification.hasAddressFilters(
                                stateId, districtId, mandalId, cityName
                        )
                );
        Page<Camps> page = repository.findAll(spec, pageable);

        return PageMapper.mapToPageResponse(page, this::mapToCampListDTO );
    }



    public Optional<Camps> getCampById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Camps createCamp(CampsDTO campsDTO) {
        validateCreateCampRequest(campsDTO);
        List<Users> users = validateCampUserIds(campsDTO);

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
        camp.setMedicineResponsibility(campsDTO.getMedicineResponsibility());

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

        CampScheduleTemplates campScheduleTemplates = getCampScheduleTemplatesFromDTO(campsDTO.getCampScheduleTemplate(), camp);
        campScheduleTemplates.setCamps(camp);
        camp.setSchedules(List.of(campScheduleTemplates));
        assignUsersToCamp(camp, users);
        return repository.save(camp);
    }

    private void assignUsersToCamp(Camps camp, List<Users> users) {
        Set<CampUsers> newCampUsers = users.stream().map(user -> {
            CampUsers campUsers = new CampUsers();
            campUsers.setCamps(camp);
            campUsers.setUsers(user);
            campUsers.setCreatedAt(LocalDateTime.now());
            campUsers.setUpdateAt(LocalDateTime.now());
            campUsers.setCreatedBy("ADMIN");
            campUsers.setUpdatedBy("ADMIN");
            return campUsers;
        }).collect(Collectors.toSet());
        
        camp.getCampUsers().clear();
        camp.getCampUsers().addAll(newCampUsers);
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

    private CampScheduleTemplates getCampScheduleTemplatesFromDTO(CampScheduleTemplateDTO campScheduleTemplateDTO, Camps camps) {
        CampScheduleTemplates campScheduleTemplates = new CampScheduleTemplates();
        campScheduleTemplates.setDayOfWeek(CampScheduleTemplates.DayOfWeekEnum.valueOf(campScheduleTemplateDTO.getDayOfWeek().toUpperCase()));
        campScheduleTemplates.setWeekOfMonth(campScheduleTemplateDTO.getWeekOfMonth());
        campScheduleTemplates.setIsActive(true);
        campScheduleTemplates.setMonthJanuary(campScheduleTemplateDTO.getMonthJanuary());
        campScheduleTemplates.setMonthFebruary(campScheduleTemplateDTO.getMonthFebruary());
        campScheduleTemplates.setMonthMarch(campScheduleTemplateDTO.getMonthMarch());
        campScheduleTemplates.setMonthApril(campScheduleTemplateDTO.getMonthApril());
        campScheduleTemplates.setMonthMay(campScheduleTemplateDTO.getMonthMay());
        campScheduleTemplates.setMonthJune(campScheduleTemplateDTO.getMonthJune());
        campScheduleTemplates.setMonthJuly(campScheduleTemplateDTO.getMonthJuly());
        campScheduleTemplates.setMonthAugust(campScheduleTemplateDTO.getMonthAugust());
        campScheduleTemplates.setMonthSeptember(campScheduleTemplateDTO.getMonthSeptember());
        campScheduleTemplates.setMonthOctober(campScheduleTemplateDTO.getMonthOctober());
        campScheduleTemplates.setMonthNovember(campScheduleTemplateDTO.getMonthNovember());
        campScheduleTemplates.setMonthDecember(campScheduleTemplateDTO.getMonthDecember());
        campScheduleTemplates.setCreatedAt(LocalDateTime.now());
        campScheduleTemplates.setCreatedBy("ADMIN");
        campScheduleTemplates.setUpdatedAt(LocalDateTime.now());
        campScheduleTemplates.setUpdatedBy("ADMIN");
        campScheduleTemplates.setCamps(camps);
        return campScheduleTemplates;
    }

    @Transactional
    public Camps updateCamp(Long id, CampsDTO campsDTO) {
        validateCreateCampRequest(campsDTO);
        List<Users> users = validateCampUserIds(campsDTO);
        
        Optional<Camps> optionalCamp = repository.findById(id);
        if (optionalCamp.isPresent()) {
            Camps camp = optionalCamp.get();
            camp.setCampName(campsDTO.getCampName());
            camp.setDescription(campsDTO.getDescription());
            camp.setOrganizerName(campsDTO.getOrganizerName());
            camp.setOrganizerEmail(campsDTO.getOrganizerEmail());
            camp.setOrganizerPhone(campsDTO.getOrganizerPhone());
            camp.setCampCode(campsDTO.getCampCode());
            camp.setMedicineResponsibility(campsDTO.getMedicineResponsibility());
            camp.setCampEstablishmentYear(campsDTO.getEstablishmentYear());
            camp.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            camp.setUpdatedBy("ADMIN");
            if (campsDTO.getIsActive() != null) {
                camp.setIsActive(campsDTO.getIsActive());
            }

            // Update Addresses
            updateCampAddresses(camp, campsDTO);

            // Update Schedule
            updateCampSchedule(camp, campsDTO.getCampScheduleTemplate());

            // Update Staff
            assignUsersToCamp(camp, users);

            return repository.save(camp);
        }
        return null;
    }

    private void updateCampAddresses(Camps camp, CampsDTO campsDTO) {
        for (CampAddress campAddress : camp.getCampAddresses()) {
            if (AddressType.LOCATION.equals(campAddress.getAddressType())) {
                updateAddressFromDTO(campAddress.getAddress(), campsDTO.getLocationAddress());
            } else if (AddressType.SHIPPING.equals(campAddress.getAddressType())) {
                updateAddressFromDTO(campAddress.getAddress(), campsDTO.getShippingAddress());
            }
        }
    }

    private void updateAddressFromDTO(Address address, AddressDTO addressDTO) {
        address.setAddressLine1(addressDTO.getAddressLine1());
        address.setAddressLine2(addressDTO.getAddressLine2());
        address.setCity(addressDTO.getCity());
        address.setDistrict(new DistrictLookup(addressDTO.getDistrictId()));
        address.setMandal(new MandalLookup(addressDTO.getMandalId()));
        address.setState(new StateLookup(addressDTO.getStateId()));
        address.setPostalCode(addressDTO.getPostalCode());
        address.setUpdatedAt(LocalDateTime.now());
        address.setUpdatedBy("ADMIN");
    }

    private void updateCampSchedule(Camps camp, CampScheduleTemplateDTO dto) {
        Optional<CampScheduleTemplates> activeScheduleOpt = camp.getSchedules().stream()
                .filter(CampScheduleTemplates::getIsActive)
                .findFirst();

        if (activeScheduleOpt.isPresent()) {
            CampScheduleTemplates schedule = activeScheduleOpt.get();
            schedule.setDayOfWeek(CampScheduleTemplates.DayOfWeekEnum.valueOf(dto.getDayOfWeek().toUpperCase()));
            schedule.setWeekOfMonth(dto.getWeekOfMonth());
            schedule.setMonthJanuary(dto.getMonthJanuary());
            schedule.setMonthFebruary(dto.getMonthFebruary());
            schedule.setMonthMarch(dto.getMonthMarch());
            schedule.setMonthApril(dto.getMonthApril());
            schedule.setMonthMay(dto.getMonthMay());
            schedule.setMonthJune(dto.getMonthJune());
            schedule.setMonthJuly(dto.getMonthJuly());
            schedule.setMonthAugust(dto.getMonthAugust());
            schedule.setMonthSeptember(dto.getMonthSeptember());
            schedule.setMonthOctober(dto.getMonthOctober());
            schedule.setMonthNovember(dto.getMonthNovember());
            schedule.setMonthDecember(dto.getMonthDecember());
            schedule.setUpdatedAt(LocalDateTime.now());
            schedule.setUpdatedBy("ADMIN");
        }
    }

    @Transactional
    public void deleteCamp(Long id) {
        repository.deleteById(id);
    }

    public List<Camps> getActiveCamps() {
        return repository.findAllActiveCamps();
    }

    private void validateCreateCampRequest(CampsDTO request) {
        if (request.getCampUserIds()== null || request.getCampUserIds().isEmpty()) {
            throw new BadRequestException("Camp Users Can't Be Empty");
        }

    }

    private List<Users> validateCampUserIds(CampsDTO request) {
        List<Users> users = usersRepository.findAllById(request.getCampUserIds());
        Set<Long> foundIds = users.stream().map(Users::getUserId).collect(Collectors.toSet());
        Set<Long> requestedIds = new HashSet<>(request.getCampUserIds());
        requestedIds.removeAll(foundIds);
        if (!requestedIds.isEmpty()) {
            throw new BadRequestException(
                    "Invalid userIds: " + requestedIds
            );
        }
        return users;
    }

    private CampsListDTO mapToCampListDTO(Camps camps) {
        CampsListDTO campsListDTO = new CampsListDTO();
        campsListDTO.setCampId(camps.getCampId());
        campsListDTO.setCampName(camps.getCampName());
        campsListDTO.setCampCode(camps.getCampCode());
        campsListDTO.setOrganizerName(camps.getOrganizerName());
        campsListDTO.setOrganizerPhone(camps.getOrganizerPhone());
        campsListDTO.setOrganizerEmail(camps.getOrganizerEmail());
        setCampRunData(camps, campsListDTO);
        campsListDTO.setActive(camps.getIsActive());
        campsListDTO.setLocationAddress(getAddressResponseDTOByAddressType(camps.getCampAddresses()
                , AddressType.LOCATION));
        campsListDTO.setShippingAddress(getAddressResponseDTOByAddressType(camps.getCampAddresses()
                , AddressType.SHIPPING));
        campsListDTO.setCampRunning(camps.getCampRuns().stream().anyMatch(campRuns -> CampRunStatus.STARTED.equals(campRuns.getStatus())));

        campsListDTO.setDoctors(camps.getCampUsers().stream()
                .filter(CampUsers::isDoctor)
                .map(campUser -> UsersUtil.mapToUserResponse(campUser.getUsers()))
                .collect(Collectors.toList()));

        campsListDTO.setVolunteers(camps.getCampUsers().stream()
                .filter(CampUsers::isVolunteer)
                .map(campUser -> UsersUtil.mapToUserResponse(campUser.getUsers()))
                .collect(Collectors.toList()));

        camps.getSchedules().stream()
                .filter(CampScheduleTemplates::getIsActive)
                .findFirst()
                .ifPresent(schedule -> campsListDTO.setCampScheduleTemplate(mapToCampScheduleDTO(schedule)));

        campsListDTO.setMedicineResponsibility(camps.getMedicineResponsibility());

        return campsListDTO;
    }

    private AddressResponseDTO getAddressResponseDTOByAddressType(List<CampAddress> campAddresses, AddressType addressType) {
        Optional<CampAddress> addressOptional = campAddresses.stream().filter(campAddress -> addressType.equals(campAddress.getAddressType()))
                .findFirst();
        return addressOptional.map(campAddress -> mapToAddressResponseDTO(campAddress.getAddress())).orElse(null);
    }

    private void setCampRunData(Camps camp, CampsListDTO campsListDTO) {
        Optional<CampRuns> activeRunOpt = camp.getCampRuns()
                .stream()
                .filter(cr -> cr.getStatus() == CampRunStatus.PLANNED
                        || cr.getStatus() == CampRunStatus.STARTED)
                .min((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));

        if (activeRunOpt.isPresent()) {
            CampRuns run = activeRunOpt.get();
            campsListDTO.setCampRunId(run.getCampRunId());
            if (run.getStatus() == CampRunStatus.PLANNED) {
                campsListDTO.setPlannedDate(run.getPlannedDate());
                campsListDTO.setCampReadyToStart(run.isCampReadyToStart());
            } else {
                campsListDTO.setPlannedDate(run.getActualDate());
                campsListDTO.setCampReadyToStart(run.isCampReadyToStart());
            }
            campsListDTO.setOrganizerPhone(run.getOrganizerPhone());
            campsListDTO.setOrganizerName(run.getOrganizerName());
            campsListDTO.setOrganizerEmail(run.getOrganizerEmail());
        } else {
            Optional<CampScheduleTemplates> campScheduleOpt = camp.getSchedules().stream().filter(CampScheduleTemplates::getIsActive).findFirst();
            campScheduleOpt.ifPresentOrElse(campScheduleTemplates -> campsListDTO.setPlannedDate(CampScheduleUtil.deriveNextDateForSchedule(campScheduleTemplates
                    , LocalDate.now())), () -> campsListDTO.setPlannedDate(LocalDate.now()));
            campsListDTO.setCampReadyToStart(false);
        }
    }

    private AddressResponseDTO mapToAddressResponseDTO(Address address) {
        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
        addressResponseDTO.setCity(address.getCity());
        addressResponseDTO.setAddressLine1(address.getAddressLine1());
        addressResponseDTO.setAddressLine2(address.getAddressLine2());
        addressResponseDTO.setDistrictId(address.getDistrict().getDistrictLookupId());
        addressResponseDTO.setDistrictName(address.getDistrict().getDistrictName());
        addressResponseDTO.setPostalCode(address.getPostalCode());
        addressResponseDTO.setMandalId(address.getMandal().getMandalLookupId());
        addressResponseDTO.setMandalName(address.getMandal().getMandalName());
        addressResponseDTO.setStateId(address.getState().getStateLookupId());
        addressResponseDTO.setStateName(address.getState().getStateName());
        return addressResponseDTO;
    }

    private boolean hasDoctors(Set<CampUsers> campUsers){
        if(CollectionUtils.isEmpty(campUsers))
            return false;
        return campUsers.stream().anyMatch(CampUsers::isDoctor);
    }

    private boolean hasVolunteers(Set<CampUsers> campUsers) {
        if(CollectionUtils.isEmpty(campUsers))
            return false;
        return campUsers.stream().anyMatch(CampUsers::isVolunteer);
    }

    private boolean hasMedicineStock(List<CampMedicineStockSummary> campMedicineStockSummary) {
        if(CollectionUtils.isEmpty(campMedicineStockSummary))
            return false;
        return true;
    }

    private CampScheduleTemplateDTO mapToCampScheduleDTO(CampScheduleTemplates schedule) {
        CampScheduleTemplateDTO dto = new CampScheduleTemplateDTO();
        dto.setDayOfWeek(schedule.getDayOfWeek().name());
        dto.setWeekOfMonth(schedule.getWeekOfMonth());
        dto.setMonthJanuary(schedule.getMonthJanuary());
        dto.setMonthFebruary(schedule.getMonthFebruary());
        dto.setMonthMarch(schedule.getMonthMarch());
        dto.setMonthApril(schedule.getMonthApril());
        dto.setMonthMay(schedule.getMonthMay());
        dto.setMonthJune(schedule.getMonthJune());
        dto.setMonthJuly(schedule.getMonthJuly());
        dto.setMonthAugust(schedule.getMonthAugust());
        dto.setMonthSeptember(schedule.getMonthSeptember());
        dto.setMonthOctober(schedule.getMonthOctober());
        dto.setMonthNovember(schedule.getMonthNovember());
        dto.setMonthDecember(schedule.getMonthDecember());
        return dto;
    }



}

