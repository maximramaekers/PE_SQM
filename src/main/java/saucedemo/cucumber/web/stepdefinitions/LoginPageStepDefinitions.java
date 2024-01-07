package saucedemo.cucumber.web.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.cucumber.web.utils.Hook;
import static com.google.common.truth.Truth.assertThat;


public class LoginPageStepDefinitions {
    private Hook hook;

    public LoginPageStepDefinitions(Hook hook) {
        this.hook = hook;
    }

    @Given("the user is on the SauceDemo login page")
    public void the_user_is_on_the_SauceDemo_login_page() {
        hook.getPages().login.navigateTo();
    }

    @Given("the user is logged in with {string} and {string}")
    public void the_user_is_logged_in_with(String username, String password) {
        hook.getPages().login.login(username, password);
    }

    @When("the user logs out")
    public void the_user_logs_out() {
        hook.getPages().inventory.logout();
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        assertThat(hook.getPages().login.isLoginPageDisplayed()).isTrue();
    }

    @When("the user logs in with {string} and {string}")
    public void the_user_logs_in_with(String username, String password) {
        hook.getPages().login.login(username, password);
    }

    @Then("the logout button should be present on the inventory page")
    public void the_logout_button_should_be_present_on_the_inventory_page() {
        assertThat(hook.getPages().inventory.getLogoutBtnSelector()).isNotNull();
    }
}
