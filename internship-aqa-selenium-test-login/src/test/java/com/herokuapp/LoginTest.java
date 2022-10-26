package com.herokuapp;

import com.herokuapp.page.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@DisplayName("Herokuapp login web tests")
public class LoginTest extends WebDriverSettings{

    @Test
    @DisplayName("Invalid credentials authorization")
    public void testFailedLogin() {
        log.info("test run, driver run");
        driver.get("https://the-internet.herokuapp.com/login");

        loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.loginWithInvalidCredentials("dad", "SuperSecretPassword!");
        String error = loginPage.getErrorText();
        assertEquals("Your username is invalid!", error.substring(0, 25));
    }

    @Test
    @DisplayName("Valid credentials authorization")
    public void testSuccessLogin(){
        log.info("test run, driver run");
        driver.get("https://the-internet.herokuapp.com/login");

        loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.loginWithValidCredentials("tomsmith", "SuperSecretPassword!");
        String error = loginPage.getSuccessText();
        assertEquals("You logged into a secure area!", error.substring(0, 30));

    }
}
