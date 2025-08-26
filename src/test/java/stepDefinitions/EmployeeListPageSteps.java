package stepDefinitions;

import commons.BasePage;
import cucumberOptions.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageUIs.adminAccount.PIM.employee.EmployeePagesUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeListPageSteps extends BasePage {
    WebDriver driver;

    public EmployeeListPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }


    @Then("Verify search result in the Employee table:")
    public void verifySearchResult(DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        List<List<String>> actualRowsOfData =  getDataInTableInAllPages(driver, "orangehrm-employee-list", EmployeePagesUI.DYNAMIC_TABLE,
                EmployeePagesUI.TABLE_ROW, EmployeePagesUI.TABLE_CELL, EmployeePagesUI.PAGE_LINKS);

        List<List<String>> expectedRowsOfData = new ArrayList<>();
        for(Map<String, String> row:dataList){
            List<String> dataByRow = new ArrayList<>();
            dataByRow.add(row.get("Id"));
            dataByRow.add(row.get("First (& Middle) Name"));
            dataByRow.add(row.get("Last Name"));
            dataByRow.add(row.get("Job Title"));
            dataByRow.add(row.get("Employment Status"));
            dataByRow.add(row.get("Sub Unit"));
            dataByRow.add(row.get("Supervisor"));
            expectedRowsOfData.add(dataByRow);
        }
        Assert.assertEquals(actualRowsOfData, expectedRowsOfData);
    }

    @Then("I see {string} Record Found")
    public void iSeeRecordFound(String expectedNumRecordFound) {
        int actualNumRecordFound;
        waitForElementVisible(driver, EmployeePagesUI.NUMBER_RECORD_FOUND);
        String recordString = getElementText(driver, EmployeePagesUI.NUMBER_RECORD_FOUND);
        if(recordString.equals("No Records Found")){
            actualNumRecordFound =  0;
        }else {
            recordString = recordString.substring(1, recordString.indexOf(")"));
            actualNumRecordFound = Integer.parseInt(recordString);
        }
        Assert.assertEquals(Integer.parseInt(expectedNumRecordFound), actualNumRecordFound);
    }
}
