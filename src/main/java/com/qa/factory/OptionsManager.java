package com.qa.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private Properties propertiesFile;
	private ChromeOptions chromeOptns;
	private FirefoxOptions ffOptns;
	private EdgeOptions edgeOptns;

	public OptionsManager(Properties prop) {
		this.propertiesFile = prop;
	}

	public ChromeOptions getChromeOptions() {
		chromeOptns = new ChromeOptions();
		if (Boolean.parseBoolean(propertiesFile.getProperty("headless"))) {
			System.out.println("....Running in headless.....");
			chromeOptns.addArguments("--headless");
		}
		if (Boolean.parseBoolean(propertiesFile.getProperty("incognito"))) {
			chromeOptns.addArguments("--incognito");
		}

		if (propertiesFile.getProperty("executionEnv").equalsIgnoreCase("remote")) {
			chromeOptns.setCapability("browserName", "chrome");
			chromeOptns.setBrowserVersion(propertiesFile.getProperty("browserversion").trim());

			Map<String, Object> browsrOptns = new HashMap<>();
			browsrOptns.put("screenResolution", "1280x1024x24");
			//browsrOptns.put("enableVNC", true);
			//browsrOptns.put("name", propertiesFile.getProperty("testname"));
			chromeOptns.setCapability("browsrOptns:options", browsrOptns);
		}

		return chromeOptns;
	}

	public FirefoxOptions getFirefoxOptions() {
		ffOptns = new FirefoxOptions();
		if (Boolean.parseBoolean(propertiesFile.getProperty("headless"))) {
			System.out.println("....Running in headless.....");
			ffOptns.addArguments("--headless");
		}
		if (Boolean.parseBoolean(propertiesFile.getProperty("incognito"))) {
			ffOptns.addArguments("--incognito");
		}
		if (propertiesFile.getProperty("executionEnv").equalsIgnoreCase("remote")) {
			ffOptns.setCapability("browserName", "firefox");
			ffOptns.setBrowserVersion(propertiesFile.getProperty("browserversion").trim());

			Map<String, Object> browsrOptns = new HashMap<>();
			browsrOptns.put("screenResolution", "1280x1024x24");
			//browsrOptns.put("enableVNC", true);
			//browsrOptns.put("name", propertiesFile.getProperty("testname"));
			ffOptns.setCapability("browsrOptns:options", browsrOptns);
		}
		return ffOptns;
	}

	public EdgeOptions getEdgeOptions() {
		edgeOptns = new EdgeOptions();
		if (Boolean.parseBoolean(propertiesFile.getProperty("headless"))) {
			System.out.println("....Running in headless.....");
			edgeOptns.addArguments("--headless");
		}
		if (Boolean.parseBoolean(propertiesFile.getProperty("incognito"))) {
			edgeOptns.addArguments("--inPrivate");
		}
		if (propertiesFile.getProperty("executionEnv").equalsIgnoreCase("remote")) {
			edgeOptns.setCapability("browserName", "edge");
		}
		return edgeOptns;
	}

}
