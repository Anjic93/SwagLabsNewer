package hooks;

import base.PageContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.ItemInventoryPage;
import pages.LoginPage;
import pages.ProductsPage;

public class MyHooks {

    PageContext context;

    public MyHooks(PageContext context) {
        this.context = context;
    }

    WebDriver driver;

    public CartPage cartPage;
    public ItemInventoryPage itemInventoryPage;
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public SoftAssert softAssert;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        context.setDriver(driver);
        context.getDriver().manage().window().maximize();

        softAssert = new SoftAssert();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        itemInventoryPage = new ItemInventoryPage(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            e.printStackTrace();
        }

        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll("", "_");
            byte[] sourcePath = ((TakesScreenshot) context.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/jpg", screenshotName);
        }

        context.getDriver().manage().deleteAllCookies();
        context.getDriver().quit();
    }
}
