package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage extends  BasePage {

    public void shouldBeOpened() {
        $(".title").shouldHave(text("Your Cart"));
    }

    public void shouldContainProduct(String productName) {

        $x("//div[@class='inventory_item_name' and text()='" + productName + "']")
                .shouldBe(visible);
    }

    public void shouldNotContainProduct(String productName) {
        $x("//div[@class='inventory_item_name' and text()='" + productName + "']")
                .shouldNot(exist);
    }
}
