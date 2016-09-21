package com.coggles.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManOrderPage extends BasePage{

	public ManOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void manFootWear(){
	driver.findElement(By.xpath("//*[@id='home']/div/div[1]/section/div[2]/div/div/article[1]/div/a/div[2]/span")).click();	
	}
}
