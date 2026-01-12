package com.medical.caresync.service;

import com.medical.caresync.entities.StateLookup;
import com.medical.caresync.repository.StateLookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StateLookupService {

    private final StateLookupRepository stateLookupRepository;

    @Autowired
    public StateLookupService(StateLookupRepository stateLookupRepository) {
        this.stateLookupRepository = stateLookupRepository;
    }

    public StateLookup createState(StateLookup stateLookup) {
        return stateLookupRepository.save(stateLookup);
    }

    @Transactional(readOnly = true)
    public List<StateLookup> getAllStates() {
        return stateLookupRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<StateLookup> getStateById(Integer id) {
        return stateLookupRepository.findById(id);
    }

    public StateLookup updateState(Integer id, StateLookup stateDetails) {
        return stateLookupRepository.findById(id).map(state -> {
            state.setStateName(stateDetails.getStateName());
            state.setStateCd(stateDetails.getStateCd());
            return stateLookupRepository.save(state);
        }).orElseThrow(() -> new RuntimeException("State not found with id " + id));
    }

    public void deleteState(Integer id) {
        stateLookupRepository.deleteById(id);
    }
}
