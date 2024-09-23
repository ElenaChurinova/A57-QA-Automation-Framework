import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class Homework25 extends BaseTest{
    @Test
    public void testLoginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        // Login to Koel Page:
        loginPage.login();
        // Assertion
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void testChangeTheme() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        // Login to Koel Page:
        loginPage.login();
        //click on user profile:
        homePage.clickUserProfile();
        // click on oak theme
        profilePage.clickOakTheme();
        //Assertion:
        Assert.assertTrue(profilePage.isOakThemeSelected());
    }
}
