package com.medical.caresync.service;

import com.medical.caresync.entities.CampRunStaff;
import com.medical.caresync.entities.CampRunStaffId;
import com.medical.caresync.repository.CampRunStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CampRunStaffService {

    private final CampRunStaffRepository repository;

    @Autowired
    public CampRunStaffService(CampRunStaffRepository repository) {
        this.repository = repository;
    }

    public CampRunStaff assignStaff(CampRunStaff staff) {
        return repository.save(staff);
    }

    @Transactional(readOnly = true)
    public List<CampRunStaff> getStaffByRunId(Long runId) {
        return repository.findByCampRuns_CampRunId(runId);
    }

    public void removeStaff(Long runId, Long userId) {
        repository.deleteById(new CampRunStaffId(runId, userId));
    }
}
