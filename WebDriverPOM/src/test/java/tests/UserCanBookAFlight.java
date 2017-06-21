package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanBookAFlight extends BaseTest {

	private static String ACTUAL_PAGE_TITLE = "";
	private static String ACTUAL_FROM_CITY_NAME = "";
	private static String ACTUAL_TO_CITY_NAME = "";
	private static String ACTUAL_NO_OF_ADULTS = "";
	private static int ACTUAL_NO_OF_CHILDREN = 1;
	private static String ACTUAL_SEARCH_RESULTS_PAGE_HEADER = "";
	private static String ACTUAL_DEPARTING_DATE = "";
	private static String ACTUAL_RETURNING_DATE = "";
	private static String EXPECTED_DEPARTING_DATE = "14 July 2017";
	private static String EXPECTED_RETURNING_DATE = "15 July 2017";

	@Test	
	public void sampleTest(){
		log.info("This is a sample Logger");
	}

	@Test
	public void search_for_flights(){

		//verify Home page is opened successfully.
		ACTUAL_PAGE_TITLE = driver.getTitle();
		Assert.assertEquals(ACTUAL_PAGE_TITLE, EXPECTED_PAGE_TITLE);

		Homepage.open_Flight_Booking_Window();
		Homepage.enter_Origin_And_Destination(EXPECTED_FROM_CITY_NAME, EXPECTED_TO_CITY_NAME);
		
		//verify Origin is selected as expected.
		ACTUAL_FROM_CITY_NAME = Homepage.get_expected_from_city().getAttribute("value");
		Assert.assertEquals(ACTUAL_FROM_CITY_NAME, EXPECTED_FROM_CITY_NAME);
		
		//verify Destination is selected as expected.
		ACTUAL_TO_CITY_NAME = Homepage.get_expected_to_city().getAttribute("value");
		Assert.assertEquals(ACTUAL_TO_CITY_NAME, EXPECTED_TO_CITY_NAME);
		
		Homepage.select_Departure_and_returnDate(EXPECTED_DEPARTURE_DATE, EXPECTED_RETURN_DATE);
		
		//verify No of Adults selected by default.
		ACTUAL_NO_OF_ADULTS = Homepage.get_no_of_Adults();
		Assert.assertEquals(ACTUAL_NO_OF_ADULTS, EXPECTED_NO_OF_ADULTS);
		
		//verify no of children selected.
		Homepage.add_Children(ACTUAL_NO_OF_CHILDREN);
		Assert.assertEquals(ACTUAL_NO_OF_CHILDREN, EXPECTED_NO_OF_CHILDREN);

		flight_Search_Results_Page = Homepage.search_for_flights();
		
		//verify Search results page is opened successfully.
		ACTUAL_SEARCH_RESULTS_PAGE_HEADER = flight_Search_Results_Page.get_page_header().getText();
		Assert.assertEquals(ACTUAL_SEARCH_RESULTS_PAGE_HEADER, EXPECTED_SEARCH_RESULTS_PAGE_HEADER);
		
		//verify departing date.
		ACTUAL_DEPARTING_DATE = flight_Search_Results_Page.get_departing_date().getText().substring(10);
		Assert.assertEquals(ACTUAL_DEPARTING_DATE, EXPECTED_DEPARTING_DATE);
		
		//verify returning date.
		ACTUAL_RETURNING_DATE = flight_Search_Results_Page.get_returning_date().getText().substring(10);
		Assert.assertEquals(ACTUAL_RETURNING_DATE, EXPECTED_RETURNING_DATE);
		
		//verify the flight has connection to Moscow
		for(WebElement i : flight_Search_Results_Page.get_list_of_flights()){
			Assert.assertEquals(i.getText().substring(0, 7), EXPECTED_CONNECTION_IN);
		}
		
		
		
		
		

	}

}
