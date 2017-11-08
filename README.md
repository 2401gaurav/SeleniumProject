# SeleniumProject



PROBLEM: As we know the explicit and the implicit waits are not applicable to the angularJS application. We are forced to use "Thread.sleep" statement in our framework. This leads to forcefull wait for the set timeout as defined. 

SOLUTION: Currently, We have come up with a stable solution without using the wait statement. The solution waits for Angular and jQuery to load and then proceed with the next statement. 

USE: 
1. Add the angularJSWait utility class into your project.
2. Create a web driver object to angularJSWait class by adding the below lines angularJSWait.setDriver(driver);
3. Finally, replace the below method with the Thread.sleep. waitUntilAngularReady(); 

It only waits for Angular and JQuery //Wait Until JQuery, Angular and JS is ready 

public static void waitJQueryAngular() 
{ waitUntilAngularReady(); waitUntilJQueryReady(); } 

Where it contains the two methods for the angular JS and JQuery. For AngularJS it will wait till the time angular JS is defined in the particular application. 
If angular JS is not defined, it waits for it to load and get defined. 

//Define whether angular is defined in the application or not Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined"); If Defined: //Define whether angular is ready or not String angularReadyScript1 = "return angular.element(document).injector().get('$http').pendingRequests.length"; 

Similarly, for JQuery it will check if JQuery is defined in the application or not.
If the JQuery is present, it will wait until the time it’s not ready.

//check that JQuery is defined on the page. Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'"); //If it is, then wait //AJAX if Defined //Wait Javascript loading until it is Ready!! jsReady1 = String.valueOf(jsExec.executeScript("return document.readyState").toString());
