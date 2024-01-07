package saucedemo.mobile.screenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailScreenObject extends BaseAppiumPageObject {
    public DetailScreenObject(AppiumDriver driver) {
        super(driver, "/inventory-item.html?id=0");
    }

    By InventoryDetailsSelector = By.cssSelector(".inventory_details");

    By addToCartDetailButtonSelector = By.id("add-to-cart-sauce-labs-backpack");

    By backToProductsSelector = By.cssSelector(".btn.btn_secondary.back.btn_large.inventory_details_back_button");

    public By getItemTitleSelector() {
        return InventoryDetailsSelector;
    }

    public void addToCart() {
        driver.findElement(addToCartDetailButtonSelector).click();
    }


    public boolean itemTitleSelectorIsPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.presenceOfElementLocated(getItemTitleSelector()));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void clickBackToProducts() {
        WebElement backToProducts = driver.findElement(backToProductsSelector);
        backToProducts.click();
    }
}
