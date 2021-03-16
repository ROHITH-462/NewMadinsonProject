package com.htc.newMadinson.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileHandler {
	
	Workbook MadinsonWorkBook;
	Sheet MadinsonDataSheet;

	public ExcelFileHandler(String excelFilePath) {
		File file = new File(excelFilePath);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			MadinsonWorkBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public Object[][] getDataRecords(String sheetName){
		MadinsonDataSheet = MadinsonWorkBook.getSheet(sheetName);
		int rowCount = MadinsonDataSheet.getLastRowNum();
		int colCount = MadinsonDataSheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowCount][1];
		
		for(int row=0; row<rowCount; row++) {
			Map<Object, Object> dataMap = new HashMap<Object, Object>();
			for(int col=0; col<colCount; col++) {
				dataMap.put(MadinsonDataSheet.getRow(0).getCell(col).toString(), MadinsonDataSheet.getRow(row+1).getCell(col).toString());
			}
			obj[row][0] = dataMap;
		}
		return obj;
		
	}
}
