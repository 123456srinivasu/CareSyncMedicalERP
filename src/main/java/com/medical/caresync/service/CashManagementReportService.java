package com.medical.caresync.service;

import com.medical.caresync.repository.CashManagementReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CashManagementReportService {

    @Autowired
    private CashManagementReportRepository repository;

}
