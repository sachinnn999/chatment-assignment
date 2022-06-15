package com.sachinnn.facts.helper;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

public class RestApiInvoker {
    /**
     *
     * @param url  needs to send with mapped query params
     * @param httpMethod  GET/POST/PUT/DELETE
     * @param queryParams  query params
     * @param headers   request headers
     * @param requestBody request body
     * @return Object with response body
     * @throws Exception exceptions
     */
    public ResponseEntity<byte[]> callRestWebService(String url, HttpMethod httpMethod, Map<String,?> queryParams, HttpHeaders headers, Object requestBody) throws Exception {
        ResponseEntity<byte[]> responseEntity;
        HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();
        if(queryParams == null) {
            responseEntity = restTemplate.exchange(url, httpMethod, entity, byte[].class);
        }else{
            responseEntity = restTemplate.exchange(url, httpMethod, entity, byte[].class, queryParams);
        }
        return responseEntity;
    }
}
