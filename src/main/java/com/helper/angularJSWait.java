package com.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class angularJSWait {

	private static WebDriver jsWaitDriver;
	private static WebDriverWait jsWait;
	private static JavascriptExecutor jsExec;
	static String angularReady1;
	static String jsReady1;

	// Get the driver
	public angularJSWait(WebDriver driver) {
		angularJSWait.jsWaitDriver = driver;
		angularJSWait.jsWait = new WebDriverWait(jsWaitDriver, 10);
		angularJSWait.jsExec = (JavascriptExecutor) jsWaitDriver;
	}

	// Wait for JQuery Load
	public static void waitForJQueryLoad() {
		// Wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) jsWaitDriver)
				.executeScript("return jQuery.active") == 0);

		// Get JQuery is Ready
		boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

		// Wait JQuery until it is Ready!
		if (!jqueryReady) {
			System.out.println("JQuery is NOT Ready!");
			// Wait for jQuery to load
			jsWait.until(jQueryLoad);
		} else {
			System.out.println("JQuery is Ready!");
		}
	}

	// Wait for Angular Load
	public static void waitForAngularLoad() {
		
		int count =0;
		int number;
		loop:do {
			JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

			String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
			String angularReadyScript1 = "return angular.element(document).injector().get('$http').pendingRequests.length";
			number=++count;
			// Wait for ANGULAR to load
		/*	ExpectedCondition<Boolean> angularLoad = driver -> Boolean
					.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());
*/
			// Get Angular is Ready
			boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());
			angularReady1 = String.valueOf(jsExec.executeScript(angularReadyScript1).toString());
			System.out.println(angularReady1);

			// Wait ANGULAR until it is Ready!
			if (!angularReady) {
				System.out.println("ANGULAR is NOT Ready!");
				// Wait for Angular to load
				//wait.until(angularLoad);
			} else {
				System.out.println("ANGULAR is Ready!");
			}
			if(Integer.toString(number).equals("100") ) {
				break loop;
			}
		} while ((!angularReady1.equals("0")));
	}

	// Wait Until JS Ready
	public static  void waitUntilJSReady() {
		//WebDriverWait wait = new WebDriverWait(jsWaitDriver, 15);
		int count = 0;
		do {
			JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

			// Wait for Javascript to load
		/*	ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) jsWaitDriver)
					.executeScript("return document.readyState").toString().equals("complete");
*/
			// Get JS is Ready
			boolean jsReady = (Boolean) jsExec.executeScript("return document.readyState").toString()
					.equals("complete");
			jsReady1 = String.valueOf(jsExec.executeScript("return document.readyState").toString());
			// Wait Javascript until it is Ready!
			System.out.println("JS is-->" + jsReady1);
			if (!jsReady) {
				System.out.println("JS in NOT Ready!");
				// Wait for Javascript to load
				//wait.until(jsLoad);
			} else {
				System.out.println("JS is Ready!");
			}
		} while (!jsReady1.equals("complete") || (count == 100));
	}

	// Wait Until JQuery and JS Ready
	public static void waitUntilJQueryReady() {
		JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

		// First check that JQuery is defined on the page. If it is, then wait
		// AJAX
		Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
		if (jQueryDefined == true) {
			// Pre Wait for stability (Optional)
			sleep(20);

			// Wait JQuery Load
			waitForJQueryLoad();

			// Wait JS Load
			waitUntilJSReady();

			// Post Wait for stability (Optional)
			sleep(20);
		} else {
			System.out.println("jQuery is not defined on this site!");
		}
	}

	// Wait Until Angular and JS Ready
	public static void waitUntilAngularReady() {
		JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

		// First check that ANGULAR is defined on the page. If it is, then wait
		// ANGULAR
		Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
		if (!angularUnDefined) {
			Boolean angularInjectorUnDefined = (Boolean) jsExec
					.executeScript("return angular.element(document).injector() === undefined");
			if (!angularInjectorUnDefined) {
				// Pre Wait for stability (Optional)
				sleep(20);

				// Wait Angular Load
				waitForAngularLoad();

				// Wait JS Load
				waitUntilJSReady();

				// Post Wait for stability (Optional)
				sleep(20);
			} else {
				System.out.println("Angular injector is not defined on this site!");
			}
		} else {
			System.out.println("Angular is not defined on this site!");
		}
	}

	// Wait Until JQuery Angular and JS is ready
	public static void waitJQueryAngular() {
		waitUntilAngularReady();
		waitUntilJQueryReady();
	}

	public static void sleep(Integer seconds) {
		long secondsLong = (long) seconds;
		try {
			Thread.sleep(secondsLong);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}