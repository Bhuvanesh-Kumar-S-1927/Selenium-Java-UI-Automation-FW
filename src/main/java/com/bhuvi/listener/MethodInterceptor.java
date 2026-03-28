package com.bhuvi.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.bhuvi.constants.FrameworkConstants;
import com.bhuvi.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<Map<String, String>> excelData = ExcelUtils.getTestDetails(FrameworkConstants.getRunnermanagersheet());
        List<IMethodInstance> result = new ArrayList<>();

        for (IMethodInstance methodInstance : methods) {

            String methodName = methodInstance.getMethod().getMethodName();

            for (Map<String, String> data : excelData) {

                String testName = data.get("testname");
                String execute = data.get("execute");

                if (methodName.equalsIgnoreCase(testName)
                        && "yes".equalsIgnoreCase(execute)) {

                    // Optional attributes (safe parsing)
                    setIfPresent(methodInstance, data);

                    result.add(methodInstance);
                    break; // IMPORTANT: stop once matched
                }
            }
        }
        return result;
    }

    private void setIfPresent(IMethodInstance methodInstance, Map<String, String> data) {

        if (data.get("testdescription") != null) {
            methodInstance.getMethod()
                    .setDescription(data.get("testdescription"));
        }

        if (data.get("count") != null) {
            methodInstance.getMethod()
                    .setInvocationCount(Integer.parseInt(data.get("count")));
        }

        if (data.get("priority") != null) {
            methodInstance.getMethod()
                    .setPriority(Integer.parseInt(data.get("priority")));
        }
    }
}
