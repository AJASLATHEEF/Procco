package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Link_issue_jira {

	WebDriver driver;

	public Link_issue_jira (WebDriver driver) {	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindAll({@FindBy(xpath = "//span[text()='Link issue']")})
	WebElement Link_issue_button;	
	public WebElement Link_issue_button() {
		return Link_issue_button;	
	}


	@FindAll({@FindBy(xpath = "//div[text()='is blocked by']") , @FindBy(xpath = "/html[1]/body[1]/div[5]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
	   })
	WebElement Link_issue_dropDown;	
	public WebElement Link_issue_dropDown() {
		return Link_issue_dropDown;	
	}
	
	
	@FindAll({@FindBy(xpath = "//h2[text()='Linked issues']")})
	WebElement Linked_Issues_Text;	
	public WebElement Linked_Issues_Text() {
		return Linked_Issues_Text;	
	}
	
	

	@FindAll({@FindBy(xpath = "//div[@data-testid='issue-line-card.card-container']//div[6]//button")})
	WebElement Current_Bug_Status;	
	public WebElement Current_Bug_Status() {
		return Current_Bug_Status;	
	}
	
	@FindAll({@FindBy(xpath = "//span[text()='Re-Open']")})
	WebElement Reopen_Option;	
	public WebElement Reopen_Option() {
		return Reopen_Option;	
	}
	
	
	@FindAll({@FindBy(xpath = "(//div[@id='jira-issue-header']//div)[8]//div[2]")})
	WebElement Duplicate_BugID;	
	public WebElement Duplicate_BugID() {
		return Duplicate_BugID;	
	}
	
	
	

	@FindAll({@FindBy(xpath = "//div[text()='Search for issues']")})
	WebElement relates_To_option;	
	public WebElement relates_To_option() {
		return relates_To_option;	
	}

	@FindAll({@FindBy(xpath = "//div[@class='issue-links-search__control css-atn8fj-control']")})
	WebElement Searchforissues;	
	public WebElement Searchforissues() {
		return Searchforissues;	
	}

	
	@FindAll({@FindBy(xpath ="//div[@class='issue-links-search__input']")})
	WebElement Searchforissues_After;	
	public WebElement Searchforissues_After() {
		return Searchforissues_After;	
	}
	
	
	@FindAll({@FindBy(xpath ="//div[@id='react-select-3-option-0-0']/span")})
	WebElement Story_result;	
	public WebElement Story_result() {
		return Story_result;	
	}
	
	
	@FindAll({@FindBy(xpath ="//span[text()='Link']")})
	WebElement Link_Button;	
	public WebElement Link_Button() {
		return Link_Button;	
	}
	
	

	

}
