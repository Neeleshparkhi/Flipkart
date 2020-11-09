package Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	protected static WebDriver driver;
	public static Properties prop;
	public static Properties verifyprop;
	
	
	public static WebDriver getdriver() throws IOException
	{
		prop = new Properties();
		String configfilepath = System.getProperty("user.dir")+ "\\src\\main\\java\\Resources\\config.properties";
		FileInputStream fis = new FileInputStream(configfilepath);
		prop.load(fis);
		
		String BrowserName=prop.getProperty("browser");
		System.out.println(BrowserName);
		
		if(BrowserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		 }
		 else if(BrowserName.equals("IE"))
		 {
			 WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();
		 }
		 else if(BrowserName.equals("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		 }
		 else
		 {
			 System.out.println("We Don't Support This Browser");
		 }
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		return driver;
	}
	
}
