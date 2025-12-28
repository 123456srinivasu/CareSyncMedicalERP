package com.medical.caresync.service;

import com.medical.caresync.repository.PrintFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PrintFormService {

    @Autowired
    private PrintFormRepository repository;

}
