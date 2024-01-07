package saucedemo.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPageObject extends BasePageObject {
    public FinishPageObject(WebDriver driver) {
        super(driver, "checkout-complete.html");
    }

    By backHomeButtonSelector = By.cssSelector("#back-to-products");

    public boolean isOnFinishPage(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("/checkout-complete.html");
    }

    public void clickBackToInventory() {
        WebElement backToProducts = driver.findElement(backHomeButtonSelector);
        backToProducts.click();
    }

}
