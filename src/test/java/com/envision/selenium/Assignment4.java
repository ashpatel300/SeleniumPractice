package com.envision.selenium;

import com.automation.framework.reusables.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Assignment4 extends BaseTest {

    @Test
    public void buyEndToEnd() throws InterruptedException, IOException {
        baseUtils.launchWebApplication("http://automationpractice.com/index.php");
        baseUtils.clickOn("plt:Sign in");
        baseUtils.typeInto("id:email","hey@abc.com");
        baseUtils.typeInto("id:passwd","Testing@1234");
        baseUtils.clickOn("id:SubmitLogin");
        Thread.sleep(2000);
        baseUtils.clickOn("plt:T-SHIRTS");
        baseUtils.mouseHoverTo("xpath://img[@title='Faded Short Sleeve T-shirts']");
        Thread.sleep(2000);
        baseUtils.clickOn("xpath://span[contains(text(),'Add to cart')]");
        String p1AddedMessage = baseUtils.findElementBy("xpath","//h2[normalize-space()='Product successfully added to your shopping cart']").getText();
        System.out.println(p1AddedMessage);
        //Assert.assertEquals(p1AddedMessage, "Product successfully added to your shopping cart");
        baseUtils.clickOn("xpath://span[contains(text(),'Proceed to checkout')]");
        String totalPrice1 = baseUtils.findElementBy("id","total_price").getText();
        totalPrice1 = totalPrice1.substring(1);
        double totalPrice = Double.parseDouble(totalPrice1);
        System.out.println(totalPrice);
        Assert.assertTrue(totalPrice<20.00);
        baseUtils.clickOn("xpath://a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");
        baseUtils.clickOn("xpath://button[@class='button btn btn-default button-medium']//span[contains(text(),'Proceed to checkout')]");
        baseUtils.clickOn("id:cgv");
        String deliveryFee1 = baseUtils.findElementBy("xpath","//div[@class=\"delivery_option_price\"]").getText();
        deliveryFee1 = deliveryFee1.substring(1);
        double deliveryFee = Double.parseDouble(deliveryFee1);
        Assert.assertTrue(deliveryFee<5.00);
        baseUtils.clickOn("xpath://button[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");
        baseUtils.clickOn("xpath://a[@title=\"Pay by bank wire\"]");
        baseUtils.clickOn("xpath://button[@class=\"button btn btn-default button-medium\"]//span[contains(text(),'I confirm my order')]");
        String messageOfDone = baseUtils.findElementBy("xpath","//div[@class=\"box\"]//p[@class=\"cheque-indent\"]").getText();
        Assert.assertTrue(messageOfDone.equalsIgnoreCase("Your order on My Store is complete."));
        String finalPrice = baseUtils.findElementBy("xpath","//div[@class=\"box\"]//span[@class=\"price\"]").getText();
        String accountOwner = baseUtils.findElementBy("xpath","//*[@id=\"center_column\"]/div/strong[1]").getText();
        String bankName = baseUtils.findElementBy("xpath","//*[@id=\"center_column\"]/div/strong[3]").getText();
        System.out.println("Final Price is " + finalPrice);
        System.out.println("Account Owner Name - " +accountOwner);
        System.out.println("Bank name - " +bankName);
    }
}
