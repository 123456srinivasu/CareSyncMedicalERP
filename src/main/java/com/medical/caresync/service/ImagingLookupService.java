package com.medical.caresync.service;

import com.medical.caresync.dto.ImagingLookupDTO;
import com.medical.caresync.entities.ImagingLookup;
import com.medical.caresync.repository.ImagingLookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
@Service
public class ImagingLookupService {

    @Autowired
    private ImagingLookupRepository imagingLookupRepository;

    public List<ImagingLookupDTO> getAllImaging() {
        return imagingLookupRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ImagingLookupDTO convertToDTO(ImagingLookup imagingLookup) {
        ImagingLookupDTO dto = new ImagingLookupDTO();
        dto.setId(imagingLookup.getId());
        dto.setImagingName(imagingLookup.getImagingName());
        dto.setDescription(imagingLookup.getDescription());
        dto.setIsActive(imagingLookup.getIsActive());
        return dto;
    }
}
*/
