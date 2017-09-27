package com.fourstay.step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fourstay.pages.FourStayHomePage;
import com.fourstay.utilies.ConfigurationReader;
import com.fourstay.utilies.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs {
 WebDriver driver;
 FourStayHomePage elements = new  FourStayHomePage();	
 
	@Given("^the user is  on fourstay home page$")
	public void the_user_is_on_fourstay_home_page() throws Throwable {
	    driver=Driver.getInstance();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(ConfigurationReader.getProperty("url"));
	}

	@When("^the user clicks on the login link$")
	public void the_user_clicks_on_the_login_link() throws Throwable {
		Thread.sleep(5000);
		elements.login.click();
		System.out.println("Email field is now displayed");
		Thread.sleep(5000);
	
	}

	@Then("^the email field should be displayed$")
	public void the_email_field_should_be_displayed() throws Throwable {
		Assert.assertTrue(elements.username.isDisplayed());
	}



}
