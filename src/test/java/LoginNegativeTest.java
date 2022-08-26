import Pages.LoginPage;
import Pages.HomePage;
import Utilities.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginNegativeTest extends UseCaseBase {
    HomePage homePage = new HomePage();
    UseCaseBase useCaseBase = new UseCaseBase();


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
}
