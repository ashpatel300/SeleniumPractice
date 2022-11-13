package com.automation.application.shoppingcart.sauceDemoPractice;

import com.automation.framework.reusables.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CartPage extends BaseUtils {


    public CartPage(WebDriver driver) {
        super(driver);
    }
    public CartPage verifyItemInCart() throws IOException {
        WebElement product1 = waitUntilElementClickable("shoppingCart.cartPage.itemSauceLabsBackPack",10);
        WebElement product2 = waitUntilElementClickable("shoppingCart.cartPage.itemSauceLabsFleeceJacket",10);
        product1.isDisplayed();
        product2.isDisplayed();
        return this;
    }
    public CheckOutStep1 clickOnCheckout() throws IOException {
        clickOn("shoppingCart.cartPage.btnCheckout");
        return new CheckOutStep1(this.driver);
    }
}
