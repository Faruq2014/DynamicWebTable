package com.FacebookUtlities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
  private String filePath;
  private String sheetName;

  public ExcelUtils(String filePath, String sheetName) {
    this.filePath = filePath;
    this.sheetName = sheetName;
  }

  public String getCellData(int rowNum, int colNum) {
    String cellData = null;
    try {
      FileInputStream fis = new FileInputStream(filePath);
      Workbook workbook = WorkbookFactory.create(fis);
      Sheet sheet = workbook.getSheet(sheetName);
      Row row = sheet.getRow(rowNum);
      Cell cell = row.getCell(colNum);
      cellData = cell.getStringCellValue();
      fis.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return cellData;
  }
  
  public double getNumericData(int rowNumber, int columnNumber) {
	    try {
	        FileInputStream file = new FileInputStream(filePath);
	        Workbook workbook = new XSSFWorkbook(file);
	        Sheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(rowNumber);
	        Cell cell = row.getCell(columnNumber);

	        double cellValue = cell.getNumericCellValue();
	        return cellValue;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0.0;
	    }
	}
  
  public Date getDateData(int rowNumber, int columnNumber) {
	    try {
	        FileInputStream file = new FileInputStream(filePath);
	        Workbook workbook = new XSSFWorkbook(file);
	        Sheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(rowNumber);
	        Cell cell = row.getCell(columnNumber);

	        Date cellValue = cell.getDateCellValue();
	        return cellValue;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
  public static void main(String[] args) {
	  String filePath="src/test/resources/registration.xlsx";
	 String sheetName="sheet1";
	 ExcelUtils excelUtils= new ExcelUtils(filePath,sheetName);
	 String stringData=excelUtils.getCellData(1, 0);
	 System.out.println(stringData);
	 String cData=excelUtils.getCellData(1, 5);
	 System.out.println(cData);
	 
	String month= excelUtils.getCellData(1, 6);
	System.out.println(month);
	 
	
}
}
