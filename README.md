
## Getting Started
Each project is an individual maven project. We can run a maven goal to execute the test cases.
```
mvn test
```

or, right click the ```RunCukesTest.java``` file and click ```Run "RunCukesTest.java"``` which will also create a Run Configuration for the same.

## Running specific test cases
In the ```RunCukesTest.java``` class, a tag is defined ```@CucumberOptions(tags = {"@run"}``` and all test cases in their feature files are tagged as @run

Just specify any tag to the test case you want to run and change @run in RunCukesTest.java to your tag.

Example:
Scenario file
```
@run @new
  Scenario: Cross-Device Elements Test
```
RunCukesTest
```
@CucumberOptions(tags = {"@new"}
```
