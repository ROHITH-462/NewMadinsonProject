package com.htc.newMadinson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.htc.newMadinson.base.GlobalVars;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, GlobalVars.explicitWaitTime);
	}
	
	public void waitForVisibilityOfElementLocatable(WebDriver driver, By locators) {
		wait = new WebDriverWait(driver, GlobalVars.explicitWaitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locators));
	}
	
	public void waitForElementToBeClickable(WebDriver driver, By locators) {
		wait = new WebDriverWait(driver, GlobalVars.explicitWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(locators));
	}
	
	public void waitForElementToBeSelected(WebDriver driver, By locators) {
		wait = new WebDriverWait(driver, GlobalVars.explicitWaitTime);
		wait.until(ExpectedConditions.elementToBeSelected(locators));
	}
	
	public void scrollToVisibleElement(By scrollLink, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(scrollLink));
	}	
	
	

}
