package saucedemo.mobile.screenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import saucedemo.mobile.utils.DeviceUtil;

import java.net.MalformedURLException;

public class SauceLabScreens {
    public LoginScreenObject login;
    public InventoryScreenObject inventory;
    private AppiumDriver driver;

    private SauceLabScreens() throws MalformedURLException {
        driver = DeviceUtil.createMobileDriver();
        login = new LoginScreenObject(driver);
        inventory = new InventoryScreenObject(driver);
    }

    public static SauceLabScreens init() throws MalformedURLException {
        return new SauceLabScreens();
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
