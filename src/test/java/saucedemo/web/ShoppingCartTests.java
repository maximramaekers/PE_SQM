package saucedemo.web;

import org.testng.annotations.*;
import saucedemo.web.pageObjects.SauceLabPages;

public class ShoppingCartTests {
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
    public void userCanNavigateFromShoppingCartToInventory(){
        //fresh start at shopping cart
        pages.cart.navigateTo();
        // Clicks on Back To Inventory Button
        pages.cart.clickBackToInventory();
        // Checks if on Inventory Page
        pages.inventory.isOnInventoryPage();
    }

    @Test
    public void userCanNavigateFromShoppingCartToCheckout(){
        pages.inventory.navigateTo();
        // Click item on inventory page
        pages.inventory.clickItemTitle();
        // Click the "Add to cart" button
        pages.detail.addToCart();
        //fresh start at shopping cart
        pages.cart.navigateTo();
        // Clicks on Back To Inventory Button
        pages.cart.clickToCheckout();
        // Checks if on Inventory Page
        pages.checkoutstepone.isOnCheckoutStepOnePage();
    }
}