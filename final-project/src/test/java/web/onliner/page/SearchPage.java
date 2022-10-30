package web.onliner.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.util.elements.Button;
import web.util.elements.EditBox;
import web.util.elements.IFrame;
import web.util.page.BasePage;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"fast-search\"]/form/input[1]")
    private EditBox searchField;
    @FindBy(xpath = "//*[@id=\"fast-search-modal\"]/div/div/iframe")
    private IFrame searchIFrame;
    @FindBy(xpath = "//*[@id=\"search-page\"]/div[2]/ul/li/div/div/div[1]/div/a")
    private Button productFromSearch;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div[4]/h1")
    private WebElement productPageHeader;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.BASE_URL = "https://www.onliner.by";
        driver.get(BASE_URL);
    }

    @Step("Enter valid value in the search field")
    public SearchPage searchProduct(String productName){
        searchField.sendKeys(productName);
        return this;
    }

    @Step("Select the product from the list, click on search")
    public SearchPage clickOnFoundProduct(){
        searchIFrame.switchTo();
        productFromSearch.click();
        return this;
    }

    public String getProductPageHeaderText(){
        return productPageHeader.getText();
    }


}
