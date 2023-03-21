package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/";
    }

    @FindBy(xpath = ".//input[@class=\"ty-login__input cm-focus\"]")
    private WebElement inputEmail;
    @FindBy(xpath = ".//input[@class=\"ty-login__input\"]")
    private WebElement inputPassword;
    @FindBy(xpath = ".//span[@class=\"csc_account_text ty-hand\"]")
    private WebElement loginInButton;
    @FindBy(xpath = ".//*[@class=\"cm-dialog-opener cm-dialog-auto-size ty-btn ty-btn__secondary\"]")
    private WebElement signInButton;
    @FindBy (xpath = ".//button[@class=\"ty-btn__login ty-btn__secondary ty-btn\"]")
    private WebElement signInButtonAfterCredEntry;
@FindBy(xpath = ".//span[@class=\"ty-login-form__wrong-credentials-text ty-error-text\"]")
   private WebElement incorrectUsernameOrOPassMsg;
    public final static String valid_password = "qwerty";
    public final static String valid_email = "volodymyr.chyrva@yahoo.com";


public LoginPage openLoginPage(){
try {webDriver.get("https://lavky.com/");
    logger.info("LoginPage was opened");
}catch (Exception e){
    logger.error("Can not open Login Page" + e);
    Assert.fail("Can not open Login Page" + e);
}
        return this;
}

    public LoginPage enterEmailIntoInputEmail(String email) {
        enterTextInToElement(inputEmail,email);
        return this;
    }

    public LoginPage enterPasswordIntoInputPassword(String pass) {
        enterTextInToElement(inputPassword, pass);
        return this;
    }

    public LoginPage clickOnSignInBtn() {
    clickOnElement(signInButton);
    return this;
    }

    public LoginPage clickOnLoginButton() {
    clickOnElement(loginInButton);
    return this;
    }
    public HomePage clickOnSignInBtnAfterCredEntry(){
    clickOnElement(signInButtonAfterCredEntry);
    return new HomePage(webDriver);
    }


    public LoginPage checkErrorMsgForIncorrectCred(String errorMsg) {
        Assert.assertEquals("The username or password you have entered is invalid. Please try again.",
                errorMsg,incorrectUsernameOrOPassMsg.getText());
        return this;
    }

    public void checkIsButtonSignInDisplayed() {
    Assert.assertTrue(isElementDisplayed(signInButton));
    logger.info("SignIn Button is not displayed");
    }
    public void fillingLoginFormWithValidCred(){
    enterEmailIntoInputEmail(valid_email);
    enterPasswordIntoInputPassword(valid_password);
    }
}
