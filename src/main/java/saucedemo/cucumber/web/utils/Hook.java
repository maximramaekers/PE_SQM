package saucedemo.cucumber.web.utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import saucedemo.web.pageObjects.SauceLabPages;


public class Hook {
    private SauceLabPages pages;

    @Before
    public void setUp() {
        this.pages = SauceLabPages.Init();
    }

    @After
    public void afterTest() {
        pages.quit();
    }

    public SauceLabPages getPages() {
        return pages;
    }
}
