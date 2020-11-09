package PageObjects;

import org.openqa.selenium.By;

public interface LandingPage {
	
	By Searchbox = By.xpath("//input[@type='text']");
	By popup = By.xpath("//button[@class='_2AkmmA _29YdH8']");
	By Maxpriceselection = By.xpath("(//*[@class='fPjUPw'])[2]");
	By Maxprice = By.xpath("(//option[@value='10000'])[2]");
	By RamSelection = By.xpath("(//div[@title='2 GB']//div)[3]");
	By ProcesserBand = By.xpath("(//*[@class='_1gjf4c D_NGuZ'])[13]");
	By Snapdragon = By.xpath("//div[@title='Snapdragon']");
	By Pagecss = By.xpath("(//div[@class='_1HmYoV _35HD7C'])[2]//div[@class='bhgxx2 col-12-12']");
	By mobilenameCount = By.xpath("//div[@class='_1-2Iqu row']//div[@class='col col-7-12']");
	By mobileName = By.xpath("//div[@class='_1-2Iqu row']//div[@class='col col-7-12']/div[1]");
	By mobilePrice = By.xpath("//div[@class='col col-5-12 _2o7WAb']//div[@class='_1uv9Cb']/div[1]");

}
