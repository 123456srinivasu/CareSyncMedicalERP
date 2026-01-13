package com.medical.caresync.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "patient_chief_complaint")
public class PatientChiefComplaint {

    // -------------------- Primary Key --------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chief_complaint_id")
    private Long chiefComplaintId;

    // -------------------- Relationship --------------------
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_CONSULTATION_ID")
    private PatientConsultation patientConsultation;

    // -------------------- Chief Complaints --------------------
    @Column(name = "has_diabetes")
    private Boolean hasDiabetes;

    @Column(name = "has_htn")
    private Boolean hasHtn;

    @Column(name = "has_seizures")
    private Boolean hasSeizures;

    @Column(name = "has_stroke")
    private Boolean hasStroke;

    @Column(name = "has_asthma")
    private Boolean hasAsthma;

    // -------------------- Diabetes Type --------------------
    @Column(name = "diabetes_type1")
    private Boolean diabetesType1;

    @Column(name = "diabetes_type2")
    private Boolean diabetesType2;

    @Column(name = "diabetes_unknow")
    private Boolean diabetesUnknown;

    @Column(name = "onset_duration", length = 50)
    private String onsetDuration;

    // -------------------- Presenting Complaints --------------------
    @Column(name = "presenting_complaints")
    private Boolean presentingComplaints;

    @Column(name = "wounds")
    private Boolean wounds;

    @Column(name = "fatigue")
    private Boolean fatigue;

    @Column(name = "vision_changes")
    private Boolean visionChanges;

    @Column(name = "polydipsia")
    private Boolean polydipsia;

    @Column(name = "polyuria")
    private Boolean polyuria;

    @Column(name = "polyphagia")
    private Boolean polyphagia;

    // -------------------- Neuropathy --------------------
    @Column(name = "tingling_numbness")
    private Boolean tinglingNumbness;

    @Column(name = "tingling_numbness_hand")
    private Boolean tinglingNumbnessHand;

    @Column(name = "tingling_numbness_feet")
    private Boolean tinglingNumbnessFeet;

    // -------------------- Weight --------------------
    @Column(name = "unexplained_weight")
    private Boolean unexplainedWeight;

    @Column(name = "unexplained_weight_gain")
    private Boolean unexplainedWeightGain;

    @Column(name = "unexplained_weight_loss")
    private Boolean unexplainedWeightLoss;

    // -------------------- Lifestyle --------------------
    @Column(name = "taking_medicines")
    private Boolean takingMedicines;

    @Column(name = "smoking")
    private Boolean smoking;

    @Column(name = "drinking")
    private Boolean drinking;

    // -------------------- Today’s Visit --------------------
    @Column(name = "todays_visit")
    private Boolean todaysVisit;

    @Column(name = "tv_routine_checkup")
    private Boolean tvRoutineCheckup;

    @Column(name = "tv_high_bp_readings")
    private Boolean tvHighBpReadings;

    @Column(name = "tv_headache")
    private Boolean tvHeadache;

    @Column(name = "tv_dizziness")
    private Boolean tvDizziness;

    @Column(name = "tv_other_reason", length = 255)
    private String tvOtherReason;

    // -------------------- HTN – Experienced Following --------------------
    @Column(name = "have_your_exp_following")
    private Boolean haveYourExpFollowing;

    @Column(name = "hyef_headache")
    private Boolean hyefHeadache;

    @Column(name = "hyef_blurred_vision")
    private Boolean hyefBlurredVision;

    @Column(name = "hyef_chest_pain")
    private Boolean hyefChestPain;

    @Column(name = "hyef_shortness_of_breath")
    private Boolean hyefShortnessOfBreath;

    // -------------------- Audit --------------------
    @Column(name = "CREATION_TS")
    private LocalDateTime creationTs;

    @Column(name = "CREATION_USER_ID", length = 50)
    private String creationUserId;

    @Column(name = "LAST_UPDATE_TS")
    private LocalDateTime lastUpdateTs;

    @Column(name = "LAST_UPDATE_USER_ID", length = 50)
    private String lastUpdateUserId;

    public Long getChiefComplaintId() {
        return chiefComplaintId;
    }

    public void setChiefComplaintId(Long chiefComplaintId) {
        this.chiefComplaintId = chiefComplaintId;
    }

    public PatientConsultation getPatientConsultation() {
        return patientConsultation;
    }

    public void setPatientConsultation(PatientConsultation patientConsultation) {
        this.patientConsultation = patientConsultation;
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

    public String getCreationUserId() {
        return creationUserId;
    }

    public void setCreationUserId(String creationUserId) {
        this.creationUserId = creationUserId;
    }

    public LocalDateTime getLastUpdateTs() {
        return lastUpdateTs;
    }

    public void setLastUpdateTs(LocalDateTime lastUpdateTs) {
        this.lastUpdateTs = lastUpdateTs;
    }

    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }
}
