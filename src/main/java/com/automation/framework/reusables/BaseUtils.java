package com.automation.framework.reusables;

import com.automation.framework.configurations.ConfigurationLoader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseUtils {

    public WebDriver driver;
    static int waitTime = ConfigurationLoader.configOptions.getExplicitWait();

    public BaseUtils(WebDriver driver){
        this.driver = driver;
    }

    public void takeScreenshot( String testName) throws IOException {
        if (ConfigurationLoader.configOptions.isTakeScreenShot()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/src/test/resources/Screenshots/screenshot-" + testName + ".png"));
        }
    }

    public String getObjectRepositoryLocator(String locatorName) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/resources/objectRepository/OR.properties")));
        return properties.getProperty(locatorName);
    }

//    public static WebDriver launchBrowser(String browser) throws MalformedURLException {
//        WebDriver driver = null;
//        if (browser.equalsIgnoreCase("chrome")){
//            ChromeOptions chromeOptions = new ChromeOptions();
//            Map<String,String> prefrences = new HashMap<>();
//            prefrences.put("excludeSwitches","disable-popup-blocking");
//            prefrences.put("download.default_directory",System.getProperty("user.dir")+"src/test/resources/Binaries/downloads/");
//            chromeOptions.setExperimentalOption("prefs",prefrences);
//            if (ConfigurationLoader.configOptions.isHeadless()){
//                chromeOptions.setHeadless(true);
//            }
//            if (ConfigurationLoader.configOptions.getRunOn().equalsIgnoreCase("local")){
//                System.setProperty("webdriver.chrome.driver", ConfigurationLoader.configOptions.getChromeDriverPath());
//                driver = new ChromeDriver(chromeOptions);
//            } else if (ConfigurationLoader.configOptions.getRunOn().equalsIgnoreCase("remote")) {
//                driver = new RemoteWebDriver(new URL(ConfigurationLoader.configOptions.getSeleniumHubUrl()),chromeOptions);
//            }
//
//        }
//        else if (browser.equalsIgnoreCase("edge")) {
//            EdgeOptions edgeOptions = new EdgeOptions();
//            Map<String,String> prefrences = new HashMap<>();
//            prefrences.put("excludeSwitches","disable-popup-blocking");
//            prefrences.put("download.default_directory",System.getProperty("user.dir")+"src/test/resources/Binaries/downloads/");
//            edgeOptions.setCapability("prefs",prefrences);
//            System.setProperty("webdriver.edge.driver", ConfigurationLoader.configOptions.getEdgeDriverPath());
//            driver = new EdgeDriver();
//
//        }
//        else if (browser.equalsIgnoreCase("firefox")){
//            System.setProperty("webdriver.gecko.driver", ConfigurationLoader.configOptions.getGeckoDriverPath());
//            driver = new FirefoxDriver();
//
//        }
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
//
//        return driver;
//    }

    public List<WebElement> findElementsBy(String locateBy, String locatorValue){
        List<WebElement> listOfWebElements = null;
        switch (locateBy){

            case "id":
                listOfWebElements = driver.findElements(By.id(locatorValue));
                break;
            case "name":
                listOfWebElements = driver.findElements(By.name(locatorValue));
                break;
            case "class":
                listOfWebElements = driver.findElements(By.className(locatorValue));
                break;
            case "tag":
                listOfWebElements = driver.findElements(By.tagName(locatorValue));
                break;
            case "lt":
                listOfWebElements = driver.findElements(By.linkText(locatorValue));
                break;
            case "plt":
                listOfWebElements = driver.findElements(By.partialLinkText(locatorValue));
                break;
            case "css":
                listOfWebElements = driver.findElements(By.cssSelector(locatorValue));
                break;
            case "xpath":
                listOfWebElements = driver.findElements(By.xpath(locatorValue));
                break;
        }
        scrollToElementView(listOfWebElements.get(0));
        return listOfWebElements;
    }

    public WebElement findElementBy(String locateBy, String locatorValue){
        WebElement element = null;
        switch (locateBy){

            case "id":
                element = driver.findElement(By.id(locatorValue));
                break;
            case "name":
                element = driver.findElement(By.name(locatorValue));
                break;
            case "class":
                element = driver.findElement(By.className(locatorValue));
                break;
            case "tag":
                element = driver.findElement(By.tagName(locatorValue));
                break;
            case "lt":
                element = driver.findElement(By.linkText(locatorValue));
                break;
            case "plt":
                element = driver.findElement(By.partialLinkText(locatorValue));
                break;
            case "css":
                element = driver.findElement(By.cssSelector(locatorValue));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(locatorValue));
                break;
        }
        scrollToElementView(element);
        return element;
    }

    public By findBy(String locateBy, String locatorValue){
        By by = null;
        switch (locateBy){
            case "id":
              by = By.id(locatorValue);
              break;
            case "name":
                by = By.name(locatorValue);
                break;
            case "tag":
                by = By.tagName(locatorValue);
                break;
            case "lt":
                by = By.linkText(locatorValue);
                break;
            case "plt":
                by = By.partialLinkText(locatorValue);
                break;
            case "css":
                by = By.cssSelector(locatorValue);
                break;
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            case "class":
                by = By.className(locatorValue);
                break;
        }
        return by;
    }

    public void launchWebApplication(String url){
        driver.get(url);
    }

    public void clickOn(String locatorName) throws IOException {
        waitUntilElementClickableAndClick(locatorName,waitTime);
    }

    public void typeInto(String locatorName,String value) throws IOException {
       waitUntilElementVisibleAndTypeInto(locatorName,waitTime,value);
    }

    public void doubleClickOn(String locatorName) throws IOException {
        WebElement elementToClick = waitUntilElementClickable(locatorName,waitTime);
        Actions actions = new Actions(driver);
        actions.doubleClick(elementToClick).build().perform();
    }

    public void rightClickOn(String locatorName) throws IOException {
        WebElement elementToClick = waitUntilElementClickable(locatorName,waitTime);
        Actions actions = new Actions(driver);
        actions.contextClick(elementToClick).build().perform();
    }

    //works only in dropdown where tag name is select
    public void selectBy(String howToSelect, String listValue,String locatorName) throws IOException {
        WebElement elementToClick = waitUntilVisibleAndReturnElement(locatorName,waitTime);
        Select selectObj = new Select(elementToClick);
        if (howToSelect.equalsIgnoreCase("ByValue")){
            selectObj.selectByValue(listValue);
        } else if (howToSelect.equalsIgnoreCase("ByVisibleText")){
            selectObj.selectByVisibleText(listValue);
        } else if (howToSelect.equalsIgnoreCase("ByIndex")) {
            selectObj.selectByIndex(Integer.parseInt(listValue));
        }

    }

    public void mouseClickOn(String locatorName) throws IOException {
        WebElement elementToClick = waitUntilElementClickable(locatorName,waitTime);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToClick).click().build().perform();
    }

    public void mouseClickAndTypeInto(String locatorName, String value) throws IOException {
        WebElement elementToClick = waitUntilElementVisibleAndTypeInto(locatorName,waitTime,value);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToClick).click().sendKeys(value).build().perform();
    }

    public void mouseHoverTo(String locatorName) throws IOException {
        WebElement elementToClick = waitUntilVisibleAndReturnElement(locatorName,waitTime);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToClick).build().perform();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public void typeIntoAlertAndAccept(String value){
        Alert alert= driver.switchTo().alert();
        alert.sendKeys(value);
        alert.accept();
    }

    public void switchToiFrame(String locatorName) throws IOException {
        String elementHow = getObjectRepositoryLocator(locatorName);
        String how = elementHow.split(":",2)[0];
        String howValue = elementHow.split(":",2)[1];
        WebElement elementToClick = findElementBy(how,howValue);
        driver.switchTo().frame(elementToClick);
    }

    public void switchToMainPage(){
        driver.switchTo().defaultContent();
    }

    public void switchToSecondWindow(){
        String currentWindow = driver.getWindowHandle();
        Set<String> setOfWindows = driver.getWindowHandles();
        List<String> listOfWindows = new ArrayList<String>(setOfWindows);
        int secondWindowIndex = 1;
        driver.switchTo().window(listOfWindows.get(secondWindowIndex));
    }

    public void switchToLastWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> setOfWindows = driver.getWindowHandles();
        List<String> listOfWindows = new ArrayList<String>(setOfWindows);
        int lastWindowIndex = listOfWindows.size() - 1;
        driver.switchTo().window(listOfWindows.get(lastWindowIndex));
    }

    public void switchToSecondLastWindow(){
        String currentWindow = driver.getWindowHandle();
        Set<String> setOfWindows = driver.getWindowHandles();
        List<String> listOfWindows = new ArrayList<String>(setOfWindows);
        int lastWindowIndex = listOfWindows.size() - 2;
        driver.switchTo().window(listOfWindows.get(lastWindowIndex));
    }

    public void closeAllOtherWindowsExceptMain(String currentWindow){
        driver.switchTo().window(currentWindow);
        Set<String> allOpenWindow= driver.getWindowHandles();
        List<String> listOfWindows = new ArrayList<String>(allOpenWindow);
        for (int i=0; i<listOfWindows.size();i++){
            if (!listOfWindows.get(i).equals(currentWindow)){
                driver.switchTo().window(listOfWindows.get(i)).close();
            }
        }
        driver.switchTo().window(currentWindow);
    }

    public void openWindows(int noOfWindows){
        for (int i=0; i<noOfWindows;i++){
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("window.open();");
        }
    }

    public void scrollToTopOfPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
    }

    public void scrollToBottomOfPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    public void scrollToElementView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void waitUntilElementVisible(WebElement element, int noOfSecond){
        Wait<WebDriver> explicitWait = new WebDriverWait(driver,noOfSecond);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilVisibleAndReturnElement(String locatorName,int noOfSeconds) throws IOException {
        String elementHow = getObjectRepositoryLocator(locatorName);
        String how = elementHow.split(":",2)[0];
        String howValue = elementHow.split(":",2)[1];
        By by = findBy(how,howValue);
        WebDriverWait wait = new WebDriverWait(driver,noOfSeconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        return element;
    }

    public WebElement waitUntilElementClickableAndClick(String locatorName,int noOfSeconds) throws IOException {
        String elementHow = getObjectRepositoryLocator(locatorName);
        String how = elementHow.split(":",2)[0];
        String howValue = elementHow.split(":",2)[1];
        By by = findBy(how,howValue);
        WebDriverWait wait = new WebDriverWait(driver,noOfSeconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElementView(element);
        element.click();

        return element;
    }

    public WebElement waitUntilElementClickable(String locatorName,int noOfSeconds) throws IOException {
        String elementHow = getObjectRepositoryLocator(locatorName);
        String how = elementHow.split(":",2)[0];
        String howValue = elementHow.split(":",2)[1];
        By by = findBy(how,howValue);
        WebDriverWait wait = new WebDriverWait(driver,noOfSeconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElementView(element);

        return element;
    }

    public WebElement waitUntilElementVisibleAndTypeInto(String locatorName,int noOfSeconds, String textToType) throws IOException {
        String elementHow = getObjectRepositoryLocator(locatorName);
        String how = elementHow.split(":",2)[0];
        String howValue = elementHow.split(":",2)[1];
        By by = findBy(how,howValue);
        WebDriverWait wait = new WebDriverWait(driver,noOfSeconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElementView(element);
        element.click();
        element.clear();
        element.sendKeys(textToType);

        return element;
    }

    public String waitUntilElementVisibleAndGetText(String locatorName,int noOfSeconds) throws IOException {
        String elementHow = getObjectRepositoryLocator(locatorName);
        String how = elementHow.split(":",2)[0];
        String howValue = elementHow.split(":",2)[1];
        By by = findBy(how,howValue);
        WebDriverWait wait = new WebDriverWait(driver,noOfSeconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        scrollToElementView(element);
        return element.getText();
    }

    public boolean waitUntilElementDisappears(String locatorName,int noOfSeconds) throws IOException {
        String elementHow = getObjectRepositoryLocator(locatorName);
        String how = elementHow.split(":",2)[0];
        String howValue = elementHow.split(":",2)[1];
        By by = findBy(how,howValue);
        WebDriverWait wait = new WebDriverWait(driver,noOfSeconds);
        boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        return status;
    }
}
