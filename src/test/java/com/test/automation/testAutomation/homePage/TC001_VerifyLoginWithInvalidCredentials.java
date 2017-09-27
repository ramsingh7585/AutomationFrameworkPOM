package com.test.automation.testAutomation.homePage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC001_VerifyLoginWithInvalidCredentials {
	
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		//driver=new FirefoxDriver();
		driver=new ChromeDriver();
		driver.get("file:///E:/workspace/POM/PageObjectWithPageFactoryFramework-master/project/demoSite.htm");
		
	}

	@Test
	public void veryfyLoginWithValidCredentials() {
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='PreviewFrame']")));
		
		driver.findElement(By.id("customer_login_link")).click();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test@gmail.com");
		
		driver.findElement(By.id("CustomerPassword")).sendKeys("password");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		String actualText = driver.findElement(By.xpath("//*[@id='customer_login']/div/ul/li")).getText();
		assertEquals(actualText, " login credentials.");


		
	}
	
	@AfterClass
	public void endTest() {
		
		driver.quit();
		
	}
	
	
}
