package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import base.BasePage;

public class FlightSearchResultsPage extends BasePage{
	
	private static ArrayList<String> FirstOutboudPrices = new ArrayList<String>();
	private static ArrayList<String> FirstReturnPrices = new ArrayList<String>();

	@FindBy(xpath ="//h1[contains(text(),'Make a booking')]")
	private WebElement search_page_Header;
	
	@FindBy(xpath = "//*[@id='resultSearchHolder']/table//*[normalize-space(text())='Departing']/..")
	private WebElement departing_date;
	
	@FindBy(xpath = "//*[@id='resultSearchHolder']/table//*[normalize-space(text())='Returning']/..")
	private WebElement returning_date;
	
	@FindBys({@FindBy(xpath = "//*[@class='via-text']")})
	private List<WebElement> list_of_flights;
	
	@FindBys({@FindBy(xpath = "(//div[@id='ctl00_c_dvOBBResult']//*[@class='flight-fares-table-curr'])[1]//td//div[@class='price']/span[@class='curr-only']")})
	private List<WebElement> first_Outbound_Flight_Prices;
	
	@FindBys({@FindBy(xpath = "(//div[@id='ctl00_c_dvIBBResult']//*[@class='flight-fares-table-curr'])[1]//td//div[@class='price']/span[@class='curr-only']")})
	private List<WebElement> first_Return_Flight_Prices;
	
	
	
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
	
	public ArrayList<String> get_Flight_Prices_Outbound(){
		for(int i=0;i<first_Outbound_Flight_Prices.size();i++){
			FirstOutboudPrices.add(first_Outbound_Flight_Prices.get(i).getText());
		}
		System.out.println("Various Prices Options for the first Outbound flight are: "+FirstOutboudPrices);
		return FirstOutboudPrices;
	}
	
	public ArrayList<String> get_Flight_Prices_return(){
		for(int i=0;i<first_Return_Flight_Prices.size();i++){
			FirstReturnPrices.add(first_Return_Flight_Prices.get(i).getText());
		}
		System.out.println("Various Prices Options for the first Return flight are: "+FirstReturnPrices);
		return FirstReturnPrices;
	}
	

}
