package saucedemo.mobile.utils;
import common.JSONHelper;

import java.time.Duration;

public class MobileConfig {
    private static final String appiumConfigJsonFile = "src/main/java/saucedemo/appium/mobileConfig.json";

    public static String getDefaultPlatform() {
        return JSONHelper.getJSONStringFromJsonFile(appiumConfigJsonFile, "defaultPlatform");
    }

    public static String getAppiumServerUrl() {
        return JSONHelper.getJSONStringFromJsonFile(appiumConfigJsonFile, "appiumServerUrl");
    }

    public static Duration getDefaultWait() {
        return Duration.ofSeconds(10);
    }

}

