package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;





public class ProductListPage extends ParentPage{
    public ProductListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@src=\"https://lavky.com/images/thumbnails/276/276/detailed/655/536ef54dec228bab3d902d03e8879a08.jpg.jpg\"]")
private WebElement targetItem;


    public ProductListPage chooseTargetItem() {
        clickOnElement(targetItem);
        return this;
    }
}
