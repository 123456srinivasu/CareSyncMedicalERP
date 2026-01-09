package com.medical.caresync.controller;

import com.medical.caresync.entities.CampScheduleTemplates;
import com.medical.caresync.service.CampScheduleTemplatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camp-schedule-templates")
public class CampScheduleTemplatesController {

    private final CampScheduleTemplatesService service;

    @Autowired
    public CampScheduleTemplatesController(CampScheduleTemplatesService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CampScheduleTemplates> createTemplate(@RequestBody CampScheduleTemplates template) {
        return ResponseEntity.ok(service.createTemplate(template));
    }

    @GetMapping
    public ResponseEntity<List<CampScheduleTemplates>> getAllTemplates() {
        return ResponseEntity.ok(service.getAllTemplates());
    }

    @GetMapping("/camp/{campId}")
    public ResponseEntity<List<CampScheduleTemplates>> getTemplatesByCampId(@PathVariable Long campId) {
        return ResponseEntity.ok(service.getTemplatesByCampId(campId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampScheduleTemplates> getTemplateById(@PathVariable Long id) {
        return service.getTemplateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampScheduleTemplates> updateTemplate(@PathVariable Long id,
            @RequestBody CampScheduleTemplates template) {
        try {
            return ResponseEntity.ok(service.updateTemplate(id, template));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemplate(@PathVariable Long id) {
        service.deleteTemplate(id);
        return ResponseEntity.noContent().build();
    }
}
