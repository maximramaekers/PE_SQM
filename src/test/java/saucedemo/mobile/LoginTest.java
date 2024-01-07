package saucedemo.mobile;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import saucedemo.mobile.screenObjects.SauceLabScreens;
import saucedemo.web.pageObjects.SauceLabPages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    final String username ="standard_user";
    SauceLabScreens screens;
    @BeforeTest(alwaysRun = true)
    public void setup() throws IOException, ParseException {
        screens = SauceLabScreens.init();
    }

    @AfterTest
    public void teardown() {
        screens.quit();
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        // Navigate to the login page
        screens.login.navigateTo();

        // Perform login with valid credentials
        screens.login.login(username, "secret_sauce");

        // Open hamburger menu
        screens.inventory.openMenu();

        // Check if login was successful by verifying the presence of an element that is only visible after login
        // For example, check if the logout button is present and clickable
        boolean isLogoutPresent = screens.inventory.isLogoutButtonPresentAndClickable();

        // Assert that the logout button is present, indicating a successful login
        Assert.assertTrue(isLogoutPresent, "Logout button should be present after a successful login.");

    }
}




