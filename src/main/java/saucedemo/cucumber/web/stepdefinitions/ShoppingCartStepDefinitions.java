package saucedemo.cucumber.web.stepdefinitions;
import io.cucumber.java.en.*;
import saucedemo.cucumber.web.utils.Hook;
import saucedemo.web.pageObjects.SauceLabPages;

public class ShoppingCartStepDefinitions {
    private SauceLabPages pages;

    public ShoppingCartStepDefinitions(Hook hook) {
        this.pages = hook.getPages();
    }

    @Given("the user is logged in the website")
    public void userIsLoggedInAndHasItemInCart() {
        // Perform actions to log in the user and add an item to the cart
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");
    }

    @When("the user navigates to the shopping cart page")
    public void userNavigatesToShoppingCartPage() {
        pages.inventory.navigateTo();
        // Click item on inventory page
        pages.inventory.clickItemTitle();
        // Click the "Add to cart" button
        pages.detail.addToCart();
        pages.cart.navigateTo();
    }

    @When("the user clicks on the {string} Button")
    public void userClicksOnButton(String buttonName) {
        if (buttonName.equals("Back To Inventory")) {
            pages.cart.clickBackToInventory();
        } else if (buttonName.equals("Checkout")) {
            pages.cart.clickToCheckout();
        }
    }

    @Then("the user should be on the inventory page")
    public void userShouldBeOnInventoryPage() {
        assert pages.inventory.isOnInventoryPage();
    }

    @Then("the user should be on the Checkout page")
    public void userShouldBeOnCheckoutPage() {
        pages.checkoutstepone.isOnCheckoutStepOnePage();
    }
}
