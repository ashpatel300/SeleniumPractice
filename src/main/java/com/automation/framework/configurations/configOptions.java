package com.automation.framework.configurations;

public class configOptions {

    private String browserType;
    private int implicitWait;
    private int pageLoadTime;
    private int explicitWait;
    private boolean takeScreenShot;
    private String chromeDriverPath;
    private String edgeDriverPath;
    private String geckoDriverPath;
    private String internetDriverPath;
    private String runOn;
    private boolean headless;
    private String seleniumHubUrl;
    private int noOfDataSets;

    public int getNoOfDataSets() {
        return noOfDataSets;
    }

    public void setNoOfDataSets(int noOfDataSets) {
        this.noOfDataSets = noOfDataSets;
    }


    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public int getImplicitWait() {
        return implicitWait;
    }

    public void setImplicitWait(int implicitWait) {
        this.implicitWait = implicitWait;
    }

    public int getPageLoadTime() {
        return pageLoadTime;
    }

    public void setPageLoadTime(int pageLoadTime) {
        this.pageLoadTime = pageLoadTime;
    }

    public int getExplicitWait() {
        return explicitWait;
    }

    public void setExplicitWait(int explicitWait) {
        this.explicitWait = explicitWait;
    }

    public boolean isTakeScreenShot() {
        return takeScreenShot;
    }

    public void setTakeScreenShot(boolean takeScreenShot) {
        this.takeScreenShot = takeScreenShot;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public void setChromeDriverPath(String chromeDriverPath) {
        this.chromeDriverPath = chromeDriverPath;
    }

    public String getEdgeDriverPath() {
        return edgeDriverPath;
    }

    public void setEdgeDriverPath(String edgeDriverPath) {
        this.edgeDriverPath = edgeDriverPath;
    }

    public String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public void setGeckoDriverPath(String geckoDriverPath) {
        this.geckoDriverPath = geckoDriverPath;
    }

    public String getInternetDriverPath() {
        return internetDriverPath;
    }

    public void setInternetDriverPath(String internetDriverPath) {
        this.internetDriverPath = internetDriverPath;
    }

    public String getRunOn() {
        return runOn;
    }

    public String setRunOn(String runOn) {
        return this.runOn = runOn;
    }

    public boolean isHeadless() {
        return headless;
    }

    public void setHeadless(boolean headless) {
        this.headless = headless;
    }

    public String getSeleniumHubUrl() {
        return seleniumHubUrl;
    }

    public void setSeleniumHubUrl(String seleniumHubUrl) {
        this.seleniumHubUrl = seleniumHubUrl;
    }




}
