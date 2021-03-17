package com.htc.newMadinson.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.htc.newMadinson.base.BaseTest;



public class LoginTest extends BaseTest {

	@Test(dataProvider = "Login", dataProviderClass = com.htc.newMadinson.utility.DataProviderManager.class)
	public void loginTest(Map<String, String> mapData)
	{	
		indexPage.navigateToLoginPage();
		loginPage.performLogin(mapData.get("Email"), mapData.get("Password"));
		if(mapData.get("Expected").equals("MY DASHBOARD")) { 
			Assert.assertEquals(dashBoardPage.checkValidLogin(),"MY DASHBOARD");
			basePage.signOff();
		}

		if(mapData.get("Expected").equals("Invalid login or password.")) 
			Assert.assertEquals(dashBoardPage.checkInvalidLogin(), "Invalid login or password.");

	}
}


















//indexPage.signOff();
//indexPage.isLogin();






//@Test(dataProvider = "Valid_Login_Details", dataProviderClass = com.htc.newMadinson.utility.DataProviderManager.class, priority = 1, enabled = false)
//public void testLoginPage_enterCredantials_shouldLoginSuccessful(Map<String, String> mapData) {
//	
//	System.out.println("ValidLoginPageTest");
//	
//	indexPage.navigateToLoginPage();
//	loginPage.performLogin(mapData.get("Email"), mapData.get("Password"));
//	Assert.assertEquals(loginPage.assertLoginPage(), "MY DASHBOARD");
//	indexPage.signOff();		
//}





//@Test(dataProvider = "Invalid_Login_Details", dataProviderClass = com.htc.newMadinson.utility.DataProviderManager.class, priority = 2, enabled = false)
//public void testLoginPage_InValidloginCredential_ShouldErrorInSigninPage(Map<String, String> mapData) {
//	
//	System.out.println("InvalidLoginPageTest");
//	
//	indexPage.navigateToLoginPage();
//	loginPage.performLogin(mapData.get("Email"), mapData.get("Password"));
//	Assert.assertEquals(loginPage.assertInvalidLoginPage(), "Invalid login or password.");
//}
