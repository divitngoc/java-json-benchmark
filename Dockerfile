FROM openjdk:17

ARG TARGET_PATH=json-benchmark/target

COPY ./${TARGET_PATH}/json-benchmark-1.0.0.jar app.jar
WORKDIR .

ADD ./${TARGET_PATH}/lib/ lib/

ENTRYPOINT ["java", "-jar", "app.jar"]