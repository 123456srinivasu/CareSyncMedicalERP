package com.medical.caresync.controller;

import com.medical.caresync.dto.*;
import com.medical.caresync.entities.Camps;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.service.CampUsersService;
import com.medical.caresync.service.CampsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/camps")
public class CampsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampsController.class);

    @Autowired
    private CampsService service;
    @Autowired
    private CampUsersService campUsersService;

    @GetMapping
    public ResponseEntity<PageResponse<CampsListDTO>> getAllCamps(
            @RequestParam(required = false, defaultValue = "All", name = "status") String status,
            @RequestParam(required = false, name = "stateId") Long stateId,
            @RequestParam(required = false, name="districtId") Long districtId,
            @RequestParam(required = false, name = "mandalId") Long mandalId,
            @RequestParam(required = false, name = "campName") String campName,
            @RequestParam(required = false, name = "cityName") String cityName,
            @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC)
            Pageable pageable
    ) {
        return ResponseEntity.ok(service.getAllCamps(status, stateId, districtId, mandalId, campName, cityName, pageable));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Camps>> getActiveCamps() {
        return ResponseEntity.ok(service.getActiveCamps());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camps> getCampById(@PathVariable Long id) {
        Optional<Camps> camp = service.getCampById(id);
        return camp.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Camps> createCamp(@Valid @RequestBody CampsDTO camp) {
        try {
            Camps createdCamp = service.createCamp(camp);
            return ResponseEntity.ok(createdCamp);
        }catch (BadRequestException ex) {
            LOGGER.error("Invalid request", ex);
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e) {
            LOGGER.error("Exception while creatig=ng a camp", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camps> updateCamp(@PathVariable Long id, @RequestBody Camps campDetails) {
        Camps updatedCamp = service.updateCamp(id, campDetails);
        if (updatedCamp != null) {
            return ResponseEntity.ok(updatedCamp);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCamp(@PathVariable Long id) {
        if (service.getCampById(id).isPresent()) {
            service.deleteCamp(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<CampUsersResponseDTO> getCampUsers(@PathVariable Long id) {
        return ResponseEntity.ok(campUsersService.getCampUsersByCampId(id));
    }
}

