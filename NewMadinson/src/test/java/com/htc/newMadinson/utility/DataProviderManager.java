package com.htc.newMadinson.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class DataProviderManager {

	Properties prop;

	public DataProviderManager(){
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\DELL\\git\\NewMadinsonProject\\NewMadinson\\src\\test\\resources\\props.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@DataProvider(name = "Registration_Details")
	public Object[][] registrationDetails(){
		ExcelFileHandler ref = new ExcelFileHandler(prop.getProperty("datarepository.madinson.excelfile"));
		System.out.println("Excel File" + prop.getProperty("datarepository.madinson.excelfile"));
		Object[][] registrationDataSet =ref.getDataRecords(prop.getProperty("datarepository.madinson.excelfile.sheetname.register"));
		return registrationDataSet;
	}

	@DataProvider(name = "Billing_Information")
	public Object[][] billingInfo(){
		ExcelFileHandler ref = new ExcelFileHandler(prop.getProperty("datarepository.madinson.excelfile"));
		Object[][] registrationDataSet =ref.getDataRecords(prop.getProperty("datarepository.madinson.excelfile.sheetname.billinginfo"));
		return registrationDataSet;
	}

	@DataProvider(name = "Login")
	public Object[][] LoginDetails(){
		ExcelFileHandler ref = new ExcelFileHandler(prop.getProperty("datarepository.madinson.excelfile"));
		Object[][] registrationDataSet =ref.getDataRecords(prop.getProperty("datarepository.madinson.excelfile.sheetname.login"));
		return registrationDataSet;
	}


}


























//@DataProvider(name = "Invalid_Login_Details")
//public Object[][] invalidLoginDetails(){
//	ExcelFileHandler ref = new ExcelFileHandler(prop.getProperty("datarepository.madinson.excelfile"));
//	Object[][] registrationDataSet =ref.getDataRecords(prop.getProperty("datarepository.madinson.excelfile.sheetname.invalidlogin"));
//	return registrationDataSet;
//}


//@DataProvider(name = "Valid_Login_Details")
//public Object[][] validLoginDetails(){
//	ExcelFileHandler ref = new ExcelFileHandler(prop.getProperty("datarepository.madinson.excelfile"));
//	Object[][] registrationDataSet =ref.getDataRecords(prop.getProperty("datarepository.madinson.excelfile.sheetname.validlogin"));
//	return registrationDataSet;
//}




//@DataProvider(name = "Registration_Details")
//public Object[][] registrationDetails(){
//	ExcelFileHandler ref = new ExcelFileHandler(prop.getProperty("datarepository.madinson.excelfile"));
//	Object[][] registrationDataSet =ref.getDataRecords(prop.getProperty("datarepository.madinson.excelfile.sheetname.register"));
//	return registrationDataSet;
//}