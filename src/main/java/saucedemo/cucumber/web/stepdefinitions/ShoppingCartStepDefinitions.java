package saucedemo.cucumber.web.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.cucumber.web.utils.Hook;
import saucedemo.web.pageObjects.SauceLabPages;

import static org.junit.Assert.assertTrue;

public class ShoppingCartStepDefinitions {
    private SauceLabPages pages;

    public ShoppingCartStepDefinitions(Hook hook) {
        this.pages = hook.getPages();
    }

    @Given("the user is logged in and at the shopping cart")
    public void the_user_is_logged_in_and_at_the_shopping_cart() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");
        pages.cart.navigateTo();
    }

    @When("the user clicks back to inventory")
    public void the_user_clicks_back_to_inventory() {
        pages.cart.clickBackToInventory();
    }

    @Then("the user should land on the inventory page")
    public void the_user_should_land_on_the_inventory_page() {
        assertTrue("User should be on inventory page", pages.inventory.isOnInventoryPage());
    }

    @Given("the user is logged in with an item in the cart")
    public void the_user_is_logged_in_with_an_item_in_the_cart() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");
        pages.inventory.navigateTo();
        pages.inventory.clickItemTitle();
        pages.detail.addToCart();
        pages.cart.navigateTo();
    }

    @When("the user clicks to checkout")
    public void the_user_clicks_to_checkout() {
        pages.cart.clickToCheckout();
    }

    @Then("the user should land on the inventory page from the cart")
    public void the_user_should_land_on_inventory_page_from_cart() {
        assertTrue("User should be on inventory page", pages.inventory.isOnInventoryPage());
    }

}
