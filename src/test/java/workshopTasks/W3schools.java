package workshopTasks;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import w3Schools.Tables;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class W3schools {
	WebDriver driver;
	Tables tablePage;

	@Test(description = "Given I am on W3Schools Tables page, Then Austria will be the Country name for Ernst Handel.")
	public void checkThatTheCorrectCountryIsDisplayed() {
		String actualCountryName = tablePage.getCountryName("Ernst Handel");
		Assert.assertEquals(actualCountryName, "Austria");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		tablePage = new Tables(driver);
		tablePage.navigate();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
	}

}
