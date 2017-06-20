package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected final WebDriver webDriver;
    
    public BasePage(WebDriver webDriver)
    {
            this.webDriver = webDriver;
            PageFactory.initElements(this.webDriver, this);
    }

    public WebDriver getDriver()
    {
            return this.webDriver;
    }

    public Boolean isElementPresent(By locator)
    {
            return webDriver.findElements(locator).size() > 0;
    }

}
