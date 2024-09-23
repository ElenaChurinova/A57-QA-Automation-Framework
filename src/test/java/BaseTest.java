import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String baseUrl)throws MalformedURLException{
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        actions = new Actions (driver);
        navigateToPage(baseUrl);
    }
    @AfterMethod
    public void tearDown(){
        threadDriver.get().quit();
        threadDriver.remove();
    }
    public void navigateToPage(String url){
        getDriver().get(url);
    }
    public  WebDriver pickBrowser(String browser)throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
             String gridURL = "http://192.168.1.220:4444";
        switch(browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*", "--incognito","--allow-notifications");
                return driver= new EdgeDriver();
            case "Safari":
                return driver = new SafariDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*", "--incognito","--allow-notifications");
                return driver = new ChromeDriver(chromeOptions);

        }
    }
    public WebDriver lambdaTest() throws MalformedURLException{
        String hubURL = "@hub.lambdatest.com/wd/hub";
        String userName ="elena.churinova";
        String accessKey = "vS7K4WY5BXqkTaBullkLWo4puBZi3fePcvU318b7DUSRNkQfBr";
        //Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion","128");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", userName);
        ltOptions.put("accessKey", accessKey);
        ltOptions.put("build", "Test");
        ltOptions.put("project", "Cloud test");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");
        capabilities.setCapability("LT:Options", ltOptions);
        return driver = new RemoteWebDriver(new URL("https://" + userName +":" + accessKey + hubURL),capabilities);
    }
}