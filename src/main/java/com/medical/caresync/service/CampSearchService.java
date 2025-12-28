package com.medical.caresync.service;

import com.medical.caresync.dto.CampSearchDTO;
import com.medical.caresync.entities.CampSearch;
import com.medical.caresync.repository.CampSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampSearchService {

    @Autowired
    private CampSearchRepository campSearchRepository;

    public List<CampSearchDTO> getAllCampSearches() {
        return campSearchRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CampSearchDTO createCampSearch(CampSearchDTO campSearchDTO) {
        CampSearch campSearch = convertToEntity(campSearchDTO);
        campSearch = campSearchRepository.save(campSearch);
        return convertToDTO(campSearch);
    }

    private CampSearchDTO convertToDTO(CampSearch campSearch) {
        CampSearchDTO dto = new CampSearchDTO();
        dto.setId(campSearch.getId());
        return dto;
    }

    private CampSearch convertToEntity(CampSearchDTO dto) {
        CampSearch campSearch = new CampSearch();
        campSearch.setId(dto.getId());
        return campSearch;
    }
}
