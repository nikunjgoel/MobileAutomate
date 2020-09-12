# MobileAutomate
CONTENTS OF THIS FILE-----
•	Introduction
•	PREREQUISITES
•	Recommended modules


INTRODUCTION---
 
I attempt to automate Amazon.com shopping app using this framework 
Using this testing framework service lets you improve the quality of your mobile apps by testing them across an extensive range of emulators and real mobile devices; without having to provision and manage any testing infrastructure. The service enables you to run your tests concurrently on real devices or emulators to speed up the execution of your test suite, and generates reports and logs to help you quickly identify issues with your app.

Concepts we will be talking about----

•	Using BDD feature file to create test scenarios.
•	Page Objects to organize the methods on how to interact with the elements on the particular page.
•	Wrappers for commonly used AndroidDriver functions.
•	Actions classes grouping up commonly used methods, so tests are easier to create.
•	Extent report to create reports after exceution of  test suites.
•	Logging functionlity using Log4j to identify quick issues.
•	Data driven using Apache POI Library to get test data from excel.
•	Using Maven to include jars used in framework .
•	Using Pagefactory method and scenario context so we can pass parameter from one stepdefinition file  to another in a scenario.
•	Using Junit Assert to validate the test scenarios.
•	Using Appium Java client library methods to automate app in mobile devices.





PREREQUISITES----

•	Eclipse (For local development/execution) : Oxygen
•	JDK (Java Development Kit) (For local development/execution): JDK 1.8.0_171-b11
•	Android Studio 4.0.1
•	Emulator Name: Pixel_2_API_30 
•	Appium 1.18.0-2
•	.Netframework


Recommended modules---

Login Module: Validate valid and invalid login scenarios of Amazon App on emulator.
Add Product to Basket : Launch Amazon App add searched product into the cart and proceed to checkout.
Validate Product in delivery page: Compare search product into delivery page.
Compare Price: Get highest and lowest price amongst all products displayed in a search page of App.

