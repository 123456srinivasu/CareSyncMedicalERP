package com.medical.caresync.controller;

import com.medical.caresync.dto.CampRunPlanningViewDTO;
import com.medical.caresync.entities.CampRuns;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.exceptions.BusinessRuleViolationException;
import com.medical.caresync.service.CampRunsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camp-runs")
public class CampRunsController {

    private final CampRunsService service;

    @Autowired
    public CampRunsController(CampRunsService service) {
        this.service = service;
    }

    @GetMapping("/planning")
   public ResponseEntity<?> getCampRunPlanning(@RequestParam(name = "campId", required = true) Long campId) {
        CampRunPlanningViewDTO campPlanningDetails = service.getCampPlanningDetails(campId);
        return ResponseEntity.ok(campPlanningDetails);
    }
}
