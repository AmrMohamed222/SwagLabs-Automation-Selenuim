import dataProviderTest.DataProviderTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Swap_TestNG {

    ChromeDriver driver;



    @BeforeMethod
    public void setup() {
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(ChromeOptions);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    public void DropDown() {
//        driver.quit();
//    }


    @Test(dataProvider = "credentials",dataProviderClass = DataProviderTest.class)
    public void validLoginTest(String user, String Pass) {
        List<String> productsName = List.of(
                "backpack",
                "bike",
                "t-shirt",
                "jacket"
        );
        WebElement Enter_User_Name = driver.findElement(By.id("user-name"));
        Enter_User_Name.sendKeys(user);

        WebElement Enter_Password = driver.findElement(By.id("password"));
        Enter_Password.sendKeys(Pass);

        WebElement Click_On_Login = driver.findElement(By.id("login-button"));
        Click_On_Login.click();

        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title, "Products");

        for (String productName : productsName) {
            List<WebElement> products = driver.findElements(
                    By.xpath("//button[contains(@class,'btn_inventory')]")
            );
            for (WebElement product : products) {
                String productId = product.getAttribute("id");
                System.out.println(productId);

                if (productId.contains(productName)) {
                    product.click();
                    break;
                }
            }
        }
    }

    @Test(dataProvider = "products",dataProviderClass = DataProviderTest.class)
    public void CheckProducts(String user, String Pass, String backpack, String bike, String shirt, String jacket) {

        WebElement Enter_User_Name = driver.findElement(By.id("user-name"));
        Enter_User_Name.sendKeys(user);

        WebElement Enter_Password = driver.findElement(By.id("password"));
        Enter_Password.sendKeys(Pass);

        WebElement Click_On_Login = driver.findElement(By.id("login-button"));
        Click_On_Login.click();


        List<String> productsName = List.of(
                backpack,
                bike,
                shirt,
                jacket
        );

        for (String productName : productsName) {
            List<WebElement> products = driver.findElements(
                    By.xpath("//button[contains(@class,'btn_inventory')]")
            );
            for (WebElement product : products) {

                String productId = product.getAttribute("id");

                Assert.assertNotNull(productId);
                if (productId.contains(productName)) {
                    product.click();
                    break;
                }
            }

        }

        String ItemCart = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        Assert.assertEquals(ItemCart, "4");
    }

    @Test
    public void CheckAddItemToCart() {
        List<String> productsName = List.of(
                "backpack",
                "bike",
                "t-shirt",
                "jacket"
        );

        WebElement Enter_User_Name = driver.findElement(By.id("user-name"));
        Enter_User_Name.sendKeys("standard_user");

        WebElement Enter_Password = driver.findElement(By.id("password"));
        Enter_Password.sendKeys("secret_sauce");

        WebElement Click_On_Login = driver.findElement(By.id("login-button"));
        Click_On_Login.click();

        for (String productName : productsName) {
            List<WebElement> products = driver.findElements(
                    By.xpath("//button[contains(@class,'btn_inventory')]")
            );
            for (WebElement product : products) {

                String productId = product.getAttribute("id");

                if (productId.contains(productName)) {
                    product.click();
                    break;
                }
            }
        }

        WebElement Shopping_Cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Shopping_Cart.click();

        boolean Cart = driver.findElement(By.className("inventory_item_name")).isDisplayed();
        Assert.assertTrue(Cart);

    }

    @Test
    public void Check_Out() {
        List<String> productsName = List.of(
                "backpack",
                "bike",
                "t-shirt",
                "jacket"
        );

        WebElement Enter_User_Name = driver.findElement(By.id("user-name"));
        Enter_User_Name.sendKeys("standard_user");

        WebElement Enter_Password = driver.findElement(By.id("password"));
        Enter_Password.sendKeys("secret_sauce");

        WebElement Click_On_Login = driver.findElement(By.id("login-button"));
        Click_On_Login.click();

        for (String productName : productsName) {
            List<WebElement> products = driver.findElements(
                    By.xpath("//button[contains(@class,'btn_inventory')]")
            );
            for (WebElement product : products) {

                String productId = product.getAttribute("id");

                if (productId.contains(productName)) {
                    product.click();
                    break;
                }
            }
        }

        WebElement Shopping_Cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Shopping_Cart.click();

        WebElement Check_Out_Button = driver.findElement(By.name("continue-shopping"));
        Check_Out_Button.click();

        boolean CheckOut = driver.findElement(By.className("title")).isDisplayed();
        Assert.assertTrue(CheckOut);
    }

    @Test
    public void Enter_Check_Out_Information() {
        List<String> productsName = List.of(
                "backpack",
                "bike",
                "t-shirt",
                "jacket"
        );

        WebElement Enter_User_Name = driver.findElement(By.id("user-name"));
        Enter_User_Name.sendKeys("standard_user");

        WebElement Enter_Password = driver.findElement(By.id("password"));
        Enter_Password.sendKeys("secret_sauce");

        WebElement Click_On_Login = driver.findElement(By.id("login-button"));
        Click_On_Login.click();

        for (String productName : productsName) {
            List<WebElement> products = driver.findElements(
                    By.xpath("//button[contains(@class,'btn_inventory')]")
            );
            for (WebElement product : products) {

                String productId = product.getAttribute("id");

                if (productId.contains(productName)) {
                    product.click();
                    break;
                }
            }
        }

        WebElement Shopping_Cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Shopping_Cart.click();

        WebElement Check_Out_Button = driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']"));
        Check_Out_Button.click();

        WebElement Enter_First_Name = driver.findElement(By.id("first-name"));
        Enter_First_Name.sendKeys("3mr");

        WebElement Enter_Last_Name = driver.findElement(By.id("last-name"));
        Enter_Last_Name.sendKeys("Mo");

        WebElement Enter_Postal_Code = driver.findElement(By.id("postal-code"));
        Enter_Postal_Code.sendKeys("1172");

        WebElement Click_On_Continue_Button = driver.findElement(By.id("continue"));
        Click_On_Continue_Button.click();

        boolean Overview = driver.findElement(By.className("title")).isDisplayed();
        Assert.assertTrue(Overview);
    }

    @Test
    public void Enter_Check_Out_Overview() {
        List<String> productsName = List.of(
                "backpack",
                "bike",
                "t-shirt",
                "jacket"
        );

        WebElement Enter_User_Name = driver.findElement(By.id("user-name"));
        Enter_User_Name.sendKeys("standard_user");

        WebElement Enter_Password = driver.findElement(By.id("password"));
        Enter_Password.sendKeys("secret_sauce");

        WebElement Click_On_Login = driver.findElement(By.id("login-button"));
        Click_On_Login.click();

        for (String productName : productsName) {
            List<WebElement> products = driver.findElements(
                    By.xpath("//button[contains(@class,'btn_inventory')]")
            );
            for (WebElement product : products) {

                String productId = product.getAttribute("id");

                if (productId.contains(productName)) {
                    product.click();
                    break;
                }
            }
        }

        WebElement Shopping_Cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Shopping_Cart.click();

        WebElement Check_Out_Button = driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']"));
        Check_Out_Button.click();

        WebElement Enter_First_Name = driver.findElement(By.id("first-name"));
        Enter_First_Name.sendKeys("3mr");

        WebElement Enter_Last_Name = driver.findElement(By.id("last-name"));
        Enter_Last_Name.sendKeys("Mo");

        WebElement Enter_Postal_Code = driver.findElement(By.id("postal-code"));
        Enter_Postal_Code.sendKeys("1172");

        WebElement Click_On_Continue_Button = driver.findElement(By.id("continue"));
        Click_On_Continue_Button.click();

        boolean Overview = driver.findElement(By.className("title")).isDisplayed();
        Assert.assertTrue(Overview);
    }

    @Test
    public void Finish_purchase() {
        List<String> productsName = List.of(
                "backpack",
                "bike",
                "t-shirt",
                "jacket"
        );

        WebElement Enter_User_Name = driver.findElement(By.id("user-name"));
        Enter_User_Name.sendKeys("standard_user");

        WebElement Enter_Password = driver.findElement(By.id("password"));
        Enter_Password.sendKeys("secret_sauce");

        WebElement Click_On_Login = driver.findElement(By.id("login-button"));
        Click_On_Login.click();

        for (String productName : productsName) {
            List<WebElement> products = driver.findElements(
                    By.xpath("//button[contains(@class,'btn_inventory')]")
            );
            for (WebElement product : products) {

                String productId = product.getAttribute("id");

                if (productId.contains(productName)) {
                    product.click();
                    break;
                }
            }
        }

        WebElement Shopping_Cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Shopping_Cart.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']")));

        WebElement Checkout_Button = driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']"));
        Checkout_Button.click();

        WebElement Enter_First_Name = driver.findElement(By.id("first-name"));
        Enter_First_Name.sendKeys("3mr");

        WebElement Enter_Last_Name = driver.findElement(By.id("last-name"));
        Enter_Last_Name.sendKeys("Mo");

        WebElement Enter_Postal_Code = driver.findElement(By.id("postal-code"));
        Enter_Postal_Code.sendKeys("1172");

        WebElement Click_On_Continue_Button = driver.findElement(By.id("continue"));
        Click_On_Continue_Button.click();

        WebElement Click_On_Finish_Button = driver.findElement(By.id("finish"));
        Click_On_Finish_Button.click();

        String CheckThankYou = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(CheckThankYou, "Thank you for your order!");

    }

}
