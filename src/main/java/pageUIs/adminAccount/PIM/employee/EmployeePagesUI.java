package pageUIs.adminAccount.PIM.employee;

public class EmployeePagesUI {
    public static final String DYNAMIC_TEXTBOX_BY_PLACEHOLDER = "xpath=//input[@placeholder='%s']";
    public static final String DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER = "xpath=//h6[text()='%s']/following-sibling::form/div/button[contains(.,'%s')]";
    public static final String ATTACHMENT_COLUMN_HEADER = "xpath=//div[@class='%s']//div[@role='columnheader']";
    public static final String ATTACHMENT_CELL_BY_COLUMN_INDEX = "xpath=//div[@class='%s']//div[@role='cell'][%s]";

    public static final String PAGE_LINKS = "xpath=//button[contains(@class,'oxd-pagination-page-item--page')]";
    public static final String DYNAMIC_TABLE = "xpath=//div[@class='%s']//div[@role='table']";
    public static final String TABLE_ROW = "xpath=//div[@role='row']";
    public static final String TABLE_CELL = "xpath=.//div[@role='cell']";
    public static final String DYNAMIC_TOPBAR_MENU = "xpath=//nav[@aria-label='Topbar Menu']//a[text()='%s']";
    public static final String NUMBER_RECORD_FOUND = "xpath=//span[contains(.,'Found')]";
    public static final String CREATE_LOGIN_DETAILS_BUTTON = "xpath=//input[@type='checkbox']/following-sibling::span";
}
