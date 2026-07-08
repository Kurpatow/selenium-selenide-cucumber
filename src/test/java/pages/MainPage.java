package pages;

import com.codeborne.selenide.ElementsCollection;
import elements.ProductCard;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {

    public List<ProductCard> getProducts() {

        ElementsCollection products =
                $$(".inventory_item");

        return products.stream()
                .map(ProductCard::new)
                .collect(Collectors.toList());
    }

    public ProductCard getProductByTitle(String title) {

        return getProducts()
                .stream()
                .filter(product ->
                        product.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Товар не найден: " + title));
    }

    public CartPage openCart() {
        $(".shooping_cart_link").click();
        return new CartPage();
    }

    public void shouldBeOpened() {
        $(".title").shouldHave(text("Products"));
    }
}
