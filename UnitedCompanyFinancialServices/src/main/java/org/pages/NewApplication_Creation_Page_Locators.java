package org.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewApplication_Creation_Page_Locators {

	WebDriver driver;

	public NewApplication_Creation_Page_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(xpath = "//h1" )})
	WebElement Signin_profileText;
	public WebElement Signin_profileText() {
		return Signin_profileText;
	

	}

	@FindAll({ @FindBy(xpath = "((//div[@class='container container-full']//div)[4]//a)[1]"),
		@FindBy(xpath = "//a[contains(text(),'English')]") })
	WebElement language_selection;

	public WebElement language_selection() {
		return language_selection; // click English
	}
	
	
	@FindAll({ @FindBy(xpath = "//a[@class='btn sml btn-warn fab-sml']"),
		@FindBy(xpath = "//div//a[contains(text(),'Sign out')]") })
	WebElement SignOut_button;
	public WebElement SignOut_button() {
		return SignOut_button; // click SignOut_button
	}
	
	
	

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Sign In / Sign Up')]"),
		@FindBy(xpath = "//div//a[contains(text(),'Sign In / Sign Up')]") })
	WebElement SignIn_SignUp_button;
	public WebElement SignIn_SignUp_button() {
		return SignIn_SignUp_button; // click Sign In /Sign Up button
	}

	@FindAll({ @FindBy(xpath = "//input[@id='enter-civil-id-CivilId']"), @FindBy(xpath = "//input[@name='CivilId']") })
	WebElement Civil_ID_Text_field;

	public WebElement Civil_ID_Text_field() {
		return Civil_ID_Text_field; // sendkeys Civil id
	}

	@FindAll({ @FindBy(xpath = "//input[@id='sign-in-pin-start-PIN']"), @FindBy(xpath = "//input[@name='PIN']") })
	WebElement Passcode_Text_field;

	public WebElement Passcode_Text_field() {
		return Passcode_Text_field; // sendkeys for existing civil id
	}

	@FindAll({ @FindBy(xpath = "//span[@class='ng-binding']"), @FindBy(xpath = "//span[text()='Sign in']") })
	WebElement SignIn_button;

	public WebElement SignIn_button() {
		return SignIn_button; // click Sign In /Sign Up button
	}

	@FindAll({ @FindBy(xpath = "//input[@id='sign-in-OTP']"), @FindBy(xpath = "//input[@name='OTP']") })
	WebElement OTP_Text_field;

	public WebElement OTP_Text_field() {
		return OTP_Text_field; // send keys for OTP of existing civil id
	}

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Start New Application')]"),
		@FindBy(xpath = "//*[@id=\"ldng-bdy\"]/div[3]/div/a") })
	WebElement StartNewApplication_Button;

	public WebElement StartNewApplication_Button() {
		return StartNewApplication_Button; // click Start new application
	}

	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Personal Financing')]"),
		@FindBy(xpath = "//label[@value='2']") })
	WebElement Personal_Financing_Radio;

	public WebElement Personal_Financing_Radio() {
		return Personal_Financing_Radio; // click Radio button
	}
	
	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Personal Financing')]"),
		@FindBy(xpath = "//label[@value='2']") })
	List<WebElement> Personal_Financing_Radio_Size;

	public List<WebElement> Personal_Financing_Radio_Size() {
		return Personal_Financing_Radio_Size; // click Radio button size
	}

	@FindAll({ @FindBy(xpath = "//span[text()='Next Step']"),
		@FindBy(xpath = "//div[@class='btn bg-gradient-success loader-wrap']//span") })
	WebElement Next_Step_Button;

	public WebElement Next_Step_Button() { //
		return Next_Step_Button;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='select-store-Store']"), @FindBy(xpath = "//select[@name='Store']") })
	WebElement Branch_Drop;

	public WebElement Branch_Drop() {
		return Branch_Drop;
	}

	@FindAll({ @FindBy(xpath = "//option[text()='Al-Qunfudhah']"),
		@FindBy(xpath = "//*[@id=\"select-store-Store\"]/option[7]") })
	WebElement Branch_Select;

	public WebElement Branch_Select() {
		return Branch_Select;
	}



	@FindAll({ @FindBy(xpath = "//select[@id='residence_info-City']"), @FindBy(xpath = "//select[@name='City']") })
	WebElement City_Dropdown;

	public WebElement City_Dropdown() {
		return City_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//option[text()='Ahd Al Masarihih']") })
	WebElement City_select;
	public WebElement City_select() {
	return City_select;
	}


	@FindAll({ @FindBy(xpath = "//option[text()='Owned']") })
	WebElement Residence_select;

	public WebElement Residence_select() {
		return Residence_select;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='residence_info-Region']"), @FindBy(xpath = "//input[@name='Region']") })
	WebElement Region;

	public WebElement Region() {
		return Region;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='residence_info-Street']"), @FindBy(xpath = "//input[@name='Street']") })
	WebElement Street;

	public WebElement Street() {
		return Street; 
	}

	@FindAll({ @FindBy(xpath = "//input[@id='residence_info-BuildingNumber']"),
		@FindBy(xpath = "//input[@name='BuildingNumber']") })
	WebElement Building_Number;

	public WebElement Building_Number() {
		return Building_Number; // sendkeys
	}

	@FindAll({ @FindBy(xpath = "//select[@id='residence_info-TypeOfRsidence']"),
		@FindBy(xpath = "//select[@name='TypeOfRsidence']") })
	WebElement Residence_DropDown;
	public WebElement Residence_DropDown() {
		return Residence_DropDown;
	}


	@FindAll({ @FindBy(xpath = "//input[@id='employment_info-Company']"), @FindBy(xpath = "//input[@name='Company']") })
	WebElement Company_name;
	public WebElement Company_name() {
		return Company_name; // sendkeys
	}

	@FindAll({ @FindBy(xpath = "//li[@ng-repeat='o in (fd.fn_opts(field) || field.$optsObj)']") })
	List<WebElement> Company_name_suggestion;
	public List<WebElement> Company_name_suggestion() {
		return Company_name_suggestion; 
	}

	@FindAll({ @FindBy(xpath = "//li[@class='ng-binding ng-scope selected']"),
		@FindBy(xpath = "//li[text()='UNLISTED COMPANY']") })
	WebElement UnlistCompany_checkbox;
	public WebElement UnlistCompany_checkbox() {
		return UnlistCompany_checkbox; // click
	}

	@FindAll({ @FindBy(xpath = "//select[@id='employment_info-JobTitle']"),
		@FindBy(xpath = "//select[@name='JobTitle']") })
	WebElement JobTitle_Drop;
	public WebElement JobTitle_Drop() {
		return JobTitle_Drop; // click
	}
	
	
	
	@FindAll({ @FindBy(xpath = "//select[@id='employment_info-DurationOfService']"),
		@FindBy(xpath = "//select[@name='DurationOfService']") })
	WebElement Duration_Service_Drop;
	public WebElement Duration_Service_Drop() {
	return Duration_Service_Drop; // click
	}
	
	@FindAll({ @FindBy(xpath = "//option[text()='3 year']") })
	WebElement Duration_Service_Select;
	public WebElement Duration_Service_Select() {
	return Duration_Service_Select; // click
	}
	
	
	

	@FindAll({ @FindBy(xpath = "//select[@id='employment_info-EmploymentType']"),
		@FindBy(xpath = "//select[@name='EmploymentType']") })
	WebElement employer_Type_Drop;

	public WebElement employer_Type_Drop() {
		return employer_Type_Drop; // dropdown
	}

	@FindAll({ @FindBy(xpath = "//select[@id='employment_info-BusinessAddress_City']"),
		@FindBy(xpath = "//select[@name='BusinessAddress_City']") })
	WebElement buisiness_city_Drop;

	public WebElement buisiness_city_Drop() {
		return buisiness_city_Drop; // dropdown
	}

	@FindAll({ @FindBy(xpath = "//input[@id='employment_info-BusinessAddress_Region']"),
		@FindBy(xpath = "//input[@name='BusinessAddress_Region']") })
	WebElement buisiness_region;

	public WebElement buisiness_region() {
		return buisiness_region; // sendkeys
	}

	@FindAll({ @FindBy(xpath = "//input[@id='employment_info-BusinessAddress_Street']"),
		@FindBy(xpath = "//input[@name='BusinessAddress_Street']") })
	WebElement buisiness_street;

	public WebElement buisiness_street() {
		return buisiness_street; // sendkeys
	}

	@FindAll({ @FindBy(xpath = "//input[@id='employment_info-BusinessAddress_BuildingNumber']"),
		@FindBy(xpath = "//input[@name='BusinessAddress_BuildingNumber']") })
	WebElement buisiness_buildngNo;

	public WebElement buisiness_buildngNo() {
		return buisiness_buildngNo; // sendkeys
	}

	@FindAll({ @FindBy(xpath = "//input[@id='business_info-Income']"), @FindBy(xpath = "//input[@name='Income']") })
	WebElement Monthly_Salary;

	public WebElement Monthly_Salary() {
		return Monthly_Salary; // sendkeys
	}

	@FindAll({ @FindBy(xpath = "//select[@name='PurposeOfLoan']") , @FindBy(xpath = "//select[@id='other_info-PurposeOfLoan']")
		 })
	WebElement Purpose_Finance;

	public WebElement Purpose_Finance() {
		return Purpose_Finance; // dropdown Buy a House
	}

	@FindAll({ @FindBy(xpath = "//input[@id='id='other_info-OtherPrivateLoans']"),
		@FindBy(xpath = "//input[@name='OtherPrivateLoans']") })
	WebElement Family_Friendspay;

	public WebElement Family_Friendspay() {
		return Family_Friendspay; // send keys
	}

	@FindBy(xpath = "(//label[@class='ipt-lbl static ng-binding'])[1]")
	WebElement CheckBox_SIMAH;

	public WebElement CheckBox_SIMAH() {
		return CheckBox_SIMAH; // click
	}

	@FindBy(xpath = "(//label[@class='ipt-lbl static ng-binding'])[2]")
	WebElement CheckBox_TermsandCondition;

	public WebElement CheckBox_TermsandCondition() {
		return CheckBox_TermsandCondition; // click
	}

	@FindBy(xpath = "(//label[@class='ipt-lbl static ng-binding'])[3]")
	WebElement CheckBox3_Terms_Condition;

	public WebElement CheckBox3_Terms_Condition() {
		return CheckBox3_Terms_Condition; // click
	}

	@FindAll({ @FindBy(xpath = "//span[text()='Submit Your Application']"),
		@FindBy(xpath = "//span[@class='ng-binding']") })
	WebElement Submit_Application;

	public WebElement Submit_Application() {
		return Submit_Application; // click Submit Application
	}
	
	
	@FindAll({ @FindBy(xpath = "//label[@for='finalize-2']")})
	WebElement Income_Verification_radio;
	public WebElement Income_Verification_radio() {
		return Income_Verification_radio; 
	}
	
	
	@FindAll({ @FindBy(xpath = "//a[@class='btn action-btn sml btn-green']"),
		@FindBy(xpath = "//a[text()='Continue to next step']") })
	WebElement ContinueNextStep_Button;

	public WebElement ContinueNextStep_Button() {
		return ContinueNextStep_Button;
	}

	// ----------------------- Account info --------------------- //

	@FindAll({ @FindBy(xpath = "//input[@id='account_info-Firstname_En']"),
		@FindBy(xpath = "//input[@name='Firstname_En']") })
	WebElement Account_FirstName;

	public WebElement Account_FirstName() {
		return Account_FirstName; // Send keys
	}

	@FindAll({ @FindBy(xpath = "//input[@id='account_info-Lastname_En']"),
		@FindBy(xpath = "//input[@name='Lastname_En']") })
	WebElement Account_LastName;

	public WebElement Account_LastName() {
		return Account_LastName; // Send keys
	}

	@FindBy(xpath = "//label[@value='5']")
	WebElement RadioButton_Ms;

	public WebElement RadioButton_Ms() {
		return RadioButton_Ms; // click Radio button of Ms
	}

	@FindBy(xpath = "//label[@value='4']")
	WebElement RadioButton_Mrs;

	public WebElement RadioButton_Mrs() {
		return RadioButton_Mrs; // click Radio button of Mrs
	}

	@FindBy(xpath = "//label[@value='3']")
	WebElement RadioButton_Mr;
	public WebElement RadioButton_Mr() {
		return RadioButton_Mr; // click Radio button of Mr
	}

	@FindAll({ @FindBy(xpath = "//input[@id='d-1']"), @FindBy(xpath = "//input[@placeholder='Day']") })
	WebElement Expiry_day;

	public WebElement Expiry_day() {
		return Expiry_day; // Send keys - National ID expiry day
	}

	@FindAll({ @FindBy(xpath = "//input[@placeholder='Month']"), @FindBy(xpath = "//input[@data-date-input='m']") })
	WebElement Expiry_month;

	public WebElement Expiry_month() {
		return Expiry_month; // Send keys - National ID expiry month
	}

	@FindAll({ @FindBy(xpath = "//input[@placeholder='Year']"), @FindBy(xpath = "//input[@data-date-input='y']") })
	WebElement Expiry_year;

	public WebElement Expiry_year() {
		return Expiry_year; // Send keys - National ID expiry year
	}

	@FindAll({ @FindBy(xpath = "//select[@id='account_info-MaritalStatus']"),
		@FindBy(xpath = "//select[@name='MaritalStatus']") })
	WebElement Marital_status;
	public WebElement Marital_status() {
		return Marital_status; // Drop Down - Marital status
	}

	@FindAll({ @FindBy(xpath = "//input[@id='account_info-NumberOfDependents']"),
		@FindBy(xpath = "//input[@name='NumberOfDependents']") })
	WebElement Number_of_Member;

	public WebElement Number_of_Member() {
		return Number_of_Member; // sendkeys No of family members
	}

	@FindAll({ @FindBy(xpath = "//select[@id='account_info-Nationality']"),
		@FindBy(xpath = "//select[@name='Nationality']") })
	WebElement Nationality;

	public WebElement Nationality() {
		return Nationality; // Dropdown of the nationality
	}

	// ----------------- Verify the Congratulation message and Application Id
	// ----------------//

	@FindBy(xpath = "//div[@id='de-details']//div//div[@class='col-sm-12']//h1")
	WebElement Verifycongrats;

	public WebElement Verifycongrats() {
		return Verifycongrats; // Get Text
	}

	@FindBy(xpath = "//b[@class='hl']")
	WebElement Application_ID_Copy;
	public WebElement Application_ID_Copy() {
		return Application_ID_Copy; // Get Text of application id
	}

	@FindBy(xpath = "//a[text()='Continue to next step']")
	WebElement Continue_tonextstep;

	public WebElement Continue_tonextstep() {
		return Continue_tonextstep; // click the continue to next step
	}

	// ---------------Verify Account and application-------------------------//

	@FindBy(xpath = "//div[@class='scroll-to-on-load']//span[1]")
	WebElement personal_Finance_Verify;

	public WebElement personal_Finance_Verify() {
		return personal_Finance_Verify; // Get Text
	}

	@FindBy(xpath = "//div[@class='scroll-to-on-load']//span[2]")
	WebElement app_ID_Verify;

	public WebElement app_ID_Verify() {
		return app_ID_Verify; // Get Text
	}

	@FindBy(xpath = "//div[@class='scroll-to-on-load']//span[3]")
	WebElement submit_date_Verify;

	public WebElement submit_date_Verify() {
		return submit_date_Verify; // Get Text
	}

	@FindBy(xpath = "//div[@class='scroll-to-on-load']//span[4]")
	WebElement status_Verify;

	public WebElement status_Verify() {
		return status_Verify; // Get Text
	}
	
	@FindBy(xpath = "//div[@class='apps-table']//span[2]/b")
	WebElement Application_id_afterSubmit;
	public WebElement Application_id_afterSubmit() {
		return Application_id_afterSubmit; 
	}

	@FindBy(xpath = "//div[@class='apps-table']//span[4]/b")
	WebElement Status_afterSubmit;
	public WebElement Status_afterSubmit() {
		return Status_afterSubmit; 
	}
	
	@FindBy(xpath = "//div[@class='apps-table']//span[1]/b")
	WebElement Application_name;
	public WebElement Application_name() {
		return Application_name; 
	}
	
	
}
