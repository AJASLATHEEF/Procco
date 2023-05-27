package org.testfunction;

import org.apache.commons.lang.RandomStringUtils;
import org.common.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.pages.AccountCreation_Page_Locators;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_001_New_account_creation_verify extends BaseClass{
     
	@Parameters({"CivilID_1"})
	
	@Test
	private void tc_001_New_account_creation_verify_PFS_1(String CivilID_1) throws InterruptedException {
		
		// Generating random email address
		String random_string = RandomStringUtils.randomAlphabetic(8);
		String email1 = random_string.toLowerCase();		

		String Civil_id = prop.getProperty("Civil_id14");
		System.out.println("Civil id is "+Civil_id);		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		AccountCreation_Page_Locators obj = new AccountCreation_Page_Locators(driver);

		//Enter CivilID
		Visibility_Wait_EnterText(obj.Civil_ID_Text_field(), Civil_id);

		//Click next step button
		Clickable_Wait_Click(obj.Next_Step_Button());
		
		
		try {	
			//Enter Birth day
			Visibility_Wait_EnterText(obj.Birth_Day(), prop.getProperty("day"));
			
		} catch (Exception e) {
			
			getURL("front_office");
			
			//Enter CivilID
			Visibility_Wait_EnterText(obj.Civil_ID_Text_field(), CivilID_1);

			//Click next step button
			Clickable_Wait_Click(obj.Next_Step_Button());
			
			//Enter Birth day
			Visibility_Wait_EnterText(obj.Birth_Day(), prop.getProperty("day"));
				
		}
		
	
		

		//Enter Birth Month
		Visibility_Wait_EnterText(obj.Birth_Month(), prop.getProperty("month"));

		//Enter Birth Year
		Visibility_Wait_EnterText(obj.Birth_Year(),  prop.getProperty("year"));

		//Enter Mobile Number
        Visibility_Wait_EnterText(obj.Mobile_Number(), prop.getProperty("Mobile_number"));

		//Enter email Address
        Visibility_Wait_EnterText(obj.Email_Address(), email1+"@gmail.com");
        
	    Sleep(2000);

		//Click next step button
		Clickable_Wait_Click(obj.Next_Step_Button());
		
		//Enter new passcode
		Visibility_Wait_EnterText(obj.New_Passcode(), prop.getProperty("passcode"));

		//Enter confirm passcode
		Visibility_Wait_EnterText(obj.Confirm_Passcode(), prop.getProperty("passcode"));

		//Click Save Passcode Button
		Clickable_Wait_Click(obj.Save_Passcode());			

		//Enter OTP
		Visibility_Wait_EnterText(obj.Onetime_Passcode(), prop.getProperty("OTP"));

		//Click Set PIN Button
		Clickable_Wait_Click(obj.Set_PIN());
		
		//Click Right hamburger menu
		Clickable_Wait_Click(obj.Right_Hamburgermenu());
		
		//Click Account info option
		Clickable_Wait_Click(obj.Account_Info_Click());
		
		Sleep(3000);
		
		// Verification of Civil ID
		if (driver.getPageSource().contains(Civil_id)||driver.getPageSource().contains(CivilID_1)) {

			System.out.println("The Civil id verified successfully");
			
		}else {
			Assert.fail("The Civil id not matching");
			System.out.println("The Civil id not matching");
		}
		
		
		// Verification of Email ID
		Sleep(3000);
		if (driver.getPageSource().contains(email1+"@gmail.com")) {

			System.out.println("The Email_id verified successfully");
		}else {

			Assert.fail("The Email id not matching");
			System.out.println("The Email id not matching");	
		}

		js.executeScript("window.scrollBy(0,250)", "");	

		// Verification of mobile number
		Sleep(3000);
		if (driver.getPageSource().contains(prop.getProperty("Mobile_number"))) {

			System.out.println("The Mobile Number verified successfully");
		}else {

			Assert.fail("The Mobile Number is  not matching");
			System.out.println("The Mobile Number not matching");	
		}

		System.out.println("The test scenario is done ");


	}

}
