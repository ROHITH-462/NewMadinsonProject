package com.htc.newMadinson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	
	protected WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By firstNameTextBoxBy = By.id("firstname");
	private By lastNameTextBoxBy = By.id("lastname");
	private By emailTextBoxBy = By.id("email_address");
	private By passwordTextBoxBy = By.id("password");
	private By confirmPasswordBy = By.id("confirmation");
	private By registerBtnBy = By.xpath("//span[text() = \"Register\"]");
	private By registrationAssertionTextBy = By.xpath("//span[text() = \"Thank you for registering with Madison Island.\"]");
	private By accountBtnBy = By.xpath("(//span[text() = \"Account\"])[1]");
	
	
	public void setFirstName(String firstName) {
		driver.findElement(firstNameTextBoxBy).sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		driver.findElement(lastNameTextBoxBy).sendKeys(lastName);
	}
	
	public void setEmail(String eMail) {
		driver.findElement(emailTextBoxBy).sendKeys(eMail);
	}
	
	public void setPassword(String password) {
		driver.findElement(passwordTextBoxBy).sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword) {
		driver.findElement(confirmPasswordBy).sendKeys(confirmPassword);
	}
	
	public void clickRegisterBtn() {
		driver.findElement(registerBtnBy).click();
	}
	
	public String registrationAssertionText() {
		return driver.findElement(registrationAssertionTextBy).getText();
	}
	
	public void clickAccountBtn() {
		driver.findElement(accountBtnBy).click();
	}
	
	
	
	public void createNewAccount(String firstName, String lastName, String eMail, String password, String confirmPassword) {
		try {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(eMail);
		setPassword(password);
		setConfirmPassword(confirmPassword);
		clickRegisterBtn();
		}catch(Throwable t) {
			t.printStackTrace();
		}
	}
	
	
}
