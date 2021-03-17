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

	private By addressDropDownBy = By.id("billing-address-select");
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
	private By lastNameTextByScroll = By.xpath("(//label[text()=\"Last Name\"])[1]");


	public void selectAddressDropDown() {
		Select addressDropDown = new Select(driver.findElement(addressDropDownBy));
		addressDropDown.selectByVisibleText("New Address");
	}

	public void setFirstName(String firstname) {
		driver.findElement(firstNameTxtBoxBy).clear();	
		driver.findElement(firstNameTxtBoxBy).sendKeys(firstname);
	}

	public void setLastName(String lastname) {
		driver.findElement(lastNameTxtBoxBy).clear();
		driver.findElement(lastNameTxtBoxBy).sendKeys(lastname);
	}

	public void setAddress(String address) {
		driver.findElement(addressTxtBoxBy).clear();
		driver.findElement(addressTxtBoxBy).sendKeys(address);
	}

	public void setCity(String city) {
		driver.findElement(cityTxtBoxBy).clear();
		driver.findElement(cityTxtBoxBy).sendKeys(city);
	}

	public void setPinCode(String pincode) {
		driver.findElement(pinCodeTxtBoxBy).clear();
		driver.findElement(pinCodeTxtBoxBy).sendKeys(pincode);
	}
	
	public void scroll1() {
		basePage.scrollToVisibleElement(lastNameTextByScroll, driver);
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
		driver.findElement(telephoneTxtBoxBy).clear();
		driver.findElement(telephoneTxtBoxBy).sendKeys(phoneNumber);
	}

	public void clickBillingInfoContinueBtn() {
		driver.findElement(clickBillingInfoContinueBtnBy).click();
	}

	public void shippingMethodRadioBtn() {
		try {
			basePage.waitForElementToBeClickable(driver, shippingMethodRadioBtnBy);
			WebElement shippingRadioBtn = driver.findElement(shippingMethodRadioBtnBy);
			shippingRadioBtn.click();
		}catch(ElementClickInterceptedException ec) {
			ec.printStackTrace();
		}	
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

	public void scroll() {
		basePage.scrollToVisibleElement(paymentInformationText, driver);
	}

	public void checkOutForTheProduct(String firstname, String lastname, String address, String city, String pincode, String country, String phoneNumber) {

		try {
			selectAddressDropDown();	
			setFirstName(firstname);
			setLastName(lastname);
			setAddress(address);
			setCity(city);
			setPinCode(pincode);
			scroll1();
//			selectCountry(country);
			setPhoneNumber(phoneNumber);
			clickBillingInfoContinueBtn();
//			scroll();
			shippingMethodRadioBtn();
			clickShippingMethodContinueBtn();
			clickPaymentContBtn();
			clickPlaceOrderBtnBy();
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
}































