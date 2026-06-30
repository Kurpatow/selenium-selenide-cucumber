package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage extends  BasePage {

    public void shouldContainProduct(String productName) {

        $x("//div[text()='" + productName + "']")
                .shouldBe(visible);
    }
}
