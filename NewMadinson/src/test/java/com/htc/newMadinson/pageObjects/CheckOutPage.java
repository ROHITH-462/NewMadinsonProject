package com.htc.newMadinson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.htc.newMadinson.utility.SeleniumUtility;



public class CheckOutPage extends BasePage {
	
	protected WebDriver driver;
	protected BasePage basePage;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		basePage = new BasePage(driver);
	}
	
	SeleniumUtility utils = new SeleniumUtility(driver);

	private By firstNameTxtBoxBy = By.id("billing:firstname");
	private By lastNameTxtBoxBy = By.id("billing:lastname");
	private By addressTxtBoxBy = By.id("billing:street1");
	private By cityTxtBoxBy = By.id("billing:city");
	private By pinCodeTxtBoxBy = By.id("billing:postcode");
	private By countryDropDownListBy = By.id("billing:country_id");
	private By telephoneTxtBoxBy = By.id("billing:telephone");
	private By clickBillingInfoContinueBtnBy = By.xpath("(//span[text() = \"Continue\"])[1]");
	private By shippingMethodRadioBtnBy = By.id("s_method_freeshipping_freeshipping");
	private By shippingContinueBtnBy = By.xpath("(//span[text()= \"Continue\"])[3]");
	private By paymentContinueBtnBy = By.xpath("(//span[text() = \"Continue\"])[4]");
	private By placeOrderBtnBy = By.xpath("(//span[text() = \"Place Order\"])");
	private By paymentInformationText = By.xpath("//h2[text() = \"Billing Information\"]");
	

	public void setFirstName(String firstname) {
		driver.findElement(firstNameTxtBoxBy).clear();	
		driver.findElement(firstNameTxtBoxBy).sendKeys(firstname);
	}

	public void setLastName(String lastname) {
		driver.findElement(lastNameTxtBoxBy).clear();
		driver.findElement(lastNameTxtBoxBy).sendKeys(lastname);
	}

	public void setAddress(String address) {
		driver.findElement(addressTxtBoxBy).sendKeys(address);
	}

	public void setCity(String city) {
		driver.findElement(cityTxtBoxBy).sendKeys(city);
	}

	public void setPinCode(String pincode) {
		driver.findElement(pinCodeTxtBoxBy).sendKeys(pincode);
	}

	public void selectCountry(String countryName) {
		Select country = new Select(driver.findElement(countryDropDownListBy));
		try {
		basePage.waitForElementToBeSelected(driver, countryDropDownListBy);
		country.selectByVisibleText(countryName);
		}catch(ElementNotSelectableException e) {
			e.printStackTrace();
		}
		
	}

	public void setPhoneNumber(String phoneNumber) {
		driver.findElement(telephoneTxtBoxBy).sendKeys(phoneNumber);
	}

	public void clickBillingInfoContinueBtn() {
		driver.findElement(clickBillingInfoContinueBtnBy).click();
	}

	public void shippingMethodRadioBtn() {
		WebElement shippingRadioBtn = driver.findElement(shippingMethodRadioBtnBy);
		shippingRadioBtn.click();
	}

	public void clickShippingMethodContinueBtn() {
		try {
			basePage.waitForElementToBeClickable(driver, shippingContinueBtnBy);
			driver.findElement(shippingContinueBtnBy).click();
		}
		catch(ElementClickInterceptedException ec) {
			ec.printStackTrace();
		}
		
	}

	public void clickPaymentContBtn() {
		try {
			basePage.waitForElementToBeClickable(driver, paymentContinueBtnBy);
			driver.findElement(paymentContinueBtnBy).click();
		}
		catch(ElementClickInterceptedException ec) {
			ec.printStackTrace();
		}
		
	}

	public void clickPlaceOrderBtnBy() {
		try {
			basePage.waitForElementToBeClickable(driver, placeOrderBtnBy);
			driver.findElement(placeOrderBtnBy).click();	
		}
		catch(ElementClickInterceptedException ec) {
			ec.printStackTrace();
		}
		
	}
	
	public void scroll(SeleniumUtility scrollLink) {
		basePage.scrollToVisibleElement(paymentInformationText, driver);
	}

	public void checkOutForTheProduct(String firstname, String lastname, String address, String city, String pincode, String country, String phoneNumber, SeleniumUtility scrollLink) {
		
		//clickProceedBtn();
		//setFirstName(firstname);
		//setLastName(lastname);
		//setAddress(address);
		//setCity(city);
		//setPinCode(pincode);
		//selectCountry(country);
		//setPhoneNumber(phoneNumber);
		clickBillingInfoContinueBtn();
		scroll(scrollLink);
		//shippingMethodRadioBtn();
		//selectShippingMethod();
		//shippingMethodRadioBtn();
		clickShippingMethodContinueBtn();
		clickPaymentContBtn();
		clickPlaceOrderBtnBy();
	}
}























		

		





