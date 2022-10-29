package web.amazon;

import org.junit.jupiter.api.*;
import web.amazon.page.LoginPage;
import web.util.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmazonTest extends BaseTest {

    @Test
    public void auth(){
        LoginPage loginPage = new LoginPage(driver.get());
        loginPage.authAs(email, password);
        assertEquals("Hello, " + username, loginPage.checkUsername());
    }

}
