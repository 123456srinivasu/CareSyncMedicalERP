package com.medical.caresync.service;

import com.medical.caresync.dto.*;
import com.medical.caresync.entities.*;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.repository.CampSpecification;
import com.medical.caresync.repository.CampsRepository;
import com.medical.caresync.repository.UsersRepository;
import com.medical.caresync.repository.WarehouseMasterRepository;
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
    @Autowired
    private WarehouseMasterRepository warehouseMasterRepository;

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
    public Camps createCamp(CampBasicDTO basicDTO) {
        Camps camp = new Camps();
        mapBasicDtoToEntity(basicDTO, camp);
        camp.setIsActive(true);
        camp.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        camp.setCreatedBy("ADMIN");
        return repository.save(camp);
    }

    private void mapBasicDtoToEntity(CampBasicDTO basicDTO, Camps camp) {
        camp.setCampName(basicDTO.getCampName());
        camp.setCampCode(basicDTO.getCampCode());
        camp.setDescription(basicDTO.getDescription());
        camp.setOrganizerEmail(basicDTO.getOrganizerEmail());
        camp.setOrganizerName(basicDTO.getOrganizerName());
        camp.setOrganizerPhone(basicDTO.getOrganizerPhone());
        camp.setCampEstablishmentYear(basicDTO.getEstablishmentYear());
        camp.setMedicineWarehouse(basicDTO.getMedicineWarehouse());
        camp.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        camp.setUpdatedBy("ADMIN");
        if (basicDTO.getActive() != null) {
            camp.setIsActive(basicDTO.getActive());
        }

        if (basicDTO.getOrganizerUserId() != null) {
            usersRepository.findById(basicDTO.getOrganizerUserId()).ifPresent(camp::setOrganizerUser);
        }

        if (basicDTO.getMedicineWarehouseId() != null) {
            warehouseMasterRepository.findById(basicDTO.getMedicineWarehouseId()).ifPresent(camp::setMedicineWarehouseLink);
        }

        // Update addresses from basic DTO
        updateCampAddresses(camp, basicDTO.getLocationAddress(), basicDTO.getShippingAddress());

        // Update schedule templates
        if (basicDTO.getSchedules() != null) {
            updateCampSchedules(camp, basicDTO.getSchedules());
        }
    }

    private void updateCampSchedules(Camps camp, List<CampScheduleTemplateDTO> scheduleDtos) {
        if (camp.getSchedules() == null) {
            camp.setSchedules(new ArrayList<>());
        } else {
            camp.getSchedules().clear();
        }

        for (CampScheduleTemplateDTO dto : scheduleDtos) {
            camp.getSchedules().add(getCampScheduleTemplatesFromDTO(dto, camp));
        }
    }

    private void updateCampAddresses(Camps camp, AddressDTO locationAddress, AddressDTO shippingAddress) {
        if (camp.getCampAddresses() == null) {
            camp.setCampAddresses(new ArrayList<>());
        }

        boolean locationUpdated = false;
        boolean shippingUpdated = false;

        for (CampAddress campAddress : camp.getCampAddresses()) {
            if (AddressType.LOCATION.equals(campAddress.getAddressType()) && locationAddress != null) {
                updateAddressFromDTO(campAddress.getAddress(), locationAddress);
                locationUpdated = true;
            } else if (AddressType.SHIPPING.equals(campAddress.getAddressType()) && shippingAddress != null) {
                updateAddressFromDTO(campAddress.getAddress(), shippingAddress);
                shippingUpdated = true;
            }
        }

        if (!locationUpdated && locationAddress != null) {
            CampAddress location = new CampAddress();
            location.setAddressType(AddressType.LOCATION);
            location.setAddress(getCampAddressFromDTO(locationAddress));
            location.setValidFrom(LocalDate.now());
            location.setCamp(camp);
            camp.getCampAddresses().add(location);
        }

        if (!shippingUpdated && shippingAddress != null) {
            CampAddress shipping = new CampAddress();
            shipping.setAddressType(AddressType.SHIPPING);
            shipping.setAddress(getCampAddressFromDTO(shippingAddress));
            shipping.setValidFrom(LocalDate.now());
            shipping.setCamp(camp);
            camp.getCampAddresses().add(shipping);
        }
    }

    @Transactional
    public Camps updateCampBasic(Long id, CampBasicDTO basicDTO) {
        Optional<Camps> optionalCamp = repository.findById(id);
        if (optionalCamp.isPresent()) {
            Camps camp = optionalCamp.get();
            mapBasicDtoToEntity(basicDTO, camp);
            return repository.save(camp);
        }
        throw new BadRequestException("Camp not found with ID: " + id);
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
    public void saveAdditionalDetails(Long campId, CampAdditionalDetailsDTO detailsDTO) {
        Optional<Camps> optionalCamp = repository.findById(campId);
        if (optionalCamp.isEmpty()) {
            throw new BadRequestException("Camp not found with ID: " + campId);
        }
        Camps camp = optionalCamp.get();

        // Update Addresses
        updateCampAddresses(camp, detailsDTO.getLocationAddress(), detailsDTO.getShippingAddress());

        // Update Schedule
        if (detailsDTO.getCampScheduleTemplate() != null) {
            updateCampSchedule(camp, detailsDTO.getCampScheduleTemplate());
            if (camp.getSchedules() == null || camp.getSchedules().isEmpty()) {
                CampScheduleTemplates template = getCampScheduleTemplatesFromDTO(detailsDTO.getCampScheduleTemplate(), camp);
                camp.setSchedules(new ArrayList<>(List.of(template)));
            }
        }

        // Update Staff
        if (detailsDTO.getCampUserIds() != null) {
            List<Users> users = usersRepository.findAllById(detailsDTO.getCampUserIds());
            assignUsersToCamp(camp, users);
        }

        repository.save(camp);
    }

    private void updateCampAddressesFromAdditionalDetails(Camps camp, CampAdditionalDetailsDTO detailsDTO) {
        updateCampAddresses(camp, detailsDTO.getLocationAddress(), detailsDTO.getShippingAddress());
    }

    public CampBasicDTO getCampBasicById(Long id) {
        Camps camp = repository.findById(id).orElseThrow(() -> new BadRequestException("Camp not found"));
        return mapToCampBasicDTO(camp);
    }

    public CampAdditionalDetailsDTO getAdditionalDetails(Long id) {
        Camps camp = repository.findById(id).orElseThrow(() -> new BadRequestException("Camp not found"));
        CampAdditionalDetailsDTO dto = new CampAdditionalDetailsDTO();
        
        // Map Addresses
        if (camp.getCampAddresses() != null) {
            camp.getCampAddresses().stream()
                .filter(a -> AddressType.LOCATION.equals(a.getAddressType()))
                .findFirst().ifPresent(a -> dto.setLocationAddress(mapAddressToDTO(a.getAddress())));
            
            camp.getCampAddresses().stream()
                .filter(a -> AddressType.SHIPPING.equals(a.getAddressType()))
                .findFirst().ifPresent(a -> dto.setShippingAddress(mapAddressToDTO(a.getAddress())));
        }

        // Map Schedule
        if (camp.getSchedules() != null) {
            camp.getSchedules().stream()
                .filter(CampScheduleTemplates::getIsActive)
                .findFirst().ifPresent(s -> dto.setCampScheduleTemplate(mapToCampScheduleDTO(s)));
        }

        // Map Staff
        if (camp.getCampUsers() != null) {
            dto.setCampUserIds(camp.getCampUsers().stream()
                .map(cu -> cu.getUsers().getUserId())
                .collect(Collectors.toList()));
        }

        return dto;
    }

    private AddressDTO mapAddressToDTO(Address address) {
        if (address == null) return null;
        AddressDTO dto = new AddressDTO();
        dto.setAddressLine1(address.getAddressLine1());
        dto.setAddressLine2(address.getAddressLine2());
        dto.setCity(address.getCity());
        if (address.getDistrict() != null) {
            dto.setDistrictId(address.getDistrict().getDistrictLookupId());
        }
        if (address.getMandal() != null) {
            dto.setMandalId(address.getMandal().getMandalLookupId());
        }
        if (address.getState() != null) {
            dto.setStateId(address.getState().getStateLookupId());
        }
        dto.setPostalCode(address.getPostalCode());
        return dto;
    }

    private CampBasicDTO mapToCampBasicDTO(Camps camp) {
        CampBasicDTO dto = new CampBasicDTO();
        dto.setCampId(camp.getCampId());
        dto.setCampName(camp.getCampName());
        dto.setCampCode(camp.getCampCode());
        dto.setDescription(camp.getDescription());
        dto.setOrganizerName(camp.getOrganizerName());
        dto.setOrganizerEmail(camp.getOrganizerEmail());
        dto.setOrganizerPhone(camp.getOrganizerPhone());
        dto.setEstablishmentYear(camp.getCampEstablishmentYear());
        dto.setMedicineWarehouse(camp.getMedicineWarehouse());
        if (camp.getMedicineWarehouseLink() != null) {
            dto.setMedicineWarehouseId(camp.getMedicineWarehouseLink().getId());
            dto.setMedicineWarehouseDetails(mapToWarehouseDTO(camp.getMedicineWarehouseLink()));
        }
        dto.setActive(camp.getIsActive());

        if (camp.getOrganizerUser() != null) {
            dto.setOrganizerUserId(camp.getOrganizerUser().getUserId());
            dto.setOrganizerUserDetails(UsersUtil.mapToUserResponse(camp.getOrganizerUser()));
        }

        // Map addresses for basic DTO
        if (camp.getCampAddresses() != null) {
            camp.getCampAddresses().stream()
                .filter(a -> AddressType.LOCATION.equals(a.getAddressType()))
                .findFirst().ifPresent(a -> dto.setLocationAddress(mapAddressToDTO(a.getAddress())));
            
            camp.getCampAddresses().stream()
                .filter(a -> AddressType.SHIPPING.equals(a.getAddressType()))
                .findFirst().ifPresent(a -> dto.setShippingAddress(mapAddressToDTO(a.getAddress())));
        }

        // Map schedules
        if (camp.getSchedules() != null) {
            dto.setSchedules(camp.getSchedules().stream()
                    .filter(s -> s.getIsActive() != null && s.getIsActive())
                    .map(this::mapToCampScheduleDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
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
        campsListDTO.setDescription(camps.getDescription());
        
        // Use basic fields if present
        campsListDTO.setOrganizerName(camps.getOrganizerName());
        campsListDTO.setOrganizerPhone(camps.getOrganizerPhone());
        campsListDTO.setOrganizerEmail(camps.getOrganizerEmail());
        
        // Override with User details if linked
        if (camps.getOrganizerUser() != null) {
            UsersResponseDTO userDto = UsersUtil.mapToUserResponse(camps.getOrganizerUser());
            campsListDTO.setOrganizerUserDetails(userDto);
            // Also update the top-level fields for convenience
            campsListDTO.setOrganizerName(userDto.getFirstName() + " " + (userDto.getLastName() != null ? userDto.getLastName() : ""));
            campsListDTO.setOrganizerEmail(userDto.getEmail());
            campsListDTO.setOrganizerPhone(userDto.getPhone());
        }

        setCampRunData(camps, campsListDTO);
        campsListDTO.setActive(camps.getIsActive() != null ? camps.getIsActive() : false);
        
        if (camps.getCampRuns() != null) {
            campsListDTO.setCampRunning(camps.getCampRuns().stream().anyMatch(run -> CampRunStatus.STARTED.equals(run.getStatus())));
        } else {
            campsListDTO.setCampRunning(false);
        }

        campsListDTO.setMedicineWarehouse(camps.getMedicineWarehouse());
        if (camps.getMedicineWarehouseLink() != null) {
            campsListDTO.setMedicineWarehouseId(camps.getMedicineWarehouseLink().getId());
            campsListDTO.setMedicineWarehouseNameLink(camps.getMedicineWarehouseLink().getWarehouseName());
            campsListDTO.setMedicineWarehouseDetails(mapToWarehouseDTO(camps.getMedicineWarehouseLink()));
        }

        // Map addresses for list DTO
        if (camps.getCampAddresses() != null) {
            camps.getCampAddresses().stream()
                .filter(a -> AddressType.LOCATION.equals(a.getAddressType()))
                .findFirst().ifPresent(a -> campsListDTO.setLocationAddress(mapAddressToDTO(a.getAddress())));
            
            camps.getCampAddresses().stream()
                .filter(a -> AddressType.SHIPPING.equals(a.getAddressType()))
                .findFirst().ifPresent(a -> campsListDTO.setShippingAddress(mapAddressToDTO(a.getAddress())));
        }

        // Map schedules
        if (camps.getSchedules() != null) {
            campsListDTO.setSchedules(camps.getSchedules().stream()
                    .filter(s -> s.getIsActive() != null && s.getIsActive())
                    .map(this::mapToCampScheduleDTO)
                    .collect(Collectors.toList()));
        }

        return campsListDTO;
    }

    private AddressResponseDTO getAddressResponseDTOByAddressType(List<CampAddress> campAddresses, AddressType addressType) {
        if (campAddresses == null) return null;
        Optional<CampAddress> addressOptional = campAddresses.stream().filter(campAddress -> addressType.equals(campAddress.getAddressType()))
                .findFirst();
        return addressOptional.map(campAddress -> mapToAddressResponseDTO(campAddress.getAddress())).orElse(null);
    }

    private void setCampRunData(Camps camp, CampsListDTO campsListDTO) {
        if (camp.getCampRuns() == null) {
            campsListDTO.setCampReadyToStart(false);
            setPlannedDateFromSchedule(camp, campsListDTO);
            return;
        }

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
            setPlannedDateFromSchedule(camp, campsListDTO);
            campsListDTO.setCampReadyToStart(false);
        }
    }

    private void setPlannedDateFromSchedule(Camps camp, CampsListDTO campsListDTO) {
        if (camp.getSchedules() != null) {
            Optional<CampScheduleTemplates> campScheduleOpt = camp.getSchedules().stream()
                    .filter(s -> s.getIsActive() != null && s.getIsActive())
                    .findFirst();
            campScheduleOpt.ifPresentOrElse(
                    campScheduleTemplates -> campsListDTO.setPlannedDate(CampScheduleUtil.deriveNextDateForSchedule(campScheduleTemplates, LocalDate.now())),
                    () -> campsListDTO.setPlannedDate(LocalDate.now())
            );
        } else {
            campsListDTO.setPlannedDate(LocalDate.now());
        }
    }

    private AddressResponseDTO mapToAddressResponseDTO(Address address) {
        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
        addressResponseDTO.setCity(address.getCity());
        addressResponseDTO.setAddressLine1(address.getAddressLine1());
        addressResponseDTO.setAddressLine2(address.getAddressLine2());
        if (address.getDistrict() != null) {
            addressResponseDTO.setDistrictId(address.getDistrict().getDistrictLookupId());
            addressResponseDTO.setDistrictName(address.getDistrict().getDistrictName());
        }
        addressResponseDTO.setPostalCode(address.getPostalCode());
        if (address.getMandal() != null) {
            addressResponseDTO.setMandalId(address.getMandal().getMandalLookupId());
            addressResponseDTO.setMandalName(address.getMandal().getMandalName());
        }
        if (address.getState() != null) {
            addressResponseDTO.setStateId(address.getState().getStateLookupId());
            addressResponseDTO.setStateName(address.getState().getStateName());
        }
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

    private WarehouseMasterDTO mapToWarehouseDTO(WarehouseMaster entity) {
        if (entity == null) return null;
        WarehouseMasterDTO dto = new WarehouseMasterDTO();
        dto.setId(entity.getId());
        dto.setWarehouseCode(entity.getWarehouseCode());
        dto.setWarehouseName(entity.getWarehouseName());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setPostalCode(entity.getPostalCode());
        
        if (entity.getState() != null && entity.getState().getStateLookupId() != null) {
            dto.setStateId((long) entity.getState().getStateLookupId());
            dto.setStateName(entity.getState().getStateName());
        }
        if (entity.getDistrict() != null && entity.getDistrict().getDistrictLookupId() != null) {
            dto.setDistrictId((long) entity.getDistrict().getDistrictLookupId());
            dto.setDistrictName(entity.getDistrict().getDistrictName());
        }
        if (entity.getMandal() != null && entity.getMandal().getMandalLookupId() != null) {
            dto.setMandalId((long) entity.getMandal().getMandalLookupId());
            dto.setMandalName(entity.getMandal().getMandalName());
        }
        
        dto.setContactPerson(entity.getContactPerson());
        dto.setContactNumber(entity.getContactNumber());
        dto.setEmailAddress(entity.getEmailAddress());
        dto.setIsActive(entity.getIsActive());
        
        return dto;
    }



}

