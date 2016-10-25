package com.centurylink.simong_app.weboperations;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opera.core.systems.internal.ImplicitWait;

public class Simon_Webop {
	
	//public WebDriver driver;
	static final long TIME_OUT = 60;
	
	public  WebDriver launch(WebDriver driver,String URL, String browser)

	{
		if (browser.contains("FIREFOX")) {
			
			
		
			driver = new FirefoxDriver();
			driver.get(URL);
			driver.manage().window().maximize();

		}

		if (browser.contains("CHROME")) {
			try{
			System.out.println("INSIDE CHROME");
			System.setProperty("webdriver.chrome.driver","src/test/resources/selenium/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-extensions");
			
			driver = new ChromeDriver(options);
			driver.get(URL);
			driver.manage().window().maximize();
			}
			catch(Exception e){System.out.println("Error :"+e);}
		}

		

		if (browser.contains("IE")) {
			System.setProperty("webdriver.ie.driver","");
			driver = new InternetExplorerDriver();
			driver.get(URL);
			driver.manage().window().maximize();
		}
		
		if (browser.contains("IE11")) {
				
				
				System.setProperty("webdriver.ie.driver", "");
				DesiredCapabilities cap = new DesiredCapabilities().internetExplorer();//.internetExplorer();
				//cap.setCapability("ignoreZoomSetting", true);
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				//cap.setJavascriptEnabled(true);
				cap.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
				cap.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
				/*	//cap.setCapability("ie.browserCommandLineSwitches", "-private");
				   //cap.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, URL);
				  // cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				   //cap.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
				 //  cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				//   cap.setJavascriptEnabled(true);
				 //  cap.setCapability("requireWindowFocus", true);
				 //  cap.setCapability("enablePersistentHover", false);
				   //cap.setCapability("nativeEvents", false);*/
				//cap.setCapability("ie.ensureCleanSession", true);
				   driver = new InternetExplorerDriver(cap); 				 
				driver.get(URL);
				 //driver.navigate().to(URL);
				driver.manage().window().maximize();
			}
		
		return driver;

	}
	
	
	public static void runtime_exe(String command)
	{
		try {
			Process p = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static WebElement getWebElement(WebDriver driver, String element,String findBy) {
		
		WebElement sendkeyelement = null ;
		
		if(findBy.equalsIgnoreCase("xpath"))
		sendkeyelement = driver.findElement(By.xpath(element));
		else
			if(findBy.equalsIgnoreCase("id"))
				sendkeyelement = driver.findElement(By.id(element));
			else
				if(findBy.equalsIgnoreCase("name"))
					sendkeyelement = driver.findElement(By.name(element));
				else
					if(findBy.equalsIgnoreCase("linkText"))
						sendkeyelement = driver.findElement(By.linkText(element));
					else
						if(findBy.equalsIgnoreCase("text")){ //*[contains(text(), 'My Button')]
							String tempXpath ="//*[contains(text(), '"+element+"')]"; 
							sendkeyelement = driver.findElement(By.xpath(tempXpath));
							
							
						}
		
		return sendkeyelement;
	}
	
	
	public static void takescreenshot(WebDriver driver,String module,int index,String screenshot_path,String purpose)
	{
		
		implicitwait(driver, 3);
		String val =String.valueOf(index);
	File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
try {
	
	String date = r_date();
	
	FileUtils.copyFile(srcfile, new File("SIMONG-APP_REPORT_"+date+"/SIMON_APP_SCREENSHOTS/"+purpose+"/"+module+"/S_"+val+"/"+screenshot_path+".jpg"));
	//FileUtils.copyFile(srcfile, new File("SIMON_APP_SCREENSHOTS/"+purpose+"/"+module+"/S_"+val+"/"+screenshot_path+".jpg"));
} catch (IOException e) {
	e.printStackTrace();	
}
implicitwait(driver, 3);

	}
	
	public static WebDriver sendkeys(WebDriver driver, String element,String Values ,String findBy){

		waitUntilElementPresent(driver, element, "xpath", 60);
		
		WebElement sendkeyelement = null ;
		
		sendkeyelement = getWebElement(driver, element, findBy);
		sendkeyelement.click();
		sendkeyelement.clear();
		sendkeyelement.sendKeys(Values);

		return driver;

	}
	
	public static String get_text(WebDriver driver,String element)
	{
		waitUntilElementPresent(driver, element, "xpath", 30);
		WebElement getmsg = getWebElement(driver, element, "xpath");
		return getmsg.getText();
	}
	
	public static int count_ele(WebDriver driver,String element)
	{
		return driver.findElements(By.xpath(element)).size();
	}
	
	public static void listwebelement(WebDriver driver,String element,String value,String radio_element)
	{
		List<WebElement> eles = driver.findElements(By.xpath(element));
		
		for(int i=0;i<eles.size();i++)
		{
			if(eles.get(i).getText().trim().equals(value))
			{
				String xx = radio_element+"["+i+"]";
				click(driver, xx, "xpath");
			}
		}
		
		
	}
	
	
	public static void asserttrue (WebDriver driver,Boolean condition)
	{
	try{	Assert.assertTrue(condition);}catch(Exception e){System.out.println("Assert True FAILED"+e);}
	}
	
	public static WebDriver click(WebDriver driver, String element ,String findBy){
		waitUntilElementPresent(driver, element, "xpath", 30);
		WebElement clickelement = null ;
		clickelement = getWebElement(driver, element, findBy);
		clickelement.click();

		return driver;
	}

	public boolean isVisible(WebDriver driver, WebElement element) {
		try {
			
			WebDriverWait dWait = new WebDriverWait(driver, TIME_OUT);
			dWait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	public boolean isSelected(WebDriver driver,WebElement element) {
		try {
			
			WebDriverWait dWait = new WebDriverWait(driver, TIME_OUT);
			element = dWait.until(ExpectedConditions.visibilityOf(element));
			return element.isSelected();
		} catch (Exception e) {
			return false;
		}
	}




	public void mouseMoveClick(WebDriver driver,WebElement ele) {
		try {
			WebDriverWait dWait = new WebDriverWait(driver, TIME_OUT);
			ele = dWait.until(ExpectedConditions.visibilityOf(ele));
			Actions action = new Actions(driver);
			action.moveToElement(ele).click().build().perform();
		} catch (Exception e) {
			fail("Failed mouseMoveClick() with Exception: " + e.getMessage());
		}
	}

	public void mouseHover(WebDriver driver,WebElement ele) {
		try {
			WebDriverWait dWait = new WebDriverWait(driver, TIME_OUT);
			ele = dWait.until(ExpectedConditions.visibilityOf(ele));
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			// action.moveToElement(ele).build().perform();
		} catch (Exception e) {
			fail("Failed mouseHover() with Exception: " + e.getMessage());
		}
	}

	
	
	public void mouseSelect(WebDriver driver,WebElement hoverElm, WebElement clickElm) {
		try {
			mouseHover(driver,hoverElm);
			WebDriverWait dWait = new WebDriverWait(driver, TIME_OUT);
			clickElm = dWait.until(ExpectedConditions.visibilityOf(clickElm));
			Actions action = new Actions(driver);
			action.moveToElement(clickElm).click(clickElm).build().perform();
		} catch (Exception e) {
			fail("Failed mouseSelect() with Exception: " + e.getMessage());
		}
	}
	public Boolean isEnabled(WebDriver driver,WebElement element) {
		
		WebDriverWait dWait = new WebDriverWait(driver, TIME_OUT);
		element = dWait.until(ExpectedConditions.visibilityOf(element));
		return element.isEnabled();
	}
	
	public static void implicitwait(WebDriver driver,int timeunit)
	{
		driver.manage().timeouts().implicitlyWait(timeunit, TimeUnit.SECONDS);
		
	}

	public Boolean isDisplayed(WebDriver driver ,String locator) {
		
	
		
		WebDriverWait dWait = new WebDriverWait(driver, TIME_OUT);
		WebElement element = getWebElement(driver, locator, "xpath");
		dWait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}

	public static WebDriver	moveToElement_js(WebDriver driver, WebElement element) {
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		return driver;

	}

	public static WebDriver action_noele(WebDriver driver, String actiontobedone)	{

		Actions action = new Actions(driver);


		if (actiontobedone.contains("MOUSECLICK")) {
			action.click().build().perform();
		}

		if (actiontobedone.contains("MOUSECLICKANDHOLD")) {
			action.clickAndHold().build().perform();
		}

		if (actiontobedone.contains("DOUBLECLICK")) {
			action.doubleClick().build().perform();
		}
		
		return driver;

	}
	
	public static WebDriver actionWithElement(WebDriver driver,WebElement wb, String actiontobedone)	{

		Actions action = new Actions(driver);

		if (actiontobedone.contains("MOUSEMOVETOELEMENT")) {

			action.moveToElement(wb).build().perform();
		}

		if (actiontobedone.contains("MOUSECLICK")) {
			action.click(wb).build().perform();
		}

		if (actiontobedone.contains("MOUSECLICKANDHOLD")) {
			action.clickAndHold(wb).build().perform();
		}

		if (actiontobedone.contains("DOUBLECLICK")) {
			action.doubleClick(wb).build().perform();
		}
		
		return driver;

	}

	public static WebDriver moveToThisElement_js(WebDriver driver,String elementValue, String type) {
		
		WebElement element = getWebElement(driver, elementValue, type);	
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		return driver;
	}
	
	public static void display_remove(WebDriver driver,String elements)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("return document.getElementById('someId');");
		WebElement element = driver.findElement(By.xpath(elements));
		js.executeScript("arguments[0].style.display='none'", element);
	}
	
	public static WebElement waitUntilElementPresent(WebDriver driver,String elementval,String findBy,int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		WebElement element = null ;
		
		
		if(findBy.equalsIgnoreCase("xpath"))
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementval)));
		else
			if(findBy.equalsIgnoreCase("id"))
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementval)));
			else
				if(findBy.equalsIgnoreCase("name"))
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementval)));
				else
					if(findBy.equalsIgnoreCase("linkText"))
						element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementval)));
					else
						if(findBy.equalsIgnoreCase("text")){ //*[contains(text(), 'My Button')]
							String tempXpath ="//*[contains(text(), '"+elementval+"')]"; 
							element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tempXpath)));
						}
		return element;
	}


	public static WebDriver selectValue(WebDriver driver,String element,String text) {
		
		List<WebElement> elements = driver.findElements(By.tagName("option"));
		Iterator<WebElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			WebElement webElement = (WebElement) iterator.next();
			String value = webElement.getText().trim();
			if(text.equalsIgnoreCase(value)){
				
				WebElement dropdown = Simon_Webop.getWebElement(driver, element, "xpath");
				Select select = new Select(dropdown);
				System.out.println("options available in dropdown : "+webElement.getText());
				select.selectByVisibleText(webElement.getText());
							}
		}
		
		
		return driver;
	}
	
	
	
	public static WebDriver List_select(WebDriver driver,String element,String text)
	{
		List<WebElement> elements = driver.findElements(By.xpath(element));
		Iterator<WebElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			int i=0;
			System.out.println("##### :"+i++);
			
			WebElement webElement = (WebElement) iterator.next();
			if(webElement.isDisplayed())
			{
				System.out.println("webVal :"+webElement.toString() );
				selectValue(driver,element,text);
			}
			
		}
		
		
		
		return driver;
	}
	
	
	public static void nested_web_sel(WebDriver driver,WebElement element,String findby,String text,String FOR)
	{
		
		
		if(FOR.toUpperCase().trim().contains("SELECT"))
		{
		List<WebElement> elements = driver.findElements(By.tagName("option"));
		Iterator<WebElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			WebElement webElement = (WebElement) iterator.next();
			String value = webElement.getText().trim();
			if(text.equalsIgnoreCase(value)){
				
				WebElement dropdown = element.findElement(By.xpath(findby));
				Select select = new Select(dropdown);
				System.out.println("options available in dropdown : "+webElement.getText());
				select.selectByVisibleText(webElement.getText());
							}
		}
		}
		
		if(FOR.toUpperCase().contains("ISDISPLAYED"))
		{
			
			//isdisplayed();
			
		}
		
		
	}
	
	
	
	public static WebElement removeReadonly(WebDriver driver,WebElement input) {
		
		((JavascriptExecutor) driver).executeScript( "arguments[0].removeAttribute('readonly','readonly')",input);
		return input;
	}
	
	public static WebElement removeOnFocus(WebDriver driver,WebElement input) {
		
		((JavascriptExecutor) driver).executeScript( "arguments[0].removeAttribute('onfocus','blur()')",input);
		return input;
	}

	public static void assertEquals(String assertValue, String text) {
		// 
		try{
		System.out.println("value1 : " + assertValue + " value2 : "+ text);
		Assert.assertEquals(true, assertValue.equals(text));
		}catch(Exception e){
			
		}
		
	}
	public static void assertNotEmpty(String assertValue) {
		// 
		Assert.assertNotNull(assertValue);
		Assert.assertEquals(true, !(assertValue.equals("")));
	}
	
	public static boolean isNotNull(String value) {
		
		if(value != null)
			if(!value.equals(""))
				return true;
		return false;
	}
	
	public static WebDriver scrollToEndOfThePage(WebDriver driver) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		
		return driver;
	}
	
	public static void loaded(WebDriver driver,String text)
	{
		try{driver.getPageSource().equals(text);}catch(Exception e){System.out.println("App Loaded Verification failed : "+e);}
	}
	
	public static void assert_pagetitle(WebDriver driver,String text)
	{
		try{Assert.assertEquals(text, driver.getTitle());}catch(Exception e){System.out.println("Page Title Verification failed : "+e);}
	}
	
	public static String r_date()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		String reportDate = dateFormat.format(date);
		String[] s_reportdate = reportDate.split("-");
		String f_reportdate = s_reportdate[0]+s_reportdate[1]+s_reportdate[2];
		System.out.println(f_reportdate);
		return f_reportdate;
	}
	
}
