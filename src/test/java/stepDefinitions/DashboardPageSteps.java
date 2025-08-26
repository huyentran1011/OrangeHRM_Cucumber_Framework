package stepDefinitions;

import commons.BasePage;
import cucumberOptions.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import pageUIs.SidePanelAndTopBarUI;
import pageUIs.adminAccount.dashboard.DashboardPageUI;

public class DashboardPageSteps extends BasePage {
    WebDriver driver;

    public DashboardPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }

    @Then("Dashboard page is displayed")
    public void dashboardPageIsDisplayed() {
        Assert.assertTrue(isElementDisplayed(driver, DashboardPageUI.PAGE_TITLE));
    }


    @When("I logout")
    public void iLogout() {
        selectItemInCustomDropdown(driver, SidePanelAndTopBarUI.USER_DROPDOWN, SidePanelAndTopBarUI.USER_DROPDOWN_CHILD_ITEMS, "Logout");
    }
}
