package saucedemo.mobile;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import saucedemo.mobile.screenObjects.SauceLabScreens;

import java.net.MalformedURLException;

public class LoginErrorTest {
    final String username ="standard_user";

    SauceLabScreens screens;
    private boolean shouldLogout = true;

    @BeforeTest(alwaysRun = true)
    public void setup() throws MalformedURLException {
        screens = SauceLabScreens.init();
    }

    @AfterTest
    public void teardown() {
        screens.quit();
    }

    @BeforeMethod
    public void navigateToLogin() {
        screens.login.navigateTo();
    }

    @Test
    public void testLoginPageDisplayAfterFailedLoginAttempt() {
        screens.login.login("invalid_user", "secret_sauce");
        Assert.assertTrue(screens.login.isLoginPageDisplayed(), "Login page should be displayed after a failed login attempt.");
    }

    @Test
    public void testErrorMessageDisplayOnFailedLogin() {
        screens.login.login("invalid_user", "secret_sauce");
        // Implement a method to retrieve the actual error message from the page
        String actualErrorMessage = screens.login.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message should be displayed on failed login.");
    }

    @Test
    public void testErrorMessageOnIncorrectPassword() {
        screens.login.login("standard_user", "incorrect_password");
        // Implement a method to retrieve the actual error message from the page
        String actualErrorMessage = screens.login.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message should be displayed for incorrect password.");
    }

    @Test
    public void testErrorMessageOnIncorrectUsername() {
        screens.login.login("invalid_user", "secret_sauce");
        // Implement a method to retrieve the actual error message from the page
        String actualErrorMessage = screens.login.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message should be displayed for incorrect username.");
    }

    @Test
    public void testLockedOutUserLogin() {
        screens.login.login("locked_out_user", "secret_sauce");
        // Implement a method to retrieve the actual error message from the page
        String actualErrorMessage = screens.login.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message should be displayed for locked out user.");
    }
}
