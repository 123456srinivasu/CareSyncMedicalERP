package com.medical.caresync.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medical.caresync.dto.CampInvoicesDTO;
import com.medical.caresync.service.CampInvoicesService;

@RestController
@RequestMapping("/api/camp-invoices")
public class CampInvoicesController {
@Autowired
	private CampInvoicesService campInvoicesService;
	@GetMapping
	public List<CampInvoicesDTO> getAllCampInvoices() {
		return campInvoicesService.getAllCampInvoices();
	}
	@GetMapping("/{id}")
	public ResponseEntity<CampInvoicesDTO> getCampInvoiceById(@PathVariable("id") Long id) {
		CampInvoicesDTO dto = campInvoicesService.getCampInvoiceById(id);
		if (dto != null) {
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public CampInvoicesDTO createCampInvoice(@RequestBody CampInvoicesDTO campInvoicesDTO) {
		return campInvoicesService.createCampInvoice(campInvoicesDTO);
	}
	@PutMapping("/{id}")
	public ResponseEntity<CampInvoicesDTO> updateCampInvoice(@PathVariable Long id, @RequestBody CampInvoicesDTO campInvoicesDTO) {
		CampInvoicesDTO updatedInvoice = campInvoicesService.updateCampInvoice(id, campInvoicesDTO);
		if (updatedInvoice != null) {
			return ResponseEntity.ok(updatedInvoice);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCampInvoice(@PathVariable Long id) {
		campInvoicesService.deleteCampInvoice(id);
		return ResponseEntity.ok().build();
	}
}
