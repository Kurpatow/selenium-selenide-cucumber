package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginSteps {

    private LoginPage loginPage;
    private MainPage mainPage;

    @Given("пользователь открыл страницу авторизации")
    public void openLoginPage() {
        open("https://www.saucedemo.com/");
        loginPage = new LoginPage();
    }

    @When("пользователь вводит логин {string}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("пользователь вводит пароль {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("пользователь нажимает кнопку Login")
    public void clickLoginButton() {
        mainPage = loginPage.clickLoginButton();
    }

    @Then("открывается главная страница")
    public void mainPageOpened() {
        mainPage.shouldBeOpened();
    }

    @Then("отображается сообщение об ошибке")
    public void loginErrorShown() {
        loginPage.shouldShowLoginError();
    }
}
