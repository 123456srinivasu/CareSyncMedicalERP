package com.medical.caresync.service;

import com.medical.caresync.repository.PharmaLookupReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PharmaLookupReportService {

    @Autowired
    private PharmaLookupReportRepository repository;

}
