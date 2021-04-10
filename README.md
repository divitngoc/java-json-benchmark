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
Benchmark                                (accountSize)  Mode  Cnt     Score     Error  Units
BenchmarkDeserialize.gson                           10  avgt    3    11.405 ±   1.596  ms/op
BenchmarkDeserialize.gson                         1000  avgt    3  1268.343 ± 477.418  ms/op
BenchmarkDeserialize.jacksonAfterburner             10  avgt    3     7.586 ±   0.911  ms/op
BenchmarkDeserialize.jacksonAfterburner           1000  avgt    3   814.616 ± 477.825  ms/op
BenchmarkDeserialize.jacksonBlackbird               10  avgt    3     7.641 ±   2.170  ms/op
BenchmarkDeserialize.jacksonBlackbird             1000  avgt    3   836.611 ± 197.586  ms/op
BenchmarkDeserialize.jacksonDefault                 10  avgt    3    10.504 ±   2.548  ms/op
BenchmarkDeserialize.jacksonDefault               1000  avgt    3  1147.884 ± 864.878  ms/op
BenchmarkSerialize.gson                             10  avgt    3    16.366 ±   3.409  ms/op
BenchmarkSerialize.gson                           1000  avgt    3  1614.168 ± 279.891  ms/op
BenchmarkSerialize.jacksonAfterburner               10  avgt    3     5.755 ±   0.302  ms/op
BenchmarkSerialize.jacksonAfterburner             1000  avgt    3   649.342 ± 196.282  ms/op
BenchmarkSerialize.jacksonBlackbird                 10  avgt    3     5.742 ±   0.940  ms/op
BenchmarkSerialize.jacksonBlackbird               1000  avgt    3   649.175 ± 130.161  ms/op
BenchmarkSerialize.jacksonDefaut                    10  avgt    3     5.828 ±   0.811  ms/op
BenchmarkSerialize.jacksonDefaut                  1000  avgt    3   653.333 ± 450.157  ms/op
```

