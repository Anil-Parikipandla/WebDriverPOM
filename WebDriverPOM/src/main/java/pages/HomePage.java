package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utils.DatePicker;
import waits.WaitforElement;

public class HomePage extends BasePage
{
//	private static final String APPLICATION_URL = "https://www.emirates.com/uk/english/";
	private DatePicker pick_a_date;
	private WebElement no_Of_Children;
	
	@FindBy(xpath = "//div[@id='navSecondary']//li/a[contains(text(), 'Book a flight')]")
	private WebElement book_A_FlightBtn;

	@FindBy(id = "seldcity1-suggest")
	private WebElement departure_Airport;

	@FindBy(id = "selacity1-suggest")
	private WebElement arrival_Airport;

	@FindBy(xpath = "//div[@id='navSecondary']//div[@id='flightSearch']//div/label[contains(text(), 'Departure date')]")
	private WebElement departure_Date;

	@FindBy(xpath = "//div[@id='navSecondary']//div[@id='seladults_chosen']/a/span")
	private WebElement no_Of_Adults;

	@FindBy(xpath = "//div[@id='navSecondary']//*[contains(text(),'Add child or infant.')]/..")
	private WebElement add_children_Link;

	@FindBy(xpath = "//div[@id='navSecondary']//div[@id='selchildren_chosen']/a[@role='combobox']")
	private WebElement children_Link;

	//This Xpath is not valid using FindBy
//	@FindBy(xpath = "//div[@id='navSecondary']//ul[@class='chosen-results']/li[@text='"+NO_OF_CHILDREN +"']")
//	private WebElement no_Of_Children;
	
	

	@FindBy(xpath = "//input[@id='btnStartBooking']")
	private WebElement find_Flights_Button;
	
	@FindBy(xpath = "//a[@aria-label='Select the number of children aged between two and 11 years of age - 1  selected']//span")
	private WebElement get_value_from_number_of_children;

	public HomePage(WebDriver driver){
		super(driver);
	}

/*	public void open_Application(String application_url)
	{
		getDriver().get(application_url);
	}
*/
	public WebElement get_no_of_children(WebDriver driver, int children){
		no_Of_Children = driver.findElement(By.xpath("//div[@id='navSecondary']//ul[@class='chosen-results']/li[@text='"+children +"']"));
		return no_Of_Children;
	}
	
	public void open_Flight_Booking_Window(){
		book_A_FlightBtn.click();
	}

	public void enter_Origin_And_Destination(String origin, String destination){
		WaitforElement.waitforElement(webDriver, departure_Airport);
		departure_Airport.clear();
		departure_Airport.sendKeys(origin);
		departure_Airport.sendKeys(Keys.ENTER);
		WaitforElement.waitforElement(webDriver, arrival_Airport);
		arrival_Airport.sendKeys(destination);
		arrival_Airport.sendKeys(Keys.ENTER);
	}

	public void select_Departure_and_returnDate(String departureDate, String returnDate){
		pick_a_date = new DatePicker();
		departure_Date.click();
		
		pick_a_date.pickDate(webDriver, departureDate);
		pick_a_date.pickDate(webDriver, returnDate);
	}
	
	public String get_no_of_Adults(){
		return no_Of_Adults.getText();
	}
	
	public void add_Children(int children){
		add_children_Link.click();
		children_Link.click();
		get_no_of_children(webDriver, children);
		no_Of_Children.click();
	}
	
	public FlightSearchResultsPage search_for_flights(){
		find_Flights_Button.click();
		return new FlightSearchResultsPage(webDriver);
	}
	
	public WebElement get_expected_from_city(){
		return departure_Airport;
	}
	
	public WebElement get_expected_to_city(){
		return arrival_Airport;
	}
	
}

