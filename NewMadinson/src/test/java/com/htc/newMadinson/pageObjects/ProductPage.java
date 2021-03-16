package com.htc.newMadinson.pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.htc.newMadinson.utility.Util;

public class ProductPage {
	
	protected WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	Util utils = null;
	
	private By selectShirtBy = By.xpath("(//a[@title=\"Plaid Cotton Shirt\"])[2]");
	private By menBtnBy = By.xpath("(//a[text()=\"Men\"])[1]");
	private By selectColourBy = By.xpath("//a[@name=\"khaki\"]");
	private By selectSizeBy = By.xpath("//a[@title=\"L\"]");
	private By qtyTextBoxBy = By.xpath("//input[@title=\"Qty\"]");
	private By addToCartBtnBy = By.xpath("(//span[text()=\"Add to Cart\"])[2]");
	
	public void selectShirt() {
		driver.findElement(selectShirtBy).click();;
	}
	
	public void scroll(Util scrollLink) {
		utils = new Util(driver);
		utils.scrollToVisibleElement(menBtnBy, driver);
	}
	
	public void selectColour() {
		driver.findElement(selectColourBy).click();
	}
	
	public void selectSize() {
		driver.findElement(selectSizeBy).click();
	}
	
	public void setQty(Properties prop) {
		driver.findElement(qtyTextBoxBy).clear();
		driver.findElement(qtyTextBoxBy).sendKeys(prop.getProperty("ShirtQuantity"));
	}
	
	public void clickAddToCartBtn() {
		WebElement addToCartButton = driver.findElement(addToCartBtnBy);
		try {
		utils.waitForElementToBeClickable(driver, addToCartBtnBy);
		}catch(ElementClickInterceptedException e) {
			e.printStackTrace();
		}
		addToCartButton.click();
	}
	
	public void enterProductDetails(Properties prop, Util scrollLink) {
		scroll(scrollLink);
		selectShirt();
		selectColour();
		selectSize();
		setQty(prop);
		clickAddToCartBtn();
	}
}
