package Pages;

public class LoginPage extends BasePage{

    public static final String LOGIN_HEADER = "//*[contains(text(), 'Login')]";
    public static final String EMAIL_FIELD = "//input[@type='email'][@name='customer[email]']";
    public static final String PASSWORD_FIELD = "//input[@type='password'][@name='customer[password]']";
    public static final String SIGN_IN = "//input[@value='Sign In']";

    public boolean isPageTitleVisible(){
       return elementExists(LOGIN_HEADER);
    }
    public LoginPage emptyFieldsLogin(){
        String emptyString = "";
        sendTextToElementByXpath(EMAIL_FIELD,emptyString);
        sendTextToElementByXpath(PASSWORD_FIELD,emptyString);
        clickElementByXpath(SIGN_IN);
        return new LoginPage();
    }
}
