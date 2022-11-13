package com.automation.framework.reusables;

import com.automation.framework.browsers.BrowserManager;
import com.automation.framework.configurations.ConfigurationLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class BaseTest {
    public BaseUtils baseUtils;
    public String currentWindowSession;
    public BrowserManager browserManager;

    @BeforeSuite
    public void loadConfiguration() throws IOException {
        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        configurationLoader.loadConfigurationForFramework();
        browserManager = new BrowserManager();
    }

    @BeforeTest
    public void launchBrowser() throws Exception {
        browserManager.initializeBrowser();
        currentWindowSession = browserManager.getDriver().getWindowHandle();
    }

    @AfterTest
    public void tearDownDriver(){
        browserManager.getDriver().quit();
    }

    @AfterMethod
    public void takeScreenshotAfterEachMethod(Method method) throws IOException {
        browserManager.captureProof(method.getName());
    }

    public void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (Exception e) {
        }
    }
}
