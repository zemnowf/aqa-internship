package com.herokuapp;

import com.herokuapp.page.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
@ExtendWith(ScreenshotExtension.class)
public class WebDriverSettings {
    public static ChromeDriver driver;
    public LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

//    @AfterEach
//    public void close(){
//
//        driver.quit();
//    }


}
