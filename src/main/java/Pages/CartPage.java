package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{
    private static final String QUANTITY_FIELD = "//input[@class='cart__qty-input']";
    private static final String TOTAL = "//span[@class='cbb-price-symbol']//preceding-sibling::span[@class='cbb-price-digits']";
    private static final String UPDATE_BUTTON = "//input[@name='update'][@class='btn btn--secondary cart__update cart__update--large small--hide']";

    public void changeQuantity(String newQuantity){
        WebElement quantityElement = webDriver.findElement(By.xpath(QUANTITY_FIELD));
        quantityElement.clear();
        quantityElement.sendKeys(newQuantity);
        WebElement updateElement = webDriver.findElement(By.xpath(UPDATE_BUTTON));
        updateElement.click();
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
