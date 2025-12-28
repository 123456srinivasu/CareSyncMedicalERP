package com.medical.caresync.service;

import com.medical.caresync.dto.InvoiceDetailsDTO;
import com.medical.caresync.entities.InvoiceDetails;
import com.medical.caresync.repository.InvoiceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceDetailsService {

    @Autowired
    private InvoiceDetailsRepository invoiceDetailsRepository;

    public List<InvoiceDetailsDTO> getAllInvoiceDetails() {
        return invoiceDetailsRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public InvoiceDetailsDTO createInvoiceDetails(InvoiceDetailsDTO invoiceDetailsDTO) {
        InvoiceDetails invoiceDetails = convertToEntity(invoiceDetailsDTO);
        invoiceDetails = invoiceDetailsRepository.save(invoiceDetails);
        return convertToDTO(invoiceDetails);
    }

    private InvoiceDetailsDTO convertToDTO(InvoiceDetails invoiceDetails) {
        InvoiceDetailsDTO dto = new InvoiceDetailsDTO();
        dto.setId(invoiceDetails.getId());
        return dto;
    }

    private InvoiceDetails convertToEntity(InvoiceDetailsDTO dto) {
        InvoiceDetails invoiceDetails = new InvoiceDetails();
        invoiceDetails.setId(dto.getId());
        return invoiceDetails;
    }
}
