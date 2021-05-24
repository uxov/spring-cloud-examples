# Spring Cloud Examples

- [Spring Cloud With Eureka](spring-cloud-eureka)
- [Spring Cloud Gateway With Eureka](spring-cloud-gateway-eureka)
- [Spring Cloud Eureka With Hystrix](spring-cloud-hystrix-eureka)
- [Spring Cloud Sleuth With Zipkin](spring-cloud-sleuth-zipkin)


## Build And Run
### Requirements
- Java version >= 8  
- Gradle

### Build
Such as the following commands:
```shell
cd spring-cloud-examples/spring-cloud-eureka
cd eureka-server
gradle build
```

### Run
```shell
gradle bootRun
```
Or
```shell
java -jar build/libs/eureka-server-0.0.1-SNAPSHOT.jar
```
