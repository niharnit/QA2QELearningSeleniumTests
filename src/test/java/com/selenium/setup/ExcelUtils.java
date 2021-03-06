package com.selenium.setup;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	
	private static FileInputStream excelFile;
	private static String filePath;
	
	public static Object[][] readExcelData(String sheetName) throws Exception {
		
		String[][] arrayExelData = null;
		
		String workingDir = System.getProperty("user.dir");
		filePath = workingDir+File.separator+"src"+File.separator+"customer_registration.xlsx";
		excelFile = new FileInputStream(filePath);
		
		ExcelWBook = new XSSFWorkbook(excelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		
		//initialize variables
		
		int startRow = 1;
		int startCol = 1;
		
		int ci, cj;
		int totalRows = ExcelWSheet.getLastRowNum();
		int totalCols = 5;
		
		arrayExelData = new String[totalRows][totalCols];
		
		ci=0;
		for (int i=startRow; i<=totalRows; i++, ci++) {
			
			cj=0;
			
			for(int j=startCol; j<=totalCols; j++, cj++ ) {
				
				XSSFCell Cell = ExcelWSheet.getRow(i).getCell(j);
				String CellData = Cell.getStringCellValue();
				arrayExelData[ci][cj] = CellData;
			}
		}
		
		
		return arrayExelData;
	}
	

}
