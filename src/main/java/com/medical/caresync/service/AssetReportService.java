package com.medical.caresync.service;

import com.medical.caresync.dto.AssetDTO;
import com.medical.caresync.repository.DonationInfoRepository;
import com.medical.caresync.repository.AssetReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AssetReportService {

    @Autowired
    private AssetReportRepository assetReportRepository;

    @Autowired
    private DonationInfoRepository donationInfoRepository;

    public List<AssetDTO> getAssetReport(Date startDate, Date endDate, Integer campId) {
        List<AssetDTO> reportData = new ArrayList<>();

        // 1. Fetch Assets from Expenses
        reportData.addAll(assetReportRepository.findAssetsFromExpenses(startDate, endDate, campId));

        // 2. Fetch Assets from Donations
        reportData.addAll(donationInfoRepository.findAssetsFromDonations(startDate, endDate, campId));

        return reportData;
    }
}