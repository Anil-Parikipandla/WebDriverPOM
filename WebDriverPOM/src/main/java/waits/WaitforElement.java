package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitforElement {

	public static void waitforElement(WebDriver driver, String str ){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(str))));
		System.out.println("Element is clickable");
	}
	
	public static void waitforElementTillDisplayed(WebDriver driver, WebElement object, String attribute, String value, int Timeout ){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(object, attribute, value));
	}
	
	public static void waitforStaleElement(WebDriver driver, String strXpath){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(strXpath)))));
	}
}
