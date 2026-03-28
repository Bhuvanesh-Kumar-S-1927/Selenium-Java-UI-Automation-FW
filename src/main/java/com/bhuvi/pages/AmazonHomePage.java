package com.bhuvi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhuvi.driver.DriverManager;
import com.bhuvi.enums.WaitStrategy;

public final class AmazonHomePage extends BasePage {

    //@FindBy(xpath = "//*[@id='nav-hamburger-menu']/i") private WebElement hamburger;
    private final By hamburger = By.id("nav-hamburger-menu");

    public AmazonHomePage() {
        //PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public AmazonHamburgerMenuPage clickHamburger() throws Exception {
        Click(hamburger, WaitStrategy.CLICKABLE, "hamburger menu");
        return new AmazonHamburgerMenuPage();
    }
}