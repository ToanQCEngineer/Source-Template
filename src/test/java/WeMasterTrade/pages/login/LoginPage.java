package WeMasterTrade.pages.login;

import WeMasterTrade.data.Environment;
import WeMasterTrade.pages.login.steps.LoginSteps;
import org.openqa.selenium.By;


public class LoginPage {
    LoginSteps loginSteps;


    By userName = By.xpath("//input[@id='user_login']");
    By passWord = By.xpath("//input[@id='user_pass']");
    By btnLogin = By.xpath("//input[@id='wp-submit']");
    By e_Contract = By.xpath("//span[@class='ant-typography ant-typography-danger css-1pzdzff']");



    public void login(Environment env)
    {
        loginSteps = new LoginSteps();

        loginSteps.login(env.getUrl(),
                userName,env.getUsername(),
                passWord, env.getPassword(),
                btnLogin);
    }



}// End class LoginPage
