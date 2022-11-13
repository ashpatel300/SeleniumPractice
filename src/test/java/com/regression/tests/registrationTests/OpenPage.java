package com.regression.tests.registrationTests;

import com.automation.application.shoppingcart.sauceDemoPractice.LandingPage;
import com.automation.framework.reusables.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class OpenPage extends BaseTest {

    @Test
    public void DoingNothing() throws IOException {
        LandingPage landingPage = new LandingPage(browserManager.getDriver());
        landingPage.navigateToWebSite()
                .clickOnLogIn();
    }
}
