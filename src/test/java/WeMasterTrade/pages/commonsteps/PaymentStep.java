package WeMasterTrade.pages.commonsteps;

import WeMasterTrade.utils.WebUI;
import org.openqa.selenium.By;

public class PaymentStep {

    public void fieldChooseGateawayWithLogoAndName(By menuLocator, By gateawayLocator, By tabLocator, By btnLocator )
    {
        WebUI.clickElement(menuLocator);
        WebUI.clickElement(gateawayLocator);
        WebUI.clickElement(tabLocator);
        WebUI.clickElement(btnLocator);
    }

    public void fieldAddNewLogoAndName ()
    {


    }

    public void fieldAddNewLogoAndName (By fieldLocator, String filedValue )
    {
        WebUI.setText(fieldLocator, filedValue);
    }

    public void fieldAddNewLogoAndName (By fieldLocator, String filedValue, By fieldLocator1, String filedValue1 )
    {
        WebUI.setText(fieldLocator, filedValue);
        WebUI.setText(fieldLocator1, filedValue1);
    }


}
