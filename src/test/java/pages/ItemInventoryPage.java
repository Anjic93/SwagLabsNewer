package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemInventoryPage extends BasePage {

    public ItemInventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div/div/button")
    public WebElement removeButtonItem;

    //------------------------

    public boolean assertRemoveButton() {
        if (removeButtonItem.getText().contains("REMOVE")) {
            removeButtonItem.isDisplayed();
            return true;
        }
        return false;
    }
}
