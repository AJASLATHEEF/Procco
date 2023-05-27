package org.jira;

import java.io.IOException;

import org.capture.ExtentManager;
import org.common.BaseClass;
import org.listener.TestListener;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;

public class JiraServiceProvider extends BaseClass {

	public JiraClient jira;
	public String project;
	public String issueNum;

	ExtentManager em = new ExtentManager();

	//Declaration of JIRA credentials as arguments
	public JiraServiceProvider(String jiraurl, String username, String password, String project) {
		BasicCredentials creds = new BasicCredentials(username, password);
		jira = new JiraClient(jiraurl, creds);
		this.project = project;
	}

	//Declaration of input data for bug raising
	public void createJiraTicket1(String issueType, String summary, String issueDesc , String Story_id , String ImagePath ) throws Exception {

		FluentCreate fluentCreate = jira.createIssue(project, issueType);
		fluentCreate.field(Field.SUMMARY, summary);
		fluentCreate.field(Field.DESCRIPTION, issueDesc);

		
		
		//Creating new bug
		Issue issuenew = fluentCreate.execute();
		System.err.println("New ticket raised in Jira with id : "+issuenew);


		//Convert bug Id to String
		issueNum = issuenew.toString();
		

		//Screenshot attachment
		ScreenshotUpload_Link sc= new ScreenshotUpload_Link(driver);
		sc.image(issueNum, ImagePath , Story_id );
	}
}


