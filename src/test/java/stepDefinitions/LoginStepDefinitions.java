package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*","--incognito","--open-maximized","--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Given("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app");
    }
    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }
    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }
    @And("I submit")
    public void iSubmit() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtn();
        Thread.sleep(5000);
    }
    @Then("I am logged in")
    public void iAmLoggedIn() {
        HomePage homepage = new HomePage(driver);
        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());
    }


    @After
    public void iCloseBrowser(){
        driver.quit();
    }

    @And("I enter incorrect password {string}")
    public void iEnterIncorrectPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        LoginPage loginPage = new LoginPage(driver);
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(),url);;
    }

    @When("I enter not existing email {string}")
    public void iEnterNotExistingEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @When("I don't enter email {string}")
    public void iDonTEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I don't enter password {string}")
    public void iDonTEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }
}
