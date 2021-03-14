# Spring Boot Getting Started
https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started-introducing-spring-boot

# Spring CLI

spring run app.groovy

java -version
mvn -v
mvn dependency:tree
mvn spring-boot:run

## created Executable JAR
mvn package
jar tvf target/myproject-0.0.1-SNAPSHOT.jar

## run the jar
java -jar target/myproject-0.0.1-SNAPSHOT.jar

# Spring Initiallizer:  generate default pom, dependency etcc
https://start.spring.io/



# Spring boot starters
Spring Boot Starters are a set of convenient dependency descriptors that you can include in your application. You get a one-stop-shop for all the Spring and related technology that you need without having to hunt through sample code and copy paste loads of dependency descriptors. For example, if you want to get started using Spring and JPA for database access include the spring-boot-starter-data-jpa dependency in your project, and you are good to go.

https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot

## GIT
https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-starters
