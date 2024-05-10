package com.khushiagrawal.WebAutoFrameWork.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponents {
    @FindBy(xpath = "//a[contains(text(),'Products')]")
    private WebElement productsLink;

    public HeaderComponents(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickProductsLink() {
        productsLink.click();
    }
}
