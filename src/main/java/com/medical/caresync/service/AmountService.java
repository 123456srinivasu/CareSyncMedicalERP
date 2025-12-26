package com.medical.caresync.service;

import com.medical.caresync.entities.Amount;
import com.medical.caresync.repository.AmountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmountService {

    private final AmountRepository amountRepository;

    public AmountService(AmountRepository amountRepository) {
        this.amountRepository = amountRepository;
    }

    public List<Amount> getAllAmounts() {
        return amountRepository.findAll();
    }

    public Optional<Amount> getAmountByComponentName(String componentName) {
        return amountRepository.findByComponentName(componentName);
    }

    public Amount saveAmount(Amount amount) {
        return amountRepository.save(amount);
    }
    
    public Optional<Amount> getAmountById(Long id) {
        return amountRepository.findById(id);
    }

    public void deleteAmount(Long id) {
        amountRepository.deleteById(id);
    }
}
