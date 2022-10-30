package web.amazon.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.util.elements.Button;
import web.util.page.BasePage;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
    private Button addToCartButton;
    @FindBy(xpath = "//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")
    private WebElement successMessage;

    public ProductPage(WebDriver driver, String url) {
        super(driver);
        this.BASE_URL = url;
        driver.get(BASE_URL);
    }

    @Step("Click on [Add to Cart] on product’s page")
    public ProductPage addProductToCart(){
        addToCartButton.click();
        return this;
    }

    @Step("Check result")
    public String checkResult(){
        return successMessage.getText();
    }


}
