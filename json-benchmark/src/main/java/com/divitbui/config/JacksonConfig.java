package com.divitbui.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.fasterxml.jackson.module.blackbird.BlackbirdModule;

import lombok.Getter;

@Getter
public class JacksonConfig {

    private ObjectMapper defaultJacksonObjectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
                                                                        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    private ObjectMapper afterbunerJacksonObjectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
                                                                           .registerModules(new AfterburnerModule())
                                                                           .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    private ObjectMapper blackbirdJacksonObjectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
                                                                          .registerModules(new BlackbirdModule())
                                                                          .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
}
