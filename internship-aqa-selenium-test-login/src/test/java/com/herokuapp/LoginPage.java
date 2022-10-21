package com.herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public LoginPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public SecurePage clickSubmitButton(){
        submitButton.click();
        return new SecurePage(driver);
    }

    public SecurePage loginWithValidCredentials(String userLogin, String password){
        this.typeLogin(userLogin);
        this.typePassword(password);
        this.clickSubmitButton();
        return new SecurePage(driver);
    }

    public LoginPage loginWithInvalidCredentials(String userLogin, String password){
        this.typeLogin(userLogin);
        this.typePassword(password);
        this.clickSubmitButton();
        return new LoginPage(driver);
    }

    public String getErrorText(){
        return errorText.getText();
    }

    public String getSuccessText(){
        return successText.getText();
    }

    @Test
    public void testSuccessLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        loginField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");

        submitButton.click();
    }

    @Test
    public void testFailLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("wrongUser");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("WrongPassword!");

        driver.findElement(By.cssSelector("#login > button")).click();


    }

}
