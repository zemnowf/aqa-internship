package web.amazon;

import org.junit.jupiter.api.*;
import web.amazon.page.LoginPage;
import web.amazon.page.ProductPage;
import web.amazon.page.SearchPage;
import web.util.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Amazon Tests")
public class AmazonTest extends BaseTest {

    protected static final String email = "salondznts@gmail.com";
    protected static final String password = "testpassword";
    protected static final String username = "Daniil";
    protected static final String productName = "iPhone";
    protected static final String productUrl = "https://www.amazon.com/Apple-iPhone-11-64GB-Black/dp/B07ZPKN6YR?th=1";

    @Test
    @DisplayName("Successful authorization")
    public void auth(){
        LoginPage loginPage = new LoginPage(driver.get());
        loginPage.authAs(email, password);
        assertEquals("Hello, " + username, loginPage.checkUsername());
    }

    @Test
    @DisplayName("Search products")
    public void searchProduct(){
        auth();
        SearchPage searchPage = new SearchPage(driver.get());
        searchPage.searchProduct(productName);
        assertEquals("\"iPhone\"", searchPage.checkResult());
    }

    @Test
    @DisplayName("Adding the product into the cart from product’s page")
    public void addProductToCart(){
        auth();
        SearchPage searchPage = new SearchPage(driver.get());
        searchPage.openCartPage();
        searchPage.clearCart();
        ProductPage productPage = new ProductPage(driver.get(), productUrl);
        productPage.addProductToCart();

        assertEquals("Added to Cart", productPage.checkResult());
    }

    @Test
    @DisplayName("Added product is displayed in the cart")
    public void checkProductInCart(){
        auth();
        SearchPage searchPage = new SearchPage(driver.get());
        searchPage.openCartPage();
        assertEquals("Shopping Cart", searchPage.checkProductInCart());
    }

}
