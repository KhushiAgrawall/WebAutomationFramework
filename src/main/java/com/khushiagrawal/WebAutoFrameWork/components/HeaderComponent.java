package com.khushiagrawal.WebAutoFrameWork.components;

import com.khushiagrawal.WebAutoFrameWork.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Products')]")
    private WebElement productsLink;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


public void clickProductsLink() {
    WebElement productsLink = driver.findElement(By.id("products-link"));
    productsLink.click();
}
    public void goToCartPage() {
        WebElement cartIcon = driver.findElement(By.id("cart-icon"));
        cartIcon.click();
    }
}
