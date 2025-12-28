package com.medical.caresync.service;

import com.medical.caresync.dto.ErrorDTO;
import com.medical.caresync.entities.Error;
import com.medical.caresync.repository.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ErrorService {

    @Autowired
    private ErrorRepository errorRepository;

    public List<ErrorDTO> getAllErrors() {
        return errorRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ErrorDTO createError(ErrorDTO errorDTO) {
        Error error = convertToEntity(errorDTO);
        error = errorRepository.save(error);
        return convertToDTO(error);
    }

    private ErrorDTO convertToDTO(Error error) {
        ErrorDTO dto = new ErrorDTO();
        dto.setId(error.getId());
        return dto;
    }

    private Error convertToEntity(ErrorDTO dto) {
        Error error = new Error();
        error.setId(dto.getId());
        return error;
    }
}
