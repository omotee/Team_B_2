package com.coggles.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{

	public LandingPage(WebDriver driver) {
		super(driver);
		
	}
	public boolean verifyLandingPage(String veriName){
		boolean validName = driver.getPageSource().contains(veriName);
		return validName;
		
	}

	 
}
