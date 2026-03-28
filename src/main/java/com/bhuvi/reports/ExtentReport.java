package com.bhuvi.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bhuvi.constants.FrameworkConstants;
import com.bhuvi.enums.CategoryType;

public final class ExtentReport {

	private ExtentReport() {
	}

	public static ExtentReports extent;
	public static ExtentTest test;

	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("PracticeAutomationTest");
			spark.config().setReportName("Automation Test Report");
		}

	}

	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}
	
	public static void addAuthors(String[] authors) {
		for(String auth: authors) {
			ExtentManager.getExtentTest().assignAuthor(auth);
		}
	}
	public static void addCategories(CategoryType[] category) {
		for(CategoryType cate: category) {
			ExtentManager.getExtentTest().assignCategory(cate.toString());
		}
	}

}
