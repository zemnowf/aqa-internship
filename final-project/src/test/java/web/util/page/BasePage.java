package web.util.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import web.util.elements.ElementsDecorator;


public abstract class BasePage {
    protected String BASE_URL;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        ElementLocatorFactory factory = new DefaultElementLocatorFactory(driver);
        ElementsDecorator decorator = new ElementsDecorator(factory, driver);
        PageFactory.initElements(decorator, this);
    }

}
