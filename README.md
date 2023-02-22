# ParallelTests_Serenity_Cucumber_JUnit5_Demo
This frameowrk show the parallel execution of Cucumber scenarios in Serenity with JUnit5

We can use the Maven Surefire plugin to run feature files in parallel.

1. Add following dependencies in your application pom.xml:
```
<dependency>
       <groupId>io.cucumber</groupId>
       <artifactId>cucumber-junit-platform-engine</artifactId>
       <version>7.11.0</version>
       <scope>test</scope>
</dependency>

<dependency>
      <groupId>org.junit.platform</groupId>
      <artifactId>junit-platform-suite</artifactId>
      <version>1.9.2</version>
      <scope>test</scope>
</dependency>
```

2. Create a file named junit-platform.properties under test/resources
```
cucumber.execution.parallel.enabled=true
cucumber.execution.parallel.config.strategy=fixed
cucumber.execution.parallel.config.fixed.parallelism=3
cucumber.plugin=io.cucumber.core.plugin.SerenityReporterParallel
```

3. Configure the classpath location of the scenarios to be executed in a Java class placed in a package under test/java
```
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("org/example")
@SelectClasspathResource("/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.example")
public class CucumberTestSuite {

}
```

4. Here is the detailed article link for Serenity Parallel Test Execution:

```https://qaautomation.expert/  ```

5. To run the tests, use the below command
```
mvn clean verify
```
