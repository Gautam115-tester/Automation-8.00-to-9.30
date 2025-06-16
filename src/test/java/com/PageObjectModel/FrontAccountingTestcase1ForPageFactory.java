package com.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FrontAccountingTestcase1ForPageFactory {

	public static void main(String[] args) throws Exception {
		
		WebDriver w = new EdgeDriver();
		w.get("https://demo.frontaccounting.eu/");
		RepoOfFrontAccountingWithPageFactory r = new RepoOfFrontAccountingWithPageFactory(w);
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
		if (w.getTitle().equals("Main Menu")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");

		}

	}

}
