package base;

import helpers.UrlConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.ItemInventoryPage;
import pages.LoginPage;
import pages.ProductsPage;

public class BaseTest {

    public WebDriver driver;
    public CartPage cartPage;
    public ItemInventoryPage itemInventoryPage;
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public SoftAssert softAssert;


    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.get(UrlConstants.LOGIN_URL);
    }

    public void logIn(String username, String password) {
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
    }


    @AfterMethod
    public void tearDown() {
        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            e.printStackTrace();
        }
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}


