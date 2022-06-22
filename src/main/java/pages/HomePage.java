package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The page that the user is on, after the login
 */
public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators using PageFactory
    @FindBy(id = "nav-link-new-post")
    WebElement newPostButton;

    @FindBy(xpath = "//i[@class='fas fa-sign-out-alt fa-lg']")
    WebElement logOutButton;

    @FindBy(id = "homeIcon")
    WebElement LogoButton;

    //Interaction Methods == actions/operations
    public void clickHomeIconButton(){
        LogoButton.click();
    }

    public void clickLogoutButton(){
        logOutButton.click();
    }

    // Assertion Methods
    public boolean isNewPostButtonDisplayed(){
        return newPostButton.isDisplayed();
    }
    public boolean isLogOutButtonDisplayed(){
        return logOutButton.isDisplayed();
    }


    // upper two can be combined in one assert method:
//    public boolean isUserLoggedIn(){
//        return logOutButton.isDisplayed() && newPostButton.isDisplayed();
//    }

    //toast message may be checked also - add assert method here and assertion in BaseTests


}
