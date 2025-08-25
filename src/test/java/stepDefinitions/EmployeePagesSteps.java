package stepDefinitions;

import commons.BasePage;
import cucumberOptions.Hooks;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageUIs.adminAccount.PIM.employee.AddEmployeePageUI;

public class AddEmployeePageSteps extends BasePage {
    WebDriver driver;
    public AddEmployeePageSteps() {
        driver = Hooks.openAndQuitBrowser();
    }

    @When("I enter {string} into a textbox which has placeholder is {string}")
    public void enterIntoATextboxWhichHasPlaceholderIs(String inputValue, String placeholder) {
        waitForElementVisible(driver, AddEmployeePageUI.DYNAMIC_TEXTBOX_BY_PLACEHOLDER, placeholder);
        sendKeyIntoElement(driver, AddEmployeePageUI.DYNAMIC_TEXTBOX_BY_PLACEHOLDER,inputValue, placeholder );
    }
}
