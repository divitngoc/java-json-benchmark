package com.divitbui.execution;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import com.divitbui.config.GsonConfig;
import com.divitbui.config.JacksonConfig;

import lombok.Getter;

@Getter
@State(Scope.Benchmark)
public abstract class ExecutionBase {

    private final JacksonConfig jacksonConfig = new JacksonConfig();
    private final GsonConfig gsonConfig = new GsonConfig();

    @State(Scope.Benchmark)
    @Getter
    public static class BenchmarkParamsState {

        @Param({ "10", "1000" })
        private int accountSize;

    }

}
