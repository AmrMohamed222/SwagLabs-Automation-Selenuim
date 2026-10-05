package org.example.pages.product;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By ContinueShoppingButton = By.xpath("//button[@class='btn btn_secondary back btn_medium']");
    private final By ShoppingCart = By.xpath("//a[@class='shopping_cart_link']");
    private final By RemoveProducts = By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory ']");
    private final By assertCartPage = By.xpath("//span[@class='title']");
    private final By listOfProductsRemove = By.xpath("//button[@class='btn btn_secondary btn_small cart_button']");
    public int number = 0;

    public String  isCartPage(){
        return findElement(assertCartPage).getText();
    }

    public int NumOfRemoveItems = 0;

    public WebElement getContinueShoppingButton() {
        return findElement(ContinueShoppingButton);
    }

    public void clickContinueShoppingButton() {
        getContinueShoppingButton().click();
    }

    public WebElement getShoppingCartButton() {
        return findElement(ShoppingCart);
    }

    public void clickShoppingCartButton() {
        getShoppingCartButton().click();
    }

    public void clickToRemoveProducts() {
        List<String> productsName = List.of(
                "backpack",
                "bike",
                "t-shirt",
                "jacket"
        );

        NumOfRemoveItems =  productsName.size();
        for (String productName : productsName) {
            List<WebElement> products = driver.findElements(RemoveProducts);
            for (WebElement product : products) {

                String productId = product.getAttribute("id");

                if (productId.contains(productName)) {
                    product.click();
                    NumOfRemoveItems--;
                    break;
                }
            }
        }
    }

    public void checkForListOfProductsInCart() {
        List<String> productsName = List.of(
                "backpack",
                "bike",
                "t-shirt",
                "jacket"
        );

        for (String productName : productsName) {
            List<WebElement> products = driver.findElements(listOfProductsRemove);
            System.out.println(products.size());
            for (WebElement product : products) {

                String productId = product.getAttribute("id");

                if (productId.contains(productName)) {
                    number++;
                    break;
                }
            }
        }

    }
}
