package com.gmail.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gmail.base.TestBase;
import com.gmail.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase
{
    LoginPage loginPage; // Declared Globally
    
	public LoginPageTest() throws Exception  // Constructor Calling
	{
		super(); // will call super class constructor , it's mandatory to call testbase class constructor.
	}

	@BeforeMethod
	
	public void initializePageObjects() 
	{
		loginPage=new LoginPage(driver); // Login page class object to access all the login functions or methods
	}
	
	@Test(priority=1)
	
	public void t01_loginPageTitleTest() 
	{
		String title=loginPage.gmailTitle();
		Assert.assertEquals(title, "Gmail");
	}
	
	@Test(priority=2 )
	public void t02_loginTest() throws InterruptedException 
	{
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
}
