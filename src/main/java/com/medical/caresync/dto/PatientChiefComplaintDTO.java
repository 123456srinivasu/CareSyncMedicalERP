package com.medical.caresync.dto;

import java.time.LocalDateTime;

public class PatientChiefComplaintDTO {

    private Long chiefComplaintId;

    private Boolean hasDiabetes;
    private Boolean hasHtn;
    private Boolean hasSeizures;
    private Boolean hasStroke;
    private Boolean hasAsthma;

    private Boolean diabetesType1;
    private Boolean diabetesType2;
    private Boolean diabetesUnknown;
    private String onsetDuration;

    private Boolean presentingComplaints;
    private Boolean wounds;
    private Boolean fatigue;
    private Boolean visionChanges;
    private Boolean polydipsia;
    private Boolean polyuria;
    private Boolean polyphagia;

    private Boolean tinglingNumbness;
    private Boolean tinglingNumbnessHand;
    private Boolean tinglingNumbnessFeet;

    private Boolean unexplainedWeight;
    private Boolean unexplainedWeightGain;
    private Boolean unexplainedWeightLoss;

    private Boolean takingMedicines;
    private Boolean smoking;
    private Boolean drinking;

    private Boolean todaysVisit;
    private Boolean tvRoutineCheckup;
    private Boolean tvHighBpReadings;
    private Boolean tvHeadache;
    private Boolean tvDizziness;
    private String tvOtherReason;

    private Boolean haveYourExpFollowing;
    private Boolean hyefHeadache;
    private Boolean hyefBlurredVision;
    private Boolean hyefChestPain;
    private Boolean hyefShortnessOfBreath;

    private LocalDateTime creationTs;
    private LocalDateTime lastUpdateTs;

    public Long getChiefComplaintId() {
        return chiefComplaintId;
    }

    public void setChiefComplaintId(Long chiefComplaintId) {
        this.chiefComplaintId = chiefComplaintId;
    }

    public Boolean getHasDiabetes() {
        return hasDiabetes;
    }

    public void setHasDiabetes(Boolean hasDiabetes) {
        this.hasDiabetes = hasDiabetes;
    }

    public Boolean getHasHtn() {
        return hasHtn;
    }

    public void setHasHtn(Boolean hasHtn) {
        this.hasHtn = hasHtn;
    }

    public Boolean getHasSeizures() {
        return hasSeizures;
    }

    public void setHasSeizures(Boolean hasSeizures) {
        this.hasSeizures = hasSeizures;
    }

    public Boolean getHasStroke() {
        return hasStroke;
    }

    public void setHasStroke(Boolean hasStroke) {
        this.hasStroke = hasStroke;
    }

    public Boolean getHasAsthma() {
        return hasAsthma;
    }

    public void setHasAsthma(Boolean hasAsthma) {
        this.hasAsthma = hasAsthma;
    }

    public Boolean getDiabetesType1() {
        return diabetesType1;
    }

    public void setDiabetesType1(Boolean diabetesType1) {
        this.diabetesType1 = diabetesType1;
    }

    public Boolean getDiabetesType2() {
        return diabetesType2;
    }

    public void setDiabetesType2(Boolean diabetesType2) {
        this.diabetesType2 = diabetesType2;
    }

    public Boolean getDiabetesUnknown() {
        return diabetesUnknown;
    }

    public void setDiabetesUnknown(Boolean diabetesUnknown) {
        this.diabetesUnknown = diabetesUnknown;
    }

    public String getOnsetDuration() {
        return onsetDuration;
    }

    public void setOnsetDuration(String onsetDuration) {
        this.onsetDuration = onsetDuration;
    }

    public Boolean getPresentingComplaints() {
        return presentingComplaints;
    }

    public void setPresentingComplaints(Boolean presentingComplaints) {
        this.presentingComplaints = presentingComplaints;
    }

    public Boolean getWounds() {
        return wounds;
    }

    public void setWounds(Boolean wounds) {
        this.wounds = wounds;
    }

    public Boolean getFatigue() {
        return fatigue;
    }

    public void setFatigue(Boolean fatigue) {
        this.fatigue = fatigue;
    }

    public Boolean getVisionChanges() {
        return visionChanges;
    }

    public void setVisionChanges(Boolean visionChanges) {
        this.visionChanges = visionChanges;
    }

    public Boolean getPolydipsia() {
        return polydipsia;
    }

    public void setPolydipsia(Boolean polydipsia) {
        this.polydipsia = polydipsia;
    }

    public Boolean getPolyuria() {
        return polyuria;
    }

    public void setPolyuria(Boolean polyuria) {
        this.polyuria = polyuria;
    }

    public Boolean getPolyphagia() {
        return polyphagia;
    }

