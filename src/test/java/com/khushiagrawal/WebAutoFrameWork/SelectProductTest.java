package com.khushiagrawal.WebAutoFrameWork;

import com.khushiagrawal.WebAutoFrameWork.components.HeaderComponent;
import com.khushiagrawal.WebAutoFrameWork.pages.ProductDetailsPage;
import com.khushiagrawal.WebAutoFrameWork.pages.ProductSelectionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectProductTest {
    private WebDriver driver;
    private HeaderComponent headerComponents;
    private ProductSelectionPage productSelectionPage;
    private ProductDetailsPage productDetailsPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://your-url-here");
        headerComponents = new HeaderComponent(driver);
        productSelectionPage = new ProductSelectionPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @Test
    public void selectProductByName() {
        headerComponents.clickProductsLink();
        productSelectionPage.searchProduct("product-name-here");
        productSelectionPage.selectProductByName("product-name-here");
        Assert.assertEquals(productDetailsPage.getProductTitle(), "product-name-here");
        Assert.assertEquals(productDetailsPage.getProductPrice(), "$product-price-here");
    }

    @Test
    public void selectProductByIndex() {
        headerComponents.clickProductsLink();
        productSelectionPage.selectProductByIndex(0);
        Assert.assertEquals(productDetailsPage.getProductTitle(), "product-name-here");
        Assert.assertEquals(productDetailsPage.getProductPrice(), "$product-price-here");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
