package saucedemo.cucumber.web.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.cucumber.web.utils.Hook;
import saucedemo.web.pageObjects.SauceLabPages;

import static org.junit.Assert.assertTrue;

public class CheckoutStepDefinitions {
    private SauceLabPages pages;

    public CheckoutStepDefinitions(Hook hook) {
        this.pages = hook.getPages();
    }

    @Given("the user is logged in and has an item in the cart")
    public void the_user_is_logged_in_and_has_an_item_in_the_cart() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");
        pages.inventory.navigateTo();
        pages.inventory.clickItemTitle();
        pages.detail.addToCart();
        pages.cart.navigateTo();
    }

    @When("the user navigates to checkout and clicks back to shopping cart")
    public void the_user_navigates_to_checkout_and_clicks_back_to_shopping_cart() {
        pages.checkoutstepone.navigateTo();
        pages.checkoutstepone.clickBackToShoppingCart();
    }

    @Then("the user should land on the shopping cart page")
    public void the_user_should_land_on_the_shopping_cart_page() {
        assertTrue("Should be on cart page", pages.cart.isOnCartPage());
    }

    @Given("the user is on the checkout step one page")
    public void the_user_is_on_the_checkout_step_one_page() {
        pages.checkoutstepone.navigateTo();
    }

    @When("the user fills in the information and continues to checkout step two")
    public void the_user_fills_in_the_information_and_continues_to_checkout_step_two() {
        pages.checkoutstepone.addInformationToInfoFields();
        pages.checkoutstepone.clickContinueToCheckoutStepTwo();
    }

    @Then("the user should see the item in the overview on checkout step two")
    public void the_user_should_see_the_item_in_the_overview_on_checkout_step_two() {
        assertTrue("Item should be in cart on checkout step two", pages.checkoutsteptwo.itemIsInCart());
    }
}
