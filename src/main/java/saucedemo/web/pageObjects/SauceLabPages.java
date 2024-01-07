package saucedemo.web.pageObjects;

import org.openqa.selenium.WebDriver;
import saucedemo.web.utils.BrowserUtil;

public class SauceLabPages {
    public LoginPageObject login;
    public InventoryPageObject inventory;
    public DetailPageObject detail;
    private WebDriver driver;

    private SauceLabPages() {
        driver = BrowserUtil.createBrowser();
        login = new LoginPageObject(driver);
        inventory = new InventoryPageObject(driver);
        detail = new DetailPageObject(driver);
    }

    public static SauceLabPages Init() {
        return new SauceLabPages();
    }

    public void quit() {
        driver.quit();
    }
}
