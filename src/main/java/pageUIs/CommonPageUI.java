package pageUIs;

public class CommonPageUI {
    public static final String DYNAMIC_TEXTBOX_BY_LABEL = "xpath=//label[text()=\"%s\"]/../following-sibling::div//input";
    public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/span";
    public static final String DYNAMIC_BUTTON_BY_NAME = "xpath=//button[contains(.,'%s')]";
    public static final String DYNAMIC_TABLE_FILTER_TITLE = "xpath=//h5[@class='oxd-table-filter-title' and text()='%s']";
    public static final String DYNAMIC_PAGE_BY_TITLE = "xpath=//h6[contains(@class,'orangehrm-main-title') and text()='%s']";
    public static final String DYNAMIC_DROPDOWN_MENU = "xpath=//label[text()='%s']/parent::div/following-sibling::div//div[contains(@class,'input')]";
    public static final String CHILD_LIST_IN_DROPDOWN = "xpath=//div[@role='option']/span";
    public static final String MESSAGE_CONTENT = "xpath=//div[contains(@class,'oxd-toast-content')]/p[contains(@class,'message')]";
    public static final String MESSAGE_TITLE = "xpath=//div[contains(@class,'oxd-toast-content')]/p[contains(@class,'title')]";
    public static final String DYNAMIC_SUB_MENU_ITEM = "xpath=//a[@class='orangehrm-tabs-item' and text()='%s']";
}
