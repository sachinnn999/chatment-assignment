package com.sachinnn.facts.service;

import com.sachinnn.facts.enumeration.AnimalType;

public interface FactsService {
    String getRandomFact(AnimalType animalType) throws Exception;
}
