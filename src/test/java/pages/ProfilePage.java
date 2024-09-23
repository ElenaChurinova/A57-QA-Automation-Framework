package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    // Web Elements:
    @FindBy (css = "[data-testid='theme-card-oak']")
    WebElement oakTheme;
    @FindBy (css = "[data-testid='theme-card-oak'][class='theme selected']")
    WebElement oakThemeSelected;

    //Methods:
    public void clickOakTheme(){
        oakTheme.click();
    }
    public boolean isOakThemeSelected(){
        //findElement((By) oakThemeSelected);
        return oakThemeSelected.isDisplayed();
    }


}
