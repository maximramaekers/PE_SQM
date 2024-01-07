package saucedemo.mobile.screenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import saucedemo.mobile.screenObjects.BaseAppiumPageObject;

import java.time.Duration;

public class CartScreenObject extends BaseAppiumPageObject {
    public CartScreenObject(AppiumDriver driver) {
        super(driver, "/cart.html");
    }

    By CartItemSelector = By.cssSelector(".cart_item");

    public By getCartItemSelector() {
        return CartItemSelector;
    }


    public boolean itemIsInCart() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.presenceOfElementLocated(getCartItemSelector()));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isOnCartPage(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("/cart");
    }

}
