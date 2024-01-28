package w3Schools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Tables {
	WebDriver driver;
	String url = "https://www.w3schools.com/html/html_tables.asp";
	
	By companyLocator;

	public Tables(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate() {
		driver.navigate().to(url);
	}

	public String getCountryName(String companyName) {
		/*
		//tagName[@attribute='value']
		//tagName[contains(attribute,'subset-value')]
		//parentTagName[@attribute='value']/childTagName
		//parentTagName[@attribute='value']//grandChildTagName
		(//tagName[@attribute='value'])[2]
		//*[@attribute='value']
		//tagName[text()='value']
		//parentTagName[contains(.,'value')]
		//tagName[@attribute='value']/following-sibling::siblingTagName
		 */
		
//		companyLocator = By.xpath("(//td[text()='"+companyName+"']/following-sibling::td)[2]");
//		companyLocator = By.xpath("//tr[contains(.,'"+companyName+"')]/td[3]");
		companyLocator = RelativeLocator.with(By.tagName("td")).below(By.xpath("//th[text()='Country']")).toRightOf(By.xpath("//td[text()='"+companyName+"']"));
		return driver.findElement(companyLocator).getText();
	}
}
