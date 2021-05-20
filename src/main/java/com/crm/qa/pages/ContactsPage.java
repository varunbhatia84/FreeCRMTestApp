package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	//@FindBy(xpath="//a[contains(text(),'Aayur')]/parent::td//preceding-sibling::td//input[@name='contact_id']")
	
	@FindBy(xpath="//select[@name='title']")
	WebElement titleDropdown;
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyName;
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	@FindBy(xpath="//input[@name='phone']")
	WebElement phone;
	@FindBy(xpath="//input[@type='button'][@value='Load From Company']/following-sibling::input[@value='Save']")
	WebElement saveBtn;
	//@FindBy(xpath="//span[@id=\"first_name\"]")
	//WebElement addedContact;
	
	
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel()
	{
		return contactLabel.isDisplayed();
	}
	
	public boolean selectContactByName(String name)
	{
		String beforeXpath="//a[contains(text(),'";
		String afterXpath="')]/parent::td//preceding-sibling::td//input[@name='contact_id']";
		WebElement checkBox=driver.findElement(By.xpath(beforeXpath+name+afterXpath));
		checkBox.click();
		Boolean flag=checkBox.isSelected();
		return flag;
	}
	
	
	public boolean createNewContact(String titl,String fname,String lname,String comp,String eml, String phn)
	{
		Select title=new Select(titleDropdown);
		title.selectByVisibleText(titl);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyName.sendKeys(comp);
		email.sendKeys(eml);
		phone.sendKeys(phn);
		saveBtn.click();
		
		//span[contains(text(),'Mukesh')]
		String bfore_xpath="//span[contains(text(),'";
		String aft_xpath="')]";
		WebElement addedContact=driver.findElement(By.xpath(bfore_xpath+fname+aft_xpath));
		Boolean add=addedContact.isDisplayed();
		return add;
		
		
	}
	
}
