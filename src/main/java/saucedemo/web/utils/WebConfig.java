package saucedemo.web.utils;

import common.JSONHelper;

import java.time.Duration;

public class WebConfig {
    private static final String webConfigJsonFile = "src/main/java/saucedemo/web/webConfig.json";
    public static String getDefaultBrowser(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "defaultBrowser");
    }

    public static String getBaseUrl(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "baseURL");
    }

    public static Duration getDefaultWait() {
        return Duration.ofSeconds(10);
    }
}
