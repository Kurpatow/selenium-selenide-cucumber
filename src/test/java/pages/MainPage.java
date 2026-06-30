package pages;

import com.codeborne.selenide.ElementsCollection;
import elements.ProductCard;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

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
                .orElseThrow();
    }
}
