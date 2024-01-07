package saucedemo.mobile;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.*;
import saucedemo.mobile.screenObjects.SauceLabScreens;

import java.io.IOException;
import java.net.MalformedURLException;

public class InventoryTest {
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

    @BeforeMethod
    public void login() {
        screens.login.navigateTo();
        screens.login.login(username, "secret_sauce");
    }

    @Test
    public void userCanSelectProductAndLandOnDetailPage(){
        // Navigate to the inventory page
        screens.inventory.navigateTo();

        // Click on the first product name to navigate to the detail page
        screens.inventory.clickItemTitle();

        // Verify that the detail page is displayed
        screens.detail.itemTitleSelectorIsPresent();

        // Assert that the detail page is displayed
        Assert.assertTrue(screens.detail.itemTitleSelectorIsPresent(), "Detail page should be displayed after clicking on the product name.");
    }

    @Test
    public void testAddItemToCartFromDetailPage() {
        // Navigate to the detail page of the first item
        screens.inventory.navigateTo();
        // Click item on inventory page
        screens.inventory.clickItemTitle();
        // Click the "Add to cart" button
        screens.detail.addToCart();
        // Verify that the item has been added to the cart
        // This is done in Cart POM
        // first navigate to the cart itself
        screens.cart.navigateTo();
        Assert.assertTrue(screens.cart.itemIsInCart(), "Item should be in the cart after adding.");
    }

    @Test
    public void testNavigateBackToInventoryPageFromDetailPage() {
        // Navigate to the detail page of the first item
        screens.detail.navigateTo();
        // Click item on inventory page
        screens.detail.clickBackToProducts();
        Assert.assertTrue(screens.inventory.isOnInventoryPage(), "Should land on inventory Page.");
    }

    @Test
    public void testAbleToClickAndNavigateToCartPage() {
        // Navigate to the inventory
        screens.inventory.navigateTo();
        // Click shopping button
        screens.inventory.clickShoppingCart();
        Assert.assertTrue(screens.cart.isOnCartPage(), "Should land on cart Page.");
    }
}

