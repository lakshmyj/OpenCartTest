package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static String TESTDATA_EXCEL_PATH=System.getProperty("user.dir")+"/src/main/java/com/qa/testdata/loginTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try
		{
			file= new FileInputStream(TESTDATA_EXCEL_PATH);
			System.out.println(TESTDATA_EXCEL_PATH);
			book = WorkbookFactory.create(file);
			sheet=book.getSheet(sheetName);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//System.out.println("sheet.getLastRowNum() "+sheet.getLastRowNum());
		//System.out.println("sheet.getRow(0).getLastCellNum() "+sheet.getRow(0).getLastCellNum());
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
//				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				data[i][k]=(sheet.getRow(i+1).getCell(k) != null) ? sheet.getRow(i+1).getCell(k).toString() : "";;
				//System.out.println("data "+data[i][k]);
			}
		}
		return data;
	}
}
