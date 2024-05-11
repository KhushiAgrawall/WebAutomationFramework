package com.khushiagrawal.WebAutoFrameWork;

import com.khushiagrawal.WebAutoFrameWork.actions.CartActions;
import com.khushiagrawal.WebAutoFrameWork.pages.CartItem;
import com.khushiagrawal.WebAutoFrameWork.pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
                new CartItem("Product 1", "Medium", "1")
        );
    }
}
