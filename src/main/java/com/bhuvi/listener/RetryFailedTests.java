package com.bhuvi.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.bhuvi.enums.ConfigProperties;
import com.bhuvi.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {
	
	int count = 0;
	int retries=1;

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("yes")) {
				value = count<retries;
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
		
	}

}
