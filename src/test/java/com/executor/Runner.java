package com.executor;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "TestCaseInGerkinLanguage",
glue = "com.TestCases" , 
tags = "@flipkart",
plugin ="html:C:\\Users\\QST\\Downloads\\Staff Room Lecture code 18-5-2025\\Automtion_8.00_to_9.30\\CucumberReport\\Cucumber.html")
public class Runner extends AbstractTestNGCucumberTests {

}
