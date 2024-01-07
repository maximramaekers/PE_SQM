package saucedemo.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepTwoPageObject extends BasePageObject {
    public CheckoutStepTwoPageObject(WebDriver driver) {
        super(driver, "/checkout-step-two.html");
    }

    By overviewItemSelector = By.cssSelector(".cart_item_label");

    public boolean isOnCheckoutStepTwoPage(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("/checkout-step-two");
    }

    public By getOverviewItemSelector() {
        return overviewItemSelector;
    }

    public boolean itemIsInCart() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.presenceOfElementLocated(getOverviewItemSelector()));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
