package stepDefinitions;

import commons.BasePage;
import cucumberOptions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageUIs.CommonPageUI;
import pageUIs.adminAccount.PIM.employee.EmployeePagesUI;

import java.util.List;

public class EmployeePagesSteps extends BasePage {
    WebDriver driver;
    TestContext testContext;
    public EmployeePagesSteps(TestContext testContext) {
        driver = Hooks.openAndQuitBrowser();
        this.testContext = testContext;
    }

    @When("I enter {string} into a textbox which has placeholder is {string}")
    public void enterIntoATextboxWhichHasPlaceholderIs(String inputValue, String placeholder) {
        waitForElementVisible(driver, EmployeePagesUI.DYNAMIC_TEXTBOX_BY_PLACEHOLDER, placeholder);
        sendKeyIntoElement(driver, EmployeePagesUI.DYNAMIC_TEXTBOX_BY_PLACEHOLDER,inputValue, placeholder );
    }

    @And("I click on the {string} button at {string} container")
    public void clickOnTheButtonAtContainer(String buttonName, String containerName) {
        sleepInSeconds(3);
        waitForElementClickable(driver, EmployeePagesUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, containerName, buttonName);
        clickOnElement(driver, EmployeePagesUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, containerName, buttonName);
    }

    @And("I click on the {string} button at {string} container by JS")
    public void clickOnTheButtonAtContainerByJS(String buttonName, String containerName) {
        waitForElementClickable(driver, EmployeePagesUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, containerName, buttonName);
        clickOnElementByJS(driver, EmployeePagesUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, containerName, buttonName);
    }

    @Then("I see the {string} file is displayed")
    public void iSeeTheUploadedFileIsDisplayed(String fileName) {
        boolean isFileDisplayed = false;
        waitForLoadingSpinnerDisable(driver);
        waitForElementVisible(driver, EmployeePagesUI.DYNAMIC_TABLE, "orangehrm-attachment");
        List<String> uploadedFiles = getAllValueByColumnName(driver,EmployeePagesUI.ATTACHMENT_COLUMN_HEADER, "File Name", EmployeePagesUI.ATTACHMENT_CELL_BY_COLUMN_INDEX, "orangehrm-attachment");
        for(String file:uploadedFiles) {
            if (file.trim().equals(fileName)) {
                isFileDisplayed = true;
            }
        }
        Assert.assertTrue(isFileDisplayed);
    }

    @Then("I click on {string} top bar menu")
    public void iClickOnTopBarMenu(String topbarMenu) {
        waitForElementVisible(driver, EmployeePagesUI.DYNAMIC_TOPBAR_MENU, topbarMenu);
        clickOnElement(driver, EmployeePagesUI.DYNAMIC_TOPBAR_MENU, topbarMenu);
    }

    @Then("I enter EmployeeID into textbox")
    public void iEnterEmployeeIDIntoTextbox() {
        String employeeID = (String) testContext.getDataContext().getContext(Context.EMPLOYEE_ID);
        sleepInSeconds(1);
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_LABEL,"Employee Id");
        sendKeyIntoElement(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_LABEL, employeeID, "Employee Id");
    }

    @And("I click on {string} toggle button")
    public void iClickOnToggleButton(String arg0) {
        waitForElementClickable(driver, EmployeePagesUI.CREATE_LOGIN_DETAILS_BUTTON);
        clickOnElement(driver, EmployeePagesUI.CREATE_LOGIN_DETAILS_BUTTON);
    }
}
