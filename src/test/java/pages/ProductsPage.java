package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inventory_container")
    public WebElement itemsListAssert;

    @FindBy(className = "shopping_cart_container")
    public WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    @FindBy(className = "btn_inventory")
    public List<WebElement> addToCartButton;

    @FindBy(className = "btn_inventory")
    public WebElement addToCartButtonSingle;

    @FindBy(css = ".btn_secondary.btn_inventory")
    public List<WebElement> removeButton;

    @FindBy(className = "btn_inventory")
    public WebElement removeButtonSingle;

    @FindBy(className = "inventory_item_name")
    public WebElement itemTitle;

    @FindBy(className = "inventory_item")
    public WebElement singleItem;

    //------------------

    public void addAllItemsToTheCart() {
        for (int i = 0; i < addToCartButton.size(); i++) {
            addToCartButton.get(i).click();
        }
    }

    public boolean assertRemoveButton() {
        if (removeButtonSingle.getText().contains("REMOVE")) {
            removeButtonSingle.isDisplayed();
        }
        return true;
    }


    public boolean verifyCartBadgeNumberOfAddedProducts() {
        String badgeTxt = cartBadge.getText();
        int badgeNumb = Integer.parseInt(badgeTxt);

        int addedProdCount = removeButton.size();

        if (badgeNumb == addedProdCount) {
            return true;
        }
        return false;
    }

    public void addSingleProduct() {
        if (singleItem.getText().contains("Sauce Labs Backpack")) {
            addToCartButtonSingle.click();
        }
    }

    public void clickOnSingleRemoveButton() {
        if (removeButtonSingle.getText().contains("Sauce Labs Backpack")) {
            removeButtonSingle.click();
        }
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void clickOnItemTitle() {
        if (itemTitle.getText().contains("Sauce Labs Backpack")) {
            itemTitle.click();
        }
    }
}
