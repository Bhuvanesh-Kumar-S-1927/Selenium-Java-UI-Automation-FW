package com.bhuvi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.bhuvi.driver.DriverManager;

public class LoginpageTests extends BaseTest {
	
	private LoginpageTests() {
		
	}
	
	
	
	@Test
	public void tests1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes", Keys.ENTER);		
		}
	
	

}
