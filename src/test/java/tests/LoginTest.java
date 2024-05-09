package tests;

import base.BaseTest;
import helpers.LoginConstants;
import helpers.UrlConstants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static helpers.SoftAssertions.*;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void verifyThatUserCanLogInSuccessfullyWithValidCredentialsAndMandatoryFieldsFilled() {
        loginPage.clickOnLoginButton();

        errorMessageEmptyFieldsAssert(softAssert, loginPage);

        loginPage.insertUsername(LoginConstants.VALID_USERNAME);
        loginPage.clickOnLoginButton();

        invalidPasswordErrorMessageAssert(softAssert, loginPage);

        loginPage.insertPassword(LoginConstants.VALID_PASSWORD);
        loginPage.clickOnLoginButton();

        softAssert.assertEquals(driver.getCurrentUrl(), UrlConstants.PRODUCTS_PAGE_URL, "URL is not changed, page is not redirected");
        presenceOfItemsListOnProductsPage(softAssert, productsPage);
        cartIconPresenceAssert(softAssert, productsPage);
    }

    @Test
    public void verifyThatUserCantLoginWithInvalidUsernameAndPassword() {
        loginPage.insertUsername(LoginConstants.INVALID_USERNAME);
        loginPage.insertPassword(LoginConstants.VALID_PASSWORD);
        loginPage.clickOnLoginButton();

        invalidUsernameErrorMessageAssert(softAssert, loginPage);

        loginPage.insertUsername(LoginConstants.VALID_USERNAME);
        loginPage.insertPassword(LoginConstants.INVALID_PASSWORD);

        invalidPasswordErrorMessageAssert(softAssert, loginPage);

        logIn(LoginConstants.INVALID_USERNAME, LoginConstants.INVALID_PASSWORD);

        invalidUsernameAndPasswordErrorMessageAssert(softAssert, loginPage);
    }
}
