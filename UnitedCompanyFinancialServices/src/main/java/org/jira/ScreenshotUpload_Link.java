package org.jira;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.common.BaseClass;
import org.dcryptutils.DcryptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.JiraUpload;
import org.pages.Link_issue_jira;


public class ScreenshotUpload_Link extends BaseClass{

	WebDriver driver;

	public ScreenshotUpload_Link(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void image(String issueNum , String screenshotpath , String Story) throws InterruptedException, AWTException {
		

		try {
			
			DcryptUtils dc = new DcryptUtils();
			
			dc.Dcrypt_username();
			dc.Dcrypt_password();
			
			System.out.println("https://xillidev.atlassian.net/browse/"+issueNum);
					
			JiraUpload obj = new JiraUpload(driver);
			System.out.println();
			
			Thread.sleep(2000);
			
			driver.get(prop.getProperty("Bug_URL")+issueNum);		
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(2000);
//
//			obj.Username_TextField().sendKeys(dc.username);
//			obj.Continue_button().click();
//			Thread.sleep(5000);
//
//			obj.Password_TextField().sendKeys(dc.password);
//			obj.Login_button().click();
//			Thread.sleep(7000);

			WebDriverWait wait = new WebDriverWait(driver, 20);

			Thread.sleep(20000);

			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			obj.Secreenshot_Attach().sendKeys(screenshotpath);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			
			System.out.println("Screenshot attachment is pass");
				
			try {

				Link_issue_jira obj1 = new Link_issue_jira(driver);


				wait.until(ExpectedConditions.elementToBeClickable(obj1.Link_issue_button()));
				obj1.Link_issue_button().click();	
				obj1.Link_issue_button().click();	
				
				js.executeScript("window.scrollBy(0,250)", "");	
				js.executeScript("arguments[0].scrollIntoView(true);", obj1.Link_issue_dropDown());
				
				Actions a = new Actions(driver);
				a.click(obj1.Link_issue_dropDown());
				
				wait.until(ExpectedConditions.elementToBeClickable(obj1.Link_issue_dropDown()));
				obj1.Link_issue_dropDown().click();

				wait.until(ExpectedConditions.elementToBeClickable(obj1.relates_To_option()));
				obj1.relates_To_option().click();
		
				Thread.sleep(3000);

				WebElement activeElement1 = driver.switchTo().activeElement();
				activeElement1.sendKeys(Story);
				
				Thread.sleep(3000);
				
				wait.until(ExpectedConditions.elementToBeClickable(obj1.Link_Button()));
				obj1.Link_Button().click();
				
				System.out.println("**********Link Issue is pass*******************");
				
			} catch (Exception e) {
				e.printStackTrace();

				System.out.println("**********Link Issue is fail*******************");
				System.out.println("**********Link Issue is fail*******************");

			}
			
			driver.quit();
			
		} catch (Exception e) {

			e.printStackTrace();

			System.out.println("**********Screenshot Uploading is failed*******************");
			System.out.println("**********Screenshot Uploading is failed*******************");

		}
	}
}
