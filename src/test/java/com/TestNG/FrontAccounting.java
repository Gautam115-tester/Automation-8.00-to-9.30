package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrontAccounting {

	WebDriver w;
	@BeforeClass   // pre-condition
	public void LaunchBrowser() throws Exception {
		w = new EdgeDriver();
	}
	@BeforeMethod    // it will always execute with your before test condition. (test condition hone ka phel execution kar tha hai)
	public void openSite() {
		w.get("https://demo.frontaccounting.eu/");
	}
	@Test
	public void login() throws Exception {
		Thread.sleep(2000);
		w.findElement(By.name("SubmitUser")).click();
	}
	@Test
	public void logout() throws Exception {
		Thread.sleep(2000);
		w.findElement(By.name("SubmitUser")).click();
		Thread.sleep(2000);
		w.findElement(By.linkText("Logout")).click();
	}
	@AfterMethod     // post - condition   it will always execute with your after test condition. (test condition hone ka baad execution kar tha hai)
	public void logoutSite() throws Exception {
		Thread.sleep(2000);
		w.findElement(By.linkText("Logout")).click();
	}
	@AfterClass (alwaysRun = true)
	public void QuitBrowser() throws Exception {
		Thread.sleep(2000);
		w.quit();
	}
	
	
}
