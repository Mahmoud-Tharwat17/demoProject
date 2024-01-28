package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHome {
	//variables
	String url = "https://www.google.com/";
	WebDriver driver;
	
	//locators
	By googleLogo = By.xpath("//img[@alt='Google']");
	By googleSearch = By.name("q");
	
	//constructor
	public GoogleHome(WebDriver driver){
		this.driver = driver;
	}
	
	//keywords / actions
	public void navigate() {
		driver.navigate().to(url);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean isGoogleLogoDisplayed() {
		return  driver.findElement(googleLogo).isDisplayed();
	}
	
	public void searchForQuery(String query) {
		driver.findElement(googleSearch).sendKeys(query + Keys.ENTER);
	}  
	
	public void Login()
	{
		
	}

}