    public void setPolyphagia(Boolean polyphagia) {
        this.polyphagia = polyphagia;
    }

    public Boolean getTinglingNumbness() {
        return tinglingNumbness;
    }

    public void setTinglingNumbness(Boolean tinglingNumbness) {
        this.tinglingNumbness = tinglingNumbness;
    }

    public Boolean getTinglingNumbnessHand() {
        return tinglingNumbnessHand;
    }

    public void setTinglingNumbnessHand(Boolean tinglingNumbnessHand) {
        this.tinglingNumbnessHand = tinglingNumbnessHand;
    }

    public Boolean getTinglingNumbnessFeet() {
        return tinglingNumbnessFeet;
    }

    public void setTinglingNumbnessFeet(Boolean tinglingNumbnessFeet) {
        this.tinglingNumbnessFeet = tinglingNumbnessFeet;
    }

    public Boolean getUnexplainedWeight() {
        return unexplainedWeight;
    }

    public void setUnexplainedWeight(Boolean unexplainedWeight) {
        this.unexplainedWeight = unexplainedWeight;
    }

    public Boolean getUnexplainedWeightGain() {
        return unexplainedWeightGain;
    }

    public void setUnexplainedWeightGain(Boolean unexplainedWeightGain) {
        this.unexplainedWeightGain = unexplainedWeightGain;
    }

    public Boolean getUnexplainedWeightLoss() {
        return unexplainedWeightLoss;
    }

    public void setUnexplainedWeightLoss(Boolean unexplainedWeightLoss) {
        this.unexplainedWeightLoss = unexplainedWeightLoss;
    }

    public Boolean getTakingMedicines() {
        return takingMedicines;
    }

    public void setTakingMedicines(Boolean takingMedicines) {
        this.takingMedicines = takingMedicines;
    }

    public Boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }

    public Boolean getDrinking() {
        return drinking;
    }

    public void setDrinking(Boolean drinking) {
        this.drinking = drinking;
    }

    public Boolean getTodaysVisit() {
        return todaysVisit;
    }

    public void setTodaysVisit(Boolean todaysVisit) {
        this.todaysVisit = todaysVisit;
    }

    public Boolean getTvRoutineCheckup() {
        return tvRoutineCheckup;
    }

    public void setTvRoutineCheckup(Boolean tvRoutineCheckup) {
        this.tvRoutineCheckup = tvRoutineCheckup;
    }

    public Boolean getTvHighBpReadings() {
        return tvHighBpReadings;
    }

    public void setTvHighBpReadings(Boolean tvHighBpReadings) {
        this.tvHighBpReadings = tvHighBpReadings;
    }

    public Boolean getTvHeadache() {
        return tvHeadache;
    }

    public void setTvHeadache(Boolean tvHeadache) {
        this.tvHeadache = tvHeadache;
    }

    public Boolean getTvDizziness() {
        return tvDizziness;
    }

    public void setTvDizziness(Boolean tvDizziness) {
        this.tvDizziness = tvDizziness;
    }

    public String getTvOtherReason() {
        return tvOtherReason;
    }

    public void setTvOtherReason(String tvOtherReason) {
        this.tvOtherReason = tvOtherReason;
    }

    public Boolean getHaveYourExpFollowing() {
        return haveYourExpFollowing;
    }

    public void setHaveYourExpFollowing(Boolean haveYourExpFollowing) {
        this.haveYourExpFollowing = haveYourExpFollowing;
    }

    public Boolean getHyefHeadache() {
        return hyefHeadache;
    }

    public void setHyefHeadache(Boolean hyefHeadache) {
        this.hyefHeadache = hyefHeadache;
    }

    public Boolean getHyefBlurredVision() {
        return hyefBlurredVision;
    }

    public void setHyefBlurredVision(Boolean hyefBlurredVision) {
        this.hyefBlurredVision = hyefBlurredVision;
    }

    public Boolean getHyefChestPain() {
        return hyefChestPain;
    }

    public void setHyefChestPain(Boolean hyefChestPain) {
        this.hyefChestPain = hyefChestPain;
    }

    public Boolean getHyefShortnessOfBreath() {
        return hyefShortnessOfBreath;
    }

    public void setHyefShortnessOfBreath(Boolean hyefShortnessOfBreath) {
        this.hyefShortnessOfBreath = hyefShortnessOfBreath;
    }

    public LocalDateTime getCreationTs() {
        return creationTs;
    }

    public void setCreationTs(LocalDateTime creationTs) {
        this.creationTs = creationTs;
    }

    public LocalDateTime getLastUpdateTs() {
        return lastUpdateTs;
    }

    public void setLastUpdateTs(LocalDateTime lastUpdateTs) {
        this.lastUpdateTs = lastUpdateTs;
    }
}
