package pomScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTests extends BaseTest {

    int currentTime = (int) System.currentTimeMillis();
    String email = "Si" + currentTime + "@S2";
    String password = "Ts" + currentTime + "@S2";

    @Test
    public void signInTest() throws InterruptedException {
        driver.get("http://training.skillo-bg.com/");
        defaultPage.clickLoginButton();
        defaultPage.clickRegisterButton();
        signUpModal.inputUserName("Si" + currentTime);
        signUpModal.inputEmail(email);
        signUpModal.inputPassword(password);
        signUpModal.inputConfirmPassword(password);
        signUpModal.clickSignUpButton();

        Assert.assertTrue(homePage.isLogOutButtonDisplayed());
        Assert.assertTrue(homePage.isNewPostButtonDisplayed());

    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("http://training.skillo-bg.com/");
        defaultPage.clickLoginButton();
        loginModal.inputUsername("S70520035352@S2");
        loginModal.inputPassword("Ts05035352@S2");
        loginModal.clickSignIn();

        Assert.assertTrue(homePage.isLogOutButtonDisplayed());
        Assert.assertTrue(homePage.isNewPostButtonDisplayed());

    }

    @Test
    public void logOut() throws InterruptedException {
        loginTest();
        homePage.clickHomeIconButton();
        homePage.clickLogoutButton();

        Assert.assertTrue(defaultPage.isLogInButtonDisplayed());

    }
    @Test
    public void likePost() throws InterruptedException {
        loginTest();
        //TBD to be finish

    }

}
