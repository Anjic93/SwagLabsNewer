package stepDefinitions;


import base.PageContext;
import helpers.LoginConstants;
import helpers.UrlConstants;
import hooks.MyHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductsPage;

import static helpers.SoftAssertions.*;


public class LoginSteps {

    private final PageContext context;
    private final SoftAssert softAssert;
    private final LoginPage loginPage;
    private final ProductsPage productsPage;


    public LoginSteps(PageContext context, MyHooks hooks) {
        this.context = context;
        this.softAssert = hooks.softAssert;
        this.loginPage = hooks.loginPage;
        this.productsPage = hooks.productsPage;
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        context.getDriver().get(UrlConstants.LOGIN_URL);
    }


    @When("user enters valid username")
    public void user_enters_valid_username() {
        loginPage.insertUsername(LoginConstants.VALID_USERNAME);
    }

    @And("user enters valid password")
    public void user_enters_valid_password() {
        loginPage.insertPassword(LoginConstants.VALID_PASSWORD);
    }

    @And("user click login button")
    public void user_click_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        softAssert.assertEquals(context.getDriver().getCurrentUrl(), UrlConstants.PRODUCTS_PAGE_URL, "URL is not changed, page is not redirected");
        presenceOfItemsListOnProductsPage(softAssert, productsPage);
        cartIconPresenceAssert(softAssert, productsPage);
    }


    @When("user enters invalid username")
    public void user_enters_invalid_username() {
        loginPage.insertUsername(LoginConstants.INVALID_USERNAME);
    }

    @Then("error message for invalid username is displayed")
    public void error_message_for_invalid_username_is_displayed() {
        invalidUsernameErrorMessageAssert(softAssert, loginPage);
    }


    @And("user enters invalid password")
    public void user_enters_invalid_password() {
        loginPage.insertPassword(LoginConstants.INVALID_PASSWORD);
    }

    @Then("error message for invalid password is displayed")
    public void error_message_for_invalid_password_is_displayed() {
        invalidPasswordErrorMessageAssert(softAssert, loginPage);
    }


    @Then("error message for invalid username and password is displayed")
    public void error_message_for_invalid_username_and_password_is_displayed() {
        invalidUsernameAndPasswordErrorMessageAssert(softAssert, loginPage);
    }
}
