package com.medical.caresync.controller;

import com.medical.caresync.dto.VitalLookUpDTO;
import com.medical.caresync.service.VitalLookUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/vitals")
public class VitalLookUpController {
    @Autowired
    private VitalLookUpService vitalLookUpService;

    @GetMapping
    public List<VitalLookUpDTO> getAllActiveVitals() {
        return vitalLookUpService.getAllActiveVitals();
    }
}
