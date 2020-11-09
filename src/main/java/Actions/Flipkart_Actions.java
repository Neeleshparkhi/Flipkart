package Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import Configuration.DriverManager;

public class Flipkart_Actions extends DriverManager {
	
	public WebDriverWait wait;
	static final int TIMEOUT = 40;
	static final int POLLING = 100;
	
	Logger Log = LogManager.getLogger(Flipkart_Actions.class.getName());
	
	public Flipkart_Actions(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(driver, this);
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
					waitForElementToClick(elementBy);
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
