package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    public LoginPage enterUsername(String username) {
        $("#user-name").setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $("#password").setValue(password);
        return this;
    }

    public MainPage clickLoginButton() {
        $("#login-button").click();
        return new MainPage();
    }

    public MainPage login(String username, String password) {
         return enterUsername(username)
                 .enterPassword(password)
                 .clickLoginButton();
    }

    public void shouldShowLoginError() {
        $("h3[data-test='error']")
                .shouldBe(visible);
    }

    public void shouldShowLoginError(String message) {
        $("h3[data-test='error'")
                .shouldHave(text(message));
    }
}
