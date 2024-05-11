package com.khushiagrawal.WebAutoFrameWork;

import com.khushiagrawal.WebAutoFrameWork.actions.CartActions;
import com.khushiagrawal.WebAutoFrameWork.components.HeaderComponent;
import com.khushiagrawal.WebAutoFrameWork.pages.CartItem;
import com.khushiagrawal.WebAutoFrameWork.pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CartTest {
    private WebDriver driver;
    private CartPage cartPage;
    private CartActions cartActions;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        cartPage = new CartPage(driver);
        cartActions = new CartActions(cartPage);
    }

    @Test
    public void testAddProductToCart() {
        cartActions.addProductToCart("Product 1", "Medium");
        cartActions.navigateToCartPage();
        List<CartItem> expectedCartItems = Arrays.asList(
                new CartItem("Product 1", "Medium", "1"));
        cartActions.navigateToCartPage();
        List<CartItem> actualCartItems = cartPage.getCartItems();
        Assert.assertEquals(actualCartItems.size(), 1, "Cart should contain one product.");
        CartItem actualItem = actualCartItems.get(0);
        Assert.assertEquals(actualItem.getName(), "Product 1", "Product name should match.");
        Assert.assertEquals(actualItem.getSize(), "Medium", "Product size should match.");
        Assert.assertEquals(actualItem.getQuantity(), "1", "Product quantity should be 1.");

    }
    @Test
    public void verifyProductInCart(HeaderComponent headerComponents) {
        CartPage cartPage = new CartPage(driver);
        headerComponents.goToCartPage(); // Assuming method is in HeaderComponents
        Map<String, String> productDetails = cartPage.getProductDetailsFromCart("product-name-here");
        Assert.assertNotNull(productDetails, "Product not found in cart.");
        Assert.assertEquals(productDetails.get("name"), "product-name-here");
        // Add further assertions for size, quantity, etc.
    }
@Test
    public void verifyCartTotal(String expectedTotal){
        Assert.assertEquals(cartPage.getTotalPrice(), expectedTotal, "The total price should match the expected value.");
    }
}
