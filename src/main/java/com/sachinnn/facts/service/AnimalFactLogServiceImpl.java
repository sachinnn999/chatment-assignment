package com.sachinnn.facts.service;

import com.sachinnn.facts.model.dao.AnimalFactsLog;
import com.sachinnn.facts.repository.AnimalFactsLogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalFactLogServiceImpl implements  AnimalFactLogService{
    private final AnimalFactsLogRepository animalFactsLogRepository;

    public AnimalFactLogServiceImpl(AnimalFactsLogRepository animalFactsLogRepository) {
        this.animalFactsLogRepository = animalFactsLogRepository;
    }

    @Override
    public List<AnimalFactsLog> getAll() {
        List<AnimalFactsLog> log = new ArrayList<>();
        animalFactsLogRepository.findAll().forEach(log::add);
        return log;
    }

    @Override
    public AnimalFactsLog getById(Long id) {
        return animalFactsLogRepository.findById(id).get();
    }

    @Override
    public AnimalFactsLog saveOrUpdate(AnimalFactsLog animalFactsLog) {
        return animalFactsLogRepository.save(animalFactsLog);
    }

    @Override
    public void delete(Long id) {
        animalFactsLogRepository.deleteById(id);
    }

}
