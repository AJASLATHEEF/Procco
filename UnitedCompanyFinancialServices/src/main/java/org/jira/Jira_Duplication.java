package org.jira;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.common.BaseClass;
import org.dcryptutils.DcryptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.JiraUpload;
import org.pages.Link_issue_jira;

public class Jira_Duplication extends BaseClass {
	
	public  String Bug_ID;
	
	public void Duplication_bug(String Search_data) throws InterruptedException {
		
		
		try {
			
			System.out.println("Search data "+Search_data);
			
			DcryptUtils dc = new DcryptUtils();
			
			dc.Dcrypt_username();
			dc.Dcrypt_password();
					
			JiraUpload obj = new JiraUpload(driver);
			Link_issue_jira obj1 = new Link_issue_jira(driver);
			
			System.out.println();
			
			Thread.sleep(2000);
			
			driver.get(prop.getProperty("jira_URL"));
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			Thread.sleep(4000);
			
			obj.Username_TextField().sendKeys(dc.username);
			obj.Continue_button().click();
			Thread.sleep(5000);

			obj.Password_TextField().sendKeys(dc.password);
			obj.Login_button().click();
			Thread.sleep(7000);
			
			wait.until(ExpectedConditions.visibilityOf(obj.Search_Bar()));
			obj.Search_Bar().sendKeys(Search_data);
			
			Thread.sleep(5000);
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOf(obj.Jira_Issue_Summary()));
			String Issue_Summary1 = obj.Jira_Issue_Summary().getText();
			System.out.println("Jira issue summary is from duplication "+Issue_Summary1);
			
//			WebElement searchresult = driver.findElement(By.xpath("//span[contains(text(),'"+Search_data+"')]"));
//			
//			wait.until(ExpectedConditions.visibilityOf(searchresult));
//			String Bug_deatails = searchresult.getText();
//			System.out.println("Bug details name is :"+ Bug_deatails);
//			
//			
			Thread.sleep(4000);
			
			String Issue_Summary = " "+Issue_Summary1+" "; 
			
			if (Issue_Summary.contains(Search_data)) {
				
				wait.until(ExpectedConditions.visibilityOf(obj1.Duplicate_BugID()));
				 Bug_ID = obj1.Duplicate_BugID().getText();
				System.out.println("Search duplicate bug id is "+Bug_ID);
				
				Thread.sleep(4000);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)", " ");
				js.executeScript("arguments[0].scrollIntoView(true);", obj1.Linked_Issues_Text());
				
				String Bug_Status = obj1.Current_Bug_Status().getAttribute("aria-label");
				
				if (Bug_Status.contains("READY FOR TESTING")||Bug_Status.contains("Done")||Bug_Status.contains("BUG FIXING COMPLETED")) {
					
					wait.until(ExpectedConditions.elementToBeClickable(obj1.Current_Bug_Status()));
					obj1.Current_Bug_Status().click();
					
					wait.until(ExpectedConditions.elementToBeClickable(obj1.Reopen_Option()));
					obj1.Reopen_Option().click();
					
					System.out.println("Status is update");
					driver.close();
					
				} else {
					
					System.out.println("Bug is in TODO state no need to update");
					

				}
				
			}
			else {
				System.out.println("IF condition is not matching");
			}
			
			
		} catch (Exception e) {
			System.out.println("Duplication checking is failed");
		}
		
	}
	
}
