package com.khushiagrawal.WebAutoFrameWork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductSelectionPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'product-card')]")
    private WebElement product;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;

    private final WebDriverWait wait;

    public ProductSelectionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchProduct(String productName) {
        searchInput.sendKeys(productName);
        searchInput.submit();
    }

    public void selectProductByName(String productName) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'product-card') and .//h4[contains(text(),'" + productName + "')]]")));
        driver.findElement(By.xpath("//div[contains(@class, 'product-card') and .//h4[contains(text(),'" + productName + "')]]")).click();
    }

    public void selectProductByIndex(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'product-card')]")));
        driver.findElements(By.xpath("//div[contains(@class, 'product-card')]")).get(index).click();
    }
}
