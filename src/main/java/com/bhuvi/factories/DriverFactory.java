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

			ChromeOptions options = new ChromeOptions();
			if (Boolean.parseBoolean(System.getProperty("headless"))) {
				options.addArguments("--headless=new");
			}

			if (runmode.equalsIgnoreCase("remote")) {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			}

		} else if (browser.equalsIgnoreCase("firefox")) {

			FirefoxOptions options = new FirefoxOptions();
			if (Boolean.parseBoolean(System.getProperty("headless"))) {
				options.addArguments("--headless");
			}

			if (runmode.equalsIgnoreCase("remote")) {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(options);
			}

		} else if (browser.equalsIgnoreCase("edge")) {

			EdgeOptions options = new EdgeOptions();
			if (Boolean.parseBoolean(System.getProperty("headless"))) {
				options.addArguments("--headless=new");
			}

			if (runmode.equalsIgnoreCase("remote")) {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
			} else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(options);
			}
		}

		return driver;
	}
}