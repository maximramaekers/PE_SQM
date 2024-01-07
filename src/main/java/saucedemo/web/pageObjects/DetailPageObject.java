package saucedemo.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailPageObject extends BasePageObject {
    public DetailPageObject(WebDriver driver) {
        super(driver, "inventory-item.html?id=0");
    }

    By InventoryDetailsSelector = By.cssSelector(".inventory_details");

    public By getItemTitleSelector() {
        return InventoryDetailsSelector;
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
