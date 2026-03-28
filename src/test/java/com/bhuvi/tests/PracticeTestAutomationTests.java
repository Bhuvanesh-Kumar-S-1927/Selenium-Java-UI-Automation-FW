package com.bhuvi.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bhuvi.annotations.FrameworkAnnotations;
import com.bhuvi.enums.CategoryType;
import com.bhuvi.pages.PracticeTestAutomationLoginPage;

public class PracticeTestAutomationTests extends BaseTest {
	@FrameworkAnnotations(author = { "Bhuvi" }, categories = {CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test
    public void loginTest(Map<String, String> Data) throws Exception {

        String homePageTitle = new PracticeTestAutomationLoginPage()
                .enterUsername(Data.get("username"))
                .enterPassword(Data.get("password"))
                .clickLogin()
                .clickLogout()
                .getTitle();

        Assertions.assertThat(homePageTitle)
                  .as("Verify home page title after successful login")
                  .isEqualTo("Test login");
    }
	@FrameworkAnnotations(author = { "Bhuvi" }, categories = {CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test
    public void loginlogoutTest(Map<String, String> Data) throws Exception {

        String homePageTitle = new PracticeTestAutomationLoginPage()
                .enterUsername(Data.get("username"))
                .enterPassword(Data.get("password"))
                .clickLogin()
                .clickLogout()
                .getTitle();

        Assertions.assertThat(homePageTitle)
                  .as("Verify home page title after successful login")
                  .isEqualTo("Test login");
    }

    @DataProvider(name = "loginDataProvider", parallel = true)
    public Object[][] getLoginData() {
        return new Object[][] {
                { "student", "Password123" }
        };
    }
}
