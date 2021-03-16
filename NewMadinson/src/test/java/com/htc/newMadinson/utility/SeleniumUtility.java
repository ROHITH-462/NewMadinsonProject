package com.htc.newMadinson.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SeleniumUtility {

	protected WebDriver driver;
	
	public SeleniumUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public static String ScreenShot(WebDriver driver, String fileName, String filePath ) {

        String scrPath= filePath + fileName +  timeStamp()  +".jpg";
		TakesScreenshot tss = (TakesScreenshot) driver;
		File file = tss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(scrPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return scrPath;
	}
	
	public static String timeStamp() {
		return new SimpleDateFormat("E, dd MMMM-yyyy  hh mm ss").format(new Date());

	}

}





































//public void captureScreenshotsPass(WebDriver driver) {
//	TakesScreenshot screenshot = ((TakesScreenshot) driver);
//	File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
//	Date date = new Date();
//	//		String screenShotName = methodName + ".jpg";
//	String screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";
//	File destFile = new File(System.getProperty(baseTest.prop.getProperty("screenshot.file.location.pass") + screenshotName));
//	try {
//		FileUtils.copyFile(srcFile, destFile);
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}



//public static void captureScreenshots(WebDriver driver, String filePath, String methodName) {
//System.out.println("Before" + driver);
//TakesScreenshot screenshot = ((TakesScreenshot) driver);
//System.out.println("After" + driver);
//File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
////Date date = new Date();
////		String screenShotName = methodName + ".jpg";
//String screenshotName = LocalDateTime.now() + ".jpg";
//File destFile = new File(filePath + methodName + screenshotName);
//try {
//	FileUtils.copyFile(srcFile, destFile);
//} catch (IOException e) {
//	e.printStackTrace();
//}
//}




