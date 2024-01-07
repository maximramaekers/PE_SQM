package saucedemo.mobile.screenObjects;

import io.appium.java_client.AppiumDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import saucedemo.mobile.utils.DeviceUtil;
import saucedemo.web.pageObjects.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class SauceLabScreens {
    public LoginScreenObject login;
    public InventoryScreenObject inventory;
    public DetailScreenObject detail;
    public CartScreenObject cart;
    private AppiumDriver driver;

    public CheckoutStepOneScreenObject checkoutstepone;
    public CheckoutStepTwoScreenObject checkoutsteptwo;
    public FinishPageObject finish;


    private SauceLabScreens() throws IOException, ParseException {
        driver = DeviceUtil.createMobileDriver();
        login = new LoginScreenObject(driver);
        inventory = new InventoryScreenObject(driver);
        detail = new DetailScreenObject(driver);
        cart = new CartScreenObject(driver);
        checkoutstepone = new CheckoutStepOneScreenObject(driver);
        checkoutsteptwo = new CheckoutStepTwoScreenObject(driver);
        finish = new FinishPageObject(driver);
    }

    public static SauceLabScreens init() throws IOException, ParseException {
        return new SauceLabScreens();
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
