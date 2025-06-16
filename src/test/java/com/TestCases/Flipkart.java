package com.TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Flipkart {
WebDriver w;
	@Given("user launch firefox browser.")
	public void user_launch_firefox_browser() {
	    w = new FirefoxDriver();
	}
	@Given("user navigate to flipkart site.")
	public void user_navigate_to_flipkart_site() {
	   w.get("https://www.flipkart.com/");
	}
	@When("user search {string} in search field.")
	public void user_search_in_search_field(String search) throws Exception {
		Thread.sleep(2000);
	    w.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
	    Thread.sleep(2000);
	}
	@Then("I verify the title of {string} of the page")
	public void i_verify_the_title_of_of_the_page(String exptitle) {
	   Assert.assertEquals(w.getTitle().contains(exptitle), true);
	}
	@Then("Close firefox browser.")
	public void close_firefox_browser() {
	    w.quit();
	}	
}