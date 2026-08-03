package utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.MutableCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverConfig {

    public static void configure() {

        Configuration.remote = System.getProperty(
                "selenoid.url",
                "http://localhost:4444/wd/hub"
        );

        Configuration.browser = System.getProperty(
                "browser",
                "chrome"
        );

        Configuration.browserVersion = System.getProperty(
                "browserVersion",
                "128.0"
        );

        Map<String, Object> selenoidOptions = new HashMap<>();

        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", true);
        selenoidOptions.put("screenResolution", "1920x1080x24");

        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("selenoid:options", selenoidOptions);

        Configuration.browserCapabilities = capabilities;
    }
}