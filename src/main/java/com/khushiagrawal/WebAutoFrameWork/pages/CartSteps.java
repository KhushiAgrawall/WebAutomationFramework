package com.khushiagrawal.WebAutoFrameWork.pages;

import java.util.List;

public class CartSteps {
    private final CartPage cartPage;

    public CartSteps(CartPage cartPage) {
        this.cartPage = cartPage;
    }


    public void i_am_on_the_cart_page() {
        cartPage.navigateToCartPage();
    }


   }
