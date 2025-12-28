package com.medical.caresync.service;

import com.medical.caresync.dto.InvoicesDTO;
import com.medical.caresync.entities.Invoices;
import com.medical.caresync.repository.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoicesService {

    @Autowired
    private InvoicesRepository invoicesRepository;

    public List<InvoicesDTO> getAllInvoices() {
        return invoicesRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public InvoicesDTO createInvoices(InvoicesDTO invoicesDTO) {
        Invoices invoices = convertToEntity(invoicesDTO);
        invoices = invoicesRepository.save(invoices);
        return convertToDTO(invoices);
    }

    private InvoicesDTO convertToDTO(Invoices invoices) {
        InvoicesDTO dto = new InvoicesDTO();
        dto.setId(invoices.getId());
        return dto;
    }

    private Invoices convertToEntity(InvoicesDTO dto) {
        Invoices invoices = new Invoices();
        invoices.setId(dto.getId());
        return invoices;
    }
}
