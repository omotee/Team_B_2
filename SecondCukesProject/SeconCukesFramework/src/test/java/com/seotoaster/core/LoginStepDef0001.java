package com.seotoaster.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.seotoaster.pages.BasePage;
import com.seotoaster.pages.HomePage;
import com.seotoaster.pages.LandingPage;
import com.seotoaster.pages.SignInPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef0001 {
	
	private WebDriver driver;
	private BasePage basePage;
	private HomePage homePage;
	private SignInPage signInPage;
	private LandingPage landingPage;
	private static Properties config = new Properties();
	private static InputStream fis;
	
	public LoginStepDef0001() throws Throwable{
		if(driver == null){
			fis = new FileInputStream("C:\\Projects\\JavaProjects\\team_B\\CucumberFramework\\SecondCukesProject\\SeconCukesFramework\\src\\main\\resources\\ObjectRepository.properties");
			config.load(fis);
			if(config.getProperty("browser").equals("firefox")){
				driver = new FirefoxDriver();
			}else if(config.getProperty("browser").equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Projects\\InstalledSoftwares\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(config.getProperty("browser").equals("ie")){
				System.setProperty("webdriver.ie.driver", "C:\\Projects\\InstalledSoftwares\\IEDriverServer_x64_2.46.0\\IEDriverServer.exe");
				driver= new InternetExplorerDriver();
			}else if(config.getProperty("browser").equals("ghost")){
				driver = new HtmlUnitDriver(BrowserVersion.CHROME);
				((HtmlUnitDriver) driver).setJavascriptEnabled(true);
			}else{
				throw new Exception("There is no such browser and we are currently working to incorporate more browser!!!");
			}
		}
	
		basePage = new BasePage(driver);
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
		landingPage = new LandingPage(driver);
	}
	
	
	
	@After
	public void stopTest(){
		basePage.tearDownDriver();
	}
	
	
	@Before
	public void startTest(){
		basePage.setUpDriver();
	}
	
	@Given("^that a customer is on the home page$")
	public void that_a_customer_is_on_the_home_page() throws Throwable {
		homePage.visitHomePage();
	    homePage.verifyHomePageExist();
	}

	@When("^he logs on with username as \"(.*?)\" and password as \"(.*?)\"$")
	public void he_logs_on_with_username_as_and_password_as(String username, String password) throws Throwable {
	    signInPage.loginWith(username, password);
	}

	@Then("^he should see \"(.*?)\" on the landing page$")
	public void he_should_see_on_the_landing_page(String message) throws Throwable {
	    landingPage.verifyThatTheMessageExist(message);
	}


}
