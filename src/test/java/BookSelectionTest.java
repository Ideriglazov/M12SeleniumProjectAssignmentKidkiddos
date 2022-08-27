import Consts.Consts;
import Pages.BooksResultsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.UseCaseBase;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookSelectionTest extends UseCaseBase {
    HomePage homePage = new HomePage();
    BooksResultsPage booksResultsPage = new BooksResultsPage();
    @Test
    @Order(1)
    public void bookSelection() {
        homePage.navigateToHomePage();
        homePage.pressBooksByLanguageIcon();
        homePage.pressEnglishOnlyIcon();
        String actualURL = webDriver.getCurrentUrl();
        assertEquals(actualURL, Consts.ENGLISH_ONLY_URL);
        booksResultsPage.chooseBook();
        actualURL = webDriver.getCurrentUrl();
        assertEquals(actualURL, Consts.BOOK_DETAILS_PAGE_URL);
    }
}