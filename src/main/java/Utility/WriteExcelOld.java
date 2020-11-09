package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Configuration.DriverManager;

public class WriteExcelOld {

	public static void writeExcel(String sheetName, String cellValue, int row, int col) throws Exception
	{
		String excelPath = "C:\\Users\\2101\\eclipse-workspace\\Flipkart\\TestData\\MobileDetails.xlsx";
		
		File file = new File(excelPath);
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		sheet.getRow(row).createCell(col).setCellValue(cellValue);
		
		//sheet.getRow(row).createCell(col).setCellValue(cellValue);
		
		FileOutputStream fos = new FileOutputStream(new File(excelPath));
		
		wb.write(fos);
		
		wb.close();
		
		fos.close();
		
		
	}
	
}
