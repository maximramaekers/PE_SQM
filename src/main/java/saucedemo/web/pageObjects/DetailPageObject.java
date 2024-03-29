package saucedemo.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailPageObject extends BasePageObject {
    public DetailPageObject(WebDriver driver) {
        super(driver, "/inventory-item.html?id=0");
    }

    By inventoryDetailsSelector = By.cssSelector(".inventory_details");
    By addToCartDetailButtonSelector = By.id("add-to-cart-sauce-labs-backpack");
    By backToProductsSelector = By.cssSelector(".btn.btn_secondary.back.btn_large.inventory_details_back_button");

    public By getItemTitleSelector() {
        return inventoryDetailsSelector;
    }

    public void addToCart() {
        driver.findElement(addToCartDetailButtonSelector).click();
    }

    public void clickBackToProducts() {
        WebElement backToProducts = driver.findElement(backToProductsSelector);
        backToProducts.click();
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

}
