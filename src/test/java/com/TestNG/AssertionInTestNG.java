package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionInTestNG {
WebDriver w;
	@BeforeMethod
	public void LaunchBrowser() throws Exception {
		 w = new EdgeDriver();
		 Thread.sleep(2000);
		 w.get("https://demo.frontaccounting.eu/index.php");
	}
	@Test
	public void login() throws Exception {
		 Thread.sleep(2000);
		w.findElement(By.name("SubmitUser")).click();
		 Thread.sleep(1000);
//		 Hard Assertion
//		Assert.assertEquals(w.getTitle(), "Main Menu  ");
//		System.out.println("hello");
//		Assert.assertEquals(w.getCurrentUrl(), "https://demo.frontaccounting.eu/index.php    ");	
		 
//		 soft Assertion
		 SoftAssert soft = new SoftAssert();
		 soft.assertEquals(w.getTitle(), "Main Menu  ");
			System.out.println("hello");
			soft.assertEquals(w.getCurrentUrl(), "https://demo.frontaccounting.eu/index.php    ");
			soft.assertAll();
		 
	}
	@AfterMethod
	public void closeBrowser() throws Exception {
		w.quit();
	}
	
	
}
