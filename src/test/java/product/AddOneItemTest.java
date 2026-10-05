package product;

import baseTest.BaseTest;
import org.example.pages.login.LoginPage;
import org.example.pages.product.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddOneItemTest extends BaseTest {

    @Test
    public void CheckAddOneItemToCart(){

        ProductPage productPage = new ProductPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();

        productPage.ClickOnOneProduct();

        Assert.assertEquals(productPage.ItemCart(),1);
    }
}
