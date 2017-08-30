/**
 * 
 */
package com.helper;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author h.sengar
 *
 */
public class CaptureScreenshot
{
	static WebDriver driver;
	public CaptureScreenshot (WebDriver driver)
	{
		CaptureScreenshot.driver = driver;
	}
	
	public void getscreenshot(WebDriver driver, String filePath) throws Exception 
	{
         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
         FileUtils.copyFile(scrFile, new File(filePath));      
    }
	
	
    public static void highlightElement(WebElement element) throws InterruptedException {
        for (int i = 0; i <2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
            Thread.sleep(2000);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
            }
        }
}
