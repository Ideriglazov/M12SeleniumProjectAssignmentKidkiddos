package Pages;

import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    private static final String LOGIN_ICON = "//*[@href='/account/login']";
    private static final String BOOKS_BY_LANGUAGE_ICON = "//*[@href='/collections'][contains(text(), 'Books by language')]//following-sibling::*[@role='presentation']";
    private static final String ENGLISH_ONLY_ICON = "//*[@href='/collections/english-only'][contains(text(), 'English Only')][@class='site-nav__link site-nav__child-link']";
    public void navigateToHomePage(){
        webDriver.get(Consts.MAIN_URL);
    }



    public LoginPage pressLoginIcon(){
        clickElementByXpath(LOGIN_ICON);
        return new LoginPage();//Что значит такой синтаксис?
    }
    public HomePage pressBooksByLanguageIcon(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BOOKS_BY_LANGUAGE_ICON)));
        clickElementByXpath(BOOKS_BY_LANGUAGE_ICON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ENGLISH_ONLY_ICON)));
        return new HomePage();//Что значит такой синтаксис?
    }
    public HomePage pressEnglishOnlyIcon(){
        clickElementByXpath(ENGLISH_ONLY_ICON);
        wait.until(ExpectedConditions.urlToBe(Consts.ENGLISH_ONLY_URL));
        return new HomePage();//Что значит такой синтаксис?
    }
    public boolean isPageLoaded() {
        if (webDriver.getCurrentUrl() == Consts.ENGLISH_ONLY_URL) {
            return true;
        }
        else {
            return false;
        }
    }
}
