package web.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    @BeforeEach
    public void createDriver(){
        driver.set(WebDriverFactory.getWebDriver());
        driver.get().manage().window().maximize();
    }

    @AfterEach
    public void disposeDriver(){
        if(driver != null){
            driver.get().quit();
        }
    }

}
