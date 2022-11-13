package com.automation.application.shoppingcart.sauceDemoPractice;

import com.automation.framework.reusables.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class CheckOutStep2 extends BaseUtils {

    public CheckOutStep2(WebDriver driver) {
        super(driver);
    }
    public CheckOutStep2 verifyShippingInformation() throws IOException {
        WebElement paymentInfo =waitUntilVisibleAndReturnElement("shoppingCart.checkoutPage2.paymentInfo",10);
        String paymentInfoDetails = paymentInfo.getText();
        Assert.assertEquals(paymentInfoDetails,"SauceCard #31337");
        WebElement shippingInfo = waitUntilVisibleAndReturnElement("shoppingCart.checkoutPage2.shippingInfo",10);
        String shippingInfoDetails = shippingInfo.getText();
        Assert.assertEquals(shippingInfoDetails,"FREE PONY EXPRESS DELIVERY!");
        WebElement item1Price = waitUntilVisibleAndReturnElement("shoppingCart.checkoutPage2.vrfPriceSauceLabsBackpack",10);
        String item1Cost = item1Price.getText();
        String item1 = item1Cost.substring(1);
        double item1FinalPrice = Double.parseDouble(item1);
        WebElement item2Price = waitUntilVisibleAndReturnElement("shoppingCart.checkoutPage2.vrfPriceSauceLabsFleeceJacket",10);
        String item2Cost = item2Price.getText();
        String item2 = item2Cost.substring(1);
        double item2FinalPrice = Double.parseDouble(item2);
        WebElement total = waitUntilVisibleAndReturnElement("shoppingCart.checkoutPage2.totalPrice",10);
        String totalInString = total.getText();
        String totalNew = totalInString.substring(13);
        double totalFinal = Double.parseDouble(totalNew);
        double bothItemTotal = item1FinalPrice+item2FinalPrice;
        Assert.assertEquals(totalFinal,bothItemTotal);
        return this;
    }

    public CheckOutCompletePage clickOnFinish() throws IOException {
        clickOn("shoppingCart.checkoutPage2.btnFinish");
        return new CheckOutCompletePage(this.driver);
    }
}
