import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest{
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

    @Test
    public void changeProfileName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        // Login to Koel Page:
        loginPage.login();
        //click on user profile:
        homePage.clickUserProfile();
        //generate random name for profile
        String randomName = profilePage.generateRandomName();
        System.out.println("Random name is: "+randomName);
        //Current Password
        profilePage.provideCurrentPassword("skL&mpg67");
        //provide new Generated name
        profilePage.provideProfileName(randomName);
        //click on Save button
        profilePage.clickOnSaveBtn();
        Thread.sleep(2000);
        //Assertions (Actual vs Expected)
        Assert.assertEquals(profilePage.actualProfileName.getText(), randomName);

    }
}
