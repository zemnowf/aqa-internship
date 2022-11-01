package web.relax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import web.relax.page.PlacePage;
import web.relax.page.PosterPage;
import web.relax.page.SearchPage;
import web.util.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Relax Test")
public class RelaxTest extends BaseTest {

    protected static final String placeName = "Luna";
    protected static final String phone = "+375 33 676-87-06";
    protected static final String address = "Минск, Я. Купалы, 25";
    protected static final String workingHours = "до 00:00";
    protected static final String district = "Заводской";
    protected static final String cuisine = "Белорусская";
    protected static final String category = "КИНО";

    @Test
    @DisplayName("Search validation")
    public void validateSearch(){
        SearchPage searchPage = new SearchPage(driver.get());
        searchPage.insertPlaceName(placeName);
        searchPage.clickOnPlaceButton();
        PlacePage placePage = new PlacePage(driver.get());
        String currentAddress = placePage.getAddressInfo();
        String currentWorkingHours = placePage.getWorkingHoursInfo();
        placePage.clickOnPhonesButton();
        String currentPhone = placePage.getPhoneInfo();
        placePage.closePhoneInfo();
        Assertions.assertAll(() -> assertEquals(phone, currentPhone),
                () -> assertEquals(address, currentAddress),
                () -> assertEquals(workingHours, currentWorkingHours));
    }

    @Test
    @DisplayName("Filters validation")
    public void validateFilters(){
        SearchPage searchPage = new SearchPage(driver.get());
        searchPage.clickOnFoodButton();
        searchPage.clickOnRestaurantsButton();
        searchPage.applyFilters();
        searchPage.openFilters();
        Assertions.assertAll(() -> assertEquals(district, searchPage.getDistrictInfoText()),
                () -> assertEquals(cuisine, searchPage.getCuisineInfoText()));
    }

    @Test
    @DisplayName("Poster validation")
    public void validatePoster(){
        PosterPage posterPage = new PosterPage(driver.get());
        posterPage.clickOnCardLink();
        Assertions.assertAll(() -> assertEquals(category, posterPage.getCategoryInfoText()),
                () -> assertTrue(posterPage.getFeedbackSectionPresented()));
    }
}
