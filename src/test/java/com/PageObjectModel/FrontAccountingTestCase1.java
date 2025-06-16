package com.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FrontAccountingTestCase1 {

	public static void main(String[] args) throws Exception {
		
		WebDriver w = new EdgeDriver();
		System.out.println(w);
		RepoOfFrontAccounting r = new RepoOfFrontAccounting(w);
		w.get("http://demo.frontaccounting.eu/");
		Thread.sleep(2000);
		r.clearUsername();
		Thread.sleep(2000);
		r.clearPassword();
		Thread.sleep(2000);
		r.enterUsername("demouser");
		Thread.sleep(2000);
		r.enterPassword("password");
		Thread.sleep(2000);
		r.login();
		Thread.sleep(2000);
		r.logout();

	}

}
