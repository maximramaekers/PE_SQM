package saucedemo.web;

import org.testng.Assert;
import org.testng.annotations.*;
import saucedemo.web.pageObjects.SauceLabPages;

public class LoginErrorTests {
    final String username ="standard_user";

    SauceLabPages pages;
    private boolean shouldLogout = true;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        pages = SauceLabPages.Init();
    }

    @AfterTest
    public void teardown() {
        pages.quit();
    }

    @BeforeMethod
    public void navigateToLogin() {
        pages.login.navigateTo();
    }

    @Test
    public void testLoginPageDisplayAfterFailedLoginAttempt() {
        pages.login.login("invalid_user", "secret_sauce");
        Assert.assertTrue(pages.login.isLoginPageDisplayed(), "Login page should be displayed after a failed login attempt.");
    }

    @Test
    public void testErrorMessageDisplayOnFailedLogin() {
        pages.login.login("invalid_user", "secret_sauce");
        // Implement a method to retrieve the actual error message from the page
        String actualErrorMessage = pages.login.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message should be displayed on failed login.");
    }

    @Test
    public void testErrorMessageOnIncorrectPassword() {
        pages.login.login("standard_user", "incorrect_password");
        // Implement a method to retrieve the actual error message from the page
        String actualErrorMessage = pages.login.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message should be displayed for incorrect password.");
    }

    @Test
    public void testErrorMessageOnIncorrectUsername() {
        pages.login.login("invalid_user", "secret_sauce");
        // Implement a method to retrieve the actual error message from the page
        String actualErrorMessage = pages.login.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message should be displayed for incorrect username.");
    }

    @Test
    public void testLockedOutUserLogin() {
        pages.login.login("locked_out_user", "secret_sauce");
        // Implement a method to retrieve the actual error message from the page
        String actualErrorMessage = pages.login.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message should be displayed for locked out user.");
    }
}
