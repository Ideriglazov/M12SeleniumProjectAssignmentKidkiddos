import Pages.LoginPage;
import Pages.HomePage;
import Utilities.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest extends UseCaseBase {
    @Test
    public void emptyFieldsLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.emptyFieldsLogin();
        boolean isLoaded = loginPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }
}