package com.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class TestCasesOnFrontaccounting {
RemoteWebDriver w;
DesiredCapabilities dc;
//	pre-condition before contains
@Parameters("browserName")
	@BeforeClass   // before class will execute first then before method will be execute.  //1
	public void openBrowser(String browser) {
		if (browser.equals("edge")) {
			dc = new DesiredCapabilities();
			dc.setPlatform(Platform.WINDOWS);
			dc.setBrowserName("MicrosoftEdge");
			w = new RemoteWebDriver(dc);
//			w = new EdgeDriver();
		}else if (browser.equals("firefox")) {
			dc = new DesiredCapabilities();
			dc.setPlatform(Platform.WINDOWS);
			dc.setBrowserName("firefox");
			w = new RemoteWebDriver(dc);
//			w = new FirefoxDriver();
		}else {
			System.out.println("NO BROWSER AVALIABLE BY THIS NAME : "+browser);
		}
	}
	@BeforeMethod   // infinite time run // test condition 10 = 10
	public void login() throws Exception {
		w.get("https://demo.frontaccounting.eu/");
		Thread.sleep(2000);
		w.findElement(By.name("SubmitUser")).click();
		Thread.sleep(2000);
	}
	@Test
	public void SalesQuotationEntry() throws Exception {
		w.findElement(By.linkText("Sales Quotation Entry")).click();
		Thread.sleep(1000);
		if (w.getTitle().equals("New Sales Quotation Entry")) {
			System.out.println("Test pass for Sales Quotation Entry");
		} else {
			System.out.println("Test fail for Sales Quotation Entry");
		}	
	}
	@Test
	public void SalesOrderEntry() throws Exception {
		w.findElement(By.linkText("Sales Order Entry")).click();
		Thread.sleep(1000);
		if (w.getTitle().equals("New Sales Order Entry")) {
			System.out.println("Test pass for Sales Order Entry");
		} else {
			System.out.println("Test fail for Sales Order Entry");
		}
	}
	@AfterMethod
	public void logout() throws Exception {
		Thread.sleep(2000);
		w.findElement(By.linkText("Logout")).click();
	}
	
	@AfterClass   // after method got execute it will then start to execute itself.  // 1
	public void closeBrowser() throws Exception {
		Thread.sleep(2000);
		w.quit();
	}
}
