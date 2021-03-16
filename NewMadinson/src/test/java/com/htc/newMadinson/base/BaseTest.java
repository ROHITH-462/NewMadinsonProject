package com.htc.newMadinson.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.htc.newMadinson.pageObjects.ShoppingCartPage;
import com.htc.newMadinson.utility.SeleniumUtility;
import com.htc.newMadinson.pageObjects.CheckOutPage;
import com.htc.newMadinson.pageObjects.DashBoardPage;
import com.htc.newMadinson.pageObjects.IndexPage;
import com.htc.newMadinson.pageObjects.LoginPage;
import com.htc.newMadinson.pageObjects.OrderPlacedPage;
import com.htc.newMadinson.pageObjects.ProductPage;
import com.htc.newMadinson.pageObjects.RegistrationPage;


public class BaseTest {

	public Properties prop;

	protected WebDriver driver;
	protected IndexPage indexPage;
	protected RegistrationPage registrationPage;
	protected LoginPage loginPage;
	protected DashBoardPage dashBoardPage;
	protected ProductPage productPage;
	protected ShoppingCartPage addToCartPage;
	protected CheckOutPage checkOutPage;
	protected OrderPlacedPage orderPlacedPage;
	protected SeleniumUtility utils;
	

//	@BeforeSuite
	public Properties loadProperties() {

		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\NewMadinson\\src\\test\\resources\\props.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	

	public WebDriver getDriver() {
		return driver;
	}




	@BeforeClass
	public void setUp() {

		loadProperties();
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		indexPage = new IndexPage(driver);
		registrationPage = new RegistrationPage(driver);
		loginPage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		productPage = new ProductPage(driver);
		addToCartPage = new ShoppingCartPage(driver);
		checkOutPage = new CheckOutPage(driver);
		orderPlacedPage = new OrderPlacedPage(driver);
		utils = new SeleniumUtility(driver);
	}
	
//	@AfterTest
//	public void signOff() {
//		System.out.println("Status " + indexPage.isLogin());
//		if(indexPage.isLogin() == true)
//			indexPage.signOff();
//	}
	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}
		
}
