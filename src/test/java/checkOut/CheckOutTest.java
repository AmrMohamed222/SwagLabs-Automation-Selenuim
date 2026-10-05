package checkOut;

import baseTest.BaseTest;
import org.example.pages.checkOut.CheckOutPage;
import org.example.pages.login.LoginPage;
import org.example.pages.product.CartPage;
import org.example.pages.product.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilies.JSONFileManager;

import java.util.List;

public class CheckOutTest extends BaseTest {
    public JSONFileManager jsonFileManager;
    @Test
    public void Check_Out(){
        List<String> productsName = List.of(
                jsonFileManager.getValue("product1").toString().toLowerCase(),
                jsonFileManager.getValue("product2").toString().toLowerCase(),
                jsonFileManager.getValue("product3").toString().toLowerCase()
        );
        ProductPage productPage = new ProductPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);

        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();

        productPage.clickOnListOfProducts(productsName);

        cartPage.clickShoppingCartButton();

        cartPage.checkForListOfProductsInCart();

        checkOutPage.clickCheckOutButton();

        Assert.assertEquals(checkOutPage.getCheckOutTitle(),"Checkout: Your Information");
    }
}
