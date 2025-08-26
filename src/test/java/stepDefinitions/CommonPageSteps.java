package stepDefinitions;

import commons.BasePage;
import cucumberOptions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageUIs.CommonPageUI;

public class CommonPageSteps extends BasePage {
    WebDriver driver;
    TestContext testContext;
    public CommonPageSteps(TestContext testContext) {
        driver = Hooks.openAndQuitBrowser();
        this.testContext = testContext;
    }

    @When("I enter {string} into {string} textbox")
    public void enterValueIntoTextboxByLabel(String value, String label) {
        sleepInSeconds(1);
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_LABEL,label);
        sendKeyIntoElement(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_LABEL, value, label);
    }

    @And("I click on the {string} button")
    public void clickOnTheButtonByName(String buttonName) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_BUTTON_BY_NAME, buttonName);
        clickOnElement(driver, CommonPageUI.DYNAMIC_BUTTON_BY_NAME, buttonName);
    }

    @Then("I see the {string} textbox is displayed")
    public void verifyTheTextboxIsDisplayed(String textboxLabel) {
        Assert.assertTrue(isElementDisplayed(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_LABEL, textboxLabel));
    }

    @Then("I see the {string} button is displayed")
    public void verifyTheButtonIsDisplayed(String buttonName) {
        Assert.assertTrue(isElementDisplayed(driver, CommonPageUI.DYNAMIC_BUTTON_BY_NAME, buttonName));
    }

    @And("I select {string} dropdown menu by value is {string}")
    public void selectDropdownMenuByValueIs(String dropdownLabel, String selectValue) {
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_DROPDOWN_MENU, dropdownLabel);
        selectItemInCustomDropdown(driver, CommonPageUI.DYNAMIC_DROPDOWN_MENU, CommonPageUI.CHILD_LIST_IN_DROPDOWN, selectValue, dropdownLabel);
    }

    @Then("I see {string} page is displayed")
    public void verifyPageIsDisplayed(String pageName) {
        Assert.assertTrue(isElementDisplayed(driver, CommonPageUI.DYNAMIC_PAGE_BY_TITLE, pageName));
    }


    @Then("I see the toast message with title is {string} and content is {string}")
    public void iSeeTheToastMessageWithTitleIsAnd(String title, String message) {
        waitForElementVisible(driver, CommonPageUI.MESSAGE_TITLE);
        Assert.assertEquals(title, getElementText(driver, CommonPageUI.MESSAGE_TITLE));
        Assert.assertEquals(message, getElementText(driver, CommonPageUI.MESSAGE_CONTENT));
    }


    @And("I select {string} radio button")
    public void selectRadioButton(String label) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, label);
        clickOnElement(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, label);
    }

    @When("I click on the {string} sub menu")
    public void clickOnTheSubMenu(String subMenuName) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_SUB_MENU_ITEM, subMenuName);
        clickOnElement(driver, CommonPageUI.DYNAMIC_SUB_MENU_ITEM, subMenuName);
    }

    @And("I upload {string} file")
    public void uploadFile(String fileName) {
        uploadMultipleFiles(driver, fileName);
    }

    @And("I get value of {string} textbox")
    public void getValueFromTextbox(String label) {
        sleepInSeconds(3);
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_LABEL, label);
        String employeeID = getDomPropertyValue(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "value", label);
        testContext.getDataContext().setContext(Context.EMPLOYEE_ID, employeeID);
    }

    @When("I refresh the current page")
    public void iRefreshTheCurrentPage() {
        refreshCurrentPage(driver);
    }
}
