package org.example.pages.invalidCases;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvalidCases extends BasePage {
    private final By ValidationMassageInCheckoutPage = By.xpath("//div[@class='error-message-container error']");
    private final By ValidationMassageInLoginPage = By.xpath("//div[@class='error-message-container error']");
    public InvalidCases(WebDriver driver) {
        super(driver);
    }

    public String getValidationMassageInCheckoutPage(){
        return findElement(ValidationMassageInCheckoutPage).getText();
    }
    public String getValidationMassageInLoginPage(){
        return findElement(ValidationMassageInLoginPage).getText();
    }

}
