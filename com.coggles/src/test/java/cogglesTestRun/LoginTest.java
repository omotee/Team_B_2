package cogglesTestRun;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.coggles.pages.BasePage;
import com.coggles.pages.HomePage;
import com.coggles.pages.LandingPage;
import com.coggles.pages.MyAccountPage;

public class LoginTest {
	private BasePage basePage;
	private HomePage homePage;
//	private MyAccountPage myAccountPage;
//	private LandingPage landingPage;
//	
	
	@Before
	public void setup(){
//		WebDriver driver =  new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		this.basePage = new BasePage(driver);
		this.homePage = new HomePage(driver);
		}
	/*
	  In the method, return a boolean condition and assert inside of TestClass hence to use Assert do like below,
	  Assert.assertTrue("message", className.methodName());
	 */
		@Test
	public void runValidTest(){
		basePage.getHomePage();
		Assert.assertTrue("The system cannot find the url", homePage.verifyHomePage());
		LandingPage landingPage = homePage.gotToMyAccount().login("tayo.babs@mail.com", "automation");
		Assert.assertTrue("NO such name found", landingPage.verifyLandingPage("Welcome to your account"));
		}
	
	@After
	public void tearDown(){
		basePage.closeBrowser();
		
		
	}
}
