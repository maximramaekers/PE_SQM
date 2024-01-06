package saucedemo;

import saucedemo.web.pageObjects.SauceLabPages;

public class Login {
    public static void main(String[] args) {
        SauceLabPages pages = SauceLabPages.Init();

        pages.login.navigateTo();
        pages.login.login("standard_user", "secret_sauce");
        pages.inventory.logout();

        pages.inventory.navigateTo();

        pages.quit();
    }
}
