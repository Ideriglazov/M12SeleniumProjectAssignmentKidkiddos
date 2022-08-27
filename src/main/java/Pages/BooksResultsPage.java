package Pages;

import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BooksResultsPage extends BasePage {

    private static final String CLOSE_ICON = "//*[@class='_close-icon']";
    private static final String BOOK_ICON = "//*[@href='/collections/english-only/products/i-love-to-eat-fruits-and-vegetables-childrens-book-english-only']";
    Actions actions = new Actions(webDriver);
    public BooksResultsPage chooseBook(){
        WebElement bookElement = webDriver.findElement(By.xpath(BOOK_ICON));
        actions.moveToElement(bookElement).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CLOSE_ICON)));
        WebElement closeIconElement = webDriver.findElement(By.xpath(CLOSE_ICON));
        closeIconElement.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CLOSE_ICON)));
        bookElement.click();
        return new BooksResultsPage();
    }
}
