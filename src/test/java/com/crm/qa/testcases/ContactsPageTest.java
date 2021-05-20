/*
 * Author name : Varun Bhatia
 */

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		testUtil.switchToFrame();
		
		contactsPage=homePage.clickContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsLabel()
	{
		
		
		boolean b=contactsPage.verifyContactLabel();
		Assert.assertTrue(b, "Contact Label Not found");
	}
	
	@Test(priority=2)
	public void selectContactsCheckBox()
	{
		
		boolean val=contactsPage.selectContactByName("Pike");
		Assert.assertTrue(val, "CheckBox was not selected");
				
	}
	
	@Test(priority=3)
	public void selectMultipleContacts()
	{
		boolean val=contactsPage.selectContactByName("Apple");
		Assert.assertTrue(val, "CheckBox was not selected");
		boolean value=contactsPage.selectContactByName("Banana");
		Assert.assertTrue(value, "CheckBox was not selected");
		boolean values=contactsPage.selectContactByName("Cucumber");
		Assert.assertTrue(values, "CheckBox was not selected");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void createNewContact(String Titl,String fname,String lname,String comp,String mail,String phn)
	{
		homePage.clickOnNewContact();
		
		boolean res=contactsPage.createNewContact(Titl,fname,lname,comp,mail,phn);
		Assert.assertTrue(res);
		//homePage.clickContactsLink();
		//boolean val=contactsPage.selectContactByName("Pike");
		//Assert.assertTrue(val, "Contact is not present not selected");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
