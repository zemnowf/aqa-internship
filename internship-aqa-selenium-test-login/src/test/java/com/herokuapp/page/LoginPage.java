package com.herokuapp.page;

import com.herokuapp.SecurePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage{
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy(css = "#login > button")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='flash success']")
    private WebElement successText;

    @FindBy(xpath = "//div[@class='flash error']")
    private WebElement errorText;

    public LoginPage typeLogin(String userLogin){
        loginField.sendKeys(userLogin);
        return this;
    }

    @Step("Password insert")
    public LoginPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Click on login submit button")
    public SecurePage clickSubmitButton(){
        submitButton.click();
        return new SecurePage(driver);
    }

    @Step("Valid authorization")
    public SecurePage loginWithValidCredentials(String userLogin, String password){
        this.typeLogin(userLogin);
        this.typePassword(password);
        this.clickSubmitButton();
        return new SecurePage(driver);
    }

    @Step("Invalid authorization")
    public LoginPage loginWithInvalidCredentials(String userLogin, String password){
        this.typeLogin(userLogin);
        this.typePassword(password);
        this.clickSubmitButton();
        return new LoginPage(driver);
    }

    @Step("Checking error message")
    public String getErrorText(){
        return errorText.getText();
    }

    @Step("Checking success message")
    public String getSuccessText(){
        return successText.getText();
    }

}
