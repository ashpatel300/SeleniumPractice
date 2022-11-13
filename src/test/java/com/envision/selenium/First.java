package com.envision.selenium;

import com.automation.framework.reusables.BaseTest;
import org.testng.annotations.Test;

public class First extends BaseTest {

    @Test
    public void byPassPopup() throws Exception {

        baseUtils.launchWebApplication("https://www.saucedemo.com/");
        baseUtils.typeInto("id:user-name", "standard_user");
        baseUtils.typeInto("id:password", "secret_sauce");
        baseUtils.clickOn("id:login-button");
    }
}