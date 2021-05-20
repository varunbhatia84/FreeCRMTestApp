package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest()
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
		
	}
	//test cases should be independent with each other
	//before each test case launch browser and login
	//@Test--> execute your test case
	//after each test case close the browser
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","HomePage Title does not match");
	}
	@Test(priority=2)
	public void verifyUsername()
	{
		testUtil.switchToFrame();
		boolean flag =homePage.verifyUserNameLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage=homePage.clickContactsLink();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
