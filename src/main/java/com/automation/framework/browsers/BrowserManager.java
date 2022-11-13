package com.automation.framework.browsers;

import com.automation.framework.configurations.ConfigurationLoader;
import com.automation.framework.reusables.BaseUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowserManager {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void initializeBrowser() throws Exception {
        Browser browser = null;

        if (BrowserType.EDGE.toString().equalsIgnoreCase(ConfigurationLoader.configOptions.getBrowserType())){
            browser = new Edge();
        } else if (BrowserType.CHROME.toString().equalsIgnoreCase(ConfigurationLoader.configOptions.getBrowserType())) {
            browser = new Chrome();
        }else if (BrowserType.FIREFOX.toString().equalsIgnoreCase(ConfigurationLoader.configOptions.getBrowserType())) {
            browser = new FireFox();
        }else if (BrowserType.IE.toString().equalsIgnoreCase(ConfigurationLoader.configOptions.getBrowserType())) {
            browser = new InternetExplorer();
        }else {
            throw new UnsupportedOperationException("Invalid Browser Value Provided In Config File. Browser Not Supported");
        }

        this.driver = browser.launchBrowser();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(ConfigurationLoader.configOptions.getPageLoadTime(), TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(ConfigurationLoader.configOptions.getImplicitWait(), TimeUnit.SECONDS);
    }

    public void captureProof(String testName) throws IOException {
        BaseUtils baseUtils = new BaseUtils(getDriver());
        baseUtils.takeScreenshot(testName);
    }
}
