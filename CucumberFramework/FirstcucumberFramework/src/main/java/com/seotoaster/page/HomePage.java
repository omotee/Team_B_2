package com.seotoaster.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void verifyHomePage() {
		try{
			String message = "I am not sure that you are on the home page";
			Assert.assertTrue(message, driver.getTitle().contains("Home"));
		}catch(Exception e){
			camera.takeShot("verifyHomePage");
			System.out.println("verify method has fialed with error"+e);
		}
	}

	public void verifyUnsuccessfulLogin() {
		// TODO Auto-generated method stub
		
	}

}
