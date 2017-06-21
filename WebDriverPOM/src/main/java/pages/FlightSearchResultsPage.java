package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import base.BasePage;

public class FlightSearchResultsPage extends BasePage{

	@FindBy(xpath ="//h1[contains(text(),'Make a booking')]")
	private WebElement search_page_Header;
	
	@FindBy(xpath = "//*[@id='resultSearchHolder']/table//*[normalize-space(text())='Departing']/..")
	private WebElement departing_date;
	
	@FindBy(xpath = "//*[@id='resultSearchHolder']/table//*[normalize-space(text())='Returning']/..")
	private WebElement returning_date;
	
	@FindBys({@FindBy(xpath = "//*[@class='via-text']")})
	private List<WebElement> list_of_flights;
	
	public FlightSearchResultsPage(WebDriver driver){
		super(driver);
	}
	
	public WebElement get_page_header(){
		return search_page_Header;
	}
	
	public WebElement get_departing_date(){
		return departing_date;
	}
	
	public WebElement get_returning_date(){
		return returning_date;
	}
	public List<WebElement> get_list_of_flights(){
		return list_of_flights;
	}
	

}
