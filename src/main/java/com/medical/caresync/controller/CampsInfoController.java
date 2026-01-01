package com.medical.caresync.controller;

import com.medical.caresync.dto.CampsInfoDTO;
import com.medical.caresync.service.CampsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camps-info")
public class CampsInfoController {

    @Autowired
    private CampsInfoService service;

    @GetMapping
    public List<CampsInfoDTO> getAllCampsInfo() {
        return service.getAllCampsInfo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampsInfoDTO> getCampsInfoById(@PathVariable Long id) {
        return service.getCampsInfoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CampsInfoDTO createCampsInfo(@RequestBody CampsInfoDTO dto) {
        return service.saveCampsInfo(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampsInfoDTO> updateCampsInfo(@PathVariable Long id, @RequestBody CampsInfoDTO dto) {
        if (!service.getCampsInfoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        dto.setTblCampId(id);
        return ResponseEntity.ok(service.saveCampsInfo(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampsInfo(@PathVariable Long id) {
        if (!service.getCampsInfoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteCampsInfo(id);
        return ResponseEntity.ok().build();
    }
}
