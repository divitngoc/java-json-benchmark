package com.divitbui.execution;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.divitbui.utils.AccountUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.Getter;

@Getter
@State(Scope.Benchmark)
public class ExecutionDeserializePlan extends ExecutionBase {

    public String yapilyAccountsJsonString;

    @Setup(Level.Invocation)
    public void setup(BenchmarkParamsState params) throws JsonProcessingException {
        // Not counted towards the execution time which is why this is okay to do
        yapilyAccountsJsonString = getJacksonConfig().getDefaultJacksonObjectMapper()
                                                     .writeValueAsString(AccountUtils.generateYapilyAccounts(params.getAccountSize()));
    }

}
