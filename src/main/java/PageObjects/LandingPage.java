package PageObjects;

import org.openqa.selenium.By;

public interface LandingPage {
	

	By Searchbox = By.xpath("//input[@type='text']");
	By popup = By.xpath("//div[@class='_2QfC02']/button");
	By Maxpriceselection = By.xpath("(//*[@class='_2YxCDZ'])[2]");
	By Maxprice = By.xpath("(//option[@value='10000'])[2]");
	By Rams = By.xpath("(//div[@class='_2d0we9'])[1]/div/div/label/div[2]");
	By RamSelection = By.xpath("(//div[@title='2 GB']//div)[3]");
	By ProcesserBand = By.xpath("//div[@class='_213eRC _2ssEMF']/div)[13]");
	By processerBandName = By.xpath("(//div[@class='_2d0we9'])[5]/div/div/label/div[2]");
	By Snapdragon = By.xpath("//div[@title='Snapdragon']");
	By totalMobile = By.xpath("//div[@class='_1AtVbE col-12-12']//div[@class='_13oc-S']");
	By band = By.xpath("(//div[@title='Snapdragon']//div)[3]");
	By mobilenameCount = By.xpath("//div[@class='_1-2Iqu row']//div[@class='col col-7-12']");
	By mobileName = By.xpath("//div[@class='col col-7-12']/div[1]");
	By mobilePrice = By.xpath("//div[@class='col col-5-12 nlI3QM']/div[1]");
	
}
