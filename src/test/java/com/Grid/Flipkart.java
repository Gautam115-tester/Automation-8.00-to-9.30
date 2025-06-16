package com.Grid;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class Flipkart {
	public static void main(String[] args) throws Exception {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.WINDOWS);
		dc.setBrowserName("MicrosoftEdge");
		RemoteWebDriver w = new RemoteWebDriver(dc);
		w.get("https://www.flipkart.com/");
		w.findElement(By.name("q")).sendKeys("mobile",Keys.ENTER);
		w.findElement(By.className("CGtC98")).click();
		Thread.sleep(5000);
		w.quit();
	}
}