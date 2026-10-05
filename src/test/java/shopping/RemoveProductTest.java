package shopping;

import baseTest.BaseTest;
import org.example.pages.checkOut.CheckOutPage;
import org.example.pages.login.LoginPage;
import org.example.pages.product.CartPage;
import org.example.pages.product.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilies.JSONFileManager;

import java.util.List;

public class RemoveProductTest extends BaseTest {

    @Test
    public void RemoveProducts(){
        List<String> productsName = List.of(
                jsonFileManager.getValue("product1").toString().toLowerCase(),
                jsonFileManager.getValue("product2").toString().toLowerCase(),
                jsonFileManager.getValue("product3").toString().toLowerCase()
        );

        ProductPage productPage = new ProductPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();

        productPage.clickOnListOfProducts(productsName);

        cartPage.clickShoppingCartButton();
        cartPage.clickToRemoveProducts();

        Assert.assertTrue(productPage.counterIsDisable());
    }


}
