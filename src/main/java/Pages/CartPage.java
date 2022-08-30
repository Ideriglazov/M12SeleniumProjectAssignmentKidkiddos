package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage extends BasePage{
    private static final String QUANTITY_FIELD = "//input[@class='cart__qty-input']";
    @FindBy(css = ".cbb-price-digits")
    public List<WebElement> TOTAL;
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
    public String getPrice(int key) {
        return TOTAL.get(key).getText();
    }
}
