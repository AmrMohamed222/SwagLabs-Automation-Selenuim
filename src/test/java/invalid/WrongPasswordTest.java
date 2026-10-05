package invalid;

import baseTest.BaseTest;
import org.example.pages.invalidCases.InvalidCases;
import org.example.pages.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongPasswordTest extends BaseTest {
    @Test
    public void LoginWithWrongPassword() {

        LoginPage loginPage = new LoginPage(driver);
        InvalidCases invalidCases = new InvalidCases(driver);

        loginPage.enterUsername(configHandler.getValue("username"));
        WebElement Enter_Password =driver.findElement(By.id("password"));
        Enter_Password.sendKeys("secret_sauces");
        loginPage.clickLoginButton();

        Assert.assertEquals(invalidCases.getValidationMassageInLoginPage(),"Epic sadface: Username and password do not match any user in this service");

    }
}
