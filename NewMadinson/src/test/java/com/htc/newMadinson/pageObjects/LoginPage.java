package com.htc.newMadinson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	protected WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By emailTextBoxBy = By.xpath("//input[@id= \"email\"]");
	private By passwordTextBoxBy = By.id("pass");
	private By loginBtnBy = By.id("send2");
	
	
	
	public void setEmail(String eMail) {
		driver.findElement(emailTextBoxBy).sendKeys(eMail);
	}
	
	public void setPassword(String password) {
		driver.findElement(passwordTextBoxBy).sendKeys(password);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtnBy).click();
	}
		
	public void performLogin(String eMail, String password) {
		try {
		setEmail(eMail);
		setPassword(password);
		clickLoginBtn();
		}catch(Throwable t) {
			System.out.println(t.getStackTrace());
		}
	}

}
