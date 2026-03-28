package com.bhuvi.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.bhuvi.enums.ConfigProperties;
import com.bhuvi.factories.DriverFactory;
import com.bhuvi.utils.PropertyUtils;

public class Driver {
	private static WebDriver driver;
	
	
	public static void initDriver(String browser) {
		if(Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		
		}
		
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
		
	}
}
