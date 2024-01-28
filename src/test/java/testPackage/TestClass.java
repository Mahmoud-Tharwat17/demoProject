package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleHome;
import pages.GoogleResults;

public class TestClass {
	WebDriver driver;
	GoogleHome home;
	GoogleResults results;
	
	@Test(description = "Given I am on the Google Home page, Then the page title should be 'Google'.")
	public void checkPageTitle() {
		System.out.println("checkPageTitle");
		String title = home.getTitle();
		Assert.assertEquals(title, "Google");
	}

	@Test(description = "Given I am on the Google Home page, Then the Google Logo will be displayed.")
	public void checkThatGoogleLogoIsDisplayed() {
		System.out.println("checkThatGoogleLogoIsDisplayed");
		boolean isDisplayed = home.isGoogleLogoDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@Test(description = "Given I am on the Google Home page, When I search for 'Selenium WebDriver', Then the result stats will not be empty.")
	public void checkThatResultStatsIsNotEmpty() {
		System.out.println("checkThatResultStatsIsNotEmpty");		
		home.searchForQuery("Selenium WebDriver");
		
		String resultStatsText = results.getResultStatsText();
		Assert.assertNotEquals(resultStatsText, "");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		home = new GoogleHome(driver);
		results = new GoogleResults(driver);
		
		home.navigate();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
		driver.quit();
	}
}
