package com.bhuvi.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.bhuvi.driver.DriverManager;
import com.bhuvi.enums.ConfigProperties;
import com.bhuvi.utils.PropertyUtils;
import com.bhuvi.utils.ScreenshotUtils;

public final class ExtentLogger {
	
	private ExtentLogger() {
		
	}
	
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void pass(String message, Boolean  isScreenshotNeeded) {
		if(PropertyUtils.get(ConfigProperties.PASSEDSCREENSHOTS).equalsIgnoreCase("yes") &&  isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	
	public static void fail(String message, Boolean isScreenshotNeeded) {
		if(PropertyUtils.get(ConfigProperties.FAILEDSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
	
	public static void skip(String message, Boolean isScreenshotNeeded) {
		if(PropertyUtils.get(ConfigProperties.SKIPPEDSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			skip(message);
		}
	}
	
	

}
