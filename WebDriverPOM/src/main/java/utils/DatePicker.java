package utils;

import java.text.DateFormatSymbols;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import waits.WaitforElement;

public class DatePicker {
	private WebDriver driver;

	public void pickDate(WebDriver driver, String date){
		this.driver = driver;
		
		date = (date.charAt(0)=='0')?(date.substring(1)):date;
		String[] words = date.split("\\.");

		int day = Integer.parseInt(words[0]);
		int mon = Integer.parseInt(words[1]);
		String month = (new DateFormatSymbols().getMonths()[mon-1]).toString() +" " +words[2];
		
		String currentMonth = driver.findElement(By.xpath("//div[@id='calendarLeft']//span[@id='monthLeft']")).getText();
		System.out.println("current Month: "+currentMonth + "Month: "+ month);

		for(int i =0;i<=10;i++){
			if(currentMonth.equalsIgnoreCase(month)){
				By day_Xpath = By.xpath("//table[@class='ui-datepicker-calendar']//tbody[@id='dataLeft']//td/a[contains(text(),'"+day+"')]");
				//WaitforElement.waitforStaleElement(driver,"//table[@class='ui-datepicker-calendar']//tbody[@id='dataLeft']//td/a[contains(text(),'"+day+"')]" );
				WaitforElement.waitforElement(driver, driver.findElement(day_Xpath));
				//driver.findElement(day_Xpath).click();
				retryClick(day_Xpath);
				System.out.println("selected Date is:"+day+"/"+currentMonth+"/" );
				break;
			} else{
				WaitforElement.waitforStaleElement(driver, "//a[@id='nextMonth']");
				driver.findElement(By.xpath("//a[@id='nextMonth']")).click();
				currentMonth=driver.findElement(By.xpath("//div[@id='calendarLeft']//span[@id='monthLeft']")).getText();
			}
		}
	}
	
	private boolean retryClick(By by){
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
	}
}

