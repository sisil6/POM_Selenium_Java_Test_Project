package CucumberFirstTests
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.WebDriverWait
import CucumberFirstTests.*
import pages.LoginModal
import pages.SignUpModal
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.DefaultPage;
import pages.HomePage;
import pages.LoginModal;
import pages.SignUpModal;
import sun.jvm.hotspot.utilities.Assert
import sun.security.util.PendingException
import java.time.Duration
import pages.DefaultPage;

public class MyStepDefs {

    WebDriver driver;
    DefaultPage defaultPage;
    LoginModal loginModal;
    HomePage homePage;
    SignUpModal signUpModal;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
        defaultPage = new DefaultPage(driver);
        loginModal = new LoginModal(driver);
        homePage = new HomePage(driver);
        signUpModal = new SignUpModal(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Page load
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            Screenshots.capture(driver, "screenshots", result.getName());
        }
        driver.quit();
    }



    String URL = "http://training.skillo-bg.com/";

    //Locators
    @FindBy(id = "nav-link-login")
    WebElement loginButton;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerButton;

    @FindBy(id = "sign-in-button")
    WebElement signInButton;


    @Given("I am loaded the Skillo testing web page for a first time")
    public void loadSkilloURL() {
        driver.get(URL);
    }

    @When("I tap on the Login button")
    public void iTapOnTheLoginButton() {
        loginButton.click();
        }

    @Then("I am navigated to the login page")
    public void iAmNavigatedToTheLoginPage() {
        assert signInButton.isDisplayed();
    }
}

