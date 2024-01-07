package saucedemo.cucumber.web.stepdefinitions;

import io.cucumber.java.en.*;
import saucedemo.cucumber.web.utils.Hook;
import saucedemo.web.pageObjects.*;

import static org.junit.Assert.assertTrue;

public class InventoryStepDefinitions {
    private SauceLabPages pages;

    public InventoryStepDefinitions(Hook hook) {
        this.pages = hook.getPages();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");
        assertTrue("The user should be logged in", pages.inventory.isOnInventoryPage());
    }
    @Given("the user is logged in and on the inventory page")
    public void theUserIsLoggedInAndOnTheInventoryPage() {
        theUserIsLoggedIn(); // Ensure the user is logged in.
        pages.inventory.navigateTo(); // Navigate to the inventory page.
        assertTrue("User should be on the inventory page", pages.inventory.isOnInventoryPage());
    }
    @Given("the user navigates to the inventory page")
    public void theUserNavigatesToTheInventoryPage() {
        pages.inventory.navigateTo();
        assertTrue("User should be on the inventory page", pages.inventory.isOnInventoryPage());
    }

    @Given("the user is logged in and on a product detail page")
    public void theUserIsLoggedInAndOnAProductDetailPage() {
        theUserIsLoggedIn();
        pages.inventory.clickItemTitle();
        assertTrue("User should be on the product detail page", pages.detail.itemTitleSelectorIsPresent());
    }

    @When("the user selects a product to view its details")
    public void theUserSelectsAProductToViewItsDetails() {
        pages.inventory.clickItemTitle();
    }

    @When("the user adds the product to the cart")
    public void theUserAddsTheProductToTheCart() {
        pages.detail.addToCart();
    }

    @When("the user navigates back to the inventory page from the detail page")
    public void theUserNavigatesBackToTheInventoryPageFromDetailPage() {
        pages.detail.clickBackToProducts();
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        pages.inventory.clickShoppingCart();
    }

    @Then("the user should land on the product detail page")
    public void theUserShouldLandOnTheProductDetailPage() {
        assertTrue(pages.detail.itemTitleSelectorIsPresent());
    }

    @Then("the product should be in the cart")
    public void theProductShouldBeInTheCart() {
        pages.cart.navigateTo();
        assertTrue(pages.cart.itemIsInCart());
    }

    @Then("the user should be on the inventory page")
    public void theUserShouldBeOnTheInventoryPage() {
        assertTrue(pages.inventory.isOnInventoryPage());
    }

    @Then("the user should be on the cart page")
    public void theUserShouldBeOnTheCartPage() {
        assertTrue(pages.cart.isOnCartPage());
    }
}
