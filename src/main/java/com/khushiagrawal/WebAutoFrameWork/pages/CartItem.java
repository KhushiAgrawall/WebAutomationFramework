package com.khushiagrawal.WebAutoFrameWork.pages;

public class CartItem extends BasePage{
    private String name;
    private String size;
    private String quantity;

    public CartItem(String name, String size, String quantity) {
        super(driver);
        this.name = name;
        this.size = size;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getQuantity() {
        return quantity;
    }
}
