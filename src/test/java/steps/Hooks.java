package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
