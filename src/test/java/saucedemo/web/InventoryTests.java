package saucedemo.web;

import org.testng.Assert;
import org.testng.annotations.*;
import saucedemo.web.pageObjects.SauceLabPages;

public class InventoryTests {
    final String username ="standard_user";
    //TODO: ADD CATEGORIES TO TESTS
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

    @Test
    public void testAddItemToCartFromDetailPage() {
        // Navigate to the detail page of the first item
        pages.inventory.navigateTo();
        // Click item on inventory page
        pages.inventory.clickItemTitle();
        // Click the "Add to cart" button
        pages.detail.addToCart();
        // Verify that the item has been added to the cart
        // This is done in Cart POM
        // first navigate to the cart itself
        pages.cart.navigateTo();
        Assert.assertTrue(pages.cart.itemIsInCart(), "Item should be in the cart after adding.");
    }

    @Test
    public void testNavigateBackToInventoryPageFromDetailPage() {
        // Navigate to the detail page of the first item
        pages.detail.navigateTo();
        // Click item on inventory page
        pages.detail.clickBackToProducts();
        Assert.assertTrue(pages.inventory.isOnInventoryPage(), "Should land on inventory Page.");
    }

    @Test
    public void testAbleToClickAndNavigateToCartPage() {
        // Navigate to the inventory
        pages.inventory.navigateTo();
        // Click shopping button
        pages.inventory.clickShoppingCart();
        Assert.assertTrue(pages.cart.isOnCartPage(), "Should land on cart Page.");
    }
}


