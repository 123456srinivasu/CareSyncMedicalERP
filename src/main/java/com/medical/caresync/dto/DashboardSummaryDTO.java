package com.medical.caresync.dto;

import lombok.Data;

@Data
public class DashboardSummaryDTO {
    private long campsCount;
    private long patientsCount;
    private long medicinesCount;
    private long doctorsCount;
    private long discountsCount;
    private long illnessCount;
}
