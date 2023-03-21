package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActWithElements {





    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait10, webDriverWait15;


    public CommonActWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));

    }

    protected void enterTextInToElement(WebElement webElement, String text) {
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted in to element " + getElementName(webElement));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            String name = getElementName(webElement);
            webElement.click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    protected void clickOnElement(String xpath) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(xpath)));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }
    private String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }
    protected void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }
    protected boolean isElementDisplayed(WebElement webElement) {
        try {

            boolean state = webElement.isDisplayed();
            String message;
            if (state) {
                message = getElementName(webElement) + "Element is displayed";
            } else {
                message = getElementName(webElement) + "Element is not displayed";
            }
            logger.info(message);
            return state;

        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }

    }
    protected boolean isElementDisplayed(String xpath) {
        try {

            boolean state = webDriver.findElement(By.xpath(xpath)).isDisplayed();
            WebElement element = webDriver.findElement(By.xpath(xpath));
            isElementDisplayed(element);
            return state;

        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;

        }


    }
    public static void waitABit(Integer second){
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


}
}
