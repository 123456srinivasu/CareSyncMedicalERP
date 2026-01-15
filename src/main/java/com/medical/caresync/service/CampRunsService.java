package com.medical.caresync.service;

import com.medical.caresync.dto.CampRunPlanningViewDTO;
import com.medical.caresync.dto.UsersResponseDTO;
import com.medical.caresync.entities.*;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.exceptions.BusinessRuleViolationException;
import com.medical.caresync.repository.CampRunsRepository;
import com.medical.caresync.repository.CampsRepository;
import com.medical.caresync.util.CampRunStatus;
import com.medical.caresync.util.CampScheduleUtil;
import com.medical.caresync.util.UsersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CampRunsService {

    @Autowired
    private  CampRunsRepository repository;

    @Autowired
    private CampsRepository campsRepository;

    public CampRunPlanningViewDTO getCampPlanningDetails(Long campId){

        Optional<CampRuns> campRunDetail = repository.findFirstByCamps_CampIdAndStatusInOrderByCreatedAtDesc(campId
                , List.of(CampRunStatus.PLANNED, CampRunStatus.STARTED));
        if(campRunDetail.isPresent()){
            CampRuns campRuns = campRunDetail.get();
            if(campRuns.getStatus().equals(CampRunStatus.STARTED)){
                throw new BusinessRuleViolationException("Camp is already running, no modifications are allowed now");
            }
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
}
