package com.bhuvi.constants;

import com.bhuvi.enums.ConfigProperties;
import com.bhuvi.utils.PropertyUtils;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH+"/executables/chromedriver.exe";
	private static final String EXTENTREPORTFOLDERPATH  = System.getProperty("user.dir")+"/extent-test-output/";
	private static final String EXCELPATH = RESOURCESPATH+"/Excel/testdata.xlsx";
	private static String extentReportFilePath = "";
	private static final String RUNNERMANAGERSHEET = "RunManager";
	private static final String DATASHEET = "DATA";
	
	
	private static String createReportPath() {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"index.html";
		}
	}
	
	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
	
	
	private static final int EXPLICITWAIT = 10;
			
	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getRunnermanagersheet() {
		return RUNNERMANAGERSHEET;
	}

	public static String getDatasheet() {
		return DATASHEET;
	}

}
