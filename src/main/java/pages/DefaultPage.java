package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * DefaultPage -> HomePage -> NewPostPage
 * The page that is open when the URL is hit.
 */

public class DefaultPage extends BasePage {

        public DefaultPage(WebDriver driver) {
            super(driver);
        }


        //Locators
        @FindBy(id = "nav-link-login")
        WebElement loginButton;

        @FindBy(xpath = "//a[normalize-space()='Register']")
        WebElement registerButton;

        @FindBy(id = "sign-in-button")
        WebElement signInButton;

        //Methods
            public void clickLoginButton(){
                loginButton.click();
            }

            public void clickSignInButton(){
                signInButton.click();
            }

            public void clickRegisterButton(){
                registerButton.click();
            }

//Assert
    public boolean isLogInButtonDisplayed(){
        return loginButton.isDisplayed();
    }
}
