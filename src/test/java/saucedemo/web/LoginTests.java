package saucedemo.web;

import org.testng.Assert;
import org.testng.annotations.*;
import saucedemo.web.pageObjects.SauceLabPages;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

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
        pages.login.login(username, "secret_sauce");
    }

    public void logout() {
        if (pages.inventory.isLogoutButtonPresentAndClickable()) {
            pages.inventory.logout();
        }
    }

    @Test
    public void correctLogout() { //hoe precies implementeren? problemen met aftermethod, boolean zetten misschien
        pages.inventory.logout();
        Assert.assertTrue(pages.login.isLoginPageDisplayed(), "Login page not displayed after logout");
    }

    @Test
    public void correctLogin(){
        Assert.assertNotNull(pages.inventory.getLogoutBtnSelector(), "Logout button not found after login");
        //pages.inventory.navigateTo();
        //assertThat("message").isEqualTo("other message");
        //assertWithMessage("Incorrect").that(azea).IsEqualTo("zae")... mogelijk veel meer info
        //System.out.println("test");
    }
}
