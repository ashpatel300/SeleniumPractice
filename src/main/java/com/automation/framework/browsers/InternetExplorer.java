package com.automation.framework.browsers;

import com.automation.framework.configurations.ConfigurationLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class InternetExplorer extends Browser{

    InternetExplorerOptions internetExplorerOptions;
    @Override
    public void setCapabilities() {
        internetExplorerOptions = new InternetExplorerOptions();
        setRunOn(ConfigurationLoader.configOptions.getRunOn());
    }

    @Override
    public WebDriver launchBrowser() throws Exception {
        setCapabilities();
        WebDriver driver= null;
        if (getRunOn().equalsIgnoreCase("local")){
            System.setProperty("webdriver.ie.driver", ConfigurationLoader.configOptions.getInternetDriverPath());
            driver = new InternetExplorerDriver(internetExplorerOptions);
        }else {
            driver = new RemoteWebDriver(new URL(ConfigurationLoader.configOptions.getSeleniumHubUrl()),internetExplorerOptions);
        }
        return driver;
    }
}
