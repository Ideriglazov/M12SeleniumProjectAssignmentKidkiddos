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
        String oldQuantity = cartPage.getBooksQuantity();
        String oldPrice = cartPage.getPrice();
        cartPage.changeQuantity("6");
        String newQuantity = cartPage.getBooksQuantity();
        String newPrice = cartPage.getPrice();
        System.out.println(oldQuantity);
        System.out.println(oldPrice);
        System.out.println(newQuantity);
        System.out.println(newPrice);
        assertNotEquals(oldQuantity,newQuantity);
        //assertNotEquals(oldPrice,newPrice);
    }
}