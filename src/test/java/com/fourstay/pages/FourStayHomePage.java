package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilies.Driver;

public class FourStayHomePage {
	public FourStayHomePage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = ".not-login")
	public WebElement login;

	@FindBy(id = "email")
	public WebElement username;
}
