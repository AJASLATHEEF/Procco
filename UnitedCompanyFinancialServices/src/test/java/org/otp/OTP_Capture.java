package org.otp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OTP_Capture {

	public static WebDriver driver;
	public static WebDriverWait wait;
	static String centerId = "CP-PURPLe";
	public static String OTPs;
	static AppiumDriver<MobileElement> driver1;


	@Test
	public void OTP_capture() throws MalformedURLException, InterruptedException {

		WebDriverManager.chromedriver().setup(); 	             
		driver=new ChromeDriver();  
		driver.get("https://www.mishrasclinic.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Login']")));
		driver.findElement(By.xpath("//span[text()='Login']")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='forgotPswd']")));
			driver.findElement(By.xpath("//a[@id='forgotPswd']")).click();

			driver.findElement(By.xpath("//input[@id='emailMobno']")).sendKeys("7012902798");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='resetPasswordBut']")));
			driver.findElement(By.xpath("//input[@id='resetPasswordBut']")).click();
			
			Thread.sleep(4000);

			mobile_connectivity();
			Get_OTP();

			Thread.sleep(2000);

			System.out.println("OTP IS "+OTPs);		
			
			Thread.sleep(3000);
		   
			WebElement OTP = driver.findElement(By.xpath("//input[@id='otpTxt']"));
			
			wait.until(ExpectedConditions.visibilityOf(OTP));
			OTP.sendKeys(OTPs);
			
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='resetPasswordButOTP']"))));
			driver.findElement(By.xpath("//input[@id='resetPasswordButOTP']")).click();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='forgotpasswordNew']"))));
			driver.findElement(By.xpath("//input[@id='forgotpasswordNew']")).sendKeys("password");
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='forgotpasswordConfirm']"))));
			driver.findElement(By.xpath("//input[@id='forgotpasswordConfirm']")).sendKeys("password");
			
			
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='resetPasswordButFinal']"))));
			driver.findElement(By.xpath("//input[@id='resetPasswordButFinal']")).click();
			
	}



public static void mobile_connectivity() throws MalformedURLException {

	DesiredCapabilities cap = new DesiredCapabilities();

	cap.setCapability("deviceName", "SM-A260G");
	cap.setCapability("udid", "520060b142da3675");
	cap.setCapability("platformName", "Android");
	cap.setCapability("platformVersion", "8.1.0");
	cap.setCapability("appPackage", "com.google.android.apps.messaging");
	cap.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");

	URL url = new URL("http://127.0.0.1:4723/wd/hub");
	driver1 = new AppiumDriver<MobileElement>(url,cap);
	System.out.println("Appication started");

}


public static void Get_OTP() throws InterruptedException {

	wait = new WebDriverWait(driver1, 10);
	Thread.sleep(20000);

	List<MobileElement> Center_ID = driver1.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@content-desc=\"Conversation list\"]/android.view.ViewGroup"));

	int Center_ID_Count  = Center_ID.size();

	System.out.println("Message count :"+Center_ID_Count);

	for (int i = 1; i < Center_ID_Count; i++) {

		MobileElement CenterID = driver1.findElement(By.xpath("(//android.support.v7.widget.RecyclerView[@content-desc=\"Conversation list\"]/android.view.ViewGroup)"+"["+i+"]"+"/android.widget.RelativeLayout/android.widget.TextView[1]"));

		String CenterIDs = CenterID.getText();
		System.out.println("Each centern id is "+ CenterIDs);

		if (CenterIDs.equalsIgnoreCase(centerId)) {

			CenterID.click();

			MobileElement Message = driver1.findElement(By.id("com.google.android.apps.messaging:id/message_text"));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(Message));
			String OTP = Message.getText();
			String[] otp1 = OTP.split(" ");
			int size = otp1.length;

			//				System.out.println("OTP IS "+OTP);
			//				System.out.println("OTP IS Size "+size);
			OTPs = otp1[2];
			System.out.println("String is "+ OTPs);
			break;
		}
		
		driver1.quit();
		

	}





}

}
