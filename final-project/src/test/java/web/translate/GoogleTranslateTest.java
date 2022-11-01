package web.translate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import web.translate.page.MainPage;
import web.util.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Google Translate Tests")
public class GoogleTranslateTest extends BaseTest {

    protected static final String text = "Test";
    protected static final String translatedText = "Тест";

    @Test
    @DisplayName("UI Validation\n")
    public void validateInterface(){
        MainPage mainPage = new MainPage(driver.get());
        mainPage.selectEnglishForTheLeft();
        mainPage.selectRussianForTheRight();
        mainPage.enterText(text);
        assertEquals(translatedText, mainPage.getTranslatedInfo());
    }
}
