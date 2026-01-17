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
        Set<CampUsers> campUserList = users.stream().map(user -> {
            CampUsers campUsers = new CampUsers();
            campUsers.setCamps(camp);
            campUsers.setUsers(user);
            campUsers.setCreatedAt(LocalDateTime.now());
            campUsers.setUpdateAt(LocalDateTime.now());
            campUsers.setCreatedBy("ADMIN");
            campUsers.setUpdatedBy("ADMIN");
            return campUsers;
        }).collect(Collectors.toSet());
        camp.setCampUsers(campUserList);
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
        campScheduleTemplates.setCamps(camps);
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



}

