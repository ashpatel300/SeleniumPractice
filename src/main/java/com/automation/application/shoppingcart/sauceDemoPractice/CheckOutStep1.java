package com.automation.application.shoppingcart.sauceDemoPractice;

import com.automation.framework.reusables.BaseUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CheckOutStep1 extends BaseUtils {

    public CheckOutStep1(WebDriver driver) {
        super(driver);
    }
    public CheckOutStep1 enterCustomerDetails() throws IOException {
        typeInto("shoppingCart.checkoutPage1.tbxEnterFirstName","Aditya");
        typeInto("shoppingCart.checkoutPage1.tbxEnterLastName","Patel");
        typeInto("shoppingCart.checkoutPage1.tbxEnterPostalCode", "ABC 123");
        return this;
    }
    public CheckOutStep2 clickOnContinue() throws IOException {
        clickOn("shoppingCart.cartPage.btnContinue");
        return new CheckOutStep2(this.driver);
    }
}
