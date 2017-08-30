package com.helper;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author h.sengar
 *
 *         This class loads the different browsers
 */
public class BrowserType {

	static WebDriver driver;

	public static WebDriver launchBrowser() {
		
		return driver;
		
	}
	
	public static WebDriver launchBrowser(String broType, String url) {

		if (broType.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (broType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\workspace\\AutomationStore\\src\\com\\helper\\IEDriverServer.exe");
			/*
			 * DesiredCapabilities capabilities =
			 * DesiredCapabilities.internetExplorer();
			 * capabilities.setCapability("ignoreProtectedModeSettings", true);
			 * capabilities.setCapability("ie.forceCreateProcessApi", true);
			 * capabilities.setCapability("ie.ensureCleanSession", true);
			 * capabilities.setCapability("ie.setProxyByServer", true);
			 */
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			driver = new InternetExplorerDriver(capabilities);
		}

		else if (broType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"//home//maverick//Desktop//chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-incognito");
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();	
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			
			driver = new ChromeDriver(capabilities);
			

		}

		//driver.manage().window().maximize();

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);

		return driver;
	}
}
