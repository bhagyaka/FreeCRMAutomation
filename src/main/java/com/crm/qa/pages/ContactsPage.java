package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	String sheetName= "contacts";
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement Contacts_label;
	
	@FindBy(id="first_name")
	WebElement FirstName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	

	@FindBy(xpath="//input[(@type='submit' and @value='Save')]")
	WebElement savebtn;
	/*@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement Contacts_label;
	*/
	//a[text()='Harshada Kapile']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsPageLabel(){
		return Contacts_label.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//"
				+ "preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();;
		
	}
	
	public void createNewContact(String title, String ftname, String ltname, String comp){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		FirstName.sendKeys(ftname);
		LastName.sendKeys(ltname);
		company.sendKeys(comp);
		savebtn.click();
		
		
		
	}

}
