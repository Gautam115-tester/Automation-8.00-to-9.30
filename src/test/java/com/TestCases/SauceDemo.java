package com.TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class SauceDemo {
WebDriver w;
	@Given("user launch edge browser.")
	public void user_launch_edge_browser() {
	   w = new EdgeDriver();
	}
	@Given("user navigate to saucedemo site.")
	public void user_navigate_to_saucedemo_site() {
	   w.get("https://www.saucedemo.com/");
	}
	@When("user enter {string} in username field.")
	public void user_enter_in_username_field(String username) {
	   w.findElement(By.id("user-name")).sendKeys(username);
	}
	@When("user enter {string} in password field.")
	public void user_enter_in_password_field(String password) {
	    w.findElement(By.id("password")).sendKeys(password);
	}
	@When("user click on login button.")
	public void user_click_on_login_button() {
	   w.findElement(By.id("login-button")).click();
	}
	@Then("validate user login by checking url.")
	public void validate_user_login_by_checking_url() {
	   Assert.assertEquals(w.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
	@Then("close edge browser.")
	public void close_edge_browser() {
	   w.quit();
	}

	
	
	
}
