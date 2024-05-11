package com.khushiagrawal.WebAutoFrameWork.pages;

import com.khushiagrawal.WebAutoFrameWork.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver= new ChromeDriver();

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public HeaderComponent getHeader() {
        return new HeaderComponent(driver);
    }

}
