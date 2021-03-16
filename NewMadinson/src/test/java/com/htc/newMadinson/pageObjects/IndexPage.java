package com.htc.newMadinson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;



public class IndexPage extends BasePage{

	protected WebDriver driver;
	protected BasePage basePage;

	public IndexPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		basePage = new BasePage(driver);
	}


	private By accountBtnBy = By.xpath("(//span[text() = \"Account\"])[1]");
	private By registerBtnBy = By.xpath("//a[text() = \"Register\"]");
	private By loginBtnBy = By.xpath("//a[text() = \"Log In\"]");
	private By logoutBtnBy = By.xpath("(//a[text() = \"Log Out\"])");

	public void clickAccountBtn() {
		try {
			basePage.waitForElementToBeClickable(driver, accountBtnBy);
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
			basePage.waitForVisibilityOfElementLocatable(driver, logoutBtnBy);
			flag = true;
		return flag;
	}
}

