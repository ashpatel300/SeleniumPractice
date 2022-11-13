package com.regression.tests.registrationTests;

import com.automation.application.shoppingcart.sauceDemoPractice.*;
import com.automation.application.shoppingcart.testDataManager.TestJsonGenerator;
import com.automation.framework.reusables.BaseTest;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckOutProcessTest extends BaseTest {
    String username = TestJsonGenerator.getDataForLogin("username");
    String password = TestJsonGenerator.getDataForLogin("password");


    @Test(invocationCount = 2,description = "checkout process using valid data")
    public void validateCheckOutProcess() throws IOException, ParseException {
        LandingPage landingPage = new LandingPage(browserManager.getDriver());
        MyAccountPage myAccountPage = landingPage.navigateToWebSite()
                .enterUserName(username)
                .enterPassword(password)
                .clickOnLogIn();

        CartPage cartPage = myAccountPage.addSauceLabsBackpack()
                .verifyShoppingCartIcon()
                .addSauceLabsFleeceJacket()
                .verifyShoppingCartIcon2()
                .clickOnCart();

        CheckOutStep1 checkOutStep1 =cartPage.verifyItemInCart()
                .clickOnCheckout();

        CheckOutStep2 checkOutStep2 = checkOutStep1.enterCustomerDetails()
                .clickOnContinue();

        CheckOutCompletePage checkOutCompletePage = checkOutStep2.verifyShippingInformation()
                .clickOnFinish();

        checkOutCompletePage.verifyMessageIsDisplayed();
    }
}
