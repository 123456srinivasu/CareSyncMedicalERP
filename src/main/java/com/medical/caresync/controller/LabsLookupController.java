package com.medical.caresync.controller;

import com.medical.caresync.dto.LabsLookupDTO;
import com.medical.caresync.service.LabsLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/labs")
public class LabsLookupController {
    @Autowired
    private LabsLookupService labsLookupService;

    @GetMapping
    public List<LabsLookupDTO> getAllLabs() {
        return labsLookupService.getAllLabs();
    }
}
