package com.htc.newMadinson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

import com.htc.newMadinson.utility.Util;

public class OrderPlacedPage {
	
	protected WebDriver driver;
	Util utils = new Util(driver);
	String text;
	
	public OrderPlacedPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By orderAssertionTxtBy = By.xpath("(//h1[text() = \"Your order has been received.\"])");
	
	public String checkOutAssertion() {
		try {
			utils.waitForVisibilityOfElementLocatable(driver, orderAssertionTxtBy);
			text = driver.findElement(orderAssertionTxtBy).getText();
		}
		catch(ElementNotVisibleException ev) {
			ev.printStackTrace();
		}
		return text;
		
	}

}

