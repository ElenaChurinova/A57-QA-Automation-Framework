package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);

    }
        // Web Element:
        @FindBy (css = "img[class='avatar']")
        WebElement avatarIcon;

        public WebElement getUserAvatar(){
            return avatarIcon;
        }



}
