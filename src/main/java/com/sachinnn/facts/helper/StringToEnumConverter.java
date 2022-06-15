package com.sachinnn.facts.helper;

import com.sachinnn.facts.enumeration.AnimalType;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, AnimalType> {
    @Override
    public AnimalType convert(String source) {
        return AnimalType.valueOf(source.toUpperCase());
    }
}
