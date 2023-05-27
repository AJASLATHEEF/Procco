package org.testfunction;

import java.awt.AWTException;

import org.common.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.pages.NewApplication_Creation_Page_Locators;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_002_NewApplication_Creation_Verify extends BaseClass {

	@Parameters({"CivilID_2"})

	@Test
	public void tc_002_NewApplication_Creation_Verify_PFS_2(String CivilID_2 ) throws AWTException, InterruptedException {

		String Civil_id = prop.getProperty("Civil_id7");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		NewApplication_Creation_Page_Locators obj = new NewApplication_Creation_Page_Locators(driver);

		obj.Civil_ID_Text_field().click();
		
		//Enter civil id
		Visibility_Wait_EnterText(obj.Civil_ID_Text_field(), Civil_id);

		//Click Next Step Button
		Clickable_Wait_Click(obj.Next_Step_Button());

		//Enter Passcode		
		Visibility_Wait_EnterText(obj.Passcode_Text_field(), prop.getProperty("passcode"));

		//Click SignIn Button
		Clickable_Wait_Click(obj.SignIn_button());

		//Enter OTP		
		Visibility_Wait_EnterText(obj.OTP_Text_field(), prop.getProperty("OTP"));

		//Click SignIn button	
		Clickable_Wait_Click(obj.SignIn_button());
		Sleep(3000);

		//Click StartNew Application Button
		Clickable_Wait_Click(obj.StartNewApplication_Button());

		System.out.println("Check status");

		try {

			obj.Personal_Financing_Radio().click();


		} catch(Exception e){


			System.out.println("radio button is not displayed");
			//Click SignOut
			Clickable_Wait_Click(obj.SignOut_button());

			//Enter civil id
			Visibility_Wait_EnterText(obj.Civil_ID_Text_field(), CivilID_2);

			//Click Next Step Button
			Clickable_Wait_Click(obj.Next_Step_Button());

			//Enter Passcode		
			Visibility_Wait_EnterText(obj.Passcode_Text_field(), prop.getProperty("passcode"));

			//Click SignIn Button
			Clickable_Wait_Click(obj.SignIn_button());

			//Enter OTP		
			Visibility_Wait_EnterText(obj.OTP_Text_field(), prop.getProperty("OTP"));

			//Click SignIn button	
			Clickable_Wait_Click(obj.SignIn_button());
			Sleep(3000);

			//Click StartNew Application Button
			Clickable_Wait_Click(obj.StartNewApplication_Button());

		}

		System.out.println("Exit from catch ");

		//Click personal financing radio button
		Clickable_Wait_Click(obj.Personal_Financing_Radio());

		//Click Next Step Button
		Clickable_Wait_Click(obj.Next_Step_Button());
		Sleep(2000);

		//Select branch from the branch drop down list
		SelectByVisibleText(obj.Branch_Drop(), "Branch1");	

		//Click Next Step Button
		Clickable_Wait_Click(obj.Next_Step_Button());
		Sleep(2000);

		//Select City from the City drop down list
		SelectByVisibleText(obj.City_Dropdown(), "City1"); 

		//Enter Street name
		Visibility_Wait_EnterText(obj.Street(), prop.getProperty("Street1"));

		//Enter Building Number
		Visibility_Wait_EnterText(obj.Building_Number(), prop.getProperty("BuildingNumber1"));		

		//Select Type of Residence from the residence drop down
		SelectByVisibleText(obj.Residence_DropDown(), "Residence1");

		//Click Next Step Button
		Clickable_Wait_Click(obj.Next_Step_Button());

		//Enter Company name
		Visibility_Wait_EnterText(obj.Company_name(), prop.getProperty("Company_name1"));

		//	Company Name verification
		int Company_name_suggestion = Size(obj.Company_name_suggestion());
		System.out.println("Company_name_suggestion couont is "+ Company_name_suggestion);


		for (int i = 0; i < Company_name_suggestion; i++) {

			String name_suggestion = obj.Company_name_suggestion().get(i).getText();
			System.out.println(i +" th suggested name is "+name_suggestion);

			if (name_suggestion.equalsIgnoreCase(prop.getProperty("Company_name1"))) {

				Clickable_Wait_Click(obj.Company_name_suggestion().get(i));
				break;

			} else {
				System.out.println(i +"th number Name is not matching ");
			}
		}

		js.executeScript("window.scrollBy(0,250)", "");	
		Sleep(2000);

		//Select Job title from the drop down list
		SelectByVisibleText(obj.JobTitle_Drop(), "Job_title1");	

		//Select duration of service from the drop down list
		SelectByVisibleText(obj.Duration_Service_Drop(), "Duration_of_Service1");

		//Select city from the drop down list
		SelectByVisibleText(obj.buisiness_city_Drop(), "City1");

		//Enter Buisiness street
		Visibility_Wait_EnterText(obj.buisiness_street(), prop.getProperty("Street2"));

		//Enter Buisiness Building Number
		Visibility_Wait_EnterText(obj.buisiness_buildngNo(),prop.getProperty("buisiness_buildngNo"));

		//Click Next Step Button
		Clickable_Wait_Click(obj.Next_Step_Button());

		//Clear the existing monthly salary
		obj.Monthly_Salary().clear();

		//Enter the New Monthly salary
		Visibility_Wait_EnterText(obj.Monthly_Salary(), prop.getProperty("Monthly_Salary1"));

		//Click Next Step Button
		Clickable_Wait_Click(obj.Next_Step_Button());
		Sleep(2000);

		//Select purpose of finance from the drop down list
		SelectByVisibleText(obj.Purpose_Finance(), "Purpose_finance1");

		//Click Next Step Button
		Clickable_Wait_Click(obj.Next_Step_Button());
		Sleep(1000);

		//Click SIMAH check box
		Clickable_Wait_Click(obj.CheckBox_SIMAH());

		//Click Terms and condition Check box
		Clickable_Wait_Click(obj.CheckBox_TermsandCondition());

		//Click on terms condition check box
		Clickable_Wait_Click(obj.CheckBox3_Terms_Condition());

		//Click Submit Application Button
		Clickable_Wait_Click(obj.Submit_Application());
		Sleep(3000);

		//Income Verification 

		//Click on income verification radio button
		Clickable_Wait_Click(obj.Income_Verification_radio());
		Sleep(3000);

		//Click on continue to next step button
		Clickable_Wait_Click(obj.Continue_tonextstep());

		//Get text of Application ID
		Visibility_Wait(obj.Application_ID_Copy());
		String application_id = obj.Application_ID_Copy().getText();
		System.out.println("Application id is "+application_id);

		//Click on continue to next step button
		Clickable_Wait_Click(obj.ContinueNextStep_Button());

		//Get text of application id, status and application name after submission
		String text1 = obj.Application_id_afterSubmit().getText();
		String text2 = obj.Status_afterSubmit().getText();
		String text3 = obj.Application_name().getText();

		//Print the get text value of application id ,status and application name
		System.out.println(text1 + text2 + text3);
		Sleep(3000);

		//Verification of application name
		if (driver.getPageSource().contains(prop.getProperty("Application_name1"))) {

			System.out.println("Application name is matching");		
		}

		else {
			Assert.fail();
			System.out.println("Application name is not matching");
		}

		Sleep(3000);

		//Verification of application ID
		if (driver.getPageSource().contains(application_id)) {

			System.out.println("Application id is matching");		
		}

		else {
			Assert.fail();
			System.out.println("Application id is not matching");
		}

		Sleep(3000);

		//Verification of status
		if (driver.getPageSource().contains(prop.getProperty("Status1"))) {

			System.out.println("Status is matching");		
		}

		else {
			Assert.fail();
			System.out.println("Status is not matching");
		}




	}



}
