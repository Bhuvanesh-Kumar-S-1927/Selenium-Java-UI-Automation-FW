package com.bhuvi.pages;

import org.openqa.selenium.By;

import com.bhuvi.enums.WaitStrategy;
import com.bhuvi.reports.ExtentLogger;
import com.bhuvi.reports.ExtentManager;
import com.bhuvi.reports.ExtentReport;

public class PracticeTestAutomationHomePage extends BasePage {
	
	
	private final By button_logout = By.xpath("//a[text() = 'Log out']");
	
	public PracticeTestAutomationLoginPage clickLogout() throws Exception {
		Click(button_logout, WaitStrategy.CLICKABLE, "Logout button");
	    return new PracticeTestAutomationLoginPage();
	}


}
