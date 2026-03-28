package com.bhuvi.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.bhuvi.driver.Driver;

public class BaseTest {
	
	protected BaseTest() {
		
	}	
	@BeforeMethod
	public void setUp(Object[] data) {
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)data[0];
		Driver.initDriver(map.get("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}
	

}
