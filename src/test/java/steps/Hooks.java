package steps;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @Before
    public void setUp() {

        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );

    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
