package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

@Epic("SauceDemo")
@Feature("Авторизация")
public class LoginSteps {

    private LoginPage loginPage;
    private MainPage mainPage;

    @Given("пользователь открыл страницу авторизации")
    @Step("Открыть страницу авторизации")
    @Description("Переход на страницу входа SauceDemo")
    public void openLoginPage() {
        open("https://www.saucedemo.com/");
        loginPage = new LoginPage();
    }

    @When("пользователь вводит логин {string}")
    @Step("Ввести логин: {username}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("пользователь вводит пароль {string}")
    @Step("Ввести пароль")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("пользователь нажимает кнопку Login")
    @Step("Нажать кнопку Login")
    public void clickLoginButton() {
        mainPage = loginPage.clickLoginButton();
    }

    @Then("открывается главная страница")
    @Step("Проверить, что открылась главная страница")
    public void mainPageOpened() {
        mainPage.shouldBeOpened();
    }

    @Then("отображается сообщение об ошибке")
    @Step("Проверить отображение сообщения об ошибке")
    public void loginErrorShown() {
        loginPage.shouldShowLoginError();
    }
}
