package com.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FrontAccountingTestCase2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver w = new EdgeDriver();
		w.get("http://demo.frontaccounting.eu/");
		RepoOfFrontAccounting r = new RepoOfFrontAccounting(w);
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
		r.sQE();
		Thread.sleep(2000);
		r.cancel();
		Thread.sleep(2000);
		w.switchTo().alert().accept();
		Thread.sleep(2000);
		r.logout();

	}

}
