package saucedemo.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPageObject extends BasePageObject {
    public CartPageObject(WebDriver driver) {
        super(driver, "/cart.html");
    }

    By cartItemSelector = By.cssSelector(".cart_item_label");
    By cartBackButtonSelector = By.cssSelector("button[data-test='continue-shopping']");
    By cartToCheckoutSelector = By.cssSelector("button[data-test='checkout']");


    public By getCartItemSelector() {
        return cartItemSelector;
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

    public void clickBackToInventory() {
        WebElement backToProducts = driver.findElement(cartBackButtonSelector);
        backToProducts.click();
    }

    public void clickToCheckout() {
        WebElement goToCheckout = driver.findElement(cartToCheckoutSelector);
        goToCheckout.click();
    }

}
