package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage  extends TestBase{
	
	//Page factory--OR(Object repository)
	
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpBtn;
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo;
	
	
	
	//Intializes page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);//intializes page factor objects
	}
	//Actions : Title of page
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	//Actions : validate the image displayed
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	//Action : Login to application
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

}
