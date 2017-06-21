package tests;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import pages.FlightSearchResultsPage;
import pages.HomePage;

public class BaseTest {
	protected static final String APPLICATION_URL = "https://www.emirates.com/uk/english/";
	protected static final String EXPECTED_PAGE_TITLE = "Emirates flights – Book a flight, browse our flight offers and explore the Emirates Experience";
	protected static final String EXPECTED_FROM_CITY_NAME = "St Petersburg (LED)"; 
	protected static final String EXPECTED_TO_CITY_NAME = "Dubai (DXB)"; 
	protected static final String EXPECTED_DEPARTURE_DATE = "14.07.2017";
	protected static final String EXPECTED_RETURN_DATE = "15.07.2017";
	protected static final String EXPECTED_NO_OF_ADULTS = "1";
	protected static final int EXPECTED_NO_OF_CHILDREN = 1;
	protected static final String EXPECTED_SEARCH_RESULTS_PAGE_HEADER = "Make a booking";
	protected static final String EXPECTED_CONNECTION_IN = "via DME";
	
	protected WebDriver driver;
	protected HomePage Homepage;
	protected FlightSearchResultsPage flight_Search_Results_Page;

	Logger log = LogManager.getLogger();
	
	@BeforeClass(description = "Start browser")
	public void start_Browser() {
		// init Webdriver and open start url
		
		/*System.setProperty("webdriver.gecko.driver", "d:\\_webdriver\\geckodriver_ff\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		driver = new FirefoxDriver(capabilities);*/
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		DesiredCapabilities capabilities_chrome = DesiredCapabilities.chrome();
		driver = new ChromeDriver(capabilities_chrome);

//		new HomePage(driver).open_Application(APPLICATION_URL);
		driver.get(APPLICATION_URL); 
	}
	
	@BeforeClass(dependsOnMethods = "start_Browser", description = "Add implicit wait and maximize window")
	public void add_Implicit_Wait() {
		// set a certain implicit wait timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Maximize browser window
		driver.manage().window().maximize();
	}
	
	@BeforeClass(dependsOnMethods = "add_Implicit_Wait", description = "create and return Homepage")
	public HomePage get_HomePage(){
		return new HomePage(driver);
	}
}
