package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	//@CacheLookup--this web element is stored in cache (memory), so everytime whenever
	//we are interacting with this particular element instead of interacting with the web page
	//we would be interacting with memory , with this the speed of automation is increased
	
	WebElement ContactsLabel;
	
	//@FindBy(xpath="//select[@name='title']")
	//WebElement Title;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//td[@colspan=\"2\"]/child::input[@type='submit' and @value='Save']")
    WebElement savebtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyContactsLabel()
	{
		boolean flag=ContactsLabel.isDisplayed();
		return flag;
	}
	
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
	}
	
	public void createNewContact(String title,String ftname,String Ltname,String cmpyname)
	{
			Select select=new Select(driver.findElement(By.xpath("//select[@name='title']")));
			select.selectByVisibleText(title);
			FirstName.sendKeys(ftname);
			LastName.sendKeys(Ltname);
			company.sendKeys(cmpyname);
			savebtn.click();
					
	}
}
