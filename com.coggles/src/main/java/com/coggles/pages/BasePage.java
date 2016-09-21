package com.coggles.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver){
		
		this.driver = driver;
	}

	public void getHomePage(){
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("http://automationpractice.com");
		
	}
	
	public void closeBrowser(){
	
		driver.close();
	}
	
	

}
