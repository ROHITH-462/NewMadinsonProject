package com.htc.newMadinson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

	protected WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}


	private By proceedToCheckOutBtnBy = By.xpath("(//button[@title = \"Proceed to Checkout\"])[1]");



	public void clickProceedBtn() {
		try {
		driver.findElement(proceedToCheckOutBtnBy).click();
		}catch(ElementClickInterceptedException ec) {
			ec.printStackTrace();
		}
	}



}



