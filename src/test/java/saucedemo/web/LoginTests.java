package saucedemo.web;

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

    @AfterMethod
    public void logout() {
        pages.inventory.logout();
    }

    @Test
    public void correctLogin() {
        pages.inventory.navigateTo();
        //throw new RuntimeException("lmklm");
        //assertThat("message").isEqualTo("other message");
        assertWithMessage("Incorrect message was shown").that("message").isEqualTo("other message");
        //System.out.println("test");
    }

    @Test
    public void correctLogin2() {
        pages.inventory.navigateTo();
        System.out.println("test2");
    }
}
