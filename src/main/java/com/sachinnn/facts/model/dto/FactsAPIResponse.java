package com.sachinnn.facts.model.dto;

import lombok.Data;

@Data
public class FactsAPIResponse {
    private String _id;
    private String user;
    private String text;
    private String type;
}
