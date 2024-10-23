package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    // Web Elements
    @FindBy (css = "input[type='email']")
    WebElement emailField;

    @FindBy (css = "input[type='password']")
    WebElement passwordField;

    @FindBy (css = "button[type='submit']")
    WebElement clickBtn;

    //Helper methods

    public LoginPage provideEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickLoginBtn(){
        clickBtn.click();
        return this;
    }

    public void login(){
        provideEmail("elena.churinova@testpro.io");
        providePassword("skL&mpg67");
        clickLoginBtn();
    }

}
