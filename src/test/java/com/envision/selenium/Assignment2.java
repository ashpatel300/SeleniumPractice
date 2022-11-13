package com.envision.selenium;

import com.automation.framework.reusables.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment2 extends BaseTest {

    @Test
    public void toySellingWebsite(){

        try {
        baseUtils.launchWebApplication("https://demo.guru99.com/payment-gateway/index.php");
        baseUtils.clickOn("plt:Generate Card Number");
        baseUtils.switchToSecondWindow();
        String cardNumber = baseUtils.findElementBy("xpath", "//h4[contains(text(),'Card Number')]").getText();
        cardNumber = cardNumber.substring(14);
        String cvv = baseUtils.findElementBy("xpath","//h4[contains(text(),'CVV')]").getText();
        cvv = cvv.substring(6);
        String exp = baseUtils.findElementBy("xpath", "//h4[contains(text(),'Exp')]").getText();
        exp = exp.substring(6);
        String expMonth = exp.substring(0,2);
        String expYear = exp.substring(3);
        String creditLimit = baseUtils.findElementBy("xpath", "//h4[contains(text(),'Credit Limit')]").getText();
        creditLimit = creditLimit.substring(13);
        baseUtils.clickOn("xpath://a[@href=\"purchasetoy.php\"][contains(text(),'Cart')]");
        String priceOfToy = baseUtils.findElementBy("xpath", "//h3[contains(text(),'Price')]").getText();
        priceOfToy = priceOfToy.substring(7);
        int qty = 4;
        Assert.assertEquals(priceOfToy,"$20");
        baseUtils.selectBy("ByVisibleText","4", "xpath://select[@name=\"quantity\"]");
        baseUtils.clickOn("xpath://input[@class=\"button special\"]");
        baseUtils.typeInto("id:card_nmuber", cardNumber);
        baseUtils.selectBy("ByVisibleText", expMonth, "id:month");
        baseUtils.selectBy("ByVisibleText",expYear,"id:year");
        baseUtils.typeInto("id:cvv_code", cvv);
        String total = baseUtils.findElementBy("xpath", "//input[@name=\"submit\"]").getAttribute("value");
        total = total.substring(4);
        System.out.println(total);
        Assert.assertEquals(total, "$80.00");
        baseUtils.clickOn("name:submit");
        String paymentSuccessMessage = baseUtils.findElementBy("xpath","//div/h2").getText();
        Assert.assertEquals(paymentSuccessMessage,"Payment successfull!");
        String orderID = baseUtils.findElementBy("xpath", "//td[2]/h3").getText();
        System.out.println("OrderId ;- " + orderID);
        baseUtils.clickOn("xpath://a[contains(text(),'Check Credit Card Limit')]");
        //baseUtils.dismissAlert();
        //baseUtils.clickOn("xpath://div[@id='dismiss-button']//div//*[name()='svg']");//advertisment keep changing

        baseUtils.typeInto("id:card_nmuber",cardNumber);
        baseUtils.clickOn("name:submit");
        String creditBalance = baseUtils.findElementBy("xpath","//h4").getText();
        System.out.println(creditBalance);
        creditBalance=creditLimit.split("e ")[1];
        Assert.assertEquals(creditBalance,(100-80));
        String oId = baseUtils.findElementBy("xpath", "//td[6]/b/font").getText();
        Assert.assertFalse(oId.isEmpty());}
        catch (Exception e){
            System.out.println(e);
        }
    }
}
