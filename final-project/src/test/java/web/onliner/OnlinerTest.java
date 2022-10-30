package web.onliner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import web.onliner.page.ProductPage;
import web.onliner.page.SearchPage;
import web.util.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Onliner Tests")
public class OnlinerTest extends BaseTest {

    protected static final String productName = "�������� Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (������)";
    protected static final String productUrl = "https://catalog.onliner.by/mobile"
            +"/samsung/sma525fzkdser/prices?order=price%3Aasc";
    protected static final String productPriceList = "���� �� �������� Samsung Galaxy "
            + "A52 SM-A525F/DS 4GB/128GB (������)";
    protected static final String productDescription = "Android, ����� 6.5\" AMOLED (1080x2400), "
            + "Qualcomm Snapdragon 720G, ��� 4 ��, ����-������ 128 ��, ����� ������, ������ 64 ��, "
            + "����������� 4500 ���, 2 SIM, ����������� IP67";

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
        assertEquals("� �������", productPage.getInCartText());
    }



}
