package com.test.automation.testAutomation.homePage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.testAutomation.pageActions.HomePage;
import com.test.automation.testAutomation.testBase.TestBase;

public class TC003_VerifyRegistration extends TestBase {
	HomePage homePage;
	 String firstName="Ram";
	 String lastName="Singh	";
	 String email="ramsingh7585+"+System.currentTimeMillis()+"@gmail.com";
	 String phone="9876543210";
	 String password="radheradhe";
	 String confirmPassword="radheradhe";
	
	@BeforeClass
	public void setUp() throws IOException {
		
		init();
	}
	
	@Test
	public void verifyRegistration(){
		log("==============================================starting verifyRegistration==============================================");
		homePage=new HomePage(driver);
		homePage.registerUser(firstName, lastName, email, phone, password, confirmPassword);
		assertEquals(homePage.registrationMessage(), "Congratulations! Your new account has been successfully created!");
		//getScreenShot("verifyRegistration");
		log("==============================================Finished verifyRegistration==============================================");
				
	}
	
	@AfterClass
	public void endTest() {
		
		closeBrowser();
	}
	
	

}
