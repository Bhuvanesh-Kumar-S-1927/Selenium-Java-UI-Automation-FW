package com.bhuvi.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bhuvi.enums.ConfigProperties;
import com.bhuvi.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {}

	public static WebDriver getDriver(String browser) throws MalformedURLException {
		WebDriver driver = null;

		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);

		if (browser.equalsIgnoreCase("chrome")) {

			if (runmode.equalsIgnoreCase("remote")) {
				ChromeOptions options = new ChromeOptions();
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

		} else if (browser.equalsIgnoreCase("firefox")) {

			if (runmode.equalsIgnoreCase("remote")) {
				FirefoxOptions options = new FirefoxOptions();
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

		} else if (browser.equalsIgnoreCase("edge")) {

			if (runmode.equalsIgnoreCase("remote")) {
				EdgeOptions options = new EdgeOptions();
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
			} else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}

		return driver;
	}
}