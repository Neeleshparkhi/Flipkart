package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public void writeExcel(String sheetName,String cellValue, int row, int col) throws IOException
	{
		
		String excelPath = "C:\\Users\\2101\\eclipse-workspace\\Flipkart\\TestData\\MobileDetails.xlsx";
		
		File file = new File(excelPath);
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		sheet.getRow(row).createCell(col).setCellValue(cellValue);
		
		FileOutputStream fos = new FileOutputStream(new File(excelPath));
		
		workbook.write(fos);
		
		workbook.close();
		
		fos.close();
	}
	
}
