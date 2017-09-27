package com.fourstay.step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.FourestayLoginPage;
import com.fourstay.utilies.ConfigurationReader;
import com.fourstay.utilies.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefs  {
	FourestayLoginPage elements = new FourestayLoginPage();
   private WebDriver driver;
	@Given("^I am on the fourstay homepage$")
	public void i_am_on_the_fourstay_homepage() throws Throwable {
	driver = Driver.getInstance();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   driver.get(ConfigurationReader.getProperty("url"));
	} 

	@When("^I login as a host$")
	public void i_login_as_a_host() throws Throwable {
		WebDriverWait Wait = new WebDriverWait(driver, 30);
        elements.login.click();
        Wait.until(ExpectedConditions.visibilityOf(elements.userName));
        Thread.sleep(3000);
		elements.userName.sendKeys(ConfigurationReader.getProperty("host.username"));
		Wait.until(ExpectedConditions.visibilityOf(elements.Password));
        Thread.sleep(3000);
		elements.Password.sendKeys(ConfigurationReader.getProperty("host.password"));
		elements.loginButton.click();
	}

	@Then("^I should be able verify I am logged in$")
	public void i_should_be_able_verify_I_am_logged_in() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(Driver.getInstance().getCurrentUrl().contains("dashboard"));
		
	}

	@When("^I login as a guest$")
	public void i_login_as_a_guest() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 150);

		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(elements.login));
		elements.login.click();
		wait.until(ExpectedConditions.visibilityOf(elements.userName));
		Thread.sleep(1000);
		elements.userName.sendKeys(ConfigurationReader.getProperty("guest.username"));
		wait.until(ExpectedConditions.visibilityOf(elements.Password));
		elements.Password.sendKeys(ConfigurationReader.getProperty("guest.password"));

		elements.loginButton.click();

	}

	}
  

	

