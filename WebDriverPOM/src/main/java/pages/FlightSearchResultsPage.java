package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class FlightSearchResultsPage extends BasePage{

	
	@FindBy(xpath = "//*[@id='resultSearchHolder']/table//*[normalize-space(text())='Departing']/..")
	private WebElement departing_date;
	
	@FindBy(xpath = "//*[@id='resultSearchHolder']/table//*[normalize-space(text())='Returning']/..")
	private WebElement returning_date;
	
	public FlightSearchResultsPage(WebDriver driver){
		super(driver);
	}

}
