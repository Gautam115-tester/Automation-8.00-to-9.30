package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderInSauceDemo {
	WebDriver w;
	@DataProvider
	public String[][] loginData() {
		String[][] up= new String[6][2];
//		0. column --> username , 1. column --> password
		up[0][0] = "standard_user";
		up[0][1] = "secret_sauce";
		up[1][0] = "locked_out_user";
		up[1][1] = "secret_sauce";
		up[2][0] = "problem_user";
		up[2][1] = "secret_sauce";
		up[3][0] = "performance_glitch_user";
		up[3][1] = "secret_sauce";
		up[4][0] = "error_user";
		up[4][1] = "secret_sauce";
		up[5][0] = "visual_user";
		up[5][1] = "secret_sauce";
		return up;	
	}
	@BeforeClass  // Cross browsing testing
	public void launchBrowser() {
		w = new EdgeDriver();
	}
	@BeforeMethod
	public void navigateToSauceDemo() {
		w.get("https://www.saucedemo.com/");
	}
	@Test(dataProvider = "loginData" )
	public void login(String username , String password) {
		w.findElement(By.id("user-name")).sendKeys(username);
		w.findElement(By.id("password")).sendKeys(password);
		w.findElement(By.name("login-button")).click();
		Assert.assertEquals(w.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
	@AfterMethod
	public void logout() throws Exception {
		try {
			w.findElement(By.id("react-burger-menu-btn")).click();
			Thread.sleep(1000);
			w.findElement(By.linkText("Logout")).click();
		} catch (Exception e) {
			
		}
	}
	@AfterClass
	public void closeBrowser() {
		w.quit();
	}
	
	
}
