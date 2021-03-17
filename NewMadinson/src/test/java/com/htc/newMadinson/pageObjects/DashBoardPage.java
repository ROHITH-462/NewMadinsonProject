package com.htc.newMadinson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DashBoardPage {
	
	protected WebDriver driver;
	
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By menBtnBy = By.xpath("(//a[text()=\"Men\"])[1]");
	private By shirtOptionBy = By.xpath("//a[text()=\"Shirts\"]");
	private By assertValidTextBy = By.xpath("//div/h1");
	private By assertInvalidTextBy = By.xpath("//span[text() = \"Invalid login or password.\"]");
	
	public void placeCursorOnMen() {
		WebElement MenOption = driver.findElement(menBtnBy);
		Actions action = new Actions(driver);
		action.moveToElement(MenOption).perform();
	}
	
	public void clickShirtOption() {
		driver.findElement(shirtOptionBy).click();
	}
	
	public String checkValidLogin() {
		return driver.findElement(assertValidTextBy).getText();
	}
	
	public String checkInvalidLogin() {
		return driver.findElement(assertInvalidTextBy).getText();
	}
	
	public void selectCategory() {
		try {
		placeCursorOnMen();
		clickShirtOption();
		}catch(Throwable t) {
			System.out.println(t.getStackTrace());
		}
	}
	
}
