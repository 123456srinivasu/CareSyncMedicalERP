package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.caresync.dto.CampPassbookDTO;
import com.medical.caresync.service.CampPassbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/camp-passbook")
public class CampPassbookController {

    @Autowired
    private CampPassbookService campPassbookService;
    @PostMapping("/save")
    public ResponseEntity<CampPassbookDTO> saveCampPassbook(@RequestBody CampPassbookDTO campPassbookDTO) {
        CampPassbookDTO savedDTO = campPassbookService.saveCampPassbook(campPassbookDTO);
        return ResponseEntity.ok(savedDTO);
    }
    @GetMapping("/camp/{campId}")
    public ResponseEntity<List<CampPassbookDTO>> getPassbookByCampId(@PathVariable Integer campId) {
        List<CampPassbookDTO> list = campPassbookService.getPassbookByCampId(campId);
        return ResponseEntity.ok(list);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampPassbook(@PathVariable Long id) {
        campPassbookService.deleteCampPassbook(id);
        return ResponseEntity.ok().build();
    }
}
