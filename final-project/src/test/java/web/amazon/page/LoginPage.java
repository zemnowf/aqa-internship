package web.amazon.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.util.elements.Button;
import web.util.elements.EditBox;
import web.util.page.BasePage;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/span")
    private Button signInFormButton;
    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    private EditBox emailField;
    @FindBy(xpath = "//*[@id=\"continue\"]")
    private Button continueButton;
    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    private EditBox passwordField;
    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    private Button signInSubmitButton;
    @FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
    private WebElement authText;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.BASE_URL = "https://www.amazon.com";
        driver.get(BASE_URL);
    }

    @Step("Click on Sign-in")
    public LoginPage openSignIn(){
        signInFormButton.click();
        return this;
    }

    @Step("Enter valid value in field 'Email' and click on [Continue]")
    public LoginPage typeEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage continueWithEmail(){
        continueButton.click();
        return this;
    }

    @Step("Enter valid value in field 'Password' and click on [Sign-In]")
    public LoginPage typePassword(String password){
       passwordField.sendKeys(password);
       return this;
    }

    @Step("Submit signing in")
    public LoginPage submitSignIn(){
        signInSubmitButton.click();
        return this;
    }

    @Step("Authorisation: ")
    public LoginPage authAs(String email, String password){
        openSignIn();
        typeEmail(email);
        continueWithEmail();
        typePassword(password);
        return submitSignIn();
    }

    @Step("Check username")
    public String checkUsername(){
        return authText.getText();
    }

}
