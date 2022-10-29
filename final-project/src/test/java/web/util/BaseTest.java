package web.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected static final String email = "salondznts@gmail.com";
    protected static final String password = "testpassword";
    protected static final String username = "Daniil";


    @BeforeEach
    public void createDriver(){
        driver.set(WebDriverFactory.getWebDriver());
    }

    @AfterEach
    public void disposeDriver(){
        if(driver != null){
            driver.get().quit();
        }
    }

}
