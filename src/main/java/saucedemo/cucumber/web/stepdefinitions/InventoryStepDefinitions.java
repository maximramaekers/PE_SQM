package saucedemo.cucumber.web.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.cucumber.web.utils.Hook;
import saucedemo.web.pageObjects.SauceLabPages;

import static org.junit.Assert.assertTrue;

public class InventoryStepDefinitions {
    private SauceLabPages pages;

    public InventoryStepDefinitions(Hook hook) {
        this.pages = hook.getPages();
    }

    // Ensuring user is logged in before navigating to inventory
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");
    }

    @Given("the user is on the inventory page")
    public void the_user_is_on_inventory_page() {
        // Assuming the user is already logged in as per the previous step
        pages.inventory.navigateTo();
    }

    @Given("the user is on the detail page of the first item")
    public void the_user_is_on_detail_page_of_first_item() {
        // User must be logged in and on the inventory page first
        the_user_is_logged_in();
        the_user_is_on_inventory_page();
        pages.inventory.clickItemTitle();
    }

    @When("the user clicks on the first product")
    public void the_user_clicks_on_first_product() {
        pages.inventory.clickItemTitle();
    }

    @When("the user adds the item to the cart")
    public void the_user_adds_item_to_cart() {
        pages.detail.addToCart();
    }

    @When("the user navigates back to the inventory page")
    public void the_user_navigates_back_to_inventory_page() {
        pages.detail.clickBackToProducts();
    }

    @When("the user navigates to the cart page")
    public void the_user_navigates_to_cart_page() {
        pages.inventory.clickShoppingCart();
    }

    @Then("the product detail page is displayed")
    public void product_detail_page_is_displayed() {
        assertTrue("Detail page should be displayed after clicking on the product name.", pages.detail.itemTitleSelectorIsPresent());
    }

    @Then("the item should be in the cart")
    public void item_should_be_in_cart() {
        pages.cart.navigateTo();
        assertTrue("Item should be in the cart after adding.", pages.cart.itemIsInCart());
    }

    @Then("the user should land on the inventory page")
    public void user_should_land_on_inventory_page() {
        assertTrue("Should land on inventory Page.", pages.inventory.isOnInventoryPage());
    }

    @Then("the user should land on the cart page")
    public void user_should_land_on_cart_page() {
        assertTrue("Should land on cart Page.", pages.cart.isOnCartPage());
    }
}