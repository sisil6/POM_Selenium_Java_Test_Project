package pomScripts;
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
import Screenshots.Screenshots;

import java.time.Duration;

public class BaseTest {

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

}