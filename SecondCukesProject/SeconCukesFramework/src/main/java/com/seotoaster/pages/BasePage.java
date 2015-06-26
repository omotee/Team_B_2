package com.seotoaster.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.seotoaster.utils.Screenshot;

public class BasePage {
	
	protected WebDriver driver;
	protected static Logger logger ;
	protected static Screenshot camera;
	protected static Properties config ;
	protected static InputStream fis;
	
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		logger = LogManager.getLogger("TayoLog4J");
		camera = new Screenshot(driver);
		config = new Properties();
		try {
			fis = new FileInputStream("C:\\Projects\\JavaProjects\\team_B\\CucumberFramework\\SecondCukesProject\\SeconCukesFramework\\src\\main\\resources\\ObjectRepository.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void setUpDatabase (){
		logger.info("Database started!!!");
	}

	public void setUpDriver() {
		logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		logger.info("The setUp method started successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Implicit wait of 10 secs started");
		driver.manage().window().maximize();
		logger.info("Browser has been maximized");
		logger.info("The Web Address has been loaded successfully");
		
	}


	public void tearDownDriver() {
		driver.quit();
		logger.info("The browser has now closed successfully");
		driver = null;
		logger.info("****************************************");
	}


}
