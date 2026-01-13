package com.medical.caresync.service;

import com.medical.caresync.dto.PatientChiefComplaintDTO;
import com.medical.caresync.entities.PatientChiefComplaint;
import com.medical.caresync.repository.PatientChiefComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientChiefComplaintService {

    @Autowired
    PatientChiefComplaintRepository repository;

    public PatientChiefComplaintDTO create(PatientChiefComplaintDTO dto) {
        PatientChiefComplaint entity = dtoToEntity(dto);
        entity.setCreationTs(LocalDateTime.now());
        return entityToDto(repository.save(entity));
    }

    public PatientChiefComplaintDTO update(Long id, PatientChiefComplaintDTO dto) {
        PatientChiefComplaint entity =
                repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Record not found"));

        PatientChiefComplaint updated = dtoToEntity(dto);
        updated.setChiefComplaintId(entity.getChiefComplaintId());
        updated.setCreationTs(entity.getCreationTs());
        updated.setLastUpdateTs(LocalDateTime.now());

        return entityToDto(repository.save(updated));
    }

    public PatientChiefComplaintDTO getById(Long id) {
        return repository.findById(id)
                .map(this::entityToDto)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    public List<PatientChiefComplaintDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    /* ------------------ Mapping Methods ------------------ */
    private PatientChiefComplaint dtoToEntity(PatientChiefComplaintDTO dto) {
        PatientChiefComplaint entity = new PatientChiefComplaint();

        entity.setChiefComplaintId(dto.getChiefComplaintId());
        entity.setHasDiabetes(dto.getHasDiabetes());
        entity.setHasHtn(dto.getHasHtn());
        entity.setHasSeizures(dto.getHasSeizures());
        entity.setHasStroke(dto.getHasStroke());
        entity.setHasAsthma(dto.getHasAsthma());

        entity.setDiabetesType1(dto.getDiabetesType1());
        entity.setDiabetesType2(dto.getDiabetesType2());
        entity.setDiabetesUnknown(dto.getDiabetesUnknown());
        entity.setOnsetDuration(dto.getOnsetDuration());

        entity.setPresentingComplaints(dto.getPresentingComplaints());
        entity.setWounds(dto.getWounds());
        entity.setFatigue(dto.getFatigue());
        entity.setVisionChanges(dto.getVisionChanges());
        entity.setPolydipsia(dto.getPolydipsia());
        entity.setPolyuria(dto.getPolyuria());
        entity.setPolyphagia(dto.getPolyphagia());

        entity.setTinglingNumbness(dto.getTinglingNumbness());
        entity.setTinglingNumbnessHand(dto.getTinglingNumbnessHand());
        entity.setTinglingNumbnessFeet(dto.getTinglingNumbnessFeet());

        entity.setUnexplainedWeight(dto.getUnexplainedWeight());
        entity.setUnexplainedWeightGain(dto.getUnexplainedWeightGain());
        entity.setUnexplainedWeightLoss(dto.getUnexplainedWeightLoss());

        entity.setTakingMedicines(dto.getTakingMedicines());
        entity.setSmoking(dto.getSmoking());
        entity.setDrinking(dto.getDrinking());

        entity.setTodaysVisit(dto.getTodaysVisit());
        entity.setTvRoutineCheckup(dto.getTvRoutineCheckup());
        entity.setTvHighBpReadings(dto.getTvHighBpReadings());
        entity.setTvHeadache(dto.getTvHeadache());
        entity.setTvDizziness(dto.getTvDizziness());
        entity.setTvOtherReason(dto.getTvOtherReason());

        entity.setHaveYourExpFollowing(dto.getHaveYourExpFollowing());
        entity.setHyefHeadache(dto.getHyefHeadache());
        entity.setHyefBlurredVision(dto.getHyefBlurredVision());
        entity.setHyefChestPain(dto.getHyefChestPain());
        entity.setHyefShortnessOfBreath(dto.getHyefShortnessOfBreath());

        return entity;
    }

    private PatientChiefComplaintDTO entityToDto(PatientChiefComplaint entity) {
        PatientChiefComplaintDTO dto = new PatientChiefComplaintDTO();

        dto.setChiefComplaintId(entity.getChiefComplaintId());
        dto.setHasDiabetes(entity.getHasDiabetes());
        dto.setHasHtn(entity.getHasHtn());
        dto.setHasSeizures(entity.getHasSeizures());
        dto.setHasStroke(entity.getHasStroke());
        dto.setHasAsthma(entity.getHasAsthma());

        dto.setDiabetesType1(entity.getDiabetesType1());
        dto.setDiabetesType2(entity.getDiabetesType2());
        dto.setDiabetesUnknown(entity.getDiabetesUnknown());
        dto.setOnsetDuration(entity.getOnsetDuration());

        dto.setPresentingComplaints(entity.getPresentingComplaints());
        dto.setWounds(entity.getWounds());
        dto.setFatigue(entity.getFatigue());
        dto.setVisionChanges(entity.getVisionChanges());
        dto.setPolydipsia(entity.getPolydipsia());
        dto.setPolyuria(entity.getPolyuria());
        dto.setPolyphagia(entity.getPolyphagia());

        dto.setTinglingNumbness(entity.getTinglingNumbness());
        dto.setTinglingNumbnessHand(entity.getTinglingNumbnessHand());
        dto.setTinglingNumbnessFeet(entity.getTinglingNumbnessFeet());

        dto.setUnexplainedWeight(entity.getUnexplainedWeight());
        dto.setUnexplainedWeightGain(entity.getUnexplainedWeightGain());
        dto.setUnexplainedWeightLoss(entity.getUnexplainedWeightLoss());

        dto.setTakingMedicines(entity.getTakingMedicines());
        dto.setSmoking(entity.getSmoking());
        dto.setDrinking(entity.getDrinking());

        dto.setTodaysVisit(entity.getTodaysVisit());
        dto.setTvRoutineCheckup(entity.getTvRoutineCheckup());
        dto.setTvHighBpReadings(entity.getTvHighBpReadings());
        dto.setTvHeadache(entity.getTvHeadache());
        dto.setTvDizziness(entity.getTvDizziness());
        dto.setTvOtherReason(entity.getTvOtherReason());

        dto.setHaveYourExpFollowing(entity.getHaveYourExpFollowing());
        dto.setHyefHeadache(entity.getHyefHeadache());
        dto.setHyefBlurredVision(entity.getHyefBlurredVision());
        dto.setHyefChestPain(entity.getHyefChestPain());
        dto.setHyefShortnessOfBreath(entity.getHyefShortnessOfBreath());

        dto.setCreationTs(entity.getCreationTs());
        dto.setLastUpdateTs(entity.getLastUpdateTs());

        return dto;
    }
}
