package stepDefinitions;

import base.PageContext;
import helpers.UrlConstants;
import hooks.MyHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.ItemInventoryPage;
import pages.ProductsPage;

import static helpers.SoftAssertions.addToCartButtonPresenceAssert;
import static helpers.SoftAssertions.removeButtonPresenceOnItemPageAssert;

public class AddingProductsSteps {

    private final PageContext context;
    private final SoftAssert softAssert;
    private final ProductsPage productsPage;
    private final ItemInventoryPage itemInventoryPage;


    public AddingProductsSteps(PageContext context, MyHooks hooks) {
        this.context = context;
        this.softAssert = hooks.softAssert;
        this.productsPage = hooks.productsPage;
        this.itemInventoryPage = hooks.itemInventoryPage;
    }


    @When("user add all products to the cart with add to cart button")
    public void user_add_all_products_to_the_cart_with_add_to_cart_button() {
        productsPage.addAllItemsToTheCart();
    }


    @When("user click on remove button from products page")
    public void user_click_on_remove_button_from_products_page() {
        productsPage.clickOnSingleRemoveButton();
    }

    @Then("add to cart button appears instead of remove button")
    public void add_to_cart_button_appears_instead_of_remove_button() {
        addToCartButtonPresenceAssert(softAssert, productsPage);
    }


    @And("user click on added item title")
    public void user_click_on_added_item_title() {
        productsPage.clickOnItemTitle();
    }

    @Then("user is redirected to the added item page")
    public void user_is_redirected_to_the_added_item_page() {
        softAssert.assertEquals(context.getDriver().getCurrentUrl(), UrlConstants.SAUCE_LABS_BACKPACK_PAGE, "URL is not changed, page is not redirected");
    }

    @And("user verify that remove button is displayed instead of add to cart button")
    public void user_verify_that_remove_button_is_displayed_instead_of_add_to_cart_button() {
        removeButtonPresenceOnItemPageAssert(softAssert, itemInventoryPage);
    }

}
