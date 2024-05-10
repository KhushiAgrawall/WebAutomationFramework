package com.khushiagrawal.WebAutoFrameWork.pages;

import org.openqa.selenium.WebElement;

public class ProductAvailability {
    public static final String AVAILABLE_TEXT = "Add to Cart";
    public static final String SOLD_OUT_TEXT = "Sold Out";

    public static boolean isProductAvailable(WebElement productElement) {
        return productElement.getText().contains(AVAILABLE_TEXT);
    }

    public static boolean isProductSoldOut(WebElement productElement) {
        return productElement.getText().contains(SOLD_OUT_TEXT);
    }

}
