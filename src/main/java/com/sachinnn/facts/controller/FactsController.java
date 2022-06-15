package com.sachinnn.facts.controller;

import com.sachinnn.facts.enumeration.AnimalType;
import com.sachinnn.facts.service.FactsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/facts")
public class FactsController {

    private final FactsService factsService;

    public FactsController(FactsService factsService) {
        this.factsService = factsService;
    }

    @RequestMapping(value = "animal/{type}", method = RequestMethod.GET)
    public String getAnimalFactByType(@PathVariable(value = "type") AnimalType animalType) throws Exception {
        return factsService.getRandomFact(animalType);
    }
}
