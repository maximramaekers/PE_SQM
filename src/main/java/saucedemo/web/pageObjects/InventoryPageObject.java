package saucedemo.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPageObject extends BasePageObject{
    By menuSelector = By.cssSelector("#react-burger-menu-btn");
    By logoutBtnSelector = By.id("logout_sidebar_link");
    public InventoryPageObject(WebDriver driver) {
        super(driver, "/inventory.html");
    }

    public void openMenu() {
        WebElement hamburgerMenu = driver.findElement(menuSelector);
        hamburgerMenu.click();
    }

    public void clickLogout() {
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutBtnSelector));
        logoutBtn.click();
    }

    public void logout() {
        openMenu();
        clickLogout();
    }
}
