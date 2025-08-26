package stepDefinitions;

import commons.BasePage;
import cucumberOptions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageUIs.SidePanelAndTopBarUI;

public class SidePanelAndTopBarSteps extends BasePage {
    WebDriver driver;

    public SidePanelAndTopBarSteps() {
        driver = Hooks.openAndQuitBrowser();
    }

    @And("I click on the {string} menu")
    public void clickOnTheMenu(String menuName) {
        waitForElementClickable(driver, SidePanelAndTopBarUI.DYNAMIC_MENU_BY_PAGE_NAME, menuName);
        clickOnElement(driver, SidePanelAndTopBarUI.DYNAMIC_MENU_BY_PAGE_NAME, menuName);
    }

    @When("Logout")
    public void logout() {
        selectItemInCustomDropdown(driver, SidePanelAndTopBarUI.USER_DROPDOWN, SidePanelAndTopBarUI.USER_DROPDOWN_CHILD_ITEMS, "Logout");
    }
}
