package org.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JiraUpload {
	
	WebDriver driver;
	
	public JiraUpload (WebDriver driver) {	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(xpath="//input[@id='username']")
	WebElement Username_TextField;	
	public WebElement Username_TextField() {
		return Username_TextField;	
	}
	
	@FindBy(xpath="//span[text()='Continue']")
	WebElement Continue_button;	
	public WebElement Continue_button() {
		return Continue_button;	
	}
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password_TextField;	
	public WebElement Password_TextField() {
		return Password_TextField;	
	}
	
	@FindBy(xpath="//span[text()='Log in']")
	WebElement Login_button;	
	public WebElement Login_button() {
		return Login_button;	
	}
	
	@FindBy(xpath="//input[@data-test-id='search-dialog-input']")
	WebElement Search_Bar;	
	public WebElement Search_Bar() {
		return Search_Bar;	
	}
	
	@FindBy(xpath="//h1[@data-test-id='issue.views.issue-base.foundation.summary.heading']")
	WebElement Jira_Issue_Summary;	
	public WebElement Jira_Issue_Summary() {
		return Jira_Issue_Summary;	
	}
	
	
	
	@FindBy(xpath="//div[@class='ak-renderer-document']//p[text()='Screenshot of failure :']")
	WebElement Identify_BugText;	
	public WebElement Identify_BugText() {
		return Identify_BugText;	
	}
	
	@FindBy(xpath="//div[@class='ak-renderer-document']/p")
	List<WebElement> Bug_TextSize;	
	public List<WebElement> Bug_TextSize() {
		return Bug_TextSize;	
	}
	
	@FindBy(xpath="//input[@type='file']")
	WebElement Secreenshot_Attach;	
	public WebElement Secreenshot_Attach() {
		return Secreenshot_Attach;	
	}
	
	
	
	@FindBy(xpath="//div[@id='ak-main-content']/div/div/div[2]/div[2]/div[2]/div/div/div/div/"
			+ "div[5]/div[4]/div[2]/div/ul/div/div/div[6]/div/div/div/button/span/span/div/span/span/div")
	WebElement Current_status;	
	public WebElement Current_status() {
		return Current_status;	
	}
	
	
	@FindBy(xpath="//span[text()='Reopened']")
	WebElement Reopened_option;	
	public WebElement Reopened_option() {
		return Reopened_option;	
	}
	
	
}
