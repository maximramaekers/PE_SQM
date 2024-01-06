package saucedemo.web.utils;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
    public static WebDriver createBrowser(String browser) {
        WebDriver driver;
        switch (browser) {
            case "chrome":
                ChromeDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                FirefoxDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unsupported driver");
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver createBrowser() {
        return createBrowser(WebConfig.getDefaultBrowser());
    }
}
