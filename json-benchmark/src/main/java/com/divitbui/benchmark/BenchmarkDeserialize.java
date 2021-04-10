package com.divitbui.benchmark;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;

import com.divitbui.execution.ExecutionDeserializePlan;
import com.divitbui.model.yapily.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class BenchmarkDeserialize {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void jacksonDefault(Blackhole blackhole, ExecutionDeserializePlan plan) throws JsonProcessingException {
        ObjectMapper mapper = plan.getJacksonConfig().getDefaultJacksonObjectMapper();

        blackhole.consume(mapper.readValue(plan.getYapilyAccountsJsonString(), new TypeReference<List<Account>>() {}));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void jacksonAfterburner(Blackhole blackhole, ExecutionDeserializePlan plan) throws JsonProcessingException {
        ObjectMapper mapper = plan.getJacksonConfig().getAfterbunerJacksonObjectMapper();

        blackhole.consume(mapper.readValue(plan.getYapilyAccountsJsonString(), new TypeReference<List<Account>>() {}));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void jacksonBlackbird(Blackhole blackhole, ExecutionDeserializePlan plan) throws JsonProcessingException {
        ObjectMapper mapper = plan.getJacksonConfig().getAfterbunerJacksonObjectMapper();

        blackhole.consume(mapper.readValue(plan.getYapilyAccountsJsonString(), new TypeReference<List<Account>>() {}));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void gson(Blackhole blackhole, ExecutionDeserializePlan plan) {
        Gson mapper = plan.getGsonConfig().getDefaultGson();

        blackhole.consume(mapper.fromJson(plan.getYapilyAccountsJsonString(), new TypeToken<List<Account>>() {}.getType()));
    }

}
