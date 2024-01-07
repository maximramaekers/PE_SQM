package saucedemo.web;

import org.testng.Assert;
import org.testng.annotations.*;
import saucedemo.web.pageObjects.SauceLabPages;

public class LoginTests {
    final String username ="standard_user";

    SauceLabPages pages;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        pages = SauceLabPages.Init();
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        pages.quit();
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {
        pages.login.navigateTo();
        //pages.login.login(username, "secret_sauce");
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
        };
    }
    @Test (dataProvider = "loginData")
    public void testValidLogin(String username, String password) {
        // Navigate to the login page
        pages.login.navigateTo();

        // Perform login with valid credentials
        pages.login.login(username, password);


        // Assert that the logout button is present, indicating a successful login
        Assert.assertTrue(pages.inventory.isOnInventoryPage(), "User should be logged in.");
    }
}
