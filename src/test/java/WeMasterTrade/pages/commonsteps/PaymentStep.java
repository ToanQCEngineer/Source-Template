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
//    public void fieldAddNewLogoAndName (By drdListLocator, By optLocator )
//    {
//        WebUI.clickElement(drdListLocator);
//        WebUI.clickElement(optLocator);
//
//    }
//    public void fieldAddNewLogoAndName (By thenameLocator, String value )
//    {
//        WebUI.setText(thenameLocator, value);
//    }
//
//    public void fieldAddNewLogoAndName (By drdListLocator, By optLocator, By thenameLocator, String value )
//    {
//        WebUI.clickElement(drdListLocator);
//        WebUI.clickElement(optLocator);
//        WebUI.setText(thenameLocator, value);
//    }


}
