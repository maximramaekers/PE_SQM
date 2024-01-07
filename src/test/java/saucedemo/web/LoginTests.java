package saucedemo.web;

import org.junit.After;
import org.testng.Assert;
import org.testng.annotations.*;
import saucedemo.web.pageObjects.SauceLabPages;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

//TODO!!!!!!!!!!!!!!!
public class LoginTests {
    final String username ="standard_user";

    SauceLabPages pages;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        pages = SauceLabPages.Init();
    }

    @AfterTest
    public void teardown() {
        pages.quit();
    }

    @BeforeMethod
    public void login() {
        pages.login.navigateTo();
        //pages.login.login(username, "secret_sauce");
    }

/*    @AfterTest
    public void logout() {
        if (pages.inventory.isLogoutButtonPresentAndClickable()) {
            pages.inventory.logout();
        }
        else{teardown();}
    }*/

/*    @Test
    public void correctLogout() { //hoe precies implementeren? problemen met aftermethod, boolean zetten misschien
        pages.inventory.logout();
        Assert.assertTrue(pages.login.isLoginPageDisplayed(), "Login page not displayed after logout");
    }*/

  /*  @Test
    public void correctLogin(){
        Assert.assertNotNull(pages.inventory.getLogoutBtnSelector(), "Logout button not found after login");
        //pages.inventory.navigateTo();
        //assertThat("message").isEqualTo("other message");
        //assertWithMessage("Incorrect").that(azea).IsEqualTo("zae")... mogelijk veel meer info
        //System.out.println("test");
    }*/


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

/*    @Test
    public void testLoginPageDisplayAfterSuccessfulLogin() {
        pages.login.login("standard_user", "secret_sauce");
        Assert.assertFalse(pages.login.isLoginPageDisplayed(), "Login page should not be displayed after a successful login.");
    }

    @Test
    public void testLogoutButtonPresenceAfterSuccessfulLogin() {
        pages.login.login("standard_user", "secret_sauce");
        Assert.assertTrue(pages.inventory.isLogoutButtonPresentAndClickable(), "Logout button should be present and clickable after a successful login.");
    }*/
}
