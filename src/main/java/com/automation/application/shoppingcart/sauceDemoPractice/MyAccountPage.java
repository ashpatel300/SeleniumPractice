package com.automation.application.shoppingcart.sauceDemoPractice;

import com.automation.framework.reusables.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class MyAccountPage extends BaseUtils {


    MyAccountPage(WebDriver driver){
        super(driver);
    }

    public MyAccountPage addSauceLabsBackpack() throws IOException {
        clickOn("shoppingCart.MyAccountPage.btnAddToCartSauceLabsBackpack");
        return this;
    }

    public MyAccountPage verifyShoppingCartIcon() throws IOException {
        WebElement icon = waitUntilVisibleAndReturnElement("shoppingCart.MyAccountPage.iconNumberOnCart",10);
        icon.isDisplayed();
        String itemAddedInCart = icon.getText();
        int checkPoint1 = Integer.parseInt(itemAddedInCart);
        Assert.assertEquals(checkPoint1,1);
        return this;
    }

    public MyAccountPage addSauceLabsFleeceJacket() throws IOException {
        clickOn("shoppingCart.MyAccountPage.btnAddToCartSauceLabsFleeceJacket");
        return this;
    }

    public MyAccountPage verifyShoppingCartIcon2() throws IOException {
        WebElement icon2 = waitUntilVisibleAndReturnElement("shoppingCart.MyAccountPage.iconNumberOnCart",10);
        icon2.isDisplayed();
        String itemAddedInCart2 = icon2.getText();
        int checkPoint2 = Integer.parseInt(itemAddedInCart2);
        Assert.assertEquals(checkPoint2,2);
        return this;
    }

    public CartPage clickOnCart() throws IOException {
        clickOn("shoppingCart.MyAccountPage.iconCart");
        return new CartPage(this.driver);
    }

    public MyAccountPage clickOnMenu() throws IOException {
        clickOn("shoppingCart.MyAccountPage.barMenuItem");
        return this;
    }

    public LandingPage clickOnSignOut() throws IOException {
        waitUntilElementClickableAndClick("shoppingCart.MyAccountPage.btnSignOut",10);
        return new LandingPage(this.driver);
    }


}
