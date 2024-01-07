package saucedemo.web.pageObjects;

import org.openqa.selenium.WebDriver;
import saucedemo.web.utils.BrowserUtil;

public class SauceLabPages {
    public LoginPageObject login;
    public InventoryPageObject inventory;
    public DetailPageObject detail;
    public CartPageObject cart;
    public CheckoutStepOnePageObject checkoutstepone;
    public CheckoutStepTwoPageObject checkoutsteptwo;
    public FinishPageObject finish;
    private WebDriver driver;

    private SauceLabPages() {
        driver = BrowserUtil.createBrowser();
        login = new LoginPageObject(driver);
        inventory = new InventoryPageObject(driver);
        detail = new DetailPageObject(driver);
        cart = new CartPageObject(driver);
        checkoutstepone = new CheckoutStepOnePageObject(driver);
        checkoutsteptwo = new CheckoutStepTwoPageObject(driver);
        finish = new FinishPageObject(driver);
    }

    public static SauceLabPages Init() {
        return new SauceLabPages();
    }

    public void quit() {
        driver.quit();
    }
}
