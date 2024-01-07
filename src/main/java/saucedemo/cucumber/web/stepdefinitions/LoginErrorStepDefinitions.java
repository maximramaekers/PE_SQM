package saucedemo.cucumber.web.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.cucumber.web.utils.Hook;
import saucedemo.web.pageObjects.LoginPageObject;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class LoginErrorStepDefinitions {
    private LoginPageObject login;

    public LoginErrorStepDefinitions(Hook hook) {
        this.login = hook.getPages().login;
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        this.login.navigateTo();
    }

    @When("the user attempts to login with {string} and {string}")
    public void the_user_attempts_to_login_with_and(String username, String password) {
        this.login.login(username, password);
    }

    @Then("the login page is displayed again")
    public void the_login_page_is_displayed_again() {
        assertTrue("Login page should be displayed after a failed login attempt.", login.isLoginPageDisplayed());
    }

    @Then("an error message {string} is shown")
    public void an_error_message_is_shown(String expectedErrorMessage) {
        assertEquals("Error message should be displayed on failed login.", expectedErrorMessage, login.getErrorMessage());
    }
}
