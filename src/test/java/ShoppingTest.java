import baseTest.BaseTest;
import org.example.pages.checkOut.CheckOutPage;
import org.example.pages.login.LoginPage;
import org.example.pages.product.CartPage;
import org.example.pages.product.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilies.ConfigHandler;
import utilies.JSONFileManager;

import java.util.List;
import java.util.Locale;

import static driverFactory.GetChromeDriver.driver;


public class ShoppingTest extends BaseTest {


    @Test
    public void Check_Out() {
        List<String> productsName = List.of(
                excelFileManager.getSpecificCellValue(1,0),
                excelFileManager.getSpecificCellValue(2,0)
        );
        ProductPage productPage = new ProductPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();

        productPage.clickOnListOfProducts(productsName);

        Assert.assertEquals(productPage.ItemCart(), productPage.num);
    }

    @Test
    public void validLoginTest() {
        WebElement Enter_User_Name = driver.findElement(By.id("user-name"));
        Enter_User_Name.sendKeys("standard_user");

        WebElement Enter_Password =driver.findElement(By.id("password"));
        Enter_Password.sendKeys("secret_sauce");

        WebElement Click_On_Login =driver.findElement(By.id("login-button"));
        Click_On_Login.click();

        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title, "Products");
    }

    @Test
    public void CheckProducts() {
        WebElement Enter_User_Name = driver.findElement(By.id("user-name"));
        Enter_User_Name.sendKeys("standard_user");

        WebElement Enter_Password =driver.findElement(By.id("password"));
        Enter_Password.sendKeys("secret_sauce");

        WebElement Click_On_Login =driver.findElement(By.id("login-button"));
        Click_On_Login.click();

        WebElement Add_To_Cart = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
        Add_To_Cart.click();

        String ItemCart = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        Assert.assertEquals(ItemCart, "1");
    }

    @Test
    public void CheckAddItemToCart() {
        WebElement Enter_User_Name = driver.findElement(By.id("user-name"));
        Enter_User_Name.sendKeys("standard_user");

        WebElement Enter_Password =driver.findElement(By.id("password"));
        Enter_Password.sendKeys("secret_sauce");

        WebElement Click_On_Login =driver.findElement(By.id("login-button"));
        Click_On_Login.click();

        WebElement Add_To_Cart = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
        Add_To_Cart.click();

        WebElement Shopping_Cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Shopping_Cart.click();

        boolean Cart = driver.findElement(By.className("inventory_item_name")).isDisplayed();
        Assert.assertTrue(Cart);
    }

    @Test
    public void ReturnToHomePage() {

        WebElement Enter_User_Name = driver.findElement(By.id("user-name"));
        Enter_User_Name.sendKeys("standard_user");

        WebElement Enter_Password =driver.findElement(By.id("password"));
        Enter_Password.sendKeys("secret_sauce");

        WebElement Click_On_Login =driver.findElement(By.id("login-button"));
        Click_On_Login.click();

        WebElement Add_To_Cart = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
        Add_To_Cart.click();

        WebElement Shopping_Cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Shopping_Cart.click();

        WebElement Click_On_continue_Button = driver.findElement(By.id("continue-shopping"));
        Click_On_continue_Button.click();

        String product = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(product, "Products");

    }


}
