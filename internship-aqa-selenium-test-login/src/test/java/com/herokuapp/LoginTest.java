package com.herokuapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Herokuapp login web tests")
public class LoginTest extends WebDriverSettings{

    @Test
    @DisplayName("Invalid credentials authorization")
    public void testFailedLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.loginWithInvalidCredentials("dad", "SuperSecretPassword!");
        String error = loginPage.getErrorText();
        assertEquals("Your username is invalid!", error.substring(0, 25));
    }

    @Test
    @DisplayName("Valid credentials authorization")
    public void testSuccessLogin(){
        driver.get("https://the-internet.herokuapp.com/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.loginWithValidCredentials("tomsmith", "SuperSecretPassword!");
        String error = loginPage.getSuccessText();
        assertEquals("You logged into a secure area!", error.substring(0, 30));

    }
}
