package com.medical.caresync.service;

import com.medical.caresync.entities.CampScheduleTemplates;
import com.medical.caresync.repository.CampScheduleTemplatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CampScheduleTemplatesService {

    private final CampScheduleTemplatesRepository repository;

    @Autowired
    public CampScheduleTemplatesService(CampScheduleTemplatesRepository repository) {
        this.repository = repository;
    }

    public CampScheduleTemplates createTemplate(CampScheduleTemplates template) {
        return repository.save(template);
    }

    @Transactional(readOnly = true)
    public List<CampScheduleTemplates> getAllTemplates() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<CampScheduleTemplates> getTemplatesByCampId(Long campId) {
        return repository.findByCamps_CampId(campId);
    }

    @Transactional(readOnly = true)
    public Optional<CampScheduleTemplates> getTemplateById(Long id) {
        return repository.findById(id);
    }

    public CampScheduleTemplates updateTemplate(Long id, CampScheduleTemplates details) {
        return repository.findById(id).map(existing -> {
            existing.setDayOfWeek(details.getDayOfWeek());
            existing.setWeekOfMonth(details.getWeekOfMonth());
            existing.setIsActive(details.getIsActive());
            existing.setUpdatedBy(details.getUpdatedBy());
            // Update month flags if needed
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Template not found with id " + id));
    }

    public void deleteTemplate(Long id) {
        repository.deleteById(id);
    }
}
