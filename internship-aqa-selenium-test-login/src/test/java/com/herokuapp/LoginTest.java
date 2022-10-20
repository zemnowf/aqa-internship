package com.herokuapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends  WebDriverSettings{

    @Test
    public void testSuccessLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("#login > button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flash success']")));
    }

    @Test
    public void testFailLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("wrongUser");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("WrongPassword!");

        driver.findElement(By.cssSelector("#login > button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flash error']")));

    }

}
