package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCartPage extends ParentPage{
    public MyCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/cart/";
    }

    @FindBy(xpath = ".//*[@class=\"ty-mainbox-title\" ]")
private WebElement cartContentText;
@FindBy(xpath = ".//*[@class=\"ty-btn ty-btn__tertiary cm-external-click \" ]")
private WebElement recalculateIcon;
@FindBy(xpath = ".//*[@class=\"ty-cart-content__product-title\"]")
private WebElement correctItem;
@FindBy(xpath = ".//span[@class=\"ty-sub-price\" and @id=\"sec_product_price_3311332511\"]")
private WebElement correctPrice;
@FindBy(xpath = ".//*[@class=\"cm-decrease ty-value-changer__decrease\"]")
private WebElement decreaseNumberOfItems;
@FindBy(xpath = ".//*[@class=\"ty-no-items\"]")
private WebElement emptyCartMsg;

    public MyCartPage clickOnDecreaseNumberOfItems() {
        clickOnElement(decreaseNumberOfItems);
        return this;
    }


    public MyCartPage checkIsRedirectedToMyCartPage() {
       // checkURL();
        Assert.assertTrue(isElementDisplayed(recalculateIcon));
        Assert.assertEquals("Text in element","Cart contents",cartContentText.getText());
        return this;
    }

    public MyCartPage checkItemAndPriceAreCorrect() {
        Assert.assertEquals("Item price","42.00",correctPrice.getText());
        Assert.assertEquals("Item name","Leather key case \"SAILBOAT\"",correctItem.getText());
        return this;
    }

    public void checkYouCartIsEmtyMsg() {
        Assert.assertEquals("Empty cart message","Your cart is empty",emptyCartMsg.getText());
    }
}
