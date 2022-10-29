package web.util.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.util.elements.ElementsDecorator;

import java.time.Duration;

public abstract class BasePage {
    protected String BASE_URL;
    private static final Duration DEFAULT_TIMEOUT_SECONDS = Duration.ofSeconds(20);

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        ElementLocatorFactory factory = new DefaultElementLocatorFactory(driver);
        ElementsDecorator decorator = new ElementsDecorator(factory, driver);
        PageFactory.initElements(decorator, this);
    }

    protected WebElement waitVisibility(WebElement locator){
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    protected void waitAndClick(WebElement locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

}
