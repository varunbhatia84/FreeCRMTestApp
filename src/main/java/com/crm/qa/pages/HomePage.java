package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	//Intialize page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
		
	}
	public DealsPage clickDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
		
	}
	
	public TasksPage clickTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
		
	}
	
	public boolean verifyUserNameLabel()
	{
		
		return userNameLabel.isDisplayed();
	
	}
	
	public void clickOnNewContact()
	{
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactsLink);
		Actions action=new Actions(driver);
		action.dragAndDropBy(contactsLink,-1,0);
		JavascriptExecutor js=((JavascriptExecutor) driver); 
		js.executeScript("arguments[0].click();",newContactLink);
		//newContactLink.click();
		//return new ContactsPage();
		
	}
	
	

}
