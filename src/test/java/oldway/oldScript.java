package oldway;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class oldScript {

    ChromeDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown () throws InterruptedException {
        // driver.quit();
        driver.close();
    }

    @Test
    public void loginTest() {
        driver.get("http://training.skillo-bg.com/"); //getting the url
        WebElement loginButton = driver.findElement(By.id("nav-link-login"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();


        //  Thread.sleep(1000); //worst way of waiting - do not use
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='defaultLoginFormUsername']"));
        userNameField.sendKeys("S70520035352@S2");
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='defaultLoginFormPassword']"));
        passwordField.sendKeys("Ts05035352@S2");
        WebElement signInButton = driver.findElement(By.xpath("//button[@id='sign-in-button']"));
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-link-new-post']"))).click();
        WebElement newPostButton = driver.findElement(By.xpath("//a[@id='nav-link-new-post']"));
        Assert.assertTrue(newPostButton.isDisplayed());

    }



}
