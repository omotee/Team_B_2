package com.seotoaster.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignInPage extends BasePage{


	public SignInPage(WebDriver driver) {
		super(driver);
	}

	


	public void loginWith(String username, String password) throws Exception {
		try{
			logger.info("The loginWith method started successfully");
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.id(config.getProperty("usernameID"))).sendKeys(username);
			driver.findElement(By.id(config.getProperty("passwordID"))).sendKeys(password);
			driver.findElement(By.id("submit")).click();
			logger.info("The loginWith method executed successfully");
		}catch(Exception e){
			logger.error("The loginWith method encountered error");
			camera.takeShot("loginWith");
			throw new Exception("There is a problem with login feature");
		}
	}

}
