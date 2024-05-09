package tests;

import base.BaseTest;
import helpers.LoginConstants;
import helpers.UrlConstants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ItemInventoryPage;
import pages.LoginPage;
import pages.ProductsPage;

import static helpers.SoftAssertions.*;

public class AddingProductsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        itemInventoryPage = new ItemInventoryPage(driver);

        logIn(LoginConstants.VALID_USERNAME, LoginConstants.VALID_PASSWORD);
    }

    @Test
    public void verifyThatUserCanAddAllProductsFromProductsPageToTheCartWithAddToCartButton() {
        productsPage.addAllItemsToTheCart();

        removeButtonPresenceAssert(softAssert, productsPage);
        numberOnCartBadgeEqualsToNumberOfAddedProductsAssert(softAssert, productsPage);
    }

    @Test
    public void verifyThatNumberOfAddedProductsIsDisplayedOnCartIcon() {
        productsPage.addAllItemsToTheCart();

        numberOnCartBadgeEqualsToNumberOfAddedProductsAssert(softAssert, productsPage);
    }

    @Test
    public void verifyThatUserCanRemoveAddedProductFromProductsPageFromTheCartWithRemoveButton() {
        productsPage.addSingleProduct();

        removeButtonPresenceAssert(softAssert, productsPage);

        productsPage.clickOnSingleRemoveButton();

        addToCartButtonPresenceAssert(softAssert, productsPage);
    }

    @Test
    public void verifyThatProductIsAlreadyAdded() {
        productsPage.addSingleProduct();

        removeButtonPresenceAssert(softAssert, productsPage);

        productsPage.clickOnItemTitle();

        softAssert.assertEquals(driver.getCurrentUrl(), UrlConstants.SAUCE_LABS_BACKPACK_PAGE, "URL is not changed, page is not redirected");
        removeButtonPresenceOnItemPageAssert(softAssert, itemInventoryPage);
    }
}

