package web.translate.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.util.elements.Button;
import web.util.elements.EditBox;
import web.util.page.BasePage;

public class MainPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[1]/c-wiz/div[2]/button")
    private Button chooseLangOnTheLeft;
    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[2]/c-wiz/div[1]/div/div[3]/div/div[3]/div[6]")
    private Button chooseEnglish;
    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[1]/c-wiz/div[5]/button")
    private Button chooseLangOnTheRight;
    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[2]/c-wiz/div[2]/div/div[3]/div/div[2]/div[89]")
    private Button chooseRussian;
    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[1]/span/span/div/textarea")
    private EditBox textField;
    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[2]/div/div[8]/div/div[1]/span[1]/span/span")
    private WebElement translatedText;
    @FindBy(xpath = "//*[@id=\"kvLWu-0\"]/div[1]")
    private Button chooseVar;

    public MainPage(WebDriver driver) {
        super(driver);
        this.BASE_URL = "https://translate.google.com/";
        driver.get(BASE_URL);
    }

    @Step("Select English language for the left")
    public MainPage selectEnglishForTheLeft(){
        chooseLangOnTheLeft.click();
        chooseEnglish.click();
        return this;
    }

    @Step("Select Russian language for the right")
    public MainPage selectRussianForTheRight(){
        chooseLangOnTheRight.click();
        chooseLangOnTheRight.click();
        chooseRussian.click();
        chooseLangOnTheRight.click();
        return this;
    }

    @Step("Enter text on the left")
    public MainPage enterText(String text){
        textField.sendKeys(text);
        return this;
    }

    @Step("Validate UI")
    public String getTranslatedInfo(){
        chooseVar.click();
        try{
            translatedText.getText();
        } catch (Exception ignored){

        }
        return translatedText.getText();
    }

}
