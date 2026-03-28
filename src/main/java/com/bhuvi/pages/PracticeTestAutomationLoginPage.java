package com.bhuvi.pages;

import org.openqa.selenium.By;

import com.bhuvi.driver.DriverManager;
import com.bhuvi.enums.WaitStrategy;
import com.bhuvi.reports.ExtentLogger;
import com.bhuvi.reports.ExtentManager;
import com.bhuvi.reports.ExtentReport;
import com.bhuvi.utils.DecodeUtils;

public class PracticeTestAutomationLoginPage extends BasePage {
	
	private final By textbox_username = By.id("username");
	private final By textbox_password = By.id("password");
	private final By button_login = By.id("submit");
	private final By title = By.xpath("//h2[text()='Test login']");
	
	public PracticeTestAutomationLoginPage enterUsername(String username) throws Exception {
		SendKeys(textbox_username, username, WaitStrategy.PRESENCE, "Username");
		//DriverManager.getDriver().findElement(textbox_username).sendKeys(username);
		return this;
	}
	public PracticeTestAutomationLoginPage enterPassword(String password) throws Exception {
		SendKeys(textbox_password, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE, "Password");
		//DriverManager.getDriver().findElement(textbox_password).sendKeys(password);
		return this;
	}
	public PracticeTestAutomationHomePage clickLogin() throws Exception {
		Click(button_login, WaitStrategy.CLICKABLE, "Login Button");
		return new PracticeTestAutomationHomePage();
	}
	public String getTitle() {
		return DriverManager.getDriver().findElement(title).getText();
	}
	

}
