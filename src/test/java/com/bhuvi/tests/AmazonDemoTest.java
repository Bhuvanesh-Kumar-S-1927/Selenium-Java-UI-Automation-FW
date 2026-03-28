package com.bhuvi.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import com.bhuvi.annotations.FrameworkAnnotations;
import com.bhuvi.enums.CategoryType;
import com.bhuvi.pages.AmazonHomePage;

public final class AmazonDemoTest extends BaseTest {
	
	private AmazonDemoTest() {
		
	}
	@FrameworkAnnotations(author = { "Bhuvi" }, categories = {CategoryType.SMOKE, CategoryType.REGRESSION})
	@Test
	public void amazonTest(Map<String, String> map) throws Exception {
		String title = new AmazonHomePage().clickHamburger().clickComputer().clickOnSubMenuItem(map.get("menutext")).getTitle();
		Assertions.assertThat(title).isNotEmpty().isNotNull();
	}
}
