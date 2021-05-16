package FunctionalLibrary;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Actions.Flipkart_Actions;
import PageObjects.LandingPage;
import Utility.ScreenShot;
import Utility.XLUtility;


public class FlipkartLandingPage extends Flipkart_Actions implements LandingPage{
	
	public static String testName;
	public static String title;
	public XLUtility xlutil;
  
	String path = ".\\MobileDetails.xlsx";
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
	
    public void MaxPrice(String price)
    {
    	Select se = new Select(Maxpriceselection());
    	//List<WebElement> element = se.getOptions();
    	//String gettext = driver.findElement(Maxprice).getText();
    	se.selectByValue(price);    }
    
    public List<WebElement> Rams()
    {
    	return driver.findElements(Rams);
    }
    
    public WebElement Band()
    {
    	return driver.findElement(band);
    }
    
    public WebElement Ramselection()
    {
    	return driver.findElement(RamSelection);
    }
    
    public WebElement ProcesserBand()
    {
    	return driver.findElement(ProcesserBand);
    }
    
    public List<WebElement> processerBandName()
    {
    	return driver.findElements(processerBandName);
    }
    
    public WebElement Snapdragon()
    {
    	return driver.findElement(Snapdragon);
    }
    
    public void MobileSelection(String productname, String price, String ram, String bandname) throws Exception
    {
    	FlipkartLandingPage flp = new FlipkartLandingPage(driver);
		try {
			Thread.sleep(3000);
			flp.popup().click();
			Log.info("Autosuggestive popup is available.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.info("Autosuggestive popup is not available.");
		}
		
		Log.info("Enterin the text" + productname);
		flp.Search().sendKeys(productname);
		flp.Search().sendKeys(Keys.ENTER);
		Log.info(productname+ " is selected.");
		waitForElementToClick(Maxprice);
		String str = driver.findElement(Maxprice).getText();
		Log.info(str + " is Maximum price is selecting.");
		MaxPrice(price);
		String Ram= driver.findElement(RamSelection).getText();
		waitForElementToClick(RamSelection);
		Log.info(ram + " is selecting.");
		Thread.sleep(2000);
		
		List<WebElement> RamList = driver.findElements(Rams);
		//System.out.println(RamList.size());
		//System.out.println(Rams().size());
		int ramcount = RamList.size();
		for(int i=0;i<RamList.size(); i++) {
			//System.out.println(driver.findElement(Rams).getText());
			WebElement MobileRamInGB = RamList.get(i);
			String MobileRam = MobileRamInGB.getText();
			//System.out.println(MobileRam);
			if(MobileRam.equalsIgnoreCase(ram)) {
				//Thread.sleep(2000);
				Click(RamSelection);
			}else
			{
			   
			}
		}
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ProcesserBand());
		//js.executeScript("arguments[0].scrollIntoView();", ProcesserBand);
		waitForElementToClick(ProcesserBand);
		String pBand = driver.findElement(ProcesserBand).getText();
		Log.info(pBand + " is Selecting");
		//Thread.sleep(2000);
		//Click(ProcesserBand);
		driver.findElement(ProcesserBand).click();
		waitForElementToClick(Snapdragon);
		String snapd = driver.findElement(Snapdragon).getText();
		System.out.println("Processer Band is :- " +snapd);
		Log.info(snapd + " Is selecting.");
		List<WebElement> bandName = driver.findElements(processerBandName);
		System.out.println(processerBandName().size());
		int bandcount = bandName.size();
		for(int j=0; j<bandName.size();j++)
		{
			WebElement bandSelection = bandName.get(j);
			String BandName = bandSelection.getText();
			System.out.println(BandName);
			if(BandName.equalsIgnoreCase(bandname))
			{
				bandName.get(j).click();
			}else {
				
			}
		}
		
		ScreenShot.fullPageScreenshot(driver);
		
		XLUtility xlutil = new XLUtility(path);
		
	    List<WebElement> count = Totalmobile();
	    int totalmobilecount =  count.size();
	    System.out.println("Total count of mobile is :- " + totalmobilecount);
	    
	    for(int r=0; r<totalmobilecount; r++ )
	    {
	    	String mobileName = MobileName().get(r).getText();
	    	System.out.println(mobileName);
	    	String mobilePrice = MobilePrice().get(r).getText();
	    	System.out.println(mobilePrice);
	    	
	    	xlutil.setCellData("Mobile", r , 0, mobileName);
	    	xlutil.setCellData("Mobile", r , 1, mobilePrice);
	    }
	    
	    System.out.println("Mobile data is uploaded succesfully.");
	   
    }
    
    public List<WebElement> Totalmobile()
    {
    	return driver.findElements(totalMobile);
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
