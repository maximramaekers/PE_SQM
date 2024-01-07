package saucedemo.web;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import saucedemo.web.pageObjects.SauceLabPages;

import java.time.Duration;

public class InventoryTests {
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

    @Test
    public void userCanSelectProductAndLandOnDetailPage(){
        // Navigate to the inventory page
        pages.inventory.navigateTo();

        // Click on the first product name to navigate to the detail page
        pages.inventory.clickItemTitle();

        // Verify that the detail page is displayed
        pages.detail.itemTitleSelectorIsPresent();

        // Assert that the detail page is displayed
        Assert.assertTrue(pages.detail.itemTitleSelectorIsPresent(), "Detail page should be displayed after clicking on the product name.");
    }


/*    @AfterTest
    public void logout() {
        if (pages.inventory.isLogoutButtonPresentAndClickable()) {
            pages.inventory.logout();
        }
        else{teardown();}*/




}

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

