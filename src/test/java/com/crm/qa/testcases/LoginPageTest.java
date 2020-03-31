package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

	
public class LoginPageTest extends TestBase {
	
	static LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}

	
	@BeforeMethod 
	public void Setup() {
		
		Initialization();	
		
		loginpage=new LoginPage();
	}
	
	@Test
	public void LoginPageTitleTest() {
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test
	public void validateCRMLogo() {
		boolean flag = loginpage.validateCRMLogo();
		Assert.assertTrue(flag);
	}	
		
	@Test
	public void Logintest() throws IOException {
		homepage=loginpage.Login("Ushamul","gudiya@26");
		
	}
	
	@AfterMethod
	public void teardown() {
    driver.quit();
	}
   


}
