package com.test.automation.testAutomation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class TestBase {
	
	public static WebDriver driver;
	//String url="http://localhost/OpenCart/upload/";
	//String browser="chrome";
	public Properties OR=new Properties();
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	
	public void loadData() throws IOException {
		
		File file=new File(System.getProperty("user.dir")+"/src/main/java/com/test/automation/testAutomation/config/config.properties");
		FileInputStream fis=new FileInputStream(file);
		OR.load(fis);
				
	}
	
	public void init() throws IOException {
		loadData();
		String log4JConfPath="log4J.properties";
		PropertyConfigurator.configure(log4JConfPath);
		selectBrowser(OR.getProperty("browser"));
		log("opened the browser: "+OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
		log("entered the url: "+OR.getProperty("url"));
		
			
		
	}
	
	public void selectBrowser(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			//driver=new FirefoxDriver();
			driver=new ChromeDriver();
		
			
		}
		
		else if (browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			//driver=new FirefoxDriver();
			driver=new FirefoxDriver();
		
		}
		
	}
	
	public void getUrl(String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	public void log(String data){
		
		log.info(data);
		Reporter.log(data);
		
	}
	
	
	public void getScreenShot(String name) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/testAutomation/screenshot/";
			File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeBrowser() {
		
		driver.quit();
		log.info("Closed the browser");
	}

}
