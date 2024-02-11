package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/features",
                 publish=true,
                glue = { "stepDefinations", "hooks" }, plugin = {"pretty",
		        "html:target/CucumberReports/CucumberReports.html" })
public class TestRunner {

}
