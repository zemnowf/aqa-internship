package web.util.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomElement {
    private static final Duration DEFAULT_TIMEOUT_SECONDS = Duration.ofSeconds(5);
    protected WebElement webElement;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public CustomElement(WebElement webElement, WebDriver driver){
        this.webElement = webElement;
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS);
    }

    protected WebElement waitVisibility(){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected WebElement waitClickAbility(){
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


}
