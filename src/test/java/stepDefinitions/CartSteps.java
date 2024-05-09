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
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import static helpers.SoftAssertions.*;
import static helpers.SoftAssertions.listWithItemsPresenceOnProductsPageAssert;

public class CartSteps {

    private final PageContext context;
    private final SoftAssert softAssert;
    private final LoginPage loginPage;
    private final ProductsPage productsPage;
    private final CartPage cartPage;


    public CartSteps(PageContext context, MyHooks hooks) {
        this.context = context;
        this.softAssert = hooks.softAssert;
        this.loginPage = hooks.loginPage;
        this.productsPage = hooks.productsPage;
        this.cartPage = hooks.cartPage;
    }


    @Given("user is already logged in and it is on products page")
    public void user_is_already_logged_in_and_it_is_on_products_page() {
        context.getDriver().get(UrlConstants.LOGIN_URL);
        loginPage.logIn(LoginConstants.VALID_USERNAME, LoginConstants.VALID_PASSWORD);
    }


    @When("user add one product with add to cart button")
    public void user_add_one_product_with_add_to_cart_button() {
        productsPage.addSingleProduct();
    }

    @Then("remove button appears instead of add to cart button")
    public void remove_button_appears_instead_of_add_to_cart_button() {
        removeButtonPresenceAssert(softAssert, productsPage);
    }

    @And("number of added products is same as number on cart badge")
    public void number_of_added_products_is_same_as_number_on_cart_badge() {
        numberOnCartBadgeEqualsToNumberOfAddedProductsAssert(softAssert, productsPage);
    }


    @And("user click on cart icon")
    public void user_click_on_cart_icon() {
        productsPage.clickOnCartIcon();
    }

    @Then("user is on cart page")
    public void user_is_on_cart_page() {
        softAssert.assertEquals(context.getDriver().getCurrentUrl(), UrlConstants.CART_PAGE_URL, "URL is not changed, page is not redirected");
        checkoutButtonPresenceAssert(softAssert, cartPage);
        titleOnCartPagePresenceAssert(softAssert, cartPage);
    }

    @When("user click on remove button")
    public void user_click_on_remove_button() {
        cartPage.clickOnRemoveButton();
    }

    @Then("cart is empty")
    public void cart_is_empty() {
        listWithItemsNotPresentInCartAssert(softAssert, cartPage);
    }


    @When("user click on continue shopping button")
    public void user_click_on_continue_shopping_button() {
        cartPage.clickOnContinueShoppingButton();
    }

    @Then("user is redirected back on products page")
    public void user_is_redirected_back_on_products_page() {
        softAssert.assertEquals(context.getDriver().getCurrentUrl(), UrlConstants.PRODUCTS_PAGE_URL, "URL is not changed, page is not redirected");
        listWithItemsPresenceOnProductsPageAssert(softAssert, productsPage);
    }
}
