package org.jira;

public class Jira_description {

	public String bug;
	
	public void jiradescription(String console_data) {	

		if (console_data.contains("assert")||console_data.contains("not matching")|| console_data.contains("verification failed")) {		
			bug = " is failed in verification process" ;			
		}

		else if(console_data.contains("null pointer")|| console_data.contains("stale element")) {

			bug = " is failed due to unable to locate the element" ;

		}

		else if(console_data.contains("exception")) {

			bug = " is failed due to exception" ;

		}

		else {
			bug = "Failed due to unexpected error";
		}

	}

}
