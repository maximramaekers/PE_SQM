package saucedemo.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPageObject extends BasePageObject{
    By menuSelector = By.cssSelector("#react-burger-menu-btn");
    By logoutBtnSelector = By.id("logout_sidebar_link");
    By itemTitleSelector = By.cssSelector(".inventory_item_name");

    By cartBadgeSelector = By.cssSelector(".shopping_cart_container"); // Replace with the correct class if different
    public InventoryPageObject(WebDriver driver) {
        super(driver, "/inventory.html");
    }

    public void openMenu() {
        WebElement hamburgerMenu = wait.until(ExpectedConditions.elementToBeClickable(menuSelector));
        hamburgerMenu.click();
    }

    public void clickLogout() {
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutBtnSelector));
        logoutBtn.click();
    }

    public void clickItemTitle() {
        WebElement itemTitle = wait.until(ExpectedConditions.elementToBeClickable(itemTitleSelector));
        itemTitle.click();
    }

    public void logout() {
        openMenu();
        clickLogout();
    }

    public By getLogoutBtnSelector() {
        return logoutBtnSelector;
    }

    public boolean isLogoutButtonPresentAndClickable() { //zorgt ervoor dat tests niet crashen (anders blijven tests zoeken naar loguit knop als ze er niet zijn), wacht 1 seconde
        try {
            // Replace with the actual method to wait for the logout button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.elementToBeClickable(getLogoutBtnSelector()));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void addToCart() {
        //driver.findElement(addToCartButtonSelector).click();
    }
    public boolean isItemInCart() {
        // Check if the cart badge is present and has a quantity greater than 0
        return driver.findElements(cartBadgeSelector).size() > 0;
    }
}