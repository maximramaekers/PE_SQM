package saucedemo.cucumber.web.stepdefinitions;

import io.cucumber.java.en.*;
import saucedemo.cucumber.web.utils.Hook;
import saucedemo.web.pageObjects.*;

import static org.junit.Assert.assertTrue;

public class CheckoutStepDefinitions {
    private SauceLabPages pages;

    public CheckoutStepDefinitions(Hook hook) {
        this.pages = hook.getPages();
    }

    @Given("the user is logged in and has an item in the cart")
    public void theUserIsLoggedInAndHasAnItemInTheCart() {
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");
        pages.inventory.navigateTo();
        pages.inventory.clickItemTitle();
        pages.detail.addToCart();
        pages.cart.navigateTo();
        assertTrue("The user should be on the cart page with an item", pages.cart.isOnCartPage() && pages.cart.itemIsInCart());
    }

    @When("the user navigates to checkout step one and goes back to the shopping cart")
    public void theUserNavigatesToCheckoutStepOneAndGoesBackToTheShoppingCart() {
        pages.cart.clickToCheckout();
        assertTrue("User should be on checkout step one page", pages.checkoutstepone.isOnCheckoutStepOnePage());
        pages.checkoutstepone.clickBackToShoppingCart();
    }

    @Then("the user should be on the shopping cart page")
    public void theUserShouldBeOnTheShoppingCartPage() {
        assertTrue("User should be back on the shopping cart page", pages.cart.isOnCartPage());
    }

    @Given("the user is on the checkout step one page")
    public void theUserIsOnTheCheckoutStepOnePage() {
        theUserIsLoggedInAndHasAnItemInTheCart();
        pages.cart.clickToCheckout();
        assertTrue("User should be on checkout step one page", pages.checkoutstepone.isOnCheckoutStepOnePage());
    }

    @When("the user fills in information and continues to checkout step two")
    public void theUserFillsInInformationAndContinuesToCheckoutStepTwo() {
        pages.checkoutstepone.addInformationToInfoFields();
        pages.checkoutstepone.clickContinueToCheckoutStepTwo();
    }

    @Then("the user should see the item in the cart on checkout step two")
    public void theUserShouldSeeTheItemInTheCartOnCheckoutStepTwo() {
        assertTrue("Item should be in cart on checkout step two", pages.checkoutsteptwo.itemIsInCart());
    }

    @Given("the user is on the checkout step two page with item in cart")
    public void theUserIsOnTheCheckoutStepTwoPageWithItemInCart() {
        theUserIsOnTheCheckoutStepOnePage();
        pages.checkoutstepone.addInformationToInfoFields();
        pages.checkoutstepone.clickContinueToCheckoutStepTwo();
        assertTrue("User should be on checkout step two page with item in cart", pages.checkoutsteptwo.itemIsInCart());
    }

    @When("the user goes back to checkout step one")
    public void theUserGoesBackToCheckoutStepOne() {
        pages.checkoutsteptwo.clickBackToStepOne();
    }

    @Then("the user should be on the checkout step one page")
    public void theUserShouldBeOnTheCheckoutStepOnePage() {
        assertTrue("User should be on checkout step one page", pages.checkoutstepone.isOnCheckoutStepOnePage());
    }

    @When("the user finishes the order from checkout step two")
    public void theUserFinishesTheOrderFromCheckoutStepTwo() {
        pages.checkoutsteptwo.clickContinueToFinishPage();
    }

    @Then("the user should be on the finish page")
    public void theUserShouldBeOnTheFinishPage() {
        assertTrue("User should be on the finish page", pages.finish.isOnFinishPage());
    }

    @Given("the user has completed the order and is on the finish page")
    public void theUserHasCompletedTheOrderAndIsOnTheFinishPage() {
        // Log in the user
        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");

        // Perform steps to complete the order and reach the finish page
        pages.checkoutstepone.navigateTo();
        pages.checkoutstepone.addInformationToInfoFields();
        pages.checkoutstepone.clickContinueToCheckoutStepTwo();
        pages.checkoutsteptwo.clickContinueToFinishPage();

        // Check if the user is on the finish page
        boolean isOnFinishPage = pages.finish.isOnFinishPage();

        assertTrue("User should be on the finish page", isOnFinishPage);
    }

    @When("the user goes back to the inventory page from finish page")
    public void theUserGoesBackToTheInventoryPageFromFinishPage() {
        pages.finish.clickBackToInventory();
    }

    @Then("the user should be on the inventory page after he goes back")
    public void theUserShouldBeOnTheInventoryPage() {
        assertTrue("User should be on the inventory page", pages.inventory.isOnInventoryPage());
    }
}
