package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreation_Page_Locators {
	
	WebDriver driver;
	
	public AccountCreation_Page_Locators(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindAll({@FindBy(xpath = "((//div[@class='container container-full']//div)[4]//a)[1]"), @FindBy(xpath = "//a[contains(text(),'English')]")})
	WebElement language_selection;
	public WebElement language_selection() {
		return language_selection;		 // click English 
	}
	
	@FindAll({@FindBy(xpath = "//a[contains(text(),'Sign In / Sign Up')]"), @FindBy(xpath = "//div//a[contains(text(),'Sign In / Sign Up')]")})
	WebElement SignIn_SignUp_button;
	public WebElement SignIn_SignUp_button() {
		return SignIn_SignUp_button;	// click Sign In /Sign Up button 
	}
	
	
	@FindAll({@FindBy(xpath = "//input[@id='enter-civil-id-CivilId']"), @FindBy(xpath = "//input[@name='CivilId']")})
	WebElement Civil_ID_Text_field;
	public WebElement Civil_ID_Text_field() {
		return Civil_ID_Text_field;		// sendkeys Civil id 
	}
	
	
	@FindAll({@FindBy(xpath = "//span[text()='Next Step']"), @FindBy(xpath = "//div[@class='btn bg-gradient-success loader-wrap']//span")})
	WebElement Next_Step_Button;
	public WebElement Next_Step_Button() {
		return Next_Step_Button;		// click next step button 
	}
	
	@FindAll({@FindBy(xpath = "//input[@id='d-1']"), @FindBy(xpath = "//input[@placeholder='Day']")})
	WebElement Birth_Day;
	public WebElement Birth_Day() {
		return Birth_Day;		// sendkeys day 
	}
	
	@FindAll({@FindBy(xpath = "//input[@placeholder='Month']"), @FindBy(xpath = "//input[@data-date-input='m']")})
	WebElement Birth_Month;
	public WebElement Birth_Month() {
		return Birth_Month;		//sendkeys month 
	}
	
	@FindAll({@FindBy(xpath = "//input[@placeholder='Year']"), @FindBy(xpath = "//input[@data-date-input='y']")})
	WebElement Birth_Year;
	public WebElement Birth_Year() {
		return Birth_Year;		//sendkeys Year
	}
	
	@FindAll({@FindBy(xpath = "//input[@id='sign-up-MobileNumber']"), @FindBy(xpath = "//input[@name='MobileNumber']")})
	WebElement Mobile_Number;
	public WebElement Mobile_Number() {
	return Mobile_Number;		// sendkeys mobile number 
	}
	
	@FindAll({@FindBy(xpath = "//input[@id='sign-up-Email']"), @FindBy(xpath = "//input[@name='Email']")})
	WebElement Email_Address;
	public WebElement Email_Address() {
		return Email_Address;		// sendkeys email address 
	}
	
	@FindAll({@FindBy(xpath = "//input[@id='sign-in-PIN']"), @FindBy(xpath = "(//input[@type='password'])[1]")})
	WebElement New_Passcode;
	public WebElement New_Passcode() {
		return New_Passcode;		// sendkeys passcode new 
	}
	@FindAll({@FindBy(xpath = "sign-in-PINConfirm"), @FindBy(xpath = "(//input[@type='password'])[2]")})
	WebElement Confirm_Passcode;
	public WebElement Confirm_Passcode() {
		return Confirm_Passcode;		// sendkeys passcode confirm 
	}
	@FindAll({@FindBy(xpath = "//span[text()='Save your passcode']"), @FindBy(xpath = "(//span[@class='ng-binding'])[2]")})
	WebElement Save_Passcode;
	public WebElement Save_Passcode() {
		return Save_Passcode;		// click save passcode 
	}
	@FindAll({@FindBy(xpath = "//input[@id='sign-in-OTP']"), @FindBy(xpath = "//input[@name='OTP']")})
	WebElement Onetime_Passcode;
	public WebElement Onetime_Passcode() {
		return Onetime_Passcode;		// sendkeys OTP
	}
	@FindAll({@FindBy(xpath = "//span[text()='Set PIN']"), @FindBy(xpath = "//span[@class='ng-binding']")})
	WebElement Set_PIN;
	public WebElement Set_PIN() {
		return Set_PIN;		// click set pin 
	}
	
	//----------- Verification of scenario 1----------------// 
	
	@FindAll({@FindBy(xpath = "//div[@id='menu-btn']"), @FindBy(xpath = "//div[@ng-click='s.menu = !s.menu']")})
	WebElement Right_Hamburgermenu;
	public WebElement Right_Hamburgermenu() {
		return Right_Hamburgermenu;		// click right side menu 
	}
	@FindAll({@FindBy(xpath = "//div[@id='menu-inner']//a[text()='Account info']"), @FindBy(xpath = "//a[@href='/portal/account']")})
	WebElement Account_Info_Click;
	public WebElement Account_Info_Click() {
		return Account_Info_Click;		// click Account info 
	}
	
	@FindAll({@FindBy(xpath = "//input[@id='account_info-CivilId']"), @FindBy(xpath = "//input[@name='CivilId']")})
	WebElement Civilid_Verify;
	public WebElement Civilid_Verify() {
		return Civilid_Verify;		// get text civil id for verification
	}
	@FindAll({@FindBy(xpath = "//input[@id='account_info-Email']"), @FindBy(xpath = "//input[@name='Email']")})
	WebElement Emailid_Verify;
	public WebElement Emailid_Verify() {
		return Emailid_Verify;		// get text Email for verification
	}

	@FindAll({@FindBy(xpath = "//input[@id='account_info-MobileNumber']"), @FindBy(xpath = "//input[@name='MobileNumber']")})
	WebElement MobileNumber_Verify;
	public WebElement MobileNumber_Verify() {
		return MobileNumber_Verify;		// get text mobile number for verification
	}
	
}
