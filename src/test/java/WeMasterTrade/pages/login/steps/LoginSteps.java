package WeMasterTrade.pages.login.steps;

import WeMasterTrade.utils.Sleeps;
import WeMasterTrade.utils.WebUI;
import org.openqa.selenium.By;

public class LoginSteps {



    public void login(String url, By byUsername,String valueUsername, By byPassword, String valuePassword, By byBtn)
    {
        WebUI.openURL(url);
        WebUI.sleep(Sleeps.WAIT_ONE);
        WebUI.setText(byUsername, valueUsername);
        WebUI.setText(byPassword, valuePassword);
        WebUI.clickElement(byBtn);
        WebUI.waitForPageLoaded();

    }



}
