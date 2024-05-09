package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(css = "h3[data-test=error]")
    public WebElement errorMessage;

    //-----------------------------

    public void logIn(String username, String password) {
        insertUsername(username);
        insertPassword(password);
        clickOnLoginButton();
    }

    public void insertUsername(String userName) {
        usernameField.clear();
        usernameField.sendKeys(userName);
    }

    public void insertPassword(String passWord) {
        passwordField.clear();
        passwordField.sendKeys(passWord);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }


}


