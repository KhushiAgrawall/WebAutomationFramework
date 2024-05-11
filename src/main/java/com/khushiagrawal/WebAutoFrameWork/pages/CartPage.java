package com.khushiagrawal.WebAutoFrameWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    public WebDriver driver;

    @FindBy(id = "cart-link")
    private WebElement cartLink;

    @FindBy(id = "cart-table")
    private WebElement cartTable;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void navigateToCartPage() {
        cartLink.click();
    }

    public List<CartItem> getCartItems() {
        List<CartItem> cartItems = new ArrayList<>();
        List<WebElement> rows = cartTable.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : rows) {
            WebElement name = row.findElement(By.cssSelector("td:nth-child(1)"));
            WebElement size = row.findElement(By.cssSelector("td:nth-child(2)"));
            WebElement quantity = row.findElement(By.cssSelector("td:nth-child(3)"));
            cartItems.add(new CartItem(name.getText(), size.getText(), quantity.getText()));
        }
        return cartItems;
    }

    public String getTotalPrice() {
        return cartTable.findElement(By.cssSelector("tfoot .total")).getText();
    }
}
