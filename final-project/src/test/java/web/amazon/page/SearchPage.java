package web.amazon.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.util.elements.Button;
import web.util.elements.EditBox;
import web.util.page.BasePage;

import java.util.Objects;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
    private EditBox searchField;
    @FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
    private Button searchButton;
    @FindBy(xpath = "//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")
    private WebElement resultText;
    @FindBy(xpath = "//*[@id=\"nav-cart-count\"]")
    private WebElement cartCount;
    @FindBy(xpath = "//*[@id=\"quantity_0\"]")
    private Button deleteFromCartButton;
    @FindBy(xpath = "//*[@id=\"nav-cart-text-container\"]")
    private Button cartButton;
    @FindBy(xpath = "//*[@id=\"sc-active-cart\"]/div/div/div[1]/h1")
    private WebElement activeCart;
    @FindBy(xpath = "//*[@id=\"a-autoid-0-announce\"]")
    private Button productQuantity;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.BASE_URL = "https://www.amazon.com";
        driver.get(BASE_URL);
    }

    @Step("Enter valid value in the search field (ex. 'iPhone')")
    public SearchPage typeProductName(String productName){
        searchField.sendKeys(productName);
        return this;
    }

    @Step("Click on [Search]")
    public SearchPage clickOnSearch(){
        searchButton.click();
        return this;
    }

    @Step("Check result of search")
    public String checkResult(){
        return resultText.getText();
    }

    @Step("Search products: ")
    public SearchPage searchProduct(String productName){
        typeProductName(productName);
        return clickOnSearch();
    }

    @Step("Click on the shopping cart icon")
    public SearchPage openCartPage(){
        cartButton.click();
        return this;
    }

    @Step
    public String checkProductInCart(){
        return activeCart.getText();
    }


    public SearchPage clearCart(){
        while (!Objects.equals(cartCount.getText(), "0")){
            productQuantity.click();
            deleteFromCartButton.click();
        }
        return this;
    }

}
