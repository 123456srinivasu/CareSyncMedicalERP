package com.medical.caresync.controller;

import com.medical.caresync.dto.ImagingLookupDTO;
import com.medical.caresync.service.ImagingLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/imaging")
public class ImagingLookupController {
    @Autowired
    private ImagingLookupService imagingLookupService;

    @GetMapping
    public List<ImagingLookupDTO> getAllImaging() {
        return imagingLookupService.getAllImaging();
    }
}
