package com.khushiagrawal.WebAutoFrameWork.actions;

import com.khushiagrawal.WebAutoFrameWork.pages.BasePage;
import com.khushiagrawal.WebAutoFrameWork.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartActions extends BasePage {
    private CartPage cartPage;

    public CartActions(CartPage cartPage) {
        super(cartPage.driver);
        this.cartPage = cartPage;
    }

    public void addProductToCart(String productName, String productSize) {
        // Navigate to the product page
        driver.get("https://www.example.com/product/" + productName);

        // Select the product size
        WebElement sizeSelect = driver.findElement(By.id("size-select"));
        Select sizeDropdown = new Select(sizeSelect);
        sizeDropdown.selectByVisibleText(productSize);

        // Add the product to the cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
    }

    public void navigateToCartPage() {
        getHeader().goToCartPage();
    }
}