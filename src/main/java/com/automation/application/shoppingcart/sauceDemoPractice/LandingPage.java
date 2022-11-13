package com.automation.application.shoppingcart.sauceDemoPractice;

import com.automation.framework.reusables.BaseUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LandingPage extends BaseUtils {
    public LandingPage(WebDriver driver){
        super(driver);
    }
    public LandingPage navigateToWebSite(){
        launchWebApplication("https://www.saucedemo.com/");
        return this;
    }
    public LandingPage enterUserName(String username) throws IOException {
        typeInto("shoppingCart.LoginPage.tbxUsername",username);
        return this;
    }
    public LandingPage enterPassword(String password) throws IOException {
        typeInto("shoppingCart.LoginPage.tbxPassword",password);
        return this;
    }

    public MyAccountPage clickOnLogIn() throws IOException {
        clickOn("shoppingCart.LoginPage.btnLogIn");
        return new MyAccountPage(this.driver);
    }

}
