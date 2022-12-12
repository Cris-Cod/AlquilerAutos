package runners;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinition"},
        monochrome = true, plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})

public class MainRunner {
}
