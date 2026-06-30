package pages;

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

        enterUsername(username);
        enterPassword(password);

        return clickLoginButton();
    }
}
