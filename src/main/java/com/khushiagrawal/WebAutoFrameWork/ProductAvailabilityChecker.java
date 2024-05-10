package com.khushiagrawal.WebAutoFrameWork;

import com.khushiagrawal.WebAutoFrameWork.Pages.ProductDetailsPage;

public class ProductAvailabilityChecker {
    public boolean isProductAvailable(ProductDetailsPage productDetailsPage) {
        return productDetailsPage.isProductAvailable();
    }
}
