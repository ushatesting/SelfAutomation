package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long page_load_timeout= 10;
	public static long implicitly_wait=20;
	
public void SwitchToFrame() {
	
		driver.switchTo().frame("mainpanel");
}
	

public static Object[][] getDataFromExcel() throws IOException  {
	
	
	
	FileInputStream file=new FileInputStream("C:\\Users\\Prisha Bhatia\\Desktop\\crmdata.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	
	XSSFSheet sheet= workbook.getSheet("Sheet1");
	
	int rowcount=sheet.getLastRowNum();
	System.out.println("rowcount" + rowcount);
	int colcount=sheet.getRow(0).getLastCellNum();
	System.out.println("colcount" + colcount);
	Object [][]data = new Object[rowcount][colcount];
	
	for(int i=0;i<rowcount;i++)
	{
		for(int j=0;j<colcount;j++)
		{
			data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			System.out.println(data[i][j]);
		}
		
  }
	return data;	
	
}


 public static void takeScreenshotAtEndOfTest() throws IOException
 {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File("ExceptionOccured" + System.currentTimeMillis()+ ".png");
	FileUtils.copyFile(src, trg);

 }
}
