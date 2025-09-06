package WeMasterTrade.pages.paymentmethods;

import WeMasterTrade.pages.commonsteps.PaymentStep;
import WeMasterTrade.pages.locators.systembo.GatewayLocatorsBO;
import WeMasterTrade.pages.locators.systembo.MenuLocatorBO;
import WeMasterTrade.pages.locators.systembo.PaymentsLocatorBO;

public class GateawayCryptoChillPage {
    PaymentStep paymentStep;
    public void chooseGateawayWithLogoAndName ()
    {
        paymentStep = new PaymentStep();
        paymentStep.fieldChooseGateawayWithLogoAndName(
                MenuLocatorBO.PAYMENTMETHOD,
                GatewayLocatorsBO.CRYPTOCHILL,
                PaymentsLocatorBO.TAB_LOGOANDNAME,
                PaymentsLocatorBO.BTN_ADDNEW);
    }

    public void addNewLogoAndNameSuccess()
    {
        

    }

}
