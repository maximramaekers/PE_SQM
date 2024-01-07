package saucedemo.web;

import org.testng.annotations.*;
import saucedemo.web.pageObjects.SauceLabPages;

public class CheckoutTests {
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

    @BeforeTest
    public void AddToInventory(){


    }

    @Test
    public void userCanGoBackToShoppingCart(){
        pages.inventory.navigateTo();
        // Click item on inventory page
        pages.inventory.clickItemTitle();
        // Click the "Add to cart" button
        pages.detail.addToCart();
        //fresh start at shopping cart
        pages.cart.navigateTo();
        pages.checkoutstepone.navigateTo();
        pages.checkoutstepone.clickBackToShoppingCart();
        // Checks if on Cart Page
        pages.cart.isOnCartPage();
    }

    @Test
    public void userCanFillInInfoAndContinueToOverview(){
        pages.checkoutstepone.navigateTo();
        //Adds information to field
        pages.checkoutstepone.addInformationToInfoFields();
        //Fills in info
        pages.checkoutstepone.clickContinueToCheckoutStepTwo();
        //checks if item is in step two
        pages.checkoutsteptwo.itemIsInCart();
    }
}