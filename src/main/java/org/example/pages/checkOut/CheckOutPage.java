package org.example.pages.checkOut;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private final By CheckOutButton =By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']");
    private final By CheckOutTitle = By.xpath("//span[@class='title']");
    private final By EnterFirstName = By.id("first-name");
    private final By EnterLastName = By.id("last-name");
    private final By EnterPostalCode = By.id("postal-code");
    private final By ContinueButton = By.id("continue");
    private final By CheckoutOverview= By.xpath("//span[@class='title']");
    private final By FinishButton = By.xpath("//button[@class='btn btn_action btn_medium cart_button']");
    private final By ThankYouTitle = By.xpath("//h2[@class='complete-header']");

    public String getThankYouTitle(){
        return findElement(ThankYouTitle).getText();
    }

    public WebElement getFinishButton() {
        return findElement(FinishButton);
    }

    public void ClickFinishButton(){
        getFinishButton().click();
    }

    public String getCheckoutOverview(){
        return findElement(CheckoutOverview).getText();
    }

    public WebElement getFirstNameField(){
        return findElement(EnterFirstName);
    }

    public WebElement getLastNameField(){
        return findElement(EnterLastName);
    }

    public WebElement getPostalCodeField(){
        return findElement(EnterPostalCode);
    }

    public WebElement getContinueButton(){
        return findElement(ContinueButton);
    }

    public void ClickContinueButton(){
        getContinueButton().click();
    }

    public String getCheckOutTitle(){
        return findElement(CheckOutTitle).getText();
    }

    public WebElement getCheckOutButton(){
        return findElement(CheckOutButton);
    }

    public void clickCheckOutButton(){
        getCheckOutButton().click();
    }

    public void EnterFirstName(String firstName){
        getFirstNameField().sendKeys(firstName);
    }

    public void EnterLastName(String lastName){
        getLastNameField().sendKeys(lastName);
    }

    public void EnterPostalCode(String postalCode){
        getPostalCodeField().sendKeys(postalCode);
    }
}
