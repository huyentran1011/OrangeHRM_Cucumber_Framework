package stepDefinitions;

import commons.BasePage;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;


public class LoginPageSteps extends BasePage {
    WebDriver driver;
    TestContext testContext;

    public LoginPageSteps(TestContext testContext) {
        this.driver = Hooks.openAndQuitBrowser();
        this.testContext = testContext;
    }

}
