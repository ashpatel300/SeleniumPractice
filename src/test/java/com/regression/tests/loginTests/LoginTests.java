package com.regression.tests.loginTests;

import com.automation.application.shoppingcart.sauceDemoPractice.LandingPage;
import com.automation.application.shoppingcart.sauceDemoPractice.MyAccountPage;
import com.automation.application.shoppingcart.testDataManager.TestJsonGenerator;
import com.automation.framework.reusables.BaseTest;
import com.automation.framework.reusables.DataProviderUtils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends BaseTest {
    //String username = TestJsonGenerator.getDataForLogin("username");
    //String password = TestJsonGenerator.getDataForLogin("password");


    @Test(dataProvider = "randomLoginDataProvider", dataProviderClass = DataProviderUtils.class)
    public void validateSuccessfulLoginToApplication(String username, String password) throws IOException, ParseException {
        LandingPage landingPage = new LandingPage(browserManager.getDriver());
         MyAccountPage myAccountPage = landingPage.navigateToWebSite()
                 .enterUserName(username)
                 .enterPassword(password)
                 .clickOnLogIn();

         landingPage = myAccountPage.clickOnMenu()
                 .clickOnSignOut();
    }
}
