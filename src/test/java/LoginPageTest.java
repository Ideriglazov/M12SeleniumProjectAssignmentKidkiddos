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
    private static LoginPage loginPage;
    public static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    @BeforeAll
    public static void classSetup() {
        loginPage = new LoginPage();
    }


    @Test
    public void emptyFieldsLogin() {
        LoginPage loginPage = loginPage.emptyFieldsLogin();
        boolean isLoaded = loginPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }
}