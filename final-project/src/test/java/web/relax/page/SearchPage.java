package web.relax.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.util.elements.Button;
import web.util.elements.EditBox;
import web.util.elements.IFrame;
import web.util.page.BasePage;

import java.util.ServiceConfigurationError;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"search_open\"]")
    private WebElement searchField;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div/div[2]/div[2]/div/div/ul/div[1]/div[2]/div[1]/a[1]")
    private Button goToPlacePageButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div/div[1]")
    private Button foodButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[1]/a")
    private Button restaurantsLink;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[5]/div/div/div/div[3]/div")
    private Button filterMenuButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[11]/div[2]/div[2]/div[2]")
    private Button chooseDistrictButton;
    @FindBy(xpath = "/html/body/div[8]/div/div[2]/div/div[2]/div")
    private Button chooseDistrictRadio;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[11]/div[2]/div[4]/label/span[1]")
    private Button takeAwayRadio;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[11]/div[2]/div[9]/div[2]/div")
    private Button chooseCuisineListButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[11]/div[2]/div[9]/div[2]/label[9]/span")
    private Button chooseCuisineButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[11]/div[2]/div[28]/div[2]/label[1]/span")
    private Button takeAwayMenu;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[11]/div[3]/button[2]/span")
    private Button showResultsWithFiltersButton;
    @FindBy(xpath = "//*[@id=\"Content\"]/main/div/div[1]/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[3]/div/a[2]")
    private Button placeNameLink;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[11]/div[2]/div[2]/div[2]/span")
    private WebElement districtInfo;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[11]/div[2]/div[9]/div[2]/label[9]/span")
    private WebElement cuisineInfo;


    public SearchPage(WebDriver driver) {
        super(driver);
        this.BASE_URL = "https://www.relax.by";
        driver.get(BASE_URL);
    }

    @Step("Input place name in the search textbox")
    public SearchPage insertPlaceName(String placeName){
        searchField.sendKeys(placeName);
        return this;
    }

    @Step("Select result")
    public PlacePage clickOnPlaceButton(){
        goToPlacePageButton.click();
        return new PlacePage(driver);
    }

    @Step("Select 'Еда' in the top menu")
    public SearchPage clickOnFoodButton(){
        foodButton.click();
        return this;
    }

    @Step("Select 'Рестораны'")
    public SearchPage clickOnRestaurantsButton(){
        restaurantsLink.click();
        return this;
    }

    @Step("Open filters")
    public SearchPage openFilters(){
        filterMenuButton.click();
        return this;
    }

    @Step("Apply filters")
    public SearchPage applyFilters(){
        openFilters();
        try{
            chooseDistrictButton.click();
        } catch (Exception e){
            chooseDistrictButton.click();
        }
        chooseDistrictRadio.click();
        takeAwayRadio.click();
        chooseCuisineListButton.click();
        chooseCuisineButton.click();
        takeAwayMenu.click();
        showResultsWithFiltersButton.click();
        return this;
    }

    public String getDistrictInfoText(){
        return districtInfo.getText();
    }

    public String getCuisineInfoText(){
        return cuisineInfo.getText();
    }

}
