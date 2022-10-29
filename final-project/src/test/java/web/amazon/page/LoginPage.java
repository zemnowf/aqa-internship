package web.amazon.page;

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

    public LoginPage openSignIn(){
        signInFormButton.click();
        return this;
    }

    public LoginPage typeEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage continueWithEmail(){
        continueButton.click();
        return this;
    }

    public LoginPage typePassword(String password){
       passwordField.sendKeys(password);
       return this;
    }

    public LoginPage submitSignIn(){
        signInSubmitButton.click();
        return this;
    }

    public LoginPage authAs(String email, String password){
        openSignIn();
        typeEmail(email);
        continueWithEmail();
        typePassword(password);
        return submitSignIn();
    }

    public String checkUsername(){
        return authText.getText();
    }

}
