package com.htc.newMadinson.pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.htc.newMadinson.utility.SeleniumUtility;

public class ProductPage extends BasePage{
	
	protected WebDriver driver;
	protected BasePage basePage;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	private By selectShirtBy = By.xpath("(//a[@title=\"Plaid Cotton Shirt\"])[2]");
	private By menBtnBy = By.xpath("(//a[text()=\"Men\"])[1]");
	private By selectColourBy = By.xpath("//a[@name=\"khaki\"]");
	private By selectSizeBy = By.xpath("//a[@title=\"L\"]");
	private By qtyTextBoxBy = By.xpath("//input[@title=\"Qty\"]");
	private By addToCartBtnBy = By.xpath("(//span[text()=\"Add to Cart\"])[2]");
	
	public void selectShirt() {
		driver.findElement(selectShirtBy).click();;
	}
	
	public void scroll(SeleniumUtility scrollLink) {
		basePage = new BasePage(driver);
		basePage.scrollToVisibleElement(menBtnBy, driver);
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
	
	public void setQty(String shirtQuantity) {
		driver.findElement(qtyTextBoxBy).clear();
		driver.findElement(qtyTextBoxBy).sendKeys(shirtQuantity);
	}
	
	public void clickAddToCartBtn() {
		WebElement addToCartButton = driver.findElement(addToCartBtnBy);
		try {
			basePage.waitForElementToBeClickable(driver, addToCartBtnBy);
		}catch(ElementClickInterceptedException e) {
			e.printStackTrace();
		}
		addToCartButton.click();
	}
	
	public void enterProductDetails(SeleniumUtility scrollLink, String shirtQuantity) {
		try {
		scroll(scrollLink);
		selectShirt();
		selectColour();
		selectSize();
		setQty(shirtQuantity);
		clickAddToCartBtn();
		}catch(Throwable t) {
			System.out.println(t.getStackTrace());
		}
	}
}
