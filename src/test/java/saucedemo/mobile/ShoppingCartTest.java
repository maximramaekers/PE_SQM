package saucedemo.mobile;

import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import saucedemo.mobile.screenObjects.SauceLabScreens;
import saucedemo.web.pageObjects.SauceLabPages;

import java.io.IOException;
import java.net.MalformedURLException;

public class ShoppingCartTest {
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
    public void userCanNavigateFromShoppingCartToInventory(){
        //fresh start at shopping cart
        screens.cart.navigateTo();
        // Clicks on Back To Inventory Button
        screens.cart.clickBackToInventory();
        // Checks if on Inventory Page
        screens.inventory.isOnInventoryPage();
    }

    @Test
    public void userCanNavigateFromShoppingCartToCheckout(){
        screens.inventory.navigateTo();
        // Click item on inventory page
        screens.inventory.clickItemTitle();
        // Click the "Add to cart" button
        screens.detail.addToCart();
        //fresh start at shopping cart
        screens.cart.navigateTo();
        // Clicks on Back To Inventory Button
        screens.cart.clickToCheckout();
        // Checks if on Inventory Page
        screens.checkoutstepone.isOnCheckoutStepOnePage();
    }
}
