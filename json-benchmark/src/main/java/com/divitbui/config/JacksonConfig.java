package com.divitbui.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

import lombok.Getter;

@Getter
public class JacksonConfig {

    private ObjectMapper defaultJacksonObjectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private ObjectMapper afterbunerJacksonObjectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
                                                                           .registerModules(new AfterburnerModule());

}
