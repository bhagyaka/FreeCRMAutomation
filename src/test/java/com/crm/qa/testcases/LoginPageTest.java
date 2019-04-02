package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage ;
	HomePage homePage;
	
	
	public  LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		//testUtil = new TestUtil();
	}
	
	@Test(priority=2)
	public void LoginPageTitleTest()
	{
		String Title = 	loginPage.validateLoginPageTitle();
		Assert.assertEquals(Title, "Free CRM software in the cloud powers sales and customer service");
		
	}
	
	@Test(priority=3)
	public void CrmLogoImageTest(){
		boolean flag = loginPage.validateCrmImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
