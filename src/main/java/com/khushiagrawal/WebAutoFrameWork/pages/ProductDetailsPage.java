package com.khushiagrawal.WebAutoFrameWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage extends BasePage {
    @FindBy(xpath = "//h1")
    private WebElement productTitle;

    @FindBy(xpath = "//span[contains(@class, 'price')]")
    private WebElement productPrice;

    private final WebDriverWait wait;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getProductTitle() {
        return wait.until(ExpectedConditions.visibilityOf(productTitle)).getText();
    }

    public String getProductPrice() {
        return wait.until(ExpectedConditions.visibilityOf(productPrice)).getText();
    }

    public void addProductToCart() {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
    }
}
