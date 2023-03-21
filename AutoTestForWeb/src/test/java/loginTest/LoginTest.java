package loginTest;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {

    public final static String valid_password = "qwerty";
    public final static String valid_email = "volodymyr.chyrva@yahoo.com";
    public final static String inValidPassword = "2020Nissan";
    public final static String MyAccSign = "My Account";
public final String error_msg = "The username or password you have entered is invalid. Please try again.";
    @Test
    public void validLogin() {
        loginPage.openLoginPage()
        .clickOnLoginButton()
        .clickOnSignInBtn()
        .enterEmailIntoInputEmail(valid_email)
        .enterPasswordIntoInputPassword(valid_password)
        .clickOnSignInBtnAfterCredEntry()
        .checkIfRedirectedToHomePage()

        ;

    }

    @Test
    public void invalidLogin() {
        loginPage.openLoginPage()
        .clickOnLoginButton()
        .clickOnSignInBtn()
        .enterEmailIntoInputEmail(valid_email)
        .enterPasswordIntoInputPassword(inValidPassword)
        .clickOnSignInBtnAfterCredEntry();
        loginPage.checkIsButtonSignInDisplayed();
        loginPage.checkErrorMsgForIncorrectCred(error_msg)
        ;
    }
}
