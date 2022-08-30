import Consts.Consts;
import Pages.LoginPage;
import Pages.HomePage;
import Utilities.UseCaseBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginNegativeTest extends UseCaseBase {
    HomePage homePage = new HomePage();
    @Test
    @Order(1)
    public void openLoginPage() {
        homePage.navigateToHomePage();
        LoginPage loginPage = homePage.pressLoginIcon();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginPage.SIGN_IN_BUTTON)));
        boolean isLoadedButton = loginPage.isSignInButtonVisible();
        assertTrue(isLoadedButton);
    }

    @Test
    @Order(2)
    public void emptyFieldsLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.emptyFieldsLogin();
        boolean isLoadedIncorrectCredentials = loginPage.isIncorrectCredentialsVisible();
        boolean isLoadedCaptcha = loginPage.isCaptchaVisible();
        if (isLoadedIncorrectCredentials) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginPage.INCORRECT_CREDENTIALS)));
            assertTrue(isLoadedIncorrectCredentials);
        }
        else  {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginPage.CAPTCHA)));
            assertTrue(isLoadedCaptcha);
        }
    }

    @Test
    @Order(3)
    public void incorrectCredentialsLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        if (webDriver.getCurrentUrl() != Consts.LOGIN_URL) {
            webDriver.get(Consts.LOGIN_URL);
        }
        loginPage.incorrectCredentialsLogin();
        String actualURL = webDriver.getCurrentUrl();
        assertEquals(actualURL, Consts.LOGIN_URL);
    }
}
