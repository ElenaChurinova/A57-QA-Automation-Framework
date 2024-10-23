import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistsTests extends BaseTest{

    @Test
    public void testCreatePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String newPlaylistName = "OOO5";
        String expectedSuccessMsg = "Created playlist \"" + newPlaylistName + ".\"";

        // Login to Koel
        loginPage.login();
        // click create a new playlist btn
        homePage.clickNewPlaylistBtn();
        Thread.sleep(2000);
        //click New playlist option
        homePage.chosePlaylistOption();
        //create a playlist name
        homePage.enterNewPlaylistName(newPlaylistName);
        Thread.sleep(200);
        //Assert
        Assert.assertEquals(homePage.getNewPlaylistSuccessMsg(),expectedSuccessMsg);
    }
    @Test
    public void testDeletePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String name ="test25";
        String expectedDeletedMessage = "Deleted playlist \"" + name + ".\"";
        // Login to Koel
        loginPage.login();
        //click new Playlist Btn
       homePage.clickNewPlaylistBtn();
       //choose playlist option
        homePage.chosePlaylistOption();
       // enter new playlist name
        homePage.enterNewPlaylistName(name);
        Thread.sleep(5000);
        //delete playlist
        homePage.clickDeleteBtn();
        Thread.sleep(2000);
        //Assert
        Assert.assertEquals(homePage.getDeletedPlaylistSuccessMsg(),expectedDeletedMessage);
    }
    @Test
    public void testRenamePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String newPlaylistName ="kpo";
        String updatedPlaylistMsg = "Updated playlist \"" + newPlaylistName + ".\"";

        // Login to Koel
        loginPage.login();
        //chose playlist
        homePage.doubleClickPlaylist();
        //clear and rename playlist
        homePage.enterNewPlaylistName(newPlaylistName);
        Thread.sleep(2000);
        //Assert (Actual vs Expected)
        Assert.assertEquals(homePage.getUpdatedPlaylistSuccessMsg(),updatedPlaylistMsg);

    }

}
