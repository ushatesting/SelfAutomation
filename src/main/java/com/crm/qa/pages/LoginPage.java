package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase  {


	
		//page factory//OR
	
		@FindBy(name="username")
		WebElement Username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;
		
		@FindBy(xpath="//img[@class='img-responsive']")
		WebElement CRMlogo;
		
		//initialuzing the page Objects
		public LoginPage() {
			
			PageFactory.initElements(driver,this);
			
		}
		
		//Actions
		public String validateLoginPageTitle() {
		 return driver.getTitle();
		 
		}
		
		public boolean validateCRMLogo() {
			return CRMlogo.isDisplayed();	
		}
		
		public HomePage Login(String un,String pwd) throws IOException {
			Username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			return new HomePage();
			
			
		}
		
		
	
	

}
