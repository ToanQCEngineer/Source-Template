package WeMasterTrade.pages.locators.systembo;

import org.openqa.selenium.By;

public class PaymentsLocatorBO {

    // Locators Add new Logo&Name trong Gateaway "CryptoChill"
    public static final By TAB_LOGOANDNAME = By.xpath("//a[normalize-space()='Logo & Name']");

    public static final By BTN_ADDNEW = By.xpath("//button[@id='add-payment-method-localization']");
    public static final By DDL_COUNTRY = By.xpath("//select[@id='country']");
    public static final By OPT_COUNTRY_NAME = By.xpath("(//option[@value='13'][normalize-space()='Aruba'])[2]");
    public static final By TXT_THENAME = By.xpath("//input[@id='name']");
    public static final By TXT_THELOGO = By.xpath("//label[@id='area-choose-logo']");
    public static final By BTN_SAVE = By.xpath("//button[normalize-space()='Save']");
    public static final By BTN_CANCEL = By.xpath("(//button[@type='button'][normalize-space()='Cancel'])[6]");
    public static final By ICON_EDIT = By.xpath("//span[@data-name='toàn test']");
    public static final By ICON_DELETE = By.xpath("(//tr//td[contains(normalize-space(),'toàn test')]/ancestor::div//span[@class='dashicons dashicons-trash delete-payment-method-localization delete-icon'])[1]");


    // END Locators Add new Logo&Name trong Gateaway "CryptoChill"


}
