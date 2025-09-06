package WeMasterTrade.pages.login.locators.bo;

import org.openqa.selenium.By;

public class PaymentsLocatorBO {

    //Format đặt tên cho các loại element:
        //LBL_ → Label
        //BTN_ → Button
        //TXT_ → Input/Text field
        //DDL_ → Dropdown
        //CHK_ → Checkbox
        //RAD_ → Radio button

    // Locators Add new Logo&Name trong Gateaway "CryptoChill"
    public static final By BTN_ADDNEW = By.xpath("//button[@id='add-payment-method-localization']");
    public static final By DDL_COUNTRY = By.xpath("//select[@id='country']");
    public static final By COUNTRY_NAME = By.xpath("(//option[@value='13'][normalize-space()='Aruba'])[2]");
    public static final By TXT_THENAME = By.xpath("//input[@id='name']");
    public static final By LBL_THELOGO = By.xpath("//label[@id='area-choose-logo']");
    public static final By BTN_SAVE = By.xpath("//button[normalize-space()='Save']");
    public static final By BTN_CANCEL = By.xpath("(//button[@type='button'][normalize-space()='Cancel'])[6]");
    public static final By Icon_EDIT = By.xpath("//span[@data-name='toàn test']");


    // END Locators Add new Logo&Name trong Gateaway "CryptoChill"


}
