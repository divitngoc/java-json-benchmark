package com.divitbui.benchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;

import com.divitbui.execution.ExecutionSerializePlan;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class BenchmarkSerialize {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void jacksonDefaut(Blackhole blackhole, ExecutionSerializePlan plan) throws JsonProcessingException {
        ObjectMapper mapper = plan.getJacksonConfig().getDefaultJacksonObjectMapper();

        blackhole.consume(mapper.writeValueAsString(plan.yapilyAccounts));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void jacksonAfterburner(Blackhole blackhole, ExecutionSerializePlan plan) throws JsonProcessingException {
        ObjectMapper mapper = plan.getJacksonConfig().getAfterbunerJacksonObjectMapper();

        blackhole.consume(mapper.writeValueAsString(plan.yapilyAccounts));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void jacksonBlackbird(Blackhole blackhole, ExecutionSerializePlan plan) throws JsonProcessingException {
        ObjectMapper mapper = plan.getJacksonConfig().getBlackbirdJacksonObjectMapper();

        blackhole.consume(mapper.writeValueAsString(plan.yapilyAccounts));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void gson(Blackhole blackhole, ExecutionSerializePlan plan) throws JsonProcessingException {
        Gson mapper = plan.getGsonConfig().getDefaultGson();

        blackhole.consume(mapper.toJson(plan.yapilyAccounts));
    }

}
