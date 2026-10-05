package invalid;

import baseTest.BaseTest;
import org.example.pages.invalidCases.InvalidCases;
import org.example.pages.checkOut.CheckOutPage;
import org.example.pages.login.LoginPage;
import org.example.pages.product.CartPage;
import org.example.pages.product.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilies.JSONFileManager;

import java.util.List;

public class MissPostalCodeTest extends BaseTest {
    public JSONFileManager jsonFileManager;
    @Test
    public void CheckoutWithoutPostalCode() {
        List<String> productsName = List.of(
                jsonFileManager.getValue("product1").toString().toLowerCase(),
                jsonFileManager.getValue("product2").toString().toLowerCase(),
                jsonFileManager.getValue("product3").toString().toLowerCase()
        );

        ProductPage productPage = new ProductPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        InvalidCases invalidCases = new InvalidCases(driver);

        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();

        productPage.clickOnListOfProducts(productsName);

        cartPage.clickShoppingCartButton();

        checkOutPage.clickCheckOutButton();

        checkOutPage.EnterFirstName(configHandler.getValue("firstname"));
        checkOutPage.EnterLastName(configHandler.getValue("lastname"));

        checkOutPage.ClickContinueButton();

        Assert.assertEquals(invalidCases.getValidationMassageInCheckoutPage(),"Error: Postal Code is required");

    }

}