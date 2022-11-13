package com.automation.application.shoppingcart.sauceDemoPractice;

import com.automation.framework.reusables.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CheckOutCompletePage extends BaseUtils {

    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
    }

    public CheckOutCompletePage verifyMessageIsDisplayed() throws IOException {
        WebElement thankYouMsg = waitUntilVisibleAndReturnElement("shoppingCart.checkoutCompletePage.vrfMessage",10);
        thankYouMsg.isDisplayed();
        return this;
    }
}
