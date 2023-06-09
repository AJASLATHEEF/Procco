package org.rerunautomation;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int retrycount = 0;
	private static final int maxcount =1;
	
	
	public boolean retry(ITestResult result) {
		
		if (retrycount<maxcount) {
			
			retrycount++;
			return true;
		}	
		
		return false;
	}

}
