package WeMasterTrade.tests.ui.logintest;

import WeMasterTrade.base.BaseTest;
import WeMasterTrade.data.Environment;
import WeMasterTrade.pages.login.LoginPage;
import org.testng.annotations.Test;


@Test
public class LoginTest extends BaseTest {

    public void logins ()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Environment.STG);
    }

}
