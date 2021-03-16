package com.htc.newMadinson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

import com.htc.newMadinson.utility.Util;

public class IndexPage {

	protected WebDriver driver;
	protected Util utils;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}


	private By accountBtnBy = By.xpath("(//span[text() = \"Account\"])[1]");
	private By registerBtnBy = By.xpath("//a[text() = \"Register\"]");
	private By loginBtnBy = By.xpath("//a[text() = \"Log In\"]");
	private By logoutBtnBy = By.xpath("(//a[text() = \"Log Out\"])");

	public void clickAccountBtn() {
		try {
			utils = new Util(driver);
			utils.waitForElementToBeClickable(driver, accountBtnBy);
			driver.findElement(accountBtnBy).click();
		}catch(ElementClickInterceptedException e){
			e.printStackTrace();
		}
	}

	public void clickRegisterBtn() {
		driver.findElement(registerBtnBy).click();
	}

	public void clickLoginBtn() {
		driver.findElement(loginBtnBy).click();
	}

	public void clickLogOutBtn() {
		driver.findElement(logoutBtnBy).click();
	}

	public void navigateToRegisterPage() {
		clickAccountBtn();
		clickRegisterBtn();
	}

	public void navigateToLoginPage() {
		clickAccountBtn();
		clickLoginBtn();
	}

	public void signOff() {
		clickAccountBtn();
		clickLogOutBtn();
	}

	public boolean isLogin() {
		boolean flag = false;
		clickAccountBtn();
		if(driver.findElement(logoutBtnBy).isDisplayed())
			utils.waitForVisibilityOfElementLocatable(driver, logoutBtnBy);
			flag = true;
		return flag;
	}
}

