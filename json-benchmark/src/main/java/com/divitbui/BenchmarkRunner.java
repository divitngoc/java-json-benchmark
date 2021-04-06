package com.divitbui;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder().include(BenchMark.class.getSimpleName())
                                          .warmupIterations(1)// number of times the warmup iteration should take place
                                          .measurementIterations(3)// number of times the actual iteration should take place
                                          .forks(1)
                                          .shouldDoGC(true)
                                          .build();

        new Runner(opt).run();
    }

}
