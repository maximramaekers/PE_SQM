package saucedemo.mobile;

import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import saucedemo.mobile.screenObjects.SauceLabScreens;
import saucedemo.web.pageObjects.SauceLabPages;

import java.io.IOException;
import java.net.MalformedURLException;

public class CheckoutTest {
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

    @BeforeTest
    public void AddToInventory(){


    }

    @Test
    public void userCanGoBackToShoppingCart(){
        screens.inventory.navigateTo();
        // Click item on inventory page
        screens.inventory.clickItemTitle();
        // Click the "Add to cart" button
        screens.detail.addToCart();
        //fresh start at shopping cart
        screens.cart.navigateTo();
        screens.checkoutstepone.navigateTo();
        screens.checkoutstepone.clickBackToShoppingCart();
        // Checks if on Cart Page
        screens.cart.isOnCartPage();
    }

    @Test
    public void userCanFillInInfoAndContinueToOverviewAndSeeItemIsInCart(){
        screens.checkoutstepone.navigateTo();
        //Adds information to field
        screens.checkoutstepone.addInformationToInfoFields();
        //Fills in info
        screens.checkoutstepone.clickContinueToCheckoutStepTwo();
        //checks if item is in step two
        screens.checkoutsteptwo.itemIsInCart();
    }

    @Test
    public void userCanGoBackFromStepTwoToStepOneCheckout(){
        screens.checkoutstepone.navigateTo();
        //Adds information to field
        screens.checkoutstepone.addInformationToInfoFields();
        //Fills in info
        screens.checkoutstepone.clickContinueToCheckoutStepTwo();
        //checks if item is in step two
        screens.checkoutsteptwo.clickBackToStepOne();
    }
    @Test
    public void userCanFinishOrder(){
        screens.checkoutstepone.navigateTo();
        //Adds information to field
        screens.checkoutstepone.addInformationToInfoFields();
        //Fills in info
        screens.checkoutstepone.clickContinueToCheckoutStepTwo();
        //checks if item is in step two
        screens.checkoutsteptwo.clickContinueToFinishPage();
    }

    @Test
    public void userCanGoBackToHomeAfterFinishingOrder(){
        screens.checkoutstepone.navigateTo();
        //Adds information to field
        screens.checkoutstepone.addInformationToInfoFields();
        //Fills in info
        screens.checkoutstepone.clickContinueToCheckoutStepTwo();
        //checks if item is in step two
        screens.checkoutsteptwo.clickContinueToFinishPage();
        //checks if item is in step two
        screens.finish.clickBackToInventory();
        //checks if on inventory
        screens.inventory.isOnInventoryPage();
    }
}
