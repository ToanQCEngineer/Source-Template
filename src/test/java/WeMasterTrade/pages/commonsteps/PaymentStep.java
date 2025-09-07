package WeMasterTrade.pages.commonsteps;

import WeMasterTrade.pages.model.pojo.PaymentPOJO;
import WeMasterTrade.utils.LoggerUtils;
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

}
