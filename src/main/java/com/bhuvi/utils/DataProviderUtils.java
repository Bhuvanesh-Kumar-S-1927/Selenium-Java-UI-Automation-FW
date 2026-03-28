package com.bhuvi.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.bhuvi.constants.FrameworkConstants;

public final class DataProviderUtils {
	
	public static List<Map<String, String>>list = new ArrayList<Map<String,String>>();
	
	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		if(list.isEmpty()) {
		 list=ExcelUtils.getTestDetails(FrameworkConstants.getDatasheet());
		}
		List<Map<String, String>> datalist = new ArrayList<Map<String,String>>();
		for(int i=0; i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) && list.get(i).get("execute").equalsIgnoreCase("yes")) {
					datalist.add(list.get(i));
			}
		}
		list.removeAll(datalist);
		return datalist.toArray();
		
	}

}
