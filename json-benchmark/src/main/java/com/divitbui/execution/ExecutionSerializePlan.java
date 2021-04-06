package com.divitbui.execution;

import java.util.List;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.divitbui.model.yapily.Account;
import com.divitbui.utils.AccountUtils;

import lombok.Getter;

@Getter
@State(Scope.Benchmark)
public class ExecutionSerializePlan extends ExecutionBase {

    public List<Account> yapilyAccounts;

    @Setup(Level.Invocation)
    public void setup(BenchmarkParamsState params) {
        yapilyAccounts = AccountUtils.generateYapilyAccounts(params.getAccountSize());
    }

}
