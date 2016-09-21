package com.coggles.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	
	private By accountField = By.linkText("Sign in");

	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	public boolean verifyHomePage() {
		String freshUrl = "http://automationpractice.com/index.php";
		boolean validUrl = driver.getCurrentUrl().contains(freshUrl);
		return validUrl;
	}

	public MyAccountPage gotToMyAccount() {
	driver.findElement(accountField).click();
	return new MyAccountPage(driver);
	}
	
	

}
