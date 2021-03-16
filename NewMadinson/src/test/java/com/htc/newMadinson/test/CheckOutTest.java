package com.htc.newMadinson.test;

import java.util.Map;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.htc.newMadinson.base.BaseTest;

public class CheckOutTest extends BaseTest {
	
	
	@Test(dataProvider = "Billing_Information", dataProviderClass = com.htc.newMadinson.utility.DataProviderManager.class)
	public void checkOutPageTest_shouldSelectTheProduct_orderShouldBePlaced(Map<String, String> mapData) {
		
		System.out.println("CheckOutPageTest");
		
		indexPage.navigateToLoginPage();
		loginPage.performLogin(mapData.get("email"), mapData.get("password"));
		dashBoardPage.selectCategory();
		productPage.enterProductDetails(prop, utils);
		addToCartPage.clickProceedBtn();
		checkOutPage.checkOutForTheProduct(mapData.get("FirstName"), mapData.get("LastName"), mapData.get("Address"), mapData.get("City"),
										   mapData.get("PostalCode"), mapData.get("Country"), mapData.get("Telephone"), utils);
		
		Assert.assertEquals(orderPlacedPage.checkOutAssertion(), "YOUR ORDER HAS BEEN RECEIVED.");

	}
}




















//indexPage.isLogin();
//indexPage.signOff();