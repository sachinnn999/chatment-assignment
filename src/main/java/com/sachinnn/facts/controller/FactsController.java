package com.sachinnn.facts.controller;

import com.sachinnn.facts.enumeration.AnimalType;
import com.sachinnn.facts.model.dao.AnimalFactsLog;
import com.sachinnn.facts.service.AnimalFactLogService;
import com.sachinnn.facts.service.FactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>FactsController</h1>
 * @author sachinnn
 * @since 16.06.2022
 */
@RestController
@RequestMapping(value = "/facts")
public class FactsController {

    private final FactsService factsService;

    private final AnimalFactLogService animalFactLogService;

    public FactsController(FactsService factsService, AnimalFactLogService animalFactLogService) {
        this.factsService = factsService;
        this.animalFactLogService = animalFactLogService;
    }

    /**
     * <h3>returning a fact</h3>
     * @param animalType animalType
     * @param request HttpServletRequest
     * @return Map<String, String> including the fact
     * @throws Exception
     */
    @RequestMapping(value = "animal/{type}", method = RequestMethod.GET)
    public Map<String, String> getAnimalFactByType(@PathVariable(value = "type") AnimalType animalType,
                                                   HttpServletRequest request) throws Exception {
        Map<String, String> response = new HashMap<>();
        String fact = factsService.getRandomFact(animalType);

        AnimalFactsLog log = new AnimalFactsLog();
        log.setCallerAddress(request.getRemoteAddr());
        log.setFact(fact);
        log.setTime(new Date());
        animalFactLogService.saveOrUpdate(log);

        response.put("fact",fact);
        return response;
    }
}
