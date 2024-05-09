package helpers;

import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.ItemInventoryPage;
import pages.LoginPage;
import pages.ProductsPage;

public class SoftAssertions {

    public static void errorMessageEmptyFieldsAssert(SoftAssert softAssert, LoginPage loginPage) {
        softAssert.assertTrue(loginPage.errorMessage.isDisplayed(),
                "Error message is not displayed when trying to Login with empty fields, but it should be");
    }

    public static void invalidUsernameErrorMessageAssert(SoftAssert softAssert, LoginPage loginPage) {
        softAssert.assertTrue(loginPage.errorMessage.isDisplayed(),
                "Error message is not displayed when trying to Login with invalid username, but it should be");
    }

    public static void invalidPasswordErrorMessageAssert(SoftAssert softAssert, LoginPage loginPage) {
        softAssert.assertTrue(loginPage.errorMessage.isDisplayed(),
                "Error message is not displayed when trying to Login with invalid password, but it should be");
    }

    public static void invalidUsernameAndPasswordErrorMessageAssert(SoftAssert softAssert, LoginPage loginPage) {
        softAssert.assertTrue(loginPage.errorMessage.isDisplayed(),
                "Error message is not displayed when trying to Login with invalid username and password, but it should be");
    }

    public static void presenceOfItemsListOnProductsPage(SoftAssert softAssert, ProductsPage productsPage) {
        softAssert.assertTrue(productsPage.itemsListAssert.isDisplayed(),
                "List with items is not displayed, but it should be");
    }

    public static void cartIconPresenceAssert(SoftAssert softAssert, ProductsPage productsPage) {
        softAssert.assertTrue(productsPage.cartIcon.isDisplayed(),
                "Cart icon is not displayed, but it should be");
    }

    public static void removeButtonPresenceAssert(SoftAssert softAssert, ProductsPage productsPage) {
        softAssert.assertTrue(productsPage.assertRemoveButton(),
                "Remove button after adding product on products page is not present, but it should be");
    }

    public static void numberOnCartBadgeEqualsToNumberOfAddedProductsAssert(SoftAssert softAssert, ProductsPage productsPage) {
        softAssert.assertTrue(productsPage.verifyCartBadgeNumberOfAddedProducts(),
                "Number of added products is not same on cart badge, but it should be");
    }

    public static void checkoutButtonPresenceAssert(SoftAssert softAssert, CartPage cartPage) {
        softAssert.assertTrue(cartPage.verifyCheckoutButton(),
                "Checkout button is not present, but it should be");
    }

    public static void titleOnCartPagePresenceAssert(SoftAssert softAssert, CartPage cartPage) {
        softAssert.assertTrue(cartPage.verifyCartTitle(),
                "Cart page title Your cart is not present, but it should be");
    }

    public static void listWithItemsNotPresentInCartAssert(SoftAssert softAssert, CartPage cartPage) {
        softAssert.assertTrue(cartPage.verifyItemsListNotPresent(),
                "List with items is present, but it shouldn't be");
    }

    public static void listWithItemsPresenceOnProductsPageAssert(SoftAssert softAssert, ProductsPage productsPage) {
        softAssert.assertTrue(productsPage.itemsListAssert.isDisplayed(),
                "List with items is not present, but it should be");
    }

    public static void addToCartButtonPresenceAssert(SoftAssert softAssert, ProductsPage productsPage) {
        softAssert.assertTrue(productsPage.addToCartButtonSingle.isDisplayed(),
                "Add to Cart button is not present after clicking on Remove button, but it should be");
    }

    public static void removeButtonPresenceOnItemPageAssert(SoftAssert softAssert, ItemInventoryPage itemInventoryPage) {
        softAssert.assertTrue(itemInventoryPage.assertRemoveButton(),
                "Remove button is not displayed, but it should be because product is already added from Products page");
    }
}
