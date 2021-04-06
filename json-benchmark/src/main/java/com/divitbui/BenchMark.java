package com.divitbui;

import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

import com.divitbui.execution.ExecutionDeserializePlan;
import com.divitbui.execution.ExecutionSerializePlan;
import com.divitbui.model.yapily.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class BenchMark {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void defaultJacksonSerialize(ExecutionSerializePlan plan) throws JsonProcessingException {
        ObjectMapper mapper = plan.getJacksonConfig().getDefaultJacksonObjectMapper();

        mapper.writeValueAsString(plan.yapilyAccounts);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void afterburnerJacksonSerialize(ExecutionSerializePlan plan) throws JsonProcessingException {
        ObjectMapper mapper = plan.getJacksonConfig().getAfterbunerJacksonObjectMapper();

        mapper.writeValueAsString(plan.yapilyAccounts);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void gsonSerialize(ExecutionSerializePlan plan) throws JsonProcessingException {
        Gson mapper = plan.getGsonConfig().getDefaultGson();

        mapper.toJson(plan.yapilyAccounts);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void defaultJacksonDeserialize(ExecutionDeserializePlan plan) throws JsonProcessingException {
        ObjectMapper mapper = plan.getJacksonConfig().getDefaultJacksonObjectMapper();

        mapper.readValue(plan.getYapilyAccountsJsonString(), new TypeReference<List<Account>>() {});
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void afterburnerJacksonDeserialize(ExecutionDeserializePlan plan) throws JsonProcessingException {
        ObjectMapper mapper = plan.getJacksonConfig().getAfterbunerJacksonObjectMapper();

        mapper.readValue(plan.getYapilyAccountsJsonString(), new TypeReference<List<Account>>() {});
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void gsonDeserialize(ExecutionDeserializePlan plan) {
        Gson mapper = plan.getGsonConfig().getDefaultGson();

        mapper.fromJson(plan.getYapilyAccountsJsonString(), new TypeToken<List<Account>>() {}.getType());
    }
}
