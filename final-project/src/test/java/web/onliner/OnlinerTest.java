package web.onliner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import web.onliner.page.ProductPage;
import web.onliner.page.SearchPage;
import web.util.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Onliner Tests")
public class OnlinerTest extends BaseTest {

    protected static final String productName = "Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный)";
    protected static final String productUrl = "https://catalog.onliner.by/mobile"
            +"/samsung/sma525fzkdser/prices?order=price%3Aasc";
    protected static final String productPriceList = "Цены на смартфон Samsung Galaxy "
            + "A52 SM-A525F/DS 4GB/128GB (черный)";
    protected static final String productDescription = "Android, экран 6.5\" AMOLED (1080x2400), "
            + "Qualcomm Snapdragon 720G, ОЗУ 4 ГБ, флэш-память 128 ГБ, карты памяти, камера 64 Мп, "
            + "аккумулятор 4500 мАч, 2 SIM, влагозащита IP67";

    @Test
    public void searchProduct(){
        SearchPage searchPage = new SearchPage(driver.get());
        searchPage.searchProduct(productName);
        searchPage.clickOnFoundProduct();
        assertEquals(productPriceList,
                searchPage.getProductPageHeaderText());
    }

    @Test
    public void addProductToCart(){
        ProductPage productPage = new ProductPage(driver.get(), productUrl);
        assertEquals(productDescription, productPage.getDescription());
        productPage.addProductToCart();
        productPage.clickOnConfirmCityButton();
        assertEquals("В корзине", productPage.getInCartText());
    }



}
