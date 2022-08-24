import Pages.LoginPage;
import Pages.HomePage;
import Utilities.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest extends UseCaseBase {
    private static HomePage homePage;
    public static final Logger logger = LogManager.getLogger(HomePageTest.class);

    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateToHomePage();
    }


    @Test
    public void openLoginPage() {
        LoginPage loginPage = homePage.pressLoginIcon();
        boolean isLoaded = loginPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }
}
