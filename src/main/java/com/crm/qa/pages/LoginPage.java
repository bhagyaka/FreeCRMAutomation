package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	 // page factory / object repositiory for login page 
	
	@FindBy(name="username")
	WebElement username;
	/*@FindBy(name = "//input[@name='username']")
	WebElement Username;*/
	
	@FindBy(name="password")
	WebElement password;
	/*@FindBy(name = "//input[@name='password']")
	WebElement Password;*/
	
    @FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn;
    
    @FindBy(xpath="//button[contains(text(),'Sign Up')]")
    WebElement SignUpBtn;

    @FindBy(xpath = "//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;
    //initialize object 
    public LoginPage(){
    	PageFactory.initElements(driver, this);// to initialize page factory 
    	    }
    //action 
    public String validateLoginPageTitle()
    {
    	return driver.getTitle();
    	
    }
    
    public boolean validateCrmImage(){
    	 return crmLogo.isDisplayed();
    	
    }
    
    public HomePage login(String un, String pwd)
    {
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	//loginBtn.click();
    	//loginBtn.submit();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
    	
    	return new HomePage();
    	
    }
    
    /*public HomePage login1(String un, String pwd)
    { 
    	Username.sendKeys(un); 
    	Password.sendKeys(pwd);
    	 //loginBtn.click();
    	     JavascriptExecutor js = (JavascriptExecutor)driver; 
    	    js.executeScript("arguments[0].click();", loginBtn);
    	         return new HomePage(); 
    }*/
    
}


	




