package com.htc.newMadinson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

import com.htc.newMadinson.utility.SeleniumUtility;

public class OrderPlacedPage extends BasePage {
	
	protected WebDriver driver;
	protected BasePage basePage;
	
	String text;
	
	
	public OrderPlacedPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		basePage = new BasePage(driver);
	}
	
	private By orderAssertionTxtBy = By.xpath("(//h1[text() = \"Your order has been received.\"])");
	
	public String checkOutAssertion() {
		try {
			basePage.waitForVisibilityOfElementLocatable(driver, orderAssertionTxtBy);
			text = driver.findElement(orderAssertionTxtBy).getText();
		}
		catch(ElementNotVisibleException ev) {
			ev.printStackTrace();
		}
		return text;
		
	}

}

