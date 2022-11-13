package com.envision.selenium;

import com.automation.framework.reusables.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Assignment3 extends BaseTest {

    @Test
    public void sauceDemo() throws IOException {

        baseUtils.launchWebApplication("https://www.saucedemo.com/");
        baseUtils.typeInto("id:user-name", "standard_user");
        baseUtils.typeInto("id:password", "secret_sauce");
        baseUtils.clickOn("id:login-button");
        WebElement product1 = baseUtils.findElementBy("xpath","//div[contains(text(),'Sauce Labs Backpack')]");
        baseUtils.clickOn("id:add-to-cart-sauce-labs-backpack");
        String itemNumAddedInCart = baseUtils.findElementBy("xpath", "//span[@class=\"shopping_cart_badge\"]").getText();
        int checkPoint1 = Integer.parseInt(itemNumAddedInCart);
        Assert.assertEquals(checkPoint1,1);
        WebElement product2 = baseUtils.findElementBy("xpath","//div[contains(text(),'Sauce Labs Fleece Jacket')]");
        baseUtils.clickOn("id:add-to-cart-sauce-labs-fleece-jacket");
        String itemNumAddedInCart2 = baseUtils.findElementBy("xpath","//span[@class=\"shopping_cart_badge\"]").getText();
        int checkPoint2 = Integer.parseInt(itemNumAddedInCart2);
        Assert.assertEquals(checkPoint2,2);
        baseUtils.clickOn("xpath://a[@class=\"shopping_cart_link\"]");
        Assert.assertTrue(product1.isDisplayed());
        Assert.assertTrue(product2.isDisplayed());
        baseUtils.clickOn("id:checkout");
        baseUtils.typeInto("id:first-name","Aditya");
        baseUtils.typeInto("id:last-name", "Patel");
        baseUtils.typeInto("id:postal-code","L5V 1J2");
        baseUtils.clickOn("id:continue");
        String paymentInformation = baseUtils.findElementBy("xpath","//div[contains(text(),'Payment Information:')]/following::div[1]").getText();
        String shippingInformation = baseUtils.findElementBy("xpath","//div[contains(text(),'Shipping Information:')]/following::div[1]").getText();
        Assert.assertEquals(paymentInformation,"SauceCard #31337");
        Assert.assertEquals(shippingInformation,"FREE PONY EXPRESS DELIVERY!");
        String item1Price = baseUtils.findElementBy("xpath", "//div[@class=\"inventory_item_price\"]").getText();
        System.out.println(item1Price);
        String item1 = item1Price.substring(1);
        double i1 = Double.parseDouble(item1);
        String item2Price = baseUtils.findElementBy("xpath","//div[@class='inventory_item_price'][normalize-space()='$49.99']").getText();
        System.out.println(item2Price);
        String item2 = item2Price.substring(1);
        double i2 = Double.parseDouble(item2);
        String total = baseUtils.findElementBy("xpath","//div[@class=\"summary_subtotal_label\"]").getText();
        System.out.println(total);
        String totalNew = total.substring(13);
        System.out.println(totalNew);
        double totalNew1 = Double.parseDouble(totalNew);
        double i1i2 = i1+i2;
        System.out.println(i1i2);
        Assert.assertEquals(totalNew1,i1i2);
        baseUtils.clickOn("id:finish");
        String thankYouMessage =baseUtils.findElementBy("xpath","//h2[@class=\"complete-header\"]").getText();
        Assert.assertTrue(thankYouMessage.matches("THANK YOU FOR YOUR ORDER"));
    }

}
