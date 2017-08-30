# SeleniumProject


Problem: As, we know the explicit and the implicit waits not applicable to the angular Js application. Where we are forced to use the silly Thread.sleep(); Statement in our Framework. This basically leads to forcefully wait for the set time as defined.
Solution: Currently, We have come up with the stable solution instead of silly wait etc for the angular JS application. Where it will wait till the time Anguar JS and the JQuery is not ready in the application and it will proceed further with the next statement.
To make it use into the project:
Add the angularJSWait utility class into your project.
Then, create a web driver object to angularJSWait class by adding the below lines
angularJSWait.setDriver(driver);
Finally, you can replace the below method with the Thread.sleep.
waitUntilAngularReady(); –> It only waits Angular and JQuery

//Wait Until JQuery Angular and JS is ready
public static void waitJQueryAngular() {
waitUntilAngularReady();
waitUntilJQueryReady();
}
Where it contains the two methods for the angular JS and JQuery. For AngularJS it will wait only till the time angular JS is defined in the Particular application. If angular JS is defined it will run till the time angular JS is not ready.
Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");//Define whether angular is defined in the application or not



If Defined:
String angularReadyScript1 = "return angular.element(document).injector().get('$http').pendingRequests.length";//Define whether angular JS is ready or not

Similarly, for JQuery it will check for JQuery is defined in the application or not if the JQuery is present. It will wait till the time it’s not ready.
  Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");//check that JQuery is defined on the page. If it is, then wait AJAX
If Defined:
jsReady1 = String.valueOf(jsExec.executeScript("return document.readyState").toString());//Wait Javascript until it is Ready!






 
