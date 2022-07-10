package com.divitbui.benchmark;

import com.divitbui.execution.ExecutionDeserializePlan;
import com.divitbui.model.yapily.Account;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class BenchmarkDeserialize {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void jacksonDefault(Blackhole blackhole, ExecutionDeserializePlan plan) throws IOException {
        ObjectMapper mapper = plan.getJacksonConfig().getDefaultJacksonObjectMapper();

        blackhole.consume(mapper.readValue(plan.getYapilyAccountsJsonString(), new TypeReference<List<Account>>() {}));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void jacksonAfterburner(Blackhole blackhole, ExecutionDeserializePlan plan) throws IOException {
        ObjectMapper mapper = plan.getJacksonConfig().getAfterbunerJacksonObjectMapper();

        blackhole.consume(mapper.readValue(plan.getYapilyAccountsJsonString(), new TypeReference<List<Account>>() {}));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void jacksonBlackbird(Blackhole blackhole, ExecutionDeserializePlan plan) throws IOException {
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
