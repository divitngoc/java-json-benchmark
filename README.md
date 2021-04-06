# java-json-benchmark

This project uses JMH benchmark tool to analyse benchmarks of different JSON libraries for Java.

##### Project requirement
- Java 11
- lombok

<br/>

So far, JSON libraries tested are:

- Jackson Objectmapper
- Jackson Objectmapper + Afterburner

<br/>

I've used [Yapily API Accounts](https://api.yapily.com/explorer#!/Accounts/getAccountsUsingGET) models to serialize and deserialize which includes time.

Average time (lower the score, the better)

```
Benchmark                                (accountSize)  Mode  Cnt  Score    Error  Units
BenchMark.afterburnerJacksonDeserialize             10  avgt    3  0.007 ±  0.001   s/op
BenchMark.afterburnerJacksonDeserialize           1000  avgt    3  0.768 ±  0.349   s/op
BenchMark.afterburnerJacksonSerialize               10  avgt    3  0.006 ±  0.001   s/op
BenchMark.afterburnerJacksonSerialize             1000  avgt    3  0.625 ±  0.139   s/op
BenchMark.defaultJacksonDeserialize                 10  avgt    3  0.010 ±  0.002   s/op
BenchMark.defaultJacksonDeserialize               1000  avgt    3  1.106 ±  0.573   s/op
BenchMark.defaultJacksonSerialize                   10  avgt    3  0.006 ±  0.001   s/op
BenchMark.defaultJacksonSerialize                 1000  avgt    3  0.645 ±  0.401   s/op
```


<br/>
Another set of results for throughput (the higher the score, the better)

```
Benchmark                                (accountSize)   Mode  Cnt    Score    Error  Units
BenchMark.afterburnerJacksonDeserialize             10  thrpt    3  142.781 ± 11.907  ops/s
BenchMark.afterburnerJacksonDeserialize           1000  thrpt    3    1.241 ±  0.625  ops/s
BenchMark.afterburnerJacksonSerialize               10  thrpt    3  178.367 ±  3.358  ops/s
BenchMark.afterburnerJacksonSerialize             1000  thrpt    3    1.655 ±  0.276  ops/s
BenchMark.defaultJacksonDeserialize                 10  thrpt    3  101.303 ± 18.923  ops/s
BenchMark.defaultJacksonDeserialize               1000  thrpt    3    0.943 ±  0.416  ops/s
BenchMark.defaultJacksonSerialize                   10  thrpt    3  177.310 ± 15.535  ops/s
BenchMark.defaultJacksonSerialize                 1000  thrpt    3    1.548 ±  0.544  ops/s
```
