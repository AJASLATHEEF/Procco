package org.capture;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.common.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ExtentManager extends BaseClass{

	public static ExtentReports extent;
	public static String  screenshotPath;
	public static String  fileName;
	public  static String image_path;

	public String imagePath1;

	public static ExtentReports createInstance(String fileName) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

		//Configure html report
		htmlReporter.config().setDocumentTitle("Proco Test Report");
		htmlReporter.config().setReportName("Automation Test Result");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Ajas Latheef");
		extent.setSystemInfo("Organization", "Xilligence");
		extent.setSystemInfo("Build no", "DEMO");

		return extent;

	}

	//Capture screenshot for extent report
	public static void captureScreenshot( ) throws Exception {


		Date d = new Date();
		String random = RandomStringUtils.randomAlphabetic(1);
		String fileName = d.toString().replace(":", "_").replace(" ", "_");
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./reports/screenshot/"+fileName+random+".jpg"));
		image_path ="../reports/screenshot/"+fileName+random+".jpg";
		System.out.println("Screenshot path is "+image_path);

	}  

	//Capture screenshot for JIRA
	public void screenshot() throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_");
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File( projectPath +"/screenshot/"+fileName+".jpg"));
		imagePath1 = projectPath +"/screenshot/"+fileName+".jpg";
		System.out.println("IMAGE PATH IS "+imagePath1);
	}




}
