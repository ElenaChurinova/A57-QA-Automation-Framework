import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTests extends BaseTest{

    @Test
    public void testPlaySong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // Login to Koel
        loginPage.login();
        //click All Songs
        homePage.clickAllSongs();
        // double click first song
        homePage.doubleClickFirstSong();
        //Assertion
        Assert.assertTrue(homePage.getSoundBarVisualizer().isDisplayed());
    }



    @Test
    public void testAddSongToPlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedSuccessMsg = "Added 1 song into \"test3.\"";
        //Login to Koel
        loginPage.login();
        //click All songs
        homePage.clickAllSongs();
        //click first song in a list
        homePage.clickFirstSong();
        //click Add to Btn
        homePage.clickAddToBtn();
        //click test3 playlist
        homePage.choosePlaylist();
        Thread.sleep(2000);
        //Assertion actual vs expected
        Assert.assertEquals(homePage.getAddToPlaylistSuccessMsg(),expectedSuccessMsg);
    }

    @Test
    public void testHoverOverPlayBtn() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Login to Koel
        loginPage.login();
        //click All songs
        homePage.clickAllSongs();
        //click first song in a list
        homePage.clickFirstSong();
        //hover over Play Btn
        homePage.hoverPlay();
        //Assert
        Assert.assertTrue(homePage.hoverPlay().isDisplayed());
    }

    @Test
    public void testContextClickSong(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Login to Koel
        loginPage.login();
        //click All songs
        homePage.clickAllSongs();
        //context click first song
        homePage.contextClickFirstSong();
        //choose option
        homePage.chosePlayOption();
        //Assert
        Assert.assertTrue(homePage.getSoundBarVisualizer().isDisplayed());

    }
}
