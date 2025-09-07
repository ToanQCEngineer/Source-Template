package WeMasterTrade.pages.paymentmethods;

import WeMasterTrade.pages.commonsteps.PaymentStep;
import WeMasterTrade.pages.commonsteps.PaymentsBuider;
import WeMasterTrade.pages.locators.systembo.GatewayLocatorsBO;
import WeMasterTrade.pages.locators.systembo.MenuLocatorBO;
import WeMasterTrade.pages.locators.systembo.PaymentsLocatorBO;

public class LogoAndName {
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

    public void addNew()
    {
        PaymentsBuider paymentsBuider = new PaymentsBuider();
        paymentsBuider.setDropdown(PaymentsLocatorBO.DDL_COUNTRY);
        paymentsBuider.setOption(PaymentsLocatorBO.OPT_COUNTRY_NAME);
        paymentsBuider.setNameField(PaymentsLocatorBO.TXT_THENAME);
        paymentsBuider.setNameValue("test logo");
    }

}
