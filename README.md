# java-json-benchmark

This project uses JMH benchmark tool to analyse benchmarks of different JSON libraries for Java.

##### Project requirement
- Java 11
- lombok

<br/>

So far, JSON libraries tested are:

- Jackson default
- Jackson + Afterburner
- Jackson + Blackbird
- Gson

<br/>

I've used [Yapily API Accounts](https://api.yapily.com/explorer#!/Accounts/getAccountsUsingGET) models to serialize and deserialize which includes time.

Average time (lower the score, the better)

```
Benchmark                                (accountSize)  Mode  Cnt     Score      Error  Units
BenchmarkDeserialize.gson                           10  avgt    3    19.202 ±   18.652  ms/op
BenchmarkDeserialize.gson                         1000  avgt    3  2307.272 ± 1728.842  ms/op
BenchmarkDeserialize.jacksonAfterburner             10  avgt    3    14.858 ±   10.029  ms/op
BenchmarkDeserialize.jacksonAfterburner           1000  avgt    3  1633.823 ±  530.238  ms/op
BenchmarkDeserialize.jacksonBlackbird               10  avgt    3    14.238 ±    4.111  ms/op
BenchmarkDeserialize.jacksonBlackbird             1000  avgt    3  1651.604 ±  441.165  ms/op
BenchmarkDeserialize.jacksonDefault                 10  avgt    3    19.976 ±    9.786  ms/op
BenchmarkDeserialize.jacksonDefault               1000  avgt    3  2315.070 ±  471.364  ms/op
BenchmarkSerialize.gson                             10  avgt    3    29.376 ±   33.918  ms/op
BenchmarkSerialize.gson                           1000  avgt    3  2977.030 ±  583.201  ms/op
BenchmarkSerialize.jacksonAfterburner               10  avgt    3    16.259 ±   22.834  ms/op
BenchmarkSerialize.jacksonAfterburner             1000  avgt    3  1485.304 ± 1012.453  ms/op
BenchmarkSerialize.jacksonBlackbird                 10  avgt    3    15.826 ±   14.766  ms/op
BenchmarkSerialize.jacksonBlackbird               1000  avgt    3  1610.428 ±  367.462  ms/op
BenchmarkSerialize.jacksonDefaut                    10  avgt    3    19.449 ±   40.626  ms/op
BenchmarkSerialize.jacksonDefaut                  1000  avgt    3  1686.815 ± 1306.903  ms/op
```

