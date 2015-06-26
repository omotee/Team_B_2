package com.seotoaster.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
//	private String baseUrl = "http://free-ecommerce-solution.seotoaster.com/";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void visitHomePage() {
		try{
			logger.info("visitHomePage method started");
			driver.navigate().to(config.getProperty("baseUrl"));
			logger.info("visitHomePage method executed successfully");
		}catch(Exception e){
			logger.error("visitHomePage method encountered error");
			camera.takeShot("visitHomePage");
		}
		
	}

	public void verifyHomePageExist() {
		try{
			String message = "I am not sure that you are on the home page";
			Assert.assertTrue(message, driver.getTitle().contains("Home"));
		}catch(Exception e){
			camera.takeShot("verifyHomePage");
			System.out.println("verify method has fialed with error "+e);
		}		
	}


}
