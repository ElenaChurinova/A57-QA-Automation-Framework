package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

        // Web Element:
        @FindBy (css = "img.avatar")
        WebElement avatarIcon;
        @FindBy (css = "a.view-profile")
        WebElement userProfile;
        @FindBy(css = "li a.songs")
        WebElement allSongs;
        @FindBy(xpath = "//section[@id='songsWrapper']//tr[@class='song-item'][1]")
        WebElement firstSong;
        @FindBy(css = "div[data-testid='sound-bar-play']")
        WebElement soundBarIcon;
        @FindBy(xpath = "//*[@id=\"songsWrapper\"]/header/div[3]/span/button[2]")
        WebElement addToBtn;
        @FindBy(xpath = "//section[@id='songsWrapper']//li[contains(text(),'test3')]")
        WebElement playlist;
        @FindBy(css ="div.success.show")
        WebElement successMsg;
        @FindBy(css = "[data-testid=\"play-btn\"]")
        WebElement play;
        @FindBy(css ="li.playback")
        WebElement playback;
        @FindBy(xpath ="//*[@id='playlists']/h1/i")
        WebElement newPlaylist;
        @FindBy(css="[data-testid='playlist-context-menu-create-simple']")
        WebElement playlistOption;
        @FindBy(css ="[name='name']")
        WebElement playlistInputField;
        @FindBy(css ="#playlists > ul > li:nth-child(6) > a")
        WebElement playlistToRename;
        @FindBy(xpath="//*[@id='playlistWrapper']/header/div[3]/span/button")
        WebElement deletePlaylistBtn;




        //Methods:
        public WebElement getUserAvatar() {
            return avatarIcon;
        }
        public void clickUserProfile(){
            userProfile.click();
        }
        ///////////////////////////////////
        public void clickAllSongs(){
            allSongs.click();
        }
        public void doubleClickFirstSong(){
            actions.doubleClick(firstSong).perform();
        }
        public WebElement getSoundBarVisualizer(){
            return soundBarIcon;
        }
        ////////////////////////////////////
        public void clickFirstSong(){
            firstSong.click();
        }
        public void clickAddToBtn(){
            addToBtn.click();
        }
        public void choosePlaylist(){
            playlist.click();
        }
        public String getAddToPlaylistSuccessMsg(){
            return successMsg.getText();
        }
        ////////////////////////////////////////
        public WebElement hoverPlay(){
            actions.moveToElement(play).perform();
            return wait.until(ExpectedConditions.visibilityOf(play));
        }
        public void contextClickFirstSong(){
            actions.contextClick(firstSong).perform();
        }
        public void chosePlayOption(){
            playback.click();
        }
        ///////////////////////////////////////////
        public void clickNewPlaylistBtn(){
           newPlaylist.click();
        }
        public void chosePlaylistOption(){
            playlistOption.click();
        }
        public void enterNewPlaylistName(String name){
            playlistInputField.clear();
            playlistInputField.sendKeys(name);
            playlistInputField.sendKeys(Keys.ENTER);
        }
        public String getNewPlaylistSuccessMsg(){
            return successMsg.getText();
        }
        //////////////////////////////////////////


        public void clickDeleteBtn(){
            deletePlaylistBtn.click();
        }
        public String getDeletedPlaylistSuccessMsg(){
           return successMsg.getText();
        }

        ////////////////////////////////////////
        public void doubleClickPlaylist(){
            actions.doubleClick(playlistToRename).perform();
        }
        public String getUpdatedPlaylistSuccessMsg(){
            return successMsg.getText();
        }
        ///////////////////////////////////////










}
