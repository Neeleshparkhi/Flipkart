package LandingPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Configuration.DriverManager;
import FunctionalLibrary.FlipkartLandingPage;
import Utility.WriteExcelOld;

public class LandingPageTest extends DriverManager{


	public static Logger Log = LogManager.getLogger(LandingPageTest.class.getName());
	
	FlipkartLandingPage fp;
	
	@BeforeTest
	public void Browsersetup() throws IOException
	{
     
		fp.testName="LandingPage";
		fp.title="LandingPage";
		DriverManager.getdriver().get(prop.getProperty("url"));
		Log.info("Browser is initializing.");
	}
	
	@Test
	public void MobileSelection() throws Exception
	{
		FlipkartLandingPage flp = new FlipkartLandingPage(driver);
		flp.MobileSelection();	
		
	}
	
	
	
}
