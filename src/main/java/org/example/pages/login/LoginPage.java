package org.example.pages.login;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUsernameField(){
        return findElement(usernameField);
    }

    public WebElement getPasswordField(){
        return findElement(passwordField);
    }

    public WebElement getLoginButton(){
        return findElement(loginButton);
    }

    public void enterUsername(String username){
        getUsernameField().sendKeys(username);
    }

    public void enterPassword(String password){
        getPasswordField().sendKeys(password);
    }

    public void clickLoginButton(){
        getLoginButton().click();
    }
}
