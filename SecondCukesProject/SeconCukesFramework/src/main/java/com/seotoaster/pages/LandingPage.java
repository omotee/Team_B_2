package com.seotoaster.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public void verifyThatTheMessageExist(String message) {
		try{
			logger.info("The verifyThatTheMessageExist started successfully with "+message+ " as data");
			Assert.assertTrue(message+" does not exist", driver.getPageSource().contains(message));
		}catch(Exception e){
			camera.takeShot("verifyThatTheMessageExist");
			logger.error("The verifyThatTheMessageExist encountered an error as is does not see "+message);
		}
		
	}
	
	
	

}
