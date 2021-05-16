package Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import Configuration.DriverManager;
import Utility.PropertyReader;

public class Flipkart_Actions {
	
	public WebDriverWait wait;
	static final int TIMEOUT = 40;
	static final int POLLING = 100;
	public WebDriver driver;
	
	 PropertyReader prop = new PropertyReader();
	
	Logger Log = LogManager.getLogger(Flipkart_Actions.class.getName());
	
	public Flipkart_Actions(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);

		 wait = new WebDriverWait(driver, TIMEOUT, POLLING);
	}
	
	
	//Wait method
	public void waitForElementToClick(By elementBy)
	{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elementBy));
					
		} catch (Exception e) {
			System.out.println(elementBy + "is Not present on UI");
			e.printStackTrace();
		}
	}
	
	//Click Method
			public void Click(By elementBy)
			{
				try {
					WebElement element = driver.findElement(elementBy);
					Log.info("Trying to find element" + element.getText());
					//waitForElementToClick(elementBy);
					element.click();
				} catch (Exception e) {
					System.out.println(elementBy + "is not able to click.");// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//is Element present
			public boolean isElementPresent(By elementBy)
			{
				try { 
					if(driver.findElements(elementBy).size()>0)
					{
						return true;
					}else {
						return false;
					}		
				}catch (NoSuchElementException ex){
					return false;
				}
			}

}
