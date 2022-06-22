package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginModal extends BasePage{

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    //Locators
    By userNameField = By.xpath("//input[@id='defaultLoginFormUsername']");
    By passwordField = By.xpath("//input[@id='defaultLoginFormPassword']");
    By signInButton = By.xpath("//button[@id='sign-in-button']");


    //Methods
    public void inputUsername(String username){
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn(){
        driver.findElement(signInButton).click();
    }
 //this: can combine all methids, but if they are needed separate it is better to be on their own
//    public void commonMethod(){
//        enterUsername();
//        enterPassword();
//
//    }


}
