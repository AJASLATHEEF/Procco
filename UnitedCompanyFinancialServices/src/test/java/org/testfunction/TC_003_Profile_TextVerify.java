package org.testfunction;

import org.common.BaseClass;
import org.pages.NewApplication_Creation_Page_Locators;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003_Profile_TextVerify extends BaseClass{

	@Test
	public void tc_003_Profile_Text_Verify_PFS_8() throws InterruptedException {

		NewApplication_Creation_Page_Locators obj = new NewApplication_Creation_Page_Locators(driver);

		//Civil id
		String Civil_id = prop.getProperty("Civil_id7");
		
		
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

		String ProfileText = obj.Signin_profileText().getText();

		System.out.println("Profile text is "+ProfileText);

		// Verification process	
		if (ProfileText.equals(prop.getProperty("TextAfter_SignIn"))) {

			System.out.println("Profile Text is not matching");

		} else {

			Assert.fail("Profile Text is not matching "+'\n'+ 
					"Actual Result :"+prop.getProperty("TextAfter_SignIn")
					+'\n'+ "Expected Result :"+ProfileText);
		}

	}

}
