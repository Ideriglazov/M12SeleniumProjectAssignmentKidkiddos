package Pages;

import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasePage{
    private static final String QUANTITY_FIELD = "//input[@class='cart__qty-input']";
    private static final String TOTAL = "//span[@class='cbb-price-symbol']//preceding-sibling::span[@class='cbb-price-digits']";
    private static final String UPDATE_BUTTON = "//input[@name='update'][@class='btn btn--secondary cart__update cart__update--large small--hide']";
    public String oldQuantity = "";
    public String oldPrice = "";
    public CartPage changeQuantity(){
        WebElement quantityElement = webDriver.findElement(By.xpath(QUANTITY_FIELD));
        oldQuantity = getBooksQuantity();
        oldPrice = getPrice();
        quantityElement.clear();
        quantityElement.sendKeys("6");
        WebElement updateElement = webDriver.findElement(By.xpath(UPDATE_BUTTON));
        updateElement.click();
        return new CartPage();
    }
    public String getBooksQuantity() {
        WebElement quantityElement = webDriver.findElement(By.xpath(QUANTITY_FIELD));
        return quantityElement.getAttribute("value");
    }
    public String getPrice() {
        WebElement totalElement = webDriver.findElement(By.xpath(TOTAL));
        return totalElement.getAttribute("value");
    }
}
