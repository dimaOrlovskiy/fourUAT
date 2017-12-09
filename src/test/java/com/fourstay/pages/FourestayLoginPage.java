package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilies.Driver;

public class FourestayLoginPage {
    public FourestayLoginPage(){
    	PageFactory.initElements(Driver.getInstance(), this);
    }
    	@FindBy(css = ".not-login")
    	public WebElement login;
    	
    	@FindBy(id= "email")
    	public WebElement userName;
    	
    	@FindBy(name="password")
    	public WebElement Password;
    	
    	@FindBy(id="btn-login")
    	public WebElement loginButton;
    	
    	@FindBy(xpath="//span[.='LOGOUT']")
    	public WebElement Logout;
    	//Some changes
    	
    }
	

