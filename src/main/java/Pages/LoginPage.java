package Pages;

import Consts.Consts;

public class LoginPage extends BasePage{

    public static final String LOGIN_HEADER = "//*[contains(text(), 'Login')]";
    public static final String EMAIL_FIELD = "//input[@type='email'][@name='customer[email]']";
    public static final String PASSWORD_FIELD = "//input[@type='password'][@name='customer[password]']";
    public static final String SIGN_IN = "//input[@value='Sign In']";
    public static final String INCORRECT_CREDENTIALS = "//*[contains(text(), 'Incorrect email or password.')]";
    public void navigateToLoginPage(){
        webDriver.get(Consts.LOGIN_URL);
    }

    public boolean isPageTitleVisible(){
       return elementExists(LOGIN_HEADER);
    }
    public boolean isIncorrectCredentialsVisible(){
        return elementExists(INCORRECT_CREDENTIALS);
    }

    public LoginPage emptyFieldsLogin() throws InterruptedException {
        String emptyString = "";
        clickElementByXpath(EMAIL_FIELD);
        Thread.sleep(1000);
        sendTextToElementByXpath(EMAIL_FIELD,emptyString);
        clickElementByXpath(PASSWORD_FIELD);
        Thread.sleep(1000);
        sendTextToElementByXpath(PASSWORD_FIELD,emptyString);
        clickElementByXpath(SIGN_IN);
        return new LoginPage();
    }
}
