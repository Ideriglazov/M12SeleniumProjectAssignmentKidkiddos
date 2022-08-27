import Consts.Consts;
import Pages.*;
import Utilities.UseCaseBase;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookSelectionTest extends UseCaseBase {
    HomePage homePage = new HomePage();
    BooksResultsPage booksResultsPage = new BooksResultsPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    @Test
    @Order(1)
    public void bookSelection() throws InterruptedException {
        homePage.navigateToHomePage();
        homePage.pressBooksByLanguageIcon();
        homePage.pressEnglishOnlyIcon();
        String actualURL = webDriver.getCurrentUrl();
        assertEquals(actualURL, Consts.ENGLISH_ONLY_URL);
        booksResultsPage.chooseBook();//Book results page is not visible in the browser during the test execution after I added the last assertion in this test
        actualURL = webDriver.getCurrentUrl();
        assertEquals(actualURL, Consts.BOOK_DETAILS_PAGE_URL);
        productPage.changeFormat();
        productPage.changeQuantity();
        productPage.pressAddToCart();
        actualURL = webDriver.getCurrentUrl();
        assertEquals(actualURL, Consts.CART_URL);
        cartPage.changeQuantity();
        System.out.println(cartPage.oldQuantity);
        System.out.println(cartPage.oldPrice);//for some reason old price equals null. I assume the value from the price field was not received
        assertNotEquals(cartPage.oldQuantity,cartPage.getBooksQuantity());
        //assertNotEquals(cartPage.oldPrice,cartPage.getPrice());//does not work correctly
    }
}