package com.medical.caresync.service;

import com.medical.caresync.dto.ExpensesDTO;
import com.medical.caresync.entities.Expenses;
import com.medical.caresync.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    public List<ExpensesDTO> getAllExpenses() {
        return expensesRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ExpensesDTO createExpenses(ExpensesDTO expensesDTO) {
        Expenses expenses = convertToEntity(expensesDTO);
        expenses = expensesRepository.save(expenses);
        return convertToDTO(expenses);
    }

    private ExpensesDTO convertToDTO(Expenses expenses) {
        ExpensesDTO dto = new ExpensesDTO();
        dto.setId(expenses.getId());
        return dto;
    }

    private Expenses convertToEntity(ExpensesDTO dto) {
        Expenses expenses = new Expenses();
        expenses.setId(dto.getId());
        return expenses;
    }
}
