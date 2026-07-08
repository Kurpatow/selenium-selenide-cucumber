package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class CartSteps {

    private MainPage mainPage;
    private CartPage cartPage;

    @Given("пользователь авторизован")
    public void userIsLoggedIn() {
        open("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage();
        mainPage = loginPage.login("standard_user", "secret_sauce");
    }

    @When("пользователь добавляет товар {string} в корзину")
    public void addProductToCart(String productName) {
        mainPage.getProductByTitle(productName).addToCart();
    }

    @And("пользователь открывает корзину")
    public void openCart() {
        cartPage = mainPage.openCart();
    }

    @Then("корзина содержит товар {string}")
    public void cartContainsProduct(String productName) {
        cartPage.shouldContainProduct(productName);
    }
}
