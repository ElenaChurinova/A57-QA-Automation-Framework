import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework24 extends BaseTest{
    @Test
    public void testLoginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // Login to Koel Page:
        loginPage.login();
        // Assertion
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
}
