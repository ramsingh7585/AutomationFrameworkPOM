package com.test.automation.testAutomation.pageActions;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.test.automation.testAutomation.testBase.TestBase;

public class HomePage extends TestBase {

	WebDriver driver;
	
	public static final Logger log=Logger.getLogger(HomePage.class.getName());
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	WebElement myAccount;
	
	@FindBy(css="#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a")
	WebElement loginLink;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement username;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id='logo']/h1/a")
	WebElement actual;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement registrationLink;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstName;
	
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	
	@FindBy(css="#input-telephone")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='input-password' and @class='form-control']")
	WebElement regpassword;
	
	@FindBy(xpath="//input[@id='input-confirm' and @class='form-control']")
	WebElement confirmregPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkAgreement;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//*[@id='content']/p[1]")
	WebElement regstrationSuccessMessage;
	
	
		
	
	
	
	
	
   public HomePage(WebDriver driver) {
   this.driver=driver;
   PageFactory.initElements(driver, this);

}

   public void registerUser(String firstName, String lastName, String email, String phone, String password, String confirmPassword) {
		
	   
	        myAccount.click();
	        log("clicked on myAccount and object is:"+myAccount.toString());
	   		log.info("clicked on myAccount and object is:"+myAccount.toString());
	   		//Click on register link
	        registrationLink.click();
	        
	        log("clicked on registrationLink and object is:"+registrationLink.toString());
	   		
	   		this.firstName.sendKeys(firstName);
	   		
	   		log("entered firstname and object is:"+this.firstName.toString());
	   		
	   		this.lastName.sendKeys(lastName);
	   		
	   		log("entered lastName and object is:"+this.lastName.toString());
	   		
	   		this.email.sendKeys(email);
	   		
	   		log("entered email and object is:"+this.email.toString());
	   		System.out.println("email id: "+this.email.getAttribute("value"));
	   		
	   		
	   		this.phone.sendKeys(phone);
	   		
	   		log("entered phone and object is:"+this.phone.toString());
	   		
	   		this.regpassword.sendKeys(password);
	   		
	   		log("entered password and object is:"+this.regpassword.toString());

	   		this.confirmregPassword.sendKeys(password);
	   		
	   		log("entered password and object is:"+this.confirmregPassword.toString());
	   		
	   		checkAgreement.click();
	   		
	   		log("clicked on agreement checkbox and object is:"+checkAgreement.toString());
	   		
	   		
	   		continueButton.click();
	   		
	   		log("clicked on continueButton and object is:");
	   		
	   	}
	
   
   public String registrationMessage() {
	   
	   String regMessage = regstrationSuccessMessage.getText();
	   return regMessage;
	
}
	
	public void loginToApplication(String username, String password) {
		
		myAccount.click();
		
		log("clicked on myAccount and object is: "+myAccount.toString());
		
		loginLink.click();
		
		log("clicked on loginLink");
		
		this.username.sendKeys(username);
		
		log("entered the username and object is: "+this.username.toString());
		
		this.password.sendKeys(password);
		
		log("entered the password and object is: "+this.password.toString());
		
		loginButton.click();
		
		log("clicked on login button");
		
	}
	
	public String actualMessage() {
		String actualText = actual.getText();
		return actualText;
		
	}
	
	
	
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}
	
	
	
	
	
}
