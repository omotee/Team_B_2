package com.seotoaster.steps;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.seotoaster.page.AbstractPage;
import com.seotoaster.page.HomePage;
import com.seotoaster.page.LandingPage;
import com.seotoaster.page.MountainBikePage;
import com.seotoaster.page.RoadBikePage;
import com.seotoaster.page.SignInPage;
import com.seotoaster.page.SignOutPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefintion {
	
	public WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage;
	private LandingPage landingPage;
	private static AbstractPage abstractPage;
	private SignOutPage signOutPage;
	private RoadBikePage roadBikePage;
	private MountainBikePage mountainBikePage;
	
	
	
	
	

	
	
	public LoginStepDefintion(){
		this.driver = new FirefoxDriver();
		this.homePage = new HomePage(driver);
		this.signInPage = new SignInPage(driver);
		this.landingPage = new LandingPage(driver);
		abstractPage = new AbstractPage(driver);
		this.signOutPage = new SignOutPage(driver);
		this.roadBikePage = new RoadBikePage(driver);
		this.mountainBikePage = new MountainBikePage(driver);
	}
	
	@Before
	public void startTest(){
		abstractPage.setUpDriver();
	}
	
	@After
	public void stopTest(){
		abstractPage.tearDownDriver();	
	}
	
	
	@Given("^that a customer is on the homepage$")
	public void that_a_customer_is_on_the_homepage() throws Throwable {
		homePage.verifyHomePage();
		
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}

	@When("^he logs on with username as \"(.*?)\" and password as \"(.*?)\"$")
	public void he_logs_on_with_username_as_and_password_as(String username, String password) throws Throwable {
		signInPage.visitSignInPage();
		signInPage.loginWith(username, password);
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}

	@Then("^he should be on the landing page$")
	public void he_should_be_on_the_landing_page() throws Throwable {
		landingPage.verifySuccessfulLogin();
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}
	
	
	@Then("^he should see error message$")
	public void he_should_see_error_message() throws Throwable {
		homePage.verifyUnsuccessfulLogin();
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}
	

}
