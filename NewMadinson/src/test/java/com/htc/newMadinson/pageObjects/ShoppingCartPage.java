package com.htc.newMadinson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

	protected WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}


	private By proceedToCheckOutBtnBy = By.xpath("(//button[@title = \"Proceed to Checkout\"])[1]");

	//private By clickShippingBtnBy = By.name("shipping_method");


	public void clickProceedBtn() {
		driver.findElement(proceedToCheckOutBtnBy).click();
	}

	//	public void selectShippingMethod() {
	//		WebElement radioBtn = driver.findElement(clickShippingBtnBy);
	//		radioBtn.click();
	//	}

}



