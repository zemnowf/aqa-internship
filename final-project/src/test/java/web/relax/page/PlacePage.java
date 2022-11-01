package web.relax.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.util.elements.Button;
import web.util.elements.IFrame;
import web.util.page.BasePage;

public class PlacePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"root\"]/div[3]/div[1]/div[8]/div/div/a[2]")
    private Button phonesButton;
    @FindBy(xpath = "/html/body/div[8]/div/div[3]/div/div[1]/div[1]/main/ul/li[1]/div[1]/a/span[1]")
    private WebElement phoneInfo;
    @FindBy(xpath = "/html/body/div[8]/div/div[2]/div")
    private Button closePhoneInfoButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div[3]/div[1]/div[7]/div/div/button[1]/span")
    private WebElement addressInfo;
    @FindBy(xpath = "//*[@id=\"root\"]/div[3]/div[1]/div[7]/div/div/button[2]/span")
    private WebElement workingHoursInfo;
    @FindBy(xpath = "/html/body/div[9]/div/div[3]")
    private IFrame phonesFrame;


    public PlacePage(WebDriver driver) {
        super(driver);
    }

    public PlacePage clickOnPhonesButton(){
        phonesButton.click();
        try{
            phonesFrame.switchTo();
        } catch (Exception e){
            return this;
        }
        return this;
    }

    public String getPhoneInfo(){
        return phoneInfo.getText();
    }

    public PlacePage closePhoneInfo(){
        closePhoneInfoButton.click();
        return this;
    }

    @Step("Check Phone, Address and Working Hours")
    public String getAddressInfo(){
        return addressInfo.getText();
    }

    public String getWorkingHoursInfo(){
        return workingHoursInfo.getText();
    }


}
