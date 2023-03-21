package addToCartTest;

import baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;
import pages.MyCartPage;
import pages.SearchResultPage;

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



        ;


    }

    @After
    public void deleteItemFromMyCart() {
       homePage.openHomePage()
               .clickOnMyCartandViewBtn()
                .clickOnDecreaseNumberOfItems()
                .checkYouCartIsEmtyMsg()

        ;
    }


}
