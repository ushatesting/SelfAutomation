package com.crm.qa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	
	public ContactsPageTest() {
		super();
	}

	
	@BeforeMethod 
	public void Setup() throws IOException {
	Initialization();
	testUtil=new TestUtil();
	loginPage = new LoginPage();
	contactsPage = new ContactsPage();
	homePage=loginPage.Login("Ushamul","gudiya@26");
	testUtil.SwitchToFrame();
	contactsPage=homePage.clickOnContactsLink();
	
    }
	
	@Test(enabled=false)
	public void VerifyContactsLabel()
	{
		boolean flag=contactsPage.VerifyContactsLabel();
		Assert.assertTrue(flag);
	}
		
	@Test(enabled=false)
	public void SelectContactsTest() {
		contactsPage.selectContactsByName("Umesh");	
		contactsPage.selectContactsByName("Rajesh");
	}
	
	
	@DataProvider
	public Object[][] getTestdata() throws IOException {
	Object[][] Testdata=TestUtil.getDataFromExcel();
	return Testdata;
	
	}
	
	@Test(dataProvider="getTestdata")
	public void validateCreateNewContact(String Title,String FirstName,String LastName,String Company) throws InterruptedException
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(Title, FirstName, LastName, Company);
	}
	
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	} 
		
		
}
