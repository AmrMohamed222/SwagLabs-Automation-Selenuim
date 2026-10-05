package login;

import baseTest.BaseTest;
import org.example.pages.login.LoginPage;
import org.example.pages.product.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();

        Assert.assertEquals(productPage.getTitle(), "Products");
    }
}
