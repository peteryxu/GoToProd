# local machine: daily development: clean, package, run, test
cd complete

./mvnw clean
./mvnw package 
./mvnw spring-boot:run

suppress maven message:
./mvnw -q spring-boot:run

or
java -Dspring.profiles.active=local -jar target/spring-boot-0.0.1-SNAPSHOT.jar

http://localhost:8080/

# push to OCP px-dev project directly & Test, not from docker images

complete % oc login --token=sha256~sJFwwXnHyAbkyqGNbuD9QE60DLvcUaF9-jD4Zf1pEzY --server=https://c104-e.us-east.containers.cloud.ibm.com:30729
Logged into "https://c104-e.us-east.containers.cloud.ibm.com:30729" as "IAM#peteryxu@us.ibm.com" using the token provided.

You have access to 73 projects, the list has been suppressed. You can list all projects with 'oc projects'

Using project "px-dev".
complete % export USER=peteryxu
complete % odo push            
 ✓  Waiting for component to start [49ms]

Validation
 ✓  Validating the devfile [135614ns]

# Test on OCP px-dev,  if working correct, commit to the feature branch:
git branch
git status
git 
# Spring profiles for different ENVs
https://www.baeldung.com/spring-profiles
In Spring Boot, it picks .properties or .yaml files in the following sequences:

application-{profile}.{properties|yml}
application.{properties|yml}

# Quality Train: Moving a Spring App to Production
https://spring.io/guides/gs/spring-boot/


##  create and download using Spring Initializer
https://start.spring.io/

## run
./mvnw spring-boot:run
curl localhost:8080

## add Unit Tests

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>


## add Actuator

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>


./mvnw spring-boot:run

The actuator exposes the following:
    actuator/health
    actuator/info
    actuator

$ curl localhost:8080/actuator/health
{"status":"UP"}

$ curl -X POST localhost:8080/actuator/shutdown
{"timestamp":1401820343710,"error":"Not Found","status":404,"message":"","path":"/actuator/shutdown"}

## add Logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

Logger logger = LoggerFactory.getLogger(HelloController.class);

logger.trace("A TRACE Message");
logger.debug("A DEBUG Message");
logger.info("An INFO Message");
logger.warn("A WARN Message");
logger.error("An ERROR Message");

### change log level: 
the default logging level of the Logger is preset to INFO, meaning that TRACE and DEBUG messages are not visible. In order to activate them without changing the configuration, we can pass the –debug or –trace arguments on the command line:

java -jar target/spring-boot-0.0.1-SNAPSHOT.jar --trace

Spring Boot also gives us access to a more fine-grained log level setting via environment variables. There are several ways we can accomplish this.

-Dlogging.level.org.springframework=TRACE 
-Dlogging.level.com.baeldung=TRACE

Alternatively, if we're using Maven, we can define our log settings via the command line:
mvn spring-boot:run 
  -Dspring-boot.run.arguments=--logging.level.org.springframework=TRACE,--logging.level.com.baeldung=TRACE

If we want to change the verbosity permanently, we can do so in the application.properties file
logging.level.root=WARN
logging.level.com.baeldung=TRACE

Finally, we can change the logging level permanently by using our logging framework configuration file.
<logger name="org.springframework" level="INFO" />
<logger name="com.baeldung" level="INFO" />

Remember that if the log level for a package is defined multiple times using the different options mentioned above, but with different log levels, the lowest level will be used.

So, if we set the logging levels using Logback, Spring Boot, and environment variables at the same time, the log level will be TRACE, as it is the lowest among the requested levels.



# Dockerize the App and test
https://spring.io/guides/gs/spring-boot-docker/

https://github.com/fmarchioni/masterspringboot/tree/master/demo-docker

## create dockfile

## testing locally using docker

docker build -t springio/gs-spring-boot-docker .
docker run -p 8080:8080 springio/gs-spring-boot-docker

## Build a Docker Image with Maven
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker


# Deploy to remote OpenShift 

http://www.mastertheboss.com/jboss-frameworks/spring/deploy-your-springboot-applications-on-openshift

oc new-app registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift~https://github.com/fmarchioni/masterspringboot.git --context-dir=demo-docker --name=springboot-demo-docker


