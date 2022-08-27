import Consts.Consts;
import Pages.BooksResultsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
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
    ProductPage productPage = new ProductPage();
    @Test
    @Order(1)
    public void bookSelection() throws InterruptedException {
        homePage.navigateToHomePage();
        homePage.pressBooksByLanguageIcon();
        homePage.pressEnglishOnlyIcon();
        String actualURL = webDriver.getCurrentUrl();
        assertEquals(actualURL, Consts.ENGLISH_ONLY_URL);
        booksResultsPage.chooseBook();
        actualURL = webDriver.getCurrentUrl();
        assertEquals(actualURL, Consts.BOOK_DETAILS_PAGE_URL);
        productPage.changeFormat();
    }
}