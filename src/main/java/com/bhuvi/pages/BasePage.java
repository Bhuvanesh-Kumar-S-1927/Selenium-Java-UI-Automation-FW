package com.bhuvi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.bhuvi.driver.DriverManager;
import com.bhuvi.enums.WaitStrategy;
import com.bhuvi.factories.ExplicitWaitFactory;
import com.bhuvi.reports.ExtentLogger;

public class BasePage {

	protected void Click(By by, WaitStrategy waitstrategy, String elementName) throws Exception {
		WebElement element =  ExplicitWaitFactory.PerformExplicitWait(waitstrategy, by);
		element.click();
		ExtentLogger.pass(elementName+ " is clicked", true);
	}

	protected void SendKeys(By by, String value, WaitStrategy waitstrategy, String elementName) throws Exception {
		WebElement element =  ExplicitWaitFactory.PerformExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		ExtentLogger.pass(value+ " is entered in the " +elementName+ " field successfully", true);
	}
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	protected void scrollToElement(By by) {
	    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
	    WebElement element = DriverManager.getDriver().findElement(by);
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	    
	    
	}

}
