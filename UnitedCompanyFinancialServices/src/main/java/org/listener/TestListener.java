package org.listener;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.capture.ExtentManager;
import org.common.BaseClass;
import org.dcryptutils.DcryptUtils;
import org.jira.JiraPolicy;
import org.jira.JiraServiceProvider;
import org.jira.Jira_Duplication;
import org.jira.Jira_description;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListener extends BaseClass implements ITestListener{  

	public static WebDriver driver;
	public String a;
	public String Image_path;
	ExtentTest test;

	static Date d = new Date();
	DcryptUtils dc = new DcryptUtils();

	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {  

		String method_name = result.getMethod().getConstructorOrMethod().getMethod().getName();
		String Story_id1 = method_name.substring(method_name.length() - 5);
		String issueSummary2 = method_name.replace(Story_id1, "");
		String ReoportTitle1 = issueSummary2.replaceAll("_", " ");
		String ReoportTitle = ReoportTitle1.substring(6);

		ExtentTest test = extent.createTest("TestCase : "+ReoportTitle);
		testReport.set(test);

	}

	public void onTestSuccess(ITestResult result) {

		//Customize extentreport for success testcase
		String method_name = result.getMethod().getConstructorOrMethod().getMethod().getName();
		String Story_id1 = method_name.substring(method_name.length() - 5);
		String issueSummary2 = method_name.replace(Story_id1, "");
		String ReoportTitle1 = issueSummary2.replaceAll("_", " ");
		String ReoportTitle = ReoportTitle1.substring(6);

		String logText="<b>"+"TEST CASE:- "+ ReoportTitle.toUpperCase()+ " PASSED"+"</b>";	
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);	

	}

	public void onTestFailure(ITestResult result) {

		//Customize extent report for failed testcase and raise a bug	
		Jira_description data = new Jira_description();
		data.jiradescription(result.getThrowable().getMessage());

		String method_name = result.getMethod().getConstructorOrMethod().getMethod().getName();
		String Story_id1 = method_name.substring(method_name.length() - 5);
		String issueSummary2 = method_name.replace(Story_id1, "");
		
		String ReoportTitle1 = issueSummary2.replaceAll("_", " ");
		String ReoportTitle = ReoportTitle1.substring(6);

		String issueSummary3 = issueSummary2 + data.bug;
		String issueSummary4 = issueSummary2.substring(6).replaceAll("_", " ");
		String issueSummary = issueSummary3.substring(6).replaceAll("_", " ");;
		
		
		//Test case title
		String logText="<b>"+"TEST CASE:- "+ ReoportTitle.toUpperCase()+ " IS FAILED"+"</b>";

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);

		String excepionMessage= result.getThrowable().getMessage();

		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"

			+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");


		try {	

			//Screenshot attachment
			ExtentManager.captureScreenshot();			
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.image_path).build());

			System.out.println("Screenshot path isssss "+ ExtentManager.image_path);

			System.out.println("**********Screenshot added successfully in extent report*******");

		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ExtentManager em = new ExtentManager();
		try {
			em.screenshot();
			 Image_path = em.imagePath1;
			System.out.println("Image capturing is successfull path is "+Image_path);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		// Check for similar bug
		
		Jira_Duplication bug_duplication = new Jira_Duplication();
		try {
			bug_duplication.Duplication_bug(issueSummary4);
		} catch (InterruptedException e1) {
			System.out.println("Dupliication Checking is fail");
			e1.printStackTrace();
		}
		
		String BugID = bug_duplication.Bug_ID;
		
		
		if (BugID==null) {
			
			boolean jirapolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class)==null;

			//Decrypting token and username
			dc.Dcrypt_token();
			dc.Dcrypt_username();

			if(jirapolicy){

				//Raise a ticket in jira		
				JiraServiceProvider sp = new JiraServiceProvider("https://xillidev.atlassian.net/", dc.username , dc.token , "PFS");			
				String Story_id = Story_id1.replace("_", "-");
				System.out.println("Story id is "+Story_id);

			

				System.out.println("issueSummary is " + issueSummary);
				String issueDesc = result.getThrowable().getMessage()+"\n" + "\n";
				issueDesc.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));					 
				System.out.println("issueDesc is "+issueDesc);

				try {

					//Passing the values to JIRA Service provider class 
					sp.createJiraTicket1("Bug", issueSummary, issueDesc, Story_id , Image_path);
					a = sp.issueNum;
					System.out.println("Issue number is "+a);

				} catch (Exception e) {
					e.printStackTrace();
				}			
			}
		}
		
		

		//Creating JIRA bug hyperlink
		System.out.println("Bug id is "+a);
		String Bug_url = prop.getProperty("Bug_URL")+a;
		String Bug_url1 = prop.getProperty("Bug_URL")+BugID;
		
	  if (a==null) {
		  
		  testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Bug ID :"+BugID +" <a href='"+Bug_url1+"'>Click here to see the bug</a>");
		
	} else {
		
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Bug ID :"+a +" <a href='"+Bug_url+"'>Click here to see the bug</a>");

	}
		
		
	}
	
	public void onTestSkipped(ITestResult result) {

		//Customize extentreport for skipped testcase
		String methodName=result.getMethod().getMethodName();		
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().log(Status.SKIP, m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}

	}

}
