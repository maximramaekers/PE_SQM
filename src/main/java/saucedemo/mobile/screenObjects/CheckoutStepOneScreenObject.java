package saucedemo.mobile.screenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
    public class CheckoutStepOneScreenObject extends BaseAppiumPageObject {
        public CheckoutStepOneScreenObject(AppiumDriver driver) {
            super(driver, "/checkout-step-one.html");
        }

        By checkoutStepOneBackButtonSelector = By.cssSelector("button[data-test='cancel']");
        By checkoutStepOneContinueButtonSelector = By.cssSelector("input#continue");
        By firstNameFieldSelector = By.cssSelector("#first-name");
        By lastNameFieldSelector = By.cssSelector("#last-name");
        By postalCodeFieldSelector = By.cssSelector("#postal-code");



        public boolean isOnCheckoutStepOnePage(){
            String currentUrl = driver.getCurrentUrl();
            return currentUrl.contains("/checkout-step-one");
        }

        public void clickBackToShoppingCart() {
            WebElement backToCart = driver.findElement(checkoutStepOneBackButtonSelector);
            backToCart.click();
        }

        public void clickContinueToCheckoutStepTwo() {
            WebElement continueCheckout = driver.findElement(checkoutStepOneContinueButtonSelector);
            continueCheckout.click();
        }

        public void addInformationToInfoFields(){
            WebElement firstNameInput = driver.findElement(firstNameFieldSelector);
            firstNameInput.sendKeys("John");

            WebElement lastNameInput = driver.findElement(lastNameFieldSelector);
            lastNameInput.sendKeys("Doe");

            WebElement postalCodeInput = driver.findElement(postalCodeFieldSelector);
            postalCodeInput.sendKeys("12345");
        }
    }

