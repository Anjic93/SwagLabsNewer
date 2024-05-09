package tests;

import base.BaseTest;
import helpers.LoginConstants;
import helpers.UrlConstants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import static helpers.SoftAssertions.*;

public class CartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        logIn(LoginConstants.VALID_USERNAME, LoginConstants.VALID_PASSWORD);
    }


    @Test
    public void verifyThatUserCanRemoveAddedProductsFromTheCart() {
        productsPage.addSingleProduct();

        removeButtonPresenceAssert(softAssert, productsPage);
        numberOnCartBadgeEqualsToNumberOfAddedProductsAssert(softAssert, productsPage);

        productsPage.clickOnCartIcon();

        softAssert.assertEquals(driver.getCurrentUrl(), UrlConstants.CART_PAGE_URL, "URL is not changed, page is not redirected");
        checkoutButtonPresenceAssert(softAssert, cartPage);
        titleOnCartPagePresenceAssert(softAssert, cartPage);

        cartPage.clickOnRemoveButton();

        listWithItemsNotPresentInCartAssert(softAssert, cartPage);
    }

    @Test
    public void verifyThatUserCanGoBackOnProductsPageFromTheYourCartPage() {
        productsPage.clickOnCartIcon();

        softAssert.assertEquals(driver.getCurrentUrl(), UrlConstants.CART_PAGE_URL, "URL is not changed, page is not redirected");
        checkoutButtonPresenceAssert(softAssert, cartPage);
        titleOnCartPagePresenceAssert(softAssert, cartPage);

        cartPage.clickOnContinueShoppingButton();

        softAssert.assertEquals(driver.getCurrentUrl(), UrlConstants.PRODUCTS_PAGE_URL, "URL is not changed, page is not redirected");
        listWithItemsPresenceOnProductsPageAssert(softAssert, productsPage);
    }
}
