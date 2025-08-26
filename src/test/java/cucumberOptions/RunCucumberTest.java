package cucumberOptions;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepDefinitions")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:features")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Login")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/cucumber-reports/cucumber.html," +
        "json:target/cucumber-reports/cucumber.json," +
        "junit:target/cucumber-reports/cucumber.xml")
public class RunCucumberTest {
}

