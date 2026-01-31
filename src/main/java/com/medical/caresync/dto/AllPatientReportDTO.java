package com.medical.caresync.dto;

import java.time.LocalDate;

public interface AllPatientReportDTO {
    String getPatientName();
    String getMrNumber();
    Integer getAge();
    String getGender();
    String getMobileNumber();
    String getCampName();
    LocalDate getCampDate();
    String getMedicineName();
    Integer getMedicineQuantity();
    String getMedicineFrequency();
}
