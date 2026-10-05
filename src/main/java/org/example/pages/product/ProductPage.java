package org.example.pages.product;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {

    private final By title = By.className("title");
    private final By listOfProducts = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");
    private final By NumberOfItemsCart = By.xpath("//span[@class='shopping_cart_badge']");
    private final By AddOneItem = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");


    public int num = 0;


    public void ClickOnOneProduct() {
        findElement(AddOneItem).click();
    }

    public String getTitle() {
        return findElement(title).getText();
    }

    public boolean counterIsDisable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(NumberOfItemsCart));
    }


    public int ItemCart() {
        String temp = findElement(NumberOfItemsCart).getText();
        return Integer.parseInt(temp);
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnListOfProducts(List<String> productsName) {

        for (String productName : productsName) {
            List<WebElement> products = driver.findElements(listOfProducts);
            for (WebElement product : products) {

                String productId = product.getAttribute("id");

                if (productId.contains(productName)) {
                    product.click();
                    num++;
                    break;
                }
            }
        }
    }

}
