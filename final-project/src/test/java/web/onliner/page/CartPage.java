package web.onliner.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.util.elements.Button;
import web.util.page.BasePage;

public class CartPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/div[2]/div[1]/a")
    private WebElement addedProductInfo;
    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/div[4]/div/div[1]")
    private WebElement removeField;
    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/div[4]/div/div[1]/div/a")
    private Button removeProductButton;
    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div/div/div/div/div[2]/div/div[3]/div/div/div[2]/div/div[2]/div[2]/a[2]")
    private Button closeProductButton;
    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div/div/div/div/div[2]/div/div[3]/div/div/div[2]")
    private WebElement emptyCartInfo;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductInfoInCart(){
        return addedProductInfo.getText();
    }

    public CartPage clickOnRemoveProductButton(){
        removeField.click();
        removeProductButton.click();
        return this;
    }

    public CartPage clickOnCloseProductButton(){
        closeProductButton.click();
        return this;
    }

    public String getEmptyCartInfo(){
        return emptyCartInfo.getText();
    }

}
