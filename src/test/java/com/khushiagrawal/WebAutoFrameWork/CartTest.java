package com.khushiagrawal.WebAutoFrameWork;

import com.khushiagrawal.WebAutoFrameWork.Pages.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest {
    @Test
    public void testAddProduct() {
        Cart cart = new Cart();
        Product product = new Product("Example Product", 9.99);
        cart.addProduct(product);

        Assertions.assertEquals(1, cart.getItemCount());
    }
}
