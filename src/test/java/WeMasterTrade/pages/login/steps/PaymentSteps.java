package WeMasterTrade.pages.login.steps;

import WeMasterTrade.pages.login.locators.bo.MenuLocatorBO;
import WeMasterTrade.pages.login.locators.bo.PaymentsLocatorBO;
import WeMasterTrade.utils.WebUI;
import org.openqa.selenium.By;

public class PaymentSteps {

    public void chooseGateawayWithLogoAndName(By byMenu, By byGateaway, By byTabName, By byBtn )
    {
        WebUI.clickElement(byMenu);
        WebUI.clickElement(byGateaway);
        WebUI.clickElement(byTabName);
        WebUI.clickElement(byBtn);
    }

    public void addNewLogoAndName ()
    {

    }


    public void addNewLogoAndName (By TXTFiled, String valueTXTFiled )
    {
        WebUI.setText(TXTFiled, valueTXTFiled);
    }

    public void addNewLogoAndName (By TXTFiled, String valueTXTFiled, By TXTFiled1, String valueTXTFiled1 )
    {
        WebUI.setText(TXTFiled, valueTXTFiled);
        WebUI.setText(TXTFiled1, valueTXTFiled1);
    }


}
