package com.medical.caresync.service;

import com.medical.caresync.dto.CampRunPlanningSaveRequestDTO;
import com.medical.caresync.dto.CampRunPlanningViewDTO;
import com.medical.caresync.dto.UsersResponseDTO;
import com.medical.caresync.dto.ValidationError;
import com.medical.caresync.entities.*;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.exceptions.BusinessRuleViolationException;
import com.medical.caresync.exceptions.CampRunValidationException;
import com.medical.caresync.repository.CampRunsRepository;
import com.medical.caresync.repository.CampsRepository;
import com.medical.caresync.repository.UsersRepository;
import com.medical.caresync.util.CampRunStatus;
import com.medical.caresync.util.CampScheduleUtil;
import com.medical.caresync.util.UsersUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CampRunsService {

    @Autowired
    private  CampRunsRepository repository;

    @Autowired
    private CampsRepository campsRepository;
    @Autowired
    private UsersRepository usersRepository;

    public CampRunPlanningViewDTO getCampPlanningDetails(Long campId){

        Optional<CampRuns> campRunDetail = repository.findFirstByCamps_CampIdAndStatusInOrderByCreatedAtDesc(campId
                , List.of(CampRunStatus.PLANNED, CampRunStatus.STARTED));
        if(campRunDetail.isPresent()){
            CampRuns campRuns = campRunDetail.get();
            if(campRuns.getStatus().equals(CampRunStatus.STARTED)){
                throw new BusinessRuleViolationException("Camp is already running, no modifications are allowed at this time");
            }
            return getCampRunPlanningViewDTO(campRuns);
        } else {
            Optional<Camps> campById = campsRepository.findById(campId);
            if(campById.isPresent()){
                Camps camps = campById.get();
                CampRunPlanningViewDTO campRunPlanningViewDTO = new CampRunPlanningViewDTO();
                campRunPlanningViewDTO.setCampRunStatus(CampRunStatus.DRAFT);
                campRunPlanningViewDTO.setCampId(camps.getCampId());
                campRunPlanningViewDTO.setOrganizerPhone(camps.getOrganizerPhone());
                campRunPlanningViewDTO.setOrganizerName(camps.getOrganizerName());
                campRunPlanningViewDTO.setOrganizerEmail(camps.getOrganizerEmail());
                campRunPlanningViewDTO.setCampMedicineStockSummaries(camps.getCampMedicineStockSummaries());
                List<UsersResponseDTO> campUsers = camps.getCampUsers().stream().map(CampUsers::getUsers).map(UsersUtil::mapToUserResponse)
                        .toList();
                campRunPlanningViewDTO.setCampRunUsers(campUsers);
                Optional<CampScheduleTemplates> campScheduleOpt = camps.getSchedules().stream().filter(CampScheduleTemplates::getIsActive).findFirst();
                if(campScheduleOpt.isPresent()){
                    campRunPlanningViewDTO.setPlannedDate(CampScheduleUtil.deriveNextDateForSchedule(campScheduleOpt.get()
                            , LocalDate.now()));
                } else {
                    campRunPlanningViewDTO.setPlannedDate(LocalDate.now());
                }
                return campRunPlanningViewDTO;
            } else {
                throw new BadRequestException("Camp Not found with id "+ campId);
            }
        }

    }

    private static CampRunPlanningViewDTO getCampRunPlanningViewDTO(CampRuns campRuns) {
        CampRunPlanningViewDTO campRunPlanningViewDTO = new CampRunPlanningViewDTO();
        campRunPlanningViewDTO.setCampRunStatus(CampRunStatus.PLANNED);
        campRunPlanningViewDTO.setCampId(campRuns.getCamps().getCampId());
        campRunPlanningViewDTO.setCampRunId(campRuns.getCampRunId());
        campRunPlanningViewDTO.setOrganizerName(campRuns.getOrganizerName());
        campRunPlanningViewDTO.setOrganizerEmail(campRuns.getOrganizerEmail());
        campRunPlanningViewDTO.setOrganizerPhone(campRuns.getOrganizerPhone());
        campRunPlanningViewDTO.setPlannedDate(campRuns.getPlannedDate());
        campRunPlanningViewDTO.setActualStartDate(campRuns.getActualDate());
        List<UsersResponseDTO> campRunUsers = campRuns.getCampRunUsers().stream().map(CampRunStaff::getUsers)
                .map(UsersUtil::mapToUserResponse)
                .toList();
        campRunPlanningViewDTO.setCampRunUsers(campRunUsers);
        campRunPlanningViewDTO.setCampMedicineStockSummaries(campRuns.getCamps().getCampMedicineStockSummaries());
        return campRunPlanningViewDTO;
    }

    public CampRunPlanningViewDTO saveOrUpdateCampRun(CampRunPlanningSaveRequestDTO request) {
        CampRuns campRun;
        boolean isNew = false;
        if (request.getCampRunId() == null || request.getCampRunId() == 0) {
            campRun = new CampRuns();
            Camps camp = campsRepository.findById(request.getCampId())
                    .orElseThrow(() -> new BadRequestException("Camp not found"));
            campRun.setCamps(camp);
            campRun.setCampAddress(camp.getCampAddresses().stream().filter(campAddress -> campAddress.getValidTo() == null && AddressType.LOCATION.equals(campAddress.getAddressType())).findFirst().get());
            campRun.setStatus(CampRunStatus.PLANNED);
        } else {
            campRun = repository.findById(request.getCampRunId())
                    .orElseThrow(() -> new BadRequestException("CampRun not found"));
            if (campRun.getStatus() != CampRunStatus.PLANNED) {
                throw new BadRequestException("Camp is not in Planned State " +campRun.getCampRunId());
            }
        }
        campRun.setPlannedDate(request.getPlannedDate());
        campRun.setOrganizerName(request.getOrganizerName());
        campRun.setOrganizerEmail(request.getOrganizerEmail());
        campRun.setOrganizerPhone(request.getOrganizerPhone());
        campRun.getCampRunUsers().clear();
        List<CampRunStaff> staffList = request.getCampRunUsers().stream()
                .map(u -> {
                    Users user = usersRepository.findById(u)
                            .orElseThrow(() -> new BadRequestException("User not found: " + u));
                    CampRunStaff staff = new CampRunStaff();
                    staff.setCampRuns(campRun);
                    staff.setUsers(user);
                    return staff;
                })
                .toList();
        campRun.getCampRunUsers().addAll(staffList);
        repository.save(campRun);
        return getCampRunPlanningViewDTO(campRun);
    }

    public void startCampRun(Long campId, Long campRunId) {
        Camps camp = campsRepository.findById(campId)
                .orElseThrow(() -> new BusinessRuleViolationException("Camp not found with Id "+ campId));
        Optional<CampRuns> existingRun = repository.findById(campRunId);
        CampRuns campRun = null;
        if (existingRun.isPresent()) {
            campRun = existingRun.get();

            if (campRun.getStatus() == CampRunStatus.STARTED) {
                throw new BusinessRuleViolationException("Camp is already running");
            }
            validateBeforeStart(campRun);
            markStarted(campRun);
        }else {
            campRun = new CampRuns();
            campRun.setCamps(camp);
            campRun.setCampAddress(camp.getCampAddresses().stream().filter(campAddress -> campAddress.getValidTo() == null && AddressType.LOCATION.equals(campAddress.getAddressType())).findFirst().get());
            campRun.setStatus(CampRunStatus.PLANNED);
            Optional<CampScheduleTemplates> campScheduleOpt = camp.getSchedules().stream().filter(CampScheduleTemplates::getIsActive).findFirst();
            if (campScheduleOpt.isPresent()) {
                campRun.setPlannedDate(CampScheduleUtil.deriveNextDateForSchedule(campScheduleOpt.get()
                        , LocalDate.now()));
            } else {
                campRun.setPlannedDate(LocalDate.now());
            }
            campRun.setOrganizerName(camp.getOrganizerName());
            campRun.setOrganizerEmail(camp.getOrganizerEmail());
            campRun.setOrganizerPhone(camp.getOrganizerPhone());
            campRun.getCampRunUsers().clear();
            List<CampRunStaff> staffList = new ArrayList<>();
            for(CampUsers campUser: camp.getCampUsers()){
                CampRunStaff staff = new CampRunStaff();
                staff.setCampRuns(campRun);
                staff.setUsers(campUser.getUsers());
                staffList.add(staff);
            }
            campRun.getCampRunUsers().addAll(staffList);
            validateBeforeStart(campRun);
            markStarted(campRun);
        }
        repository.save(campRun);
    }

    private void validateBeforeStart(CampRuns campRun) {
        List<ValidationError> errors = new ArrayList<>();
        boolean hasDoctor = campRun.getCampRunUsers().stream()
                .anyMatch(CampRunStaff::isDoctor);

        if (!hasDoctor) {
            errors.add(new ValidationError(
                    "users",
                    "At least one doctor must be assigned"
            ));
        }
        boolean hasVolunteer = campRun.getCampRunUsers().stream()
                .anyMatch(CampRunStaff::isVolunteer);

        if (!hasVolunteer) {
            errors.add(new ValidationError(
                    "users",
                    "At least one volunteer must be assigned"
            ));
        }
        if (CollectionUtils.isEmpty(campRun.getCamps().getCampMedicineStockSummaries())) {
            errors.add(new ValidationError(
                    "medicineStock",
                    "Medicine stock must be planned"
            ));
        }
        if (!errors.isEmpty()) {
            throw new CampRunValidationException(errors);
        }
    }

    private void markStarted(CampRuns campRun) {
        campRun.setStatus(CampRunStatus.STARTED);
        campRun.setActualDate(LocalDate.now());
        //campRun.setStartedBy("ADMIN"); // TODO - set once user module is implemented with logged in User ID
    }

    public void stopCamp(Long campId, Long campRunId) {
        Optional<CampRuns> campRun = repository.findById(campRunId);
        if (campRun.isPresent()) {
            CampRuns campRuns = campRun.get();
            markStopped(campRuns);
            repository.save(campRuns);
        } else {
            List<ValidationError> errors = new ArrayList<>();
            errors.add(new ValidationError(
                    "campRun",
                    "Camp Run Id not found"
            ));
            throw new CampRunValidationException(errors);
        }
    }

    private void markStopped(CampRuns campRun) {
        campRun.setStatus(CampRunStatus.CLOSED);
        campRun.setClosedBy("ADMIN"); // TODO - set once user module is implemented with logged in User ID
        campRun.setClosedAt(LocalDateTime.now());
    }
}
