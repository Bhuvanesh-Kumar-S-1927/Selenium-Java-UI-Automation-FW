package com.bhuvi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.bhuvi.driver.DriverManager;

public class HomepageTests extends BaseTest {
	
	@Test
	public void tests2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Amazon", Keys.ENTER);
		
		}

}
