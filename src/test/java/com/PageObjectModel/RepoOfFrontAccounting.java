package com.PageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RepoOfFrontAccounting {
WebDriver w;
	public RepoOfFrontAccounting(WebDriver w) {  // object init  constructor
		this.w = w;
//		var = value;
	}   // without page factory.
//	This will help to located your element.
	private By username = By.name("user_name_entry_field");
	private By password = By.name("password");
	private By loginbtn = By.name("SubmitUser");
	private By SQELink = By.linkText("Sales Quotation Entry");
	private By cancel = By.id("CancelOrder");
	private By logoutLink = By.linkText("Logout");
//	operation or task you want to perform in an webpage.
	public void clearUsername() {
		w.findElement(username).clear();
	}
	public void enterUsername(String user) {
		w.findElement(username).sendKeys(user);
	}
	public void clearPassword() {
		w.findElement(password).clear();
	}
	public void enterPassword(String pass) {
		w.findElement(password).sendKeys(pass);
	}
	public void login() {
		w.findElement(loginbtn).click();
	}
	public void sQE() {
		w.findElement(SQELink).click();
	}
	public void cancel() {
		w.findElement(cancel).click();
	}
	public void logout() {
		w.findElement(logoutLink).click();
	}
}
