package com.PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RepoOfFrontAccountingWithPageFactory {
	public RepoOfFrontAccountingWithPageFactory(WebDriver w) {
		PageFactory.initElements(w, this);
	}
//	@findBy --> located the element with the help of ( written content)
	@FindBy(name = "user_name_entry_field") private WebElement username;
	@FindBy(name = "password") private WebElement password;
	@FindBy(name = "SubmitUser") private WebElement loginbtn;
	@FindBy(linkText = "Logout") private WebElement logoutbtn;
	public void clearUsername() {
		username.clear();
	}
	public void enterUsername(String user) {
		username.sendKeys(user);
	}
	public void clearPassword() {
		password.clear();
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public void login() {
		loginbtn.click();
	}
	public void logout() {
		logoutbtn.click();
	}
	
	
}
