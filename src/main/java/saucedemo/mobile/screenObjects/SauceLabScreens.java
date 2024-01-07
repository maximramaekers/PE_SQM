package saucedemo.mobile.screenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import saucedemo.mobile.utils.DeviceUtil;
import saucedemo.web.pageObjects.CartPageObject;
import saucedemo.web.pageObjects.DetailPageObject;
import saucedemo.web.pageObjects.InventoryPageObject;

import java.net.MalformedURLException;

public class SauceLabScreens {
    public LoginScreenObject login;
    public InventoryScreenObject inventory;
    public DetailScreenObject detail;
    public CartScreenObject cart;
    private AppiumDriver driver;


    private SauceLabScreens() throws MalformedURLException {
        driver = DeviceUtil.createMobileDriver();
        login = new LoginScreenObject(driver);
        inventory = new InventoryScreenObject(driver);
        detail = new DetailScreenObject(driver);
        cart = new CartScreenObject(driver);
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
