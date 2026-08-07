package steps;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import utils.DriverConfig;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @Before
    public void setUp() {
        DriverConfig.configure();
        SelenideLogger.addListener(
                "AllureSelenide", new AllureSelenide());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
