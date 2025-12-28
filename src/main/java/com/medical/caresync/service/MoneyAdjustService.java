package com.medical.caresync.service;

import com.medical.caresync.dto.MoneyAdjustDTO;
import com.medical.caresync.entities.MoneyAdjust;
import com.medical.caresync.repository.MoneyAdjustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoneyAdjustService {

    @Autowired
    private MoneyAdjustRepository moneyAdjustRepository;

    public List<MoneyAdjustDTO> getAllMoneyAdjusts() {
        return moneyAdjustRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public MoneyAdjustDTO createMoneyAdjust(MoneyAdjustDTO moneyAdjustDTO) {
        MoneyAdjust moneyAdjust = convertToEntity(moneyAdjustDTO);
        moneyAdjust = moneyAdjustRepository.save(moneyAdjust);
        return convertToDTO(moneyAdjust);
    }

    private MoneyAdjustDTO convertToDTO(MoneyAdjust moneyAdjust) {
        MoneyAdjustDTO dto = new MoneyAdjustDTO();
        dto.setId(moneyAdjust.getId());
        return dto;
    }

    private MoneyAdjust convertToEntity(MoneyAdjustDTO dto) {
        MoneyAdjust moneyAdjust = new MoneyAdjust();
        moneyAdjust.setId(dto.getId());
        return moneyAdjust;
    }
}
