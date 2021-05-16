package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShot {
	
	public WebDriver driver;
	public static String testName;
	public static String title;

	static Date date = new Date() ;
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

	public static String captureScreen(WebDriver driver, String title, String testName) {
		String path;
		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			path = System.getProperty("user.dir")+"/target/screenshots/"+dateFormat2.format(date)+"/"+testName+"/"+ title+"_"+dateFormat.format(date)+"_"+ source.getName();
			
			FileUtils.copyFile(source, new File(path)); 
			Thread.sleep(1000);
			//Screenshot scrnshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			
		}
		catch(Exception e) {
			path = "Failed to capture screenshot: " + e.getMessage();
		}
		return path;
	
}
	
	public static String fullScreenshot(WebDriver driver, String title, String testName) throws IOException
	{
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		
		String filePath = System.getProperty("user.dir")+"/Screenshots/"+testName+"/"+ title+"_"+dateFormat.format(date)+"_"+ ".png";
        ImageIO.write(s.getImage(),"PNG",new File(filePath));
        
        //closing the webdriver
       return filePath;
    }
	
	public static void fullPageScreenshot(WebDriver driver) throws IOException
	{
		JavascriptExecutor jsExec = (JavascriptExecutor)driver;

	    //Returns a Long, Representing the Height of the window’s content area.
	    Long windowHeight = (Long) jsExec.executeScript("return window.innerHeight;");

	    //Returns a Long, Representing the Height of the complete WebPage a.k.a. HTML document.
	    Long webpageHeight = (Long) jsExec.executeScript("return document.body.scrollHeight;"); 

	    //Marker to keep track of the current position of the scroll point
	    //Long currentWindowScroll = Long.valueOf(0);
	    //Using java's boxing feature to create a Long object from native long value.

	    Long currentWindowScroll = 0L;

	    do{
	        //System.out.println(windowHeight + ", " + webpageHeight + ", " + currentWindowScroll);

	        jsExec.executeScript("window.scrollTo(0, " + currentWindowScroll + ");");

	        Actions act = new Actions(driver);
	        act.pause(5000).perform();

	        File tempScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	        //Unique File Name For Each Screenshot
	        File destination = new File( System.getProperty("user.dir")+"/Screenshots/" + String.join("_", LocalDateTime.now().toString().split("[^A-Za-z0-9]"))+ ".png");

	        FileHandler.copy(tempScreenshot, destination);
	        currentWindowScroll = currentWindowScroll + windowHeight;

	    }while(currentWindowScroll <= webpageHeight);
	}
	


	
}
