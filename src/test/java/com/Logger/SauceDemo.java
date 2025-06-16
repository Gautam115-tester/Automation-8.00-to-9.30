package com.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SauceDemo {

	public static void main(String[] args) throws Exception {
		Logger log = LogManager.getFormatterLogger(); 
		WebDriver w = new EdgeDriver();
		log.info("Edge Browser has been launch");
		try {
			w.get("https://www.saucedemo.com/");
			log.info("user has been redirected to Sauce demo site.");
		} catch (Exception e) {
			log.error("Invalid site url or protocol is missing");
		}
		Thread.sleep(2000);
		w.findElement(By.id("user-name")).sendKeys("standard_user");
		log.info("User Enter user name in username field");
		Thread.sleep(2000);
		w.findElement(By.id("password")).sendKeys("secret_sauce");
		log.info("User Enter password in password field");
		Thread.sleep(2000);
		w.findElement(By.id("login-button")).click();
		log.info("user click on login button");
		Thread.sleep(2000);
		w.findElement(By.id("react-burger-menu-btn")).click();
		log.info("user click on burger button");
		Thread.sleep(2000);
		w.findElement(By.linkText("Logout")).click();
		log.info("user click on logout button");
		
		
		
		
		
		
		

	}

}
