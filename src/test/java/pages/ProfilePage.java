package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Web Elements:
    @FindBy (css = "[data-testid='theme-card-oak']")
    WebElement oakTheme;
    @FindBy (css = "[data-testid='theme-card-oak'][class='theme selected']")
    WebElement oakThemeSelected;
////////////////////////////////////////////////////
    @FindBy(css="[name='current_password']")
    WebElement currentPasswordField;
    @FindBy(css="#inputProfileName")
    WebElement profileName;
    @FindBy(css="button.btn-submit")
    WebElement saveBtn;
    @FindBy(css="a.view-profile>span")
    public WebElement actualProfileName;

    //Methods:
    public void clickOakTheme(){
        oakTheme.click();
    }
    public boolean isOakThemeSelected(){
        return oakThemeSelected.isDisplayed();
    }
///////////////////////////////////////////////////
    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", ""); //adkskldjsad23dmdj
    }
    public void provideCurrentPassword(String currentPassword){
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }
    public void provideProfileName(String newProfileName){
        profileName.clear();
        profileName.sendKeys(newProfileName);
    }
    public void clickOnSaveBtn(){
        saveBtn.click();
    }


}
