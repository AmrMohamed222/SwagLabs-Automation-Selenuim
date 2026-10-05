package baseTest;

import driverFactory.DriverFactory;
import io.qameta.allure.Allure;
import org.example.pages.checkOut.CheckOutPage;
import org.example.pages.login.LoginPage;
import org.example.pages.product.CartPage;
import org.example.pages.product.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utilies.ConfigHandler;
import utilies.ExcelFileManager;
import utilies.JSONFileManager;
import utilies.TakeScreenShot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public SoftAssert  softAssert;
    String browser="chrome";
    public ConfigHandler configHandler;
    public ProductPage productPage;
    public LoginPage loginPage;
    public CheckOutPage checkOutPage;
    public CartPage cartPage;
    public JSONFileManager jsonFileManager;
    public ExcelFileManager excelFileManager;


    @BeforeMethod
    public void setup() {
        configHandler = new ConfigHandler("src/main/resources/config.properties");
        jsonFileManager = new JSONFileManager("src/main/resources/product.json");
        driver = DriverFactory.getWebDriver(configHandler.getValue("browser"));
        driver.get(configHandler.getValue("url"));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        productPage = new ProductPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        excelFileManager = new ExcelFileManager("src/test/java/utilies/ExcelFileManager.java","Book1");
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitWebDriver(browser);
        driver = null;
    }

    @AfterMethod
    public void FailedTestCase(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {

            File image = TakeScreenShot.takesScreenshot(driver);

            FileInputStream fis = new FileInputStream(image);

            Allure.addAttachment(
                    "failure screenshot For TestCase " + result.getTestName(),
                    "image/png",
                    fis,
                    "png"
            );
        }
    }
}
