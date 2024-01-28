package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleResults {
	//variables
	WebDriver driver;
	
	//locators
	By resultStats = By.id("result-stats");
	
	//constructor
	public GoogleResults(WebDriver driver) {
		this.driver = driver;
	}
	
	//actions / keywords
	public String getResultStatsText() {
		return driver.findElement(resultStats).getText();
	}
}
