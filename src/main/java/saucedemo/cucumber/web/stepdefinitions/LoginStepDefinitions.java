package saucedemo.cucumber.web.stepdefinitions;

import io.cucumber.java.en.*;
import saucedemo.web.pageObjects.SauceLabPages;
import org.testng.Assert;
import saucedemo.cucumber.web.utils.Hook;

public class LoginStepDefinitions {
    private SauceLabPages pages;

    public LoginStepDefinitions(Hook hook) {
        this.pages = hook.getPages();
    }

    @Given("the user is currently on the login page")
    public void theUserIsOnTheLoginPage() {
        pages.login.navigateTo();
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithUsernameAndPassword(String username, String password) {
        pages.login.login(username, password);
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
        Assert.assertTrue(pages.inventory.isOnInventoryPage(), "User should be logged in.");
    }

    @Then("the user should not be logged in")
    public void theUserShouldNotBeLoggedIn() {
        Assert.assertFalse(pages.inventory.isOnInventoryPage(), "User should not be logged in.");
    }
}
