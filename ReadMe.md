Introduction:
===============

Page Object Model framework for running automation tests on different browsers  
 
Prerequisites:
===============

* Java8 JDK 
* Eclipse with Maven plugin installed 

Setup:
============

1. Clone the project from git
2. Launch Eclipse
3. click on File -> Import
5. Select Maven -> Existing Maven Projects and click on Next button
5. Click on Browse and navigate to git directory and select folder
6. Select pom.xml and click on finish button.

Framework Description:
============

Automation tests are designed in Page Object Model 

src/test/resources:
------------------- 

Resources folder contains cucumber feature files, configuration files and browser drivers
 
* create your BDD scenarios in features folder and are organize them with tags eg. "@regression", "@smoke", "@wip"
* TestConfig.properties file consists environment and accounts details for running tests on dev1 server

 Note:
 -----
replace drivers with platforms specific drivers, based on platform tests are running. Mac chromedriver doen't work while running tests on Windows machine.
 
src/main/java:
-----------------

This folder contains 2 packages pagemodel and utils. 
 * Pagemodel package, we create classes consists of reusable functions performing specific test logic like login, search, etc.,
 * utils package we have AppProperties.java and ObjectRepository.java classes.
 
	1. AppProperties class reads test configuration properties files and sets up tests to run on that particular environment.
	2. In ObjectRepository class create Strings for all identified web elements in web application

src/test/java:
--------------	
This folder contains packages acceptanceTest and stepdefs

* acceptanceTest package contains driver classes for running specific test suites.

* step definitions for all features added in features folder are added in stepdefs package.

Executing Tests:
================ 

1. select RegressionTest.java from acceptanceTest package under folder src/test/java
2. Click on Run menu option and select run as JUnit Tests

Reports:
========

Test execution reports are saved in "target/reports/cucumber-pretty" folder.
 

