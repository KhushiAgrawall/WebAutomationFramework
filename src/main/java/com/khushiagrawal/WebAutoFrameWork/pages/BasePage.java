package com.khushiagrawal.WebAutoFrameWork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BasePage {
    protected WebDriver driver= new ChromeDriver();

    public BasePage(WebDriver driver)
    {

    }
}
