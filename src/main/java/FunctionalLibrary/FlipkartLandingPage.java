package FunctionalLibrary;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Actions.Flipkart_Actions;
import Configuration.DriverManager;
import PageObjects.LandingPage;
import Utility.Screenshot;
import Utility.WriteExcel;


public class FlipkartLandingPage extends Flipkart_Actions implements LandingPage{
	
	public static String testName;
	public static String title;
	
	//WriteExcel obj;
	
	Logger Log = LogManager.getLogger(FlipkartLandingPage.class.getName());

	public FlipkartLandingPage(WebDriver driver)
	{
		super(driver);
	}
	
	public WebElement Search()
	{
		return driver.findElement(Searchbox);
	}
	
	public WebElement popup()
	{
		return driver.findElement(popup);
	}
	
	public WebElement Maxprice()
	{
		return driver.findElement(Maxprice);
	}
	
	public WebElement Maxpriceselection()
	{
		return driver.findElement(Maxpriceselection);
	}
	
    public void MaxPrice()
    {
    	Select se = new Select(Maxpriceselection());
    	//List<WebElement> element = se.getOptions();
    	String gettext = driver.findElement(Maxprice).getText();
    	se.selectByVisibleText(gettext);
    }
    
    public WebElement Ramselection()
    {
    	return driver.findElement(RamSelection);
    }
    
    public WebElement ProcesserBand()
    {
    	return driver.findElement(ProcesserBand);
    }
    
    public WebElement Snapdragon()
    {
    	return driver.findElement(Snapdragon);
    }
    
    public void MobileSelection() throws Exception
    {
    	FlipkartLandingPage flp = new FlipkartLandingPage(driver);
		try {
			flp.popup().click();
			Log.info("Autosuggestive popup is available.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.info("Autosuggestive popup is not available.");
		}
		
		Log.info("Enterin the text" + prop.getProperty("mobile"));
		flp.Search().sendKeys(prop.getProperty("mobile"));
		flp.Search().sendKeys(Keys.ENTER);
		Log.info(prop.getProperty("mobile")+ " is selected.");
		waitForElementToClick(Maxprice);
		String str = driver.findElement(Maxprice).getText();
		Log.info(str + " is Maximum price is selecting.");
		MaxPrice();
		String ram= driver.findElement(RamSelection).getText();
		waitForElementToClick(RamSelection);
		Log.info(ram + " is selecting.");
		Thread.sleep(2000);
		Click(RamSelection);
		waitForElementToClick(ProcesserBand);
		String pBand = driver.findElement(ProcesserBand).getText();
		Log.info(pBand + " is Selecting");
		Click(ProcesserBand);
		String snapd = driver.findElement(Snapdragon).getText();
		waitForElementToClick(Snapdragon);
		Log.info(snapd + " Is selecting.");
		Click(Snapdragon);
		Screenshot.captureScreen(driver, title, testName);
		
	    List<WebElement> count = Pagecss();
	    int totalcount =  count.size();
	    List<WebElement> mcount = mobileNamecount();
	    List<WebElement> Mname = MobileName();
	    List<WebElement> Mprice = MobilePrice();
	    int mtotal = mcount.size();
	    System.out.println(mtotal);
	    for(int i=0;i<mtotal;i++)
	    {
	    	
//	    	for(int j=i; j<Mcount; j++)
//	    	{
	    		WriteExcel obj = new WriteExcel();
	    		
	    		String mobilename = Mname.get(i).getText();
		    	String mobileprice = Mprice.get(i).getText();
		    	obj.writeExcel("MobileDetails", mobilename , i, 0);
		    	obj.writeExcel("MobileDetails", mobileprice , i, 1);
//		    	obj = new WriteExcel();
//		    	obj.writeExcel("MobileDetails", mobilename , i, i);
//		    	obj.writeExcel("MobileDetails", mobileprice, i, i+1);
		    	
		    
		    	
		    	System.out.print("Mobile Name is :-" + mobilename);
		    	System.out.println(" Mobile Price is :-" + mobileprice);
//	    	}
	    	
       }
    }
    
    public List<WebElement> Pagecss()
    {
    	return driver.findElements(Pagecss);
    }
    
    public List<WebElement> MobileName()
    {
    	return driver.findElements(mobileName);
    }
  
    public List<WebElement> MobilePrice()
    {
    	return driver.findElements(mobilePrice);
    }
	
    public List<WebElement> mobileNamecount()
    {
    	return driver.findElements(mobilenameCount);
    }
    
    
}
