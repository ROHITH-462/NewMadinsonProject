package com.htc.newMadinson.test;

import java.util.Map;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.htc.newMadinson.base.BaseTest;


public class RegistrationTest extends BaseTest {
		
	@Test(dataProvider = "Registration_Details", dataProviderClass = com.htc.newMadinson.utility.DataProviderManager.class)
	
	public void createNewAccountTest_credantialsShouldBeFetchedFromExcel_shouldRegisterSuccessful(Map<String, String> mapData) {
		
		System.out.println("Registration Page Test");
		
		indexPage.navigateToRegisterPage();
		registrationPage.createNewAccount( mapData.get("FirstName"), mapData.get("LastName"), mapData.get("Email"), 
										   mapData.get("Password"),  mapData.get("ConfirmPassword"));
		
		Assert.assertEquals(registrationPage.registrationAssertionText(), "Thank you for registering with Madison Island.");
//		indexPage.signOff();
//		indexPage.isLogin();
		
		
	}

}
