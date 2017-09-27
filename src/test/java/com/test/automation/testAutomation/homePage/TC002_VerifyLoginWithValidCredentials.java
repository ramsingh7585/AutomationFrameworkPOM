package com.test.automation.testAutomation.homePage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.testAutomation.pageActions.HomePage;
import com.test.automation.testAutomation.testBase.TestBase;

public class TC002_VerifyLoginWithValidCredentials extends TestBase{
	
	HomePage homepage;
	String username="ramsingh7585@gmail.com";
	String password="rama";
	//WebDriver driver;
	@BeforeClass
	public void setUp() throws IOException {
		
		init();
		
	}

	@Test
	public void veryfyLoginWithValidCredentials() {
		log("======================================starting veryfyLoginWithValidCredentials=======================================");
		homepage=new HomePage(driver);
		homepage.loginToApplication(username, password);
		assertEquals(homepage.actualMessage(), "Your Store");
		//getScreenShot("veryfyLoginWithValidCredentials");
		log("======================================finished veryfyLoginWithValidCredentials=======================================");



		
	}
	
	@AfterClass
	public void endTest() {
		
		closeBrowser();
		
	}
	

}
