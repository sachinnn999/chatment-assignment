package com.sachinnn.facts.controller;

import com.sachinnn.facts.model.dao.AnimalFactsLog;
import com.sachinnn.facts.service.AnimalFactLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class BaseController {

    private final AnimalFactLogService animalFactLogService;

    public BaseController(AnimalFactLogService animalFactLogService) {
        this.animalFactLogService = animalFactLogService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public List<AnimalFactsLog> getLog(){
        return animalFactLogService.getAll();
    }
}
