package com.khushiagrawal.WebAutoFrameWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage extends BasePage{

   public WebDriver driver;
    @FindBy(xpath = "//div[@id='cart-item-container']")
    private List<WebElement> cartItems; // Assume each cart item has all the details as child elements

    @FindBy(id = "cart-link")
    private WebElement cartLink;

    @FindBy(id = "cart-table")
    private WebElement cartTable;

    @FindBy(xpath = "//span[@id='total-price']")
    private WebElement totalPrice;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
        return totalPrice.getText();
    }
    // Method to get a cart item's details by product name
    public Map<String, String> getProductDetailsFromCart(String productName) {
        for (WebElement item : cartItems) {
            if (item.getText().contains(productName)) {
                Map<String, String> details = new HashMap<>();
                details.put("name", item.findElement(By.className("cart-item-name")).getText());
                details.put("quantity", item.findElement(By.className("cart-item-quantity")).getText());
                // Add other details as needed
                return details;
            }
        }
        return null; // Or throw exception if product not found
    }
}
