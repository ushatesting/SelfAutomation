package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {

	
	//Page factory
	
	@FindBy(xpath="//td[contains(text(),'Mulchandani')]")
	WebElement UsernameLabel;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[text()='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContactLink;
	
	
	//initialuzing the page Objects
	public HomePage() {
	PageFactory.initElements(driver,this);
	}			
	
	public String verifyHomePageTitle() 
	{
		String HomePageTitle=driver.getTitle();
		return HomePageTitle;
	}
			
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();	
		return new DealsPage();
	}
				
	public boolean validateUserNameLabel() 
	{
		
		return(UsernameLabel.isDisplayed());
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
		
	}
	
	public void clickOnNewContactLink() 
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		NewContactLink.click();
	}
}

	
	
	

