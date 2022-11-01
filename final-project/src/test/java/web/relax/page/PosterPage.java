package web.relax.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.util.elements.Button;
import web.util.page.BasePage;

public class PosterPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"append-shcedule\"]/section[1]/div[2]/ul/div/div/li[2]/div/div/a[1]/img")
    private Button cardLink;
    @FindBy(xpath = "/html/body/div[5]/div[1]/div/div[3]/div[1]/div/div/div/a")
    private WebElement categoryInfo;
    @FindBy(xpath = "//*[@id=\"review_form\"]/div")
    private WebElement feedBackSection;

    public PosterPage(WebDriver driver) {
        super(driver);
        this.BASE_URL = "https://afisha.relax.by";
        driver.get(BASE_URL);
    }

    @Step("Open second card from section \"Афиша\"")
    public PosterPage clickOnCardLink(){
        cardLink.click();
        return this;
    }

    @Step("Check that openned advertisement has correct category")
    public String getCategoryInfoText(){
        return categoryInfo.getText();
    }

    @Step("Check that feedback section is presented")
    public boolean getFeedbackSectionPresented(){
        return feedBackSection.isDisplayed();
    }
}
