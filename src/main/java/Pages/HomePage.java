package Pages;

import Consts.Consts;

public class HomePage extends BasePage{

    private static final String LOGIN_ICON = "//*[@href='/account/login']";

    public void navigateToHomePage(){
        webDriver.get(Consts.MAIN_URL);
    }



    public LoginPage pressLoginIcon(){
        clickElementByXpath(LOGIN_ICON);
        return new LoginPage();//Что значит такой синтаксис?
    }

}
