package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/loginTest.feature", "src/test/resources/cartTest.feature", "src/test/resources/addingProductsTest.feature"},
        glue ={"stepDefinitions","hooks"},
        plugin = {"pretty","json:target/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        publish = true
)
public class Run extends AbstractTestNGCucumberTests {
}
