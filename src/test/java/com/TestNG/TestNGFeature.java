package com.TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
public class TestNGFeature {
	@Test() // test condition    test cases
	public void facebook() throws Exception {
		WebDriver w = new ChromeDriver();
		w.get("https://www.facebook.com/");
		Thread.sleep(20000);
		w.quit();
	}
	@Test   // test cases
	public void google() throws Exception {
		WebDriver w = new EdgeDriver();
		w.get("https://www.google.com/");
		Thread.sleep(20000);
		w.quit();
	}
}