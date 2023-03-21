package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends ParentPage {
    LoginPage loginPage = new LoginPage(webDriver);

    @FindBy(xpath = ".//*[@class=\"ty-btn ty-btn__primary\"]")
    private WebElement signOutBtn;
    @FindBy(xpath = ".//span[@class=\"csc_account_text ty-hand\"and text()=\"Login\"]")
    private WebElement loginInButton;
    @FindBy(xpath = ".//span[@class=\"csc_account_text ty-hand\"and text()=\"Profile\"]")
    private WebElement profileButton;
    @FindBy(xpath = ".//*[@class=\"csc_advs_text\"]")
    private WebElement search;
    @FindBy(xpath = "//*[@class=\"ty-search-form__input ty-search-form__input-large\"]")
    private WebElement searchInput;
    @FindBy(xpath = ".//*[@class=\"ty-float-left\"]")
    private WebElement viewCartBtn;
    @FindBy(xpath = ".//*[@class=\"ty-logo-container__image\"]")
    private WebElement mainLogo;
    @FindBy(xpath = ".//*[@name=\"dispatch[products.search]\"]")
    private WebElement searchAfterEnterTargetItem;
    @FindBy(xpath = ".//*[@id=\"sw_elm_sort_fields\"]")
    private WebElement relevanceSearch;
    @FindBy(xpath = ".//*[@class=\"ty-mainbox-title__left\"]")
    private WebElement textItemOnPage;
@FindBy(xpath = ".//*[@class=ty-dropdown-box__title cm-combination]")
private WebElement cart;
    @FindBy(xpath = ".//a[@href=\"https://lavky.com/cart/\"]")
    private WebElement myCartIcon;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/";
    }

    public HomePage checkIfRedirectedToHomePage() {
//        clickOnElement(profileButton);
//        Assert.assertTrue("HomePage is not loaded", isElementDisplayed(signOutBtn));
        Assert.assertTrue(isElementDisplayed(profileButton));

        return this;

    }

    public HomePage openHomePage() {
        loginPage.openLoginPage();
            if(isElementDisplayed(loginInButton)) {
                loginPage.clickOnLoginButton();
                loginPage.clickOnSignInBtn();
                loginPage.fillingLoginFormWithValidCred();
                loginPage.clickOnSignInBtnAfterCredEntry();
                logger.info("Login button was clicked");
            }
        checkIfRedirectedToHomePage();
            logger.info("Redirected to Home Page");

        return this;
    }


    public HomePage clickOnSearch() {
        clickOnElement(search);
        return this;
    }


    public HomePage enterValueforSearch() {
        clickOnElement(search);
        clickOnElement(searchInput);
        enterTextInToElement(searchInput, "leather case sailboat");
        clickOnElement(searchAfterEnterTargetItem);
        ;
        return this;
    }



    public SearchResultPage checkisRedirectedToSearchResultPage() {
        Assert.assertTrue(isElementDisplayed(relevanceSearch));
       Assert.assertEquals("Text in element", "Search results", textItemOnPage.getText());
        return new SearchResultPage(webDriver);
    }

    public MyCartPage clickOnMyCartandViewBtn() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(mainLogo));
        clickOnElement(myCartIcon);
        logger.info("My cart icon was clicked");
        clickOnElement(viewCartBtn);
        logger.info("View cart button was clicked");
        return new MyCartPage(webDriver);
    }
}