package org.basicfunction;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_Functions  {


	public static String projectPath = System.getProperty("user.dir");
	public static WebDriver driver;   //instance
	public static Properties prop;
	public static WebDriverWait wait;
	public static WebDriverWait wait1;
	public static ExtentReports extent;
	public static  ExtentTest extentTest;;
	


	
// Chrome browser up
	public static void Chrome_Setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}


	//Alert Functions
	public static void alertAccept()
	{
		driver.switchTo().alert().accept();
	}

	
	
	// Alert Dismiss
	public static void alertDismiss()
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	//Alert get text
	public static void Get_Alert_Text()
	{
		Alert alert=driver.switchTo().alert();
		String Get_Alert_Text=alert.getText();
		System.out.println(Get_Alert_Text);			
	}

	// wait for alert
	public static void Wait_Alert_Present()
	{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	//Verify Alert
	public static void Verify_Alert_Message(String Alert_Text)
	{
		String Text1= prop.getProperty(Alert_Text);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String Get_Alert_Text=alert.getText();
		if (Get_Alert_Text.contains(Text1))
		{
			Assert.assertEquals(Get_Alert_Text, Text1);
			System.out.println("Verified Alert Message");

		} else {
			Assert.fail();
		}	
	}
	
	//Get Attribute value
	public static String Get_Attribute(WebElement Element,String Attribute_Value)
	{
		String Text1= prop.getProperty(Attribute_Value);
		String Attribute=Element.getAttribute(Text1);
		return Attribute;

	}
	
	//Clear Text field
	public static void Clear_Text(WebElement Element)
	{
		Element.clear();
	}

	//Passing values to Text field
	public static void SendKeys(WebElement Element,String SendKeys)
	{
		Element.sendKeys(SendKeys);
	}

	//Sleep
	public static void Thread_Sleep(long Seconds) throws InterruptedException
	{
		Thread.sleep(Seconds);

	}
	
	
	public static void navigateTo(String Url)
	{
		String Text1= prop.getProperty(Url);
		driver.navigate().to(Text1);
	}
	
	public void navigateBack() {
		
		driver.navigate().back();

	}
	
	//Get Current URL
	public static void CurrentURL()
	{
		String CurrentURl=driver.getCurrentUrl();
		System.out.println("Current URL is "+CurrentURl);
	}
	
	
	public static void getURL(String Url)
	{
		String Text1= prop.getProperty(Url);
		driver.get(Text1);
	}
	
	//Delete Cookies
	public static void deleteAllCookies()
	{
		driver.manage().deleteAllCookies();
	}

	//Page load timeout
	public static void PAGE_LOAD_TIMEOUT(int time)
	{
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	
	//implicit wait
	public static void IMPLICIT_WAIT()
	{
		driver.manage().timeouts().implicitlyWait(10 ,TimeUnit.SECONDS);
	}
	
	//Get Title
	public static String getTitle()
	{
		String getTitle=driver.getTitle();
		System.out.println("Current URL is "+getTitle);
		return getTitle;
	}
	
	//Driver close
	public void driverclose() { 
		driver.close();
		driver.quit();
	}

	//Get page source
	public static String getPageSource()
	{
		String getPageSource=driver.getPageSource();
		System.out.println("Current URL is "+getPageSource);
		return getPageSource;
	}

	//Double click
	public static void Double_Click(WebElement Element)
	{	
		Actions act = new Actions(driver);   		
		act.doubleClick(Element).perform();
	}
	
	//move to element
	public static void Move_TO_Element(WebElement Element)
	{	
		Actions act = new Actions(driver);   		
		act.moveToElement(Element);
	}

	//Drag and drop
	public static void Drag_And_Drop(WebElement sourceElement,WebElement targetElement)
	{

		Actions act = new Actions(driver);   		
		act.dragAndDrop(sourceElement, targetElement).perform();
	}

	//Select by index for drop down
	public static void SelectByIndex(WebElement Element,int index)
	{
		Select select=new Select(Element);
		select.selectByIndex(index);
	}
	
	//Select by value for dropdown
	public static void SelectByValue(WebElement Element,int value)
	{

		Select select=new Select(Element);
		select.selectByIndex(value);
	}
	
	//Select by visible text
	public static void SelectByVisibleText(WebElement Element,String Text)
	{
		String Text1= prop.getProperty(Text);
		Select select=new Select(Element);
		select.selectByVisibleText(Text1);
	}

	//Element is displayed
	public static void isDisplayed(WebElement Element)
	{
		Element.isDisplayed();
	}
	
	//element is enabled
	public static void isEnabled(WebElement Element)
	{
		Element.isEnabled();
	}
	
	//Element is selected
	public static void isSelected(WebElement Element)
	{
		Element.isSelected();

	}
	
	//Get size of a string
	public static void getSize(WebElement Element)
	{
		Element.getSize();

	}
	
	//Get the size of a web element
	public static int Size(List<WebElement> Element)
	{
		return Element.size();

	}

	//Wait until the element to be clicked
	public static void Wait(WebElement Element)
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}

	//Wait until expected condition
	public static void Wait(ExpectedCondition<WebElement> ExpectedConditions) {
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions);
	}
	
	// Click the element using JavaScript
	public static void jClick(WebElement Element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Element);
	}
	
	//Pass the value to the text box using java script executor
	public static void jSendKeys(WebElement Element,String Text)
	{
		String Text1= prop.getProperty(Text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].seAttribute(value','+" +Text1 + "+')", Element);

	}
	
	//Get Text
	public static String  GetText(WebElement Element , String TextName)
	{
		return TextName =  Element.getText();
		
		
	}

	//Scrolling using java script executor
	public static void Scroll_down()
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;//scroll
		j.executeScript("window.scrollBy(0,350)","");	
	}

	public static void Scroll_up()
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;//scroll
		j.executeScript("window.scrollBy(0,-300)");
	}

	// Scroll up to the element using JavaScript
	public static void JScrollDownToWebElement(WebElement Element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Element);

	}
	
	// Scroll down to the element using JavaScript
	public static void JScrollUpToWebElement(WebElement Element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", Element);

	}

	//Get property file
	public static void GetPropertyFile() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "/Configuration/config.properties");
		prop.load(fis);	
	}
	
	//Verification of text contains and click
	public static void VerifyTextContains_And_CLick(List<WebElement> Element,String Text) 
	{
		String Text1= prop.getProperty(Text);
		for(int i=1;i<=Element.size();i++)
		{
			String GetText=Element.get(i).getText();

			if(GetText.contains(Text1)) {
				Assert.assertTrue(true, Text1);
				Element.get(i).click();
				System.out.println("Verified VerifyTextContains");
				break ;
			}	
		}	
	}
	
	//Verify text contains
	public static void VerifyTextContains(List<WebElement> Element,String Text)
	{
		String Text1= prop.getProperty(Text);

		for(int i=1;i<=Element.size();i++)
		{

			String GetText=Element.get(i).getText();
			if(GetText.contains(Text1)) {
				Assert.assertTrue(true, Text1);
				System.out.println("Verified VerifyTextContains");
				break ;
			}	
		}	
	}
	
	//Verify text equals
	public static void VerifyTextEquals(List<WebElement> Element,String Text)
	{

		String Text1= prop.getProperty(Text);
		for(int i=1;i<=Element.size();i++)
		{

			String GetText=Element.get(i).getText();
			if(GetText.equals(Text1)) {
				System.out.println("Verified VerifyTextEquals");
				Assert.assertEquals(GetText, Text1);
				System.out.println("Verified VerifyTextEquals");
				break ;
			} else {
				Assert.fail();
			}	
		}	
	}
	
	public static void If_VerifyTextContains(WebElement Element,String Text)
	{

		String Text1= prop.getProperty(Text);

		String GetText=Element.getText();
		if(GetText.contains(Text1)) {

			Assert.assertTrue(true, Text1);
			System.out.println("Verified Text Contains");

		} else {
			Assert.fail();

		}	
	}
	
	public static void If_VerifyTextContains(String Text1,String Text2)
	{
		if(Text1.contains(Text2)) {

			Assert.assertEquals(Text1, Text2);
			System.out.println("Verified Text Contains");

		} else {
			Assert.fail();	
		}	
	}
	
	
	public static void If_VerifyTextEquals(String Text1,String Text2)
	{
		if(Text1.equals(Text2)) {

			Assert.assertEquals(Text1, Text2);
			System.out.println("Verified Text Contains");

		} else {
			Assert.fail();	
		}	
	}
	
	public static void If_VerifyTextContain(String Text1,String Input_Text)
	{
		String Text2= prop.getProperty(Input_Text);
		if(Text1.contains(Text2)) {

			Assert.assertEquals(Text1, Text2);
			System.out.println("Verified Text Contains");

		} else {
			Assert.fail();	
		}	
	}
	
	public static void If_VerifyTextEqual(String Text1,String Input_Text)
	{
		String Text2= prop.getProperty(Input_Text);
		if(Text1.equals(Text2)) {

			Assert.assertEquals(Text1, Text2);
			System.out.println("Verified Text Contains");

		} else {
			Assert.fail();	
		}	
	}

	//Load the URL
	public static void URL_load(String URL) {

		driver.get(URL);
	}

	//Maximize the window
	public static void Window_maximize() {

		driver.manage().window().maximize();
	}

	public static void GetText1(WebElement Element) {

		Element.getText();
	}

	//Keyboard actions -Tab and Enter
	public static void Tab_Enter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	//Keyboard actions - tab
	public static void Tab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	//Keyboard actions - Enter
	public static void Enter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	//Click
	public void Click(WebElement Element) {
		Element.click();
	}

	//Wait until click
	public void Clickable_Wait_Click(WebElement Element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		Element.click();
	}

	//Wait until enter text
	public void Visibility_Wait_EnterText(WebElement Element , String Text) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Element));
		Element.sendKeys(Text);
	}
	
	
	public void Visibility_Wait_EnterText1(WebElement Element , String Text) {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(Element));
		Element.sendKeys(Text);
	}

    //Wait until visibility of element
	public void Visibility_Wait(WebElement Element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}

	//Sleep
	public void Sleep(int time) throws InterruptedException {

		Thread.sleep(time);
	}

	
	

	








}
