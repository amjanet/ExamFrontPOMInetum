package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/Feature/shopping.feature",
        glue = "StepDefinition",
        plugin = {"pretty", "html:tarjet/test-report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}