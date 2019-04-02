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
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil; 
	ContactsPage contactPage;
	String sheetName = "contacts"; 
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		contactPage = new ContactsPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		contactPage = homePage.clickOnContactsLink();
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactPage.verifyContactsPageLabel(), "Label not found");
		
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactPage.selectContactsByName("Harshada Kapile");
		
	}
	
	@Test(priority=3)
	public void selectMulContactsTest(){
		contactPage.selectContactsByName("Harshada Kapile");
		contactPage.selectContactsByName("Test1 Test1");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String Title, String FirstName,String LastName, String Company){
		homePage.clickOnNewcontactLink();
		//contactPage.createNewContact("Ms.","Karuna", "Patil", "Microsoft");
		contactPage.createNewContact(Title, FirstName, LastName, Company);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
