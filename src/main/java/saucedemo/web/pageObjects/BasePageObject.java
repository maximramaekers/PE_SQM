package saucedemo.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import saucedemo.web.utils.WebConfig;

public class BasePageObject {
    protected WebDriver driver;
    protected String url;
    protected WebDriverWait wait;

    public BasePageObject(WebDriver driver, String endpoint) {
        this.driver = driver;
        url = WebConfig.getBaseUrl() + endpoint;
        wait = new WebDriverWait(driver, WebConfig.getDefaultWait());
    }

    public void navigateTo() {
        driver.get(url);
    }
}
