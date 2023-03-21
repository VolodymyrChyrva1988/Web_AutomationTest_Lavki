package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends ParentPage{

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/";
    }


    @FindBy (xpath = ".//*[@id=\"button_cart_221058\"]")
private WebElement addToCartBtn;
    @FindBy(xpath = ".//*[@class=\" csc_bg_img ty-pict     cm-image\"]")
    private WebElement targetItem;
@FindBy(xpath = ".//*[@class=\"ty-float-left\"]")
private WebElement viewCartBtn;
    @FindBy(xpath = ".//a[@href=\"https://lavky.com/cart/\"]")
    private WebElement myCartIcon;
    @FindBy(xpath = ".//*[@class=\"ty-logo-container__image\"]")
    private WebElement mainLogo;

    public SearchResultPage clickAddItemToCArt() {
        clickOnElement(addToCartBtn);
        logger.info("Add to cart was clicked");
        return this;
    }
    public SearchResultPage clickOnTargetItem() {
        clickOnElement(targetItem);
        logger.info("Target item was clicked");
        return new SearchResultPage(webDriver);
    }

    public MyCartPage clickOnMyCartIconAndViewCart()  {
        webDriverWait10.until(ExpectedConditions.visibilityOf(mainLogo));
        clickOnElement(myCartIcon);
        logger.info("My cart icon was clicked");
        clickOnElement(viewCartBtn);
        logger.info("View cart button was clicked");
        return new MyCartPage(webDriver);
    }
}
