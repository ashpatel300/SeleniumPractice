package com.automation.framework.configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {

    public static configOptions configOptions;
    private Properties properties;

    public void readConfigFileProperties() throws IOException {

        properties = new Properties();
        File configFile = new File(System.getProperty("user.dir")+"/src/main/resources/configs/appConfig.properties");
        properties.load(new FileInputStream(configFile));
    }

    public String getProperty(String name){
        return properties.getProperty(name);
    }

    public void loadConfigurationForFramework() throws IOException {
        configOptions = new configOptions();
        readConfigFileProperties();
        configOptions.setBrowserType(getProperty("browserType"));
        configOptions.setChromeDriverPath(getProperty("chromeDriverPath"));
        configOptions.setEdgeDriverPath(getProperty("edgeDriverPath"));
        configOptions.setExplicitWait(Integer.parseInt(getProperty("explicitWait")));
        configOptions.setGeckoDriverPath(getProperty("geckoDriverPath"));
        configOptions.setImplicitWait(Integer.parseInt(getProperty("implicitWait")));
        configOptions.setInternetDriverPath(getProperty("internetDriverPath"));
        configOptions.setPageLoadTime(Integer.parseInt(getProperty("pageLoadTime")));
        configOptions.setRunOn(getProperty("runOn"));
        configOptions.setSeleniumHubUrl(getProperty("seleniumHubUrl"));
        configOptions.setHeadless(Boolean.parseBoolean(getProperty("headless")));
        configOptions.setTakeScreenShot(Boolean.parseBoolean(getProperty("takeScreenShot")));
        configOptions.setNoOfDataSets(Integer.parseInt(getProperty("noOfDataSets")));

    }

    public static void main(String[] args) throws IOException {
        ConfigurationLoader reader = new ConfigurationLoader();
        reader.loadConfigurationForFramework();
        System.out.println(configOptions.getBrowserType());

    }
}
