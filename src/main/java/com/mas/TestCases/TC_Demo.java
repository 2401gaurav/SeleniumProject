package com.mas.TestCases;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.helper.BrowserType;
import com.helper.DataConfig;
import com.helper.angularJSWait;




/**
 * @author gaurav.b.kapoor
 *
 */
public class TC_Demo {

	public static DataConfig inputDataConfig;
	public static DataConfig resultDataConfig;
	public static FileOutputStream fileOut;
	public static HSSFSheet outputWorkSheet;
	public static int rowNumber;
	public static HSSFWorkbook workBook;
	String AppURL = "https://goodfil.ms/";
	WebDriver driver;
	String landingURL = "https://goodfil.ms/";
	angularJSWait objJSWaiter;

	@Parameters({ "browserType" })
	@BeforeClass
	public void initialize(String browserType) throws Exception {

		this.driver = BrowserType.launchBrowser(browserType, AppURL);

		this.objJSWaiter = PageFactory.initElements(driver, angularJSWait.class);
	}

	@Test(priority = 0)
	public void NavigateToHomePage() throws Exception {
		angularJSWait.waitJQueryAngular();
		driver.findElement(By.xpath("//a[@href='/films/on_netflix']")).click();
		angularJSWait.waitJQueryAngular();
	}

}
