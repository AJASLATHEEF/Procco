package org.common;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.basicfunction.Basic_Functions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends Basic_Functions   {

	@BeforeSuite
	public void initDriver() throws IOException {
		//Declaration of property file
		prop = new Properties();  
		FileInputStream fis= new FileInputStream(projectPath+"\\src\\test\\resources\\Configuration.confiq.properties");
		prop.load(fis);
	}

	@BeforeMethod
	public void urlUp() {
		
		//Chrome setup
		Chrome_Setup();

		//Load URL in browser
		URL_load(prop.getProperty("front_office"));

		//Maximize the browser window
		Window_maximize();	
		IMPLICIT_WAIT();
	}

	@AfterMethod
	public void close() {
		
		//Browser window close and quit
		driverclose();

	}
}







