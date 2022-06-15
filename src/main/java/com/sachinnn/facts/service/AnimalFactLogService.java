package com.sachinnn.facts.service;

import com.sachinnn.facts.model.dao.AnimalFactsLog;
import com.sachinnn.facts.repository.AnimalFactsLogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public interface AnimalFactLogService {

    List<AnimalFactsLog> getAll();

    AnimalFactsLog getById(Long id);

    AnimalFactsLog saveOrUpdate(AnimalFactsLog animalFactsLog);

    void delete(Long id);

}
