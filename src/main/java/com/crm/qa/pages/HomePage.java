package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Bhagyashree Kapile')]")
	@CacheLookup
	WebElement username_label;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement Contacts_link;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContacts_link;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement Deals_Link;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Task_Link;
	
	public HomePage(){
	PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomepageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername(){
		
		return username_label.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		Contacts_link.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		Deals_Link.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskLink(){
		Task_Link.click();
		//Deals_Link.click();
		return new TaskPage();
	}
	
	
	public void clickOnNewcontactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(Contacts_link).build().perform();
		NewContacts_link.click();
		
		
	}
	
}
