package com.herokuapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {
    public ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:/Program Files/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void close(){
        driver.quit();
    }

}
