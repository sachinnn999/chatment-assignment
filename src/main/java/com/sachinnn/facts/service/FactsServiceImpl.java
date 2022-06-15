package com.sachinnn.facts.service;

import com.google.gson.Gson;
import com.sachinnn.facts.helper.RestApiInvoker;
import com.sachinnn.facts.model.dto.FactsAPIResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sachinnn.facts.enumeration.AnimalType;
import org.springframework.web.client.HttpServerErrorException;

import java.util.HashMap;
import java.util.Map;


@Service
public class FactsServiceImpl implements FactsService {

    @Value("${api.animal.facts}")
    private String apiBase;

    @Override
    public String getRandomFact(AnimalType animalType) throws Exception {
        System.out.println(animalType);
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("amount", "1");
        queryParams.put("animal_type", animalType.name().toLowerCase());
        RestApiInvoker invoker = new RestApiInvoker();
        ResponseEntity<byte[]> responseEntity =  invoker.callRestWebService(apiBase, HttpMethod.GET, queryParams,null, null);

        if(responseEntity.getStatusCode() == HttpStatus.OK){
            if(responseEntity.getBody() == null){
                throw new HttpServerErrorException(HttpStatus.CONFLICT);
            }
        }else{
            throw new HttpServerErrorException(HttpStatus.CONFLICT);
        }
        String responseBody = new String(responseEntity.getBody());
        FactsAPIResponse  apiResponse = new Gson().fromJson(responseBody, FactsAPIResponse.class);
        return apiResponse.getText();
    }
}
