package addToCartTest;

import baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;
import pages.MyCartPage;

public class MyCartTest extends BaseTest {


    @Test
    public void addItemToCart() {

        homePage.openHomePage()
        .clickOnSearch()
        .enterValueforSearch()
        .checkisRedirectedToSearchResultPage()
        .clickOnTargetItem()
        .clickAddItemToCArt()
        .clickOnMyCartIconAndViewCart()
        .checkIsRedirectedToMyCartPage()
        .checkItemAndPriceAreCorrect();
        searchResultPage.clickOnMyCartIconAndViewCart()
                .clickOnDecreaseNumberOfItems()
                .checkYouCartIsEmtyMsg()


        ;


    }

    @After
    public void deleteItemFromMyCart() {
       homePage.openHomePage();
        searchResultPage.clickOnMyCartIconAndViewCart()
                .clickOnDecreaseNumberOfItems()
                .checkYouCartIsEmtyMsg()

        ;
    }


}
