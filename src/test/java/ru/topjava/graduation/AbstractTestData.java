package ru.topjava.graduation;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractTestData {
    public static final Integer START_SEQ = 100000;

    protected ObjectMapper objectMapper = new ObjectMapper();

}