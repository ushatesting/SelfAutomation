package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	

	public HomePageTest() {
		super();
	}
	
	

	
	@BeforeMethod 
	public void Setup() throws IOException {
	Initialization();
	testUtil=new TestUtil();
	loginPage = new LoginPage();
	contactsPage = new ContactsPage();
	homePage=loginPage.Login("Ushamul","gudiya@26");
	
	
		
	}
	
	@Test(enabled=false)
	public void VerifyHomePageTitle()
	{
		String HomePageTitle=homePage.verifyHomePageTitle();
	    Assert.assertEquals(HomePageTitle, "CRMPRO");

		
	}
	
	@Test(enabled=false)
	public void ValidateUserNamelabel()
	{
		testUtil.SwitchToFrame();
		boolean Flag=homePage.validateUserNameLabel();
		Assert.assertTrue(Flag);
	}
	
	@Test
	public void VerifyContactLinkTest() 
	{
		testUtil.SwitchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
		
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
		
		
		
		
	
}
