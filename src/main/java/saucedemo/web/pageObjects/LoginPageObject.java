package saucedemo.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageObject extends BasePageObject {
    By userTxtSelector = By.id("user-name");
    By passwordTxtSelector = By.id("password");
    By loginBtnSelector = By.id("login-button");
    By errorMessageSelector = By.cssSelector("h3[data-test='error']");

    public LoginPageObject(WebDriver driver) {
        super(driver, "/");
    }

    public void fillInUsername(String username) {
        WebElement userTxt = driver.findElement(userTxtSelector);
        userTxt.clear();
        userTxt.sendKeys(username);
    }

    public void fillInPassword(String password) {
        WebElement passwordTxt = driver.findElement(passwordTxtSelector);
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = driver.findElement(loginBtnSelector);
        loginBtn.click();
    }

    public void login(String username, String password) {
        fillInUsername(username);
        fillInPassword(password);
        clickLogin();
    }

    public boolean isLoginPageDisplayed() {
        try {
            // Check for an element that is unique to the login page
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
            return true; // Element found, indicating the login page
        } catch (Exception e) {
            return false; // Element not found, indicating it's not the login page
        }
    }



    public String getErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageSelector));
            return errorMessageElement.getText();
        } catch (TimeoutException e) {
            return "No error message displayed"; // Or any other default message or handling you prefer
        }
    }
}

