package Pages;

import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage{
    private static final String FORMAT_DROPDOWN_LIST = "//div[@class='selector-wrapper js product-form__item']//descendant::select[@class='single-option-selector single-option-selector-product-template product-form__input']";
    private static final String QUANTITY_FIELD = "//div[@class='product-form__item product-form__item--quantity']//descendant::input[@name='quantity'][@type='number']";
    private static final String ADD_TO_CART_BUTTON = "//button[@name='add']";
    public void changeFormat(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FORMAT_DROPDOWN_LIST)));
        WebElement formatElement = webDriver.findElement(By.xpath(FORMAT_DROPDOWN_LIST));
        formatElement.click();
        Select dropDownElement = new Select(webDriver.findElement(By.xpath(FORMAT_DROPDOWN_LIST)));
        dropDownElement.selectByIndex(1);
    }
    public void changeQuantity(){
        WebElement quantityElement = webDriver.findElement(By.xpath(QUANTITY_FIELD));
        quantityElement.clear();
        quantityElement.sendKeys("5");
    }
    public void pressAddToCart(){
        WebElement addToCartElement = webDriver.findElement(By.xpath(ADD_TO_CART_BUTTON));
        addToCartElement.click();
        wait.until(ExpectedConditions.urlToBe(Consts.CART_URL));
    }
}
