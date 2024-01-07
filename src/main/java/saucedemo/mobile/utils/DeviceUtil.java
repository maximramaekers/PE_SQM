package saucedemo.mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DeviceUtil {
    public static AppiumDriver createMobileDriver() throws MalformedURLException {
        AppiumDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
            capabilities.setCapability(AndroidMobileCapabilityType.BROWSER_NAME, "Chrome");
            capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:/Users/maxim/OneDrive/Bureaublad/chromedriver/chromedriver.exe");
            driver = new AndroidDriver(new URL("http://localhost:4723/"), capabilities);

        return driver;
    }

}
