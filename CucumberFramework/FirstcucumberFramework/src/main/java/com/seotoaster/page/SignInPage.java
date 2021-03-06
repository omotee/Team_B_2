package com.seotoaster.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignInPage extends AbstractPage{


	public SignInPage(WebDriver driver) {
		super(driver);
	}

	
	public void visitSignInPage() {
		try{
		driver.findElement(By.linkText("Sign in")).click();
		}catch(Exception e){
			System.out.println("The visit Sign in method failed with error "+e);
			camera.takeShot("visitSignInPage");
		}
	}

	public void loginWith(String username, String password) {
		try{
			driver.findElement(By.id("email")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("submit")).click();
		}catch(Exception e){
			camera.takeShot("loginWith");
			System.out.println("The visit Login method failed with error "+e);
		}
	}

}
