package com.teamc.notification.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {

    private static final ObjectMapper mapper = new ObjectMapper();

    private ObjectMapperFactory() {
    }

    public static ObjectMapper getInstance() {
        return mapper;
    }

}
