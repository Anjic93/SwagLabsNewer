package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "subheader")
    public WebElement cartTitle;

    @FindBy(css = ".btn_action.checkout_button")
    public WebElement checkoutButton;

    @FindBy(css = ".btn_secondary.cart_button")
    public WebElement removeCartButton;

    @FindBy(className = "cart_item")
    public List<WebElement> itemsList;

    @FindBy(className = "btn_secondary")
    public WebElement continueShoppButton;

    //-----------------------

    public boolean verifyCheckoutButton() {
        return checkoutButton.isDisplayed();
    }

    public boolean verifyCartTitle() {
        if (cartTitle.getText().contains("Your Cart")) {
            cartTitle.isDisplayed();
        }
        return true;
    }

    public void clickOnRemoveButton() {
        if (removeCartButton.isDisplayed()) {
            removeCartButton.click();
        }
    }

    public boolean verifyItemsListNotPresent() {
        return itemsList.isEmpty();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppButton.click();
    }
}
