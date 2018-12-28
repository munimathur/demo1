package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.base.TestBase;

public class LoginPage{
	// Page Factory Method
	public WebDriver driver;

	@FindBy(id = "identifierId")
	private WebElement username;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextusername;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextpassword;

	// Initialize Page Objects

	public LoginPage(WebDriver driver) // Creating Constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions or features

	public String gmailTitle() {
		System.out.println(driver.getCurrentUrl()+""+driver.getTitle());
		return driver.getTitle();
	}

	public LoginPage login(String un, String pwd) throws InterruptedException // This method is returning homepage class object
	{
		username.sendKeys(un);
		nextusername.click();
		
		Thread.sleep(3000);

		password.sendKeys(pwd);
		nextpassword.click();
		Thread.sleep(3000);
		return new LoginPage(driver);
	}

}
