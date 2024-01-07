package saucedemo.mobile.screenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import saucedemo.web.utils.WebConfig;

public class BaseAppiumPageObject {
    protected AppiumDriver driver;
    protected String url;
    protected WebDriverWait wait;

    public BaseAppiumPageObject(AppiumDriver driver, String endpoint) {
        this.driver = driver;
        url = WebConfig.getBaseUrl() + endpoint;
        wait = new WebDriverWait(driver, WebConfig.getDefaultWait());
    }

    public void navigateTo() {
        driver.get(url);
    }
}
