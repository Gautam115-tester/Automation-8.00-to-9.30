package com.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Demo {

	public static void main(String[] args) {
		
		WebDriver w = new EdgeDriver();
		w.get("https://www.saucedemo.com/");
		
		String s = w.findElement(By.className("login_logo")).getText();
		
		System.out.println(s.equals("Swag Labs"));

	}

}
