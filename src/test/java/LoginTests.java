import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void testLoginSuccess() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        // Login to Koel Page:
        loginPage.login();
        // Assertion
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    String url = "https://qa.koel.app/";

     @Test (dataProvider = "NegativeLoginTestData")
    public void negativeLoginTests(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        // Login to Koel Page:
        loginPage.provideEmail(email).providePassword(password).clickLoginBtn();
        // Assert
        Assert.assertEquals(getDriver().getCurrentUrl(),url);
    }
}
