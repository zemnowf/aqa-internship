package web.onliner.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.util.elements.Button;
import web.util.elements.IFrame;
import web.util.page.BasePage;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div[4]/h1")
    private WebElement productPageHeader;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/main/div/div/div[1]/div[2]/div[2]/p")
    private WebElement productDescription;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/main/div/div/div[2]/div[1]/div/div[3]/div/div[4]/div[1]/div/div/div[2]/div[1]/a[2]")
    private Button addToCartButton;
    @FindBy(xpath = "//*[@id=\"userbar\"]/div[2]/div/a/div")
    private WebElement cartIcon;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/main/div/div/div[2]/div[1]/div/div[3]/div/div[4]/div[1]/div/div[2]/div[2]")
    private IFrame sideBar;
    @FindBy(xpath = "//*[@id=\"userbar\"]/div[2]/div/a")
    private Button cartButton;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/main/div/div/div[2]/div[1]/div/div[3]/div/div[4]/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/a[2]")
    private Button goToCartButton;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/main/div/div/div[2]/div[1]/div/div[3]/div/div[1]/div[2]/div[1]/div/div/div/div/div[2]/span[1]")
    private Button confirmCityButton;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/main/div/div/div[2]/div[1]/div/div[3]/div/div[4]/div[1]/div/div/div[2]/div[1]/a[2]")
    private WebElement inCartText;


    public ProductPage(WebDriver driver, String url) {
        super(driver);
        this.BASE_URL = url;
        driver.get(BASE_URL);
    }

    @Step("Compare actual and expected product name")
    public String getActualProductPriceList(){
        return productPageHeader.getText();
    }

    @Step("Check the module with the description is displayed")
    public String getDescription(){
        return productDescription.getText();
    }

    @Step("Add to cart")
    public ProductPage addProductToCart(){
        addToCartButton.click();
        return this;
    }

    public ProductPage switchToSideBar(){
        sideBar.switchTo();
        goToCartButton.click();
        return this;
    }

    public String getCartIconValue(){
        return cartIcon.getText();
    }

    public ProductPage clickOnCartButton(){
        cartButton.click();
        return this;
    }

    public ProductPage clickOnConfirmCityButton(){
        confirmCityButton.click();
        return this;
    }

    public String getInCartText(){
        return inCartText.getText();
    }

}
