package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(css = ".cbb-price-digits")
    public List<WebElement> TOTAL;
    @FindBy(xpath = "//input[@class='cart__qty-input']")
    public WebElement QUANTITY_FIELD;
    @FindBy(xpath = "//input[@name='update'][@class='btn btn--secondary cart__update cart__update--large small--hide']")
    public WebElement UPDATE_BUTTON;

    public CartPage() {
        PageFactory.initElements(webDriver,this);//Этот конструктор нужен для использования @FindBy
    }


    public void changeQuantity(String newQuantity){
        QUANTITY_FIELD.clear();
        QUANTITY_FIELD.sendKeys(newQuantity);
        UPDATE_BUTTON.click();
    }
    public String getBooksQuantity() {
        return QUANTITY_FIELD.getAttribute("value");
    }
    public String getPrice(int key) {
        return TOTAL.get(key).getText();
    }
}
