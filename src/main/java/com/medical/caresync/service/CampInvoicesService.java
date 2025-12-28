package com.medical.caresync.service;

import com.medical.caresync.repository.CampInvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.medical.caresync.dto.CampInvoicesDTO;
import com.medical.caresync.entities.CampInvoices;
import com.medical.caresync.entities.CampInvoiceDetail;

@Service
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public class CampInvoicesService {

    @Autowired
	private CampInvoicesRepository campInvoiceRepository;
	
    public List<CampInvoicesDTO> getAllCampInvoices() {
		List<CampInvoices> invoices = campInvoiceRepository.findAll();
		return invoices.stream().map(this::convertToDTO).collect(Collectors.toList());
	}
    
	public CampInvoicesDTO getCampInvoiceById(Long id) {
		Optional<CampInvoices> invoice = campInvoiceRepository.findById(id);
		return invoice.map(this::convertToDTO).orElse(null);
	}
    
	@org.springframework.transaction.annotation.Transactional
	public CampInvoicesDTO createCampInvoice(CampInvoicesDTO campInvoicesDTO) {
		CampInvoices invoice = convertToEntity(campInvoicesDTO);
		CampInvoices savedInvoice = campInvoiceRepository.save(invoice);
		return convertToDTO(savedInvoice);
	}
    
	@org.springframework.transaction.annotation.Transactional
	public CampInvoicesDTO updateCampInvoice(Long id, CampInvoicesDTO campInvoicesDTO) {
		if (campInvoiceRepository.existsById(id)) {
			CampInvoices invoice = convertToEntity(campInvoicesDTO);
			invoice.setId(id);
			CampInvoices updatedInvoice = campInvoiceRepository.save(invoice);
			return convertToDTO(updatedInvoice);
		}
		return null;
	}
    
	@org.springframework.transaction.annotation.Transactional
	public void deleteCampInvoice(Long id) {
		campInvoiceRepository.deleteById(id);
	}
    
	private CampInvoicesDTO convertToDTO(CampInvoices invoice) {
		CampInvoicesDTO dto = new CampInvoicesDTO();
		dto.setId(invoice.getId());
		dto.setInvoiceDt(invoice.getInvoiceDt());
		dto.setInvoiceNo(invoice.getInvoiceNo());
		dto.setDestination(invoice.getDestination());
		dto.setDispatchThrough(invoice.getDispatchThrough());
		dto.setModeTermsPayment(invoice.getModeTermsPayment());
		dto.setGrossAmountBeforeTax(invoice.getGrossAmountBeforeTax());
		dto.setNetAmount(invoice.getNetAmount());
		
		if (invoice.getCampInvoiceDetails() != null) {
			List<CampInvoicesDTO.CampInvoiceDetailDTO> detailDTOs = invoice.getCampInvoiceDetails().stream().map(detail -> {
				CampInvoicesDTO.CampInvoiceDetailDTO detailDTO = new CampInvoicesDTO.CampInvoiceDetailDTO();
				detailDTO.setId(detail.getId());
				detailDTO.setMedicineCode(detail.getMedicineCode());
				detailDTO.setBatchNo(detail.getBatchNo());
				detailDTO.setBatchExpirationDt(detail.getBatchExpirationDt());
				detailDTO.setHsnhacNm(detail.getHsnhacNm());
				detailDTO.setCgstTax(detail.getCgstTax());
				detailDTO.setSgstTax(detail.getSgstTax());
				detailDTO.setMrp(detail.getMrp());
				detailDTO.setRate(detail.getRate());
				detailDTO.setQuantity(detail.getQuantity());
				detailDTO.setAmount(detail.getAmount());
				return detailDTO;
			}).collect(Collectors.toList());
			dto.setCampInvoiceDetails(detailDTOs);
		}
		return dto;
	}
    
	private CampInvoices convertToEntity(CampInvoicesDTO dto) {
		CampInvoices invoice = new CampInvoices();
		invoice.setId(dto.getId());
		invoice.setInvoiceDt(dto.getInvoiceDt());
		invoice.setInvoiceNo(dto.getInvoiceNo());
		invoice.setDestination(dto.getDestination());
		invoice.setDispatchThrough(dto.getDispatchThrough());
		invoice.setModeTermsPayment(dto.getModeTermsPayment());
		invoice.setGrossAmountBeforeTax(dto.getGrossAmountBeforeTax());
		invoice.setNetAmount(dto.getNetAmount());
		
		if (dto.getCampInvoiceDetails() != null) {
			List<CampInvoiceDetail> details = new ArrayList<>();
			for (CampInvoicesDTO.CampInvoiceDetailDTO detailDTO : dto.getCampInvoiceDetails()) {
				CampInvoiceDetail detail = new CampInvoiceDetail();
				detail.setId(detailDTO.getId());
				detail.setMedicineCode(detailDTO.getMedicineCode());
				detail.setBatchNo(detailDTO.getBatchNo());
				detail.setBatchExpirationDt(detailDTO.getBatchExpirationDt());
				detail.setHsnhacNm(detailDTO.getHsnhacNm());
				detail.setCgstTax(detailDTO.getCgstTax());
				detail.setSgstTax(detailDTO.getSgstTax());
				detail.setMrp(detailDTO.getMrp());
				detail.setRate(detailDTO.getRate());
				detail.setQuantity(detailDTO.getQuantity());
				detail.setAmount(detailDTO.getAmount());
				detail.setCampInvoice(invoice);
				details.add(detail);
			}
			invoice.setCampInvoiceDetails(details);
		}
		return invoice;
	}
}
