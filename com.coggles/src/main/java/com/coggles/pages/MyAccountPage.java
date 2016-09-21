package com.coggles.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyAccountPage extends BasePage{
	
	private By emailField = By.id("email");
	private By pwordField = By.id("passwd");
//	private By loginField = By.id("SubmitLogin");

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

	public LandingPage login(String email, String Password) {
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(pwordField).sendKeys(Password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		WebElement element = driver.findElement(By.id("SubmitLogin"));

		Actions actions = new Actions(driver);

		actions.moveToElement(element).click().perform();
//		driver.findElement(loginField).click();
		return new LandingPage(driver);
		
		
	}

	private By By(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
