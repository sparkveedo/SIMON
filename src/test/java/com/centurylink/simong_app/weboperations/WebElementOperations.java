package com.centurylink.simong_app.weboperations;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;

import javax.imageio.ImageIO;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebElementOperations {

	public static Stack<String> windows = new Stack<>();
	public static int ie =0;
	
	public static WebDriver launch(WebDriver driver,String URL, String browser)

	{
		ie =0;
		if (browser.contains("FIREFOX")) {
			
			
			File pathToBinary = new File("C:\\Users\\ajay.ilango.INTELLECTDESIGN\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
	    	FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
	    	FirefoxProfile firefoxProfile = new FirefoxProfile();
	    	
			driver = new FirefoxDriver(ffBinary,firefoxProfile);
			
			//driver = new FirefoxDriver();
			driver.get(URL);
			driver.manage().window().maximize();

		}

		if (browser.contains("CHROME")) {
			System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
		}

		if (browser.contains("IE11")) {
			
			ie =1;
			System.setProperty("webdriver.ie.driver", "D://workbench_NBAD//workspace2//Selenium//IEDriver//IEDriverServer.exe");
			
			DesiredCapabilities cap = new DesiredCapabilities().internetExplorer();//.internetExplorer();
			//cap.setCapability("ignoreZoomSetting", true);
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//cap.setJavascriptEnabled(true);
			//cap.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			cap.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			//cap.setCapability("ie.browserCommandLineSwitches", "-private");
			   //cap.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, URL);
			  // cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			   //cap.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
			 //  cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//   cap.setJavascriptEnabled(true);
			 //  cap.setCapability("requireWindowFocus", true);
			 //  cap.setCapability("enablePersistentHover", false);
			  //cap.setCapability("ie.ensureCleanSession", true);
			   //cap.setCapability("nativeEvents", false);
			   driver = new InternetExplorerDriver(cap); 
			//driver=new InternetExplorerDriver();
			/*driver = new InternetExplorerDriver();*/

			
			//driver=new InternetExplorerDriver();
			 
			driver.get(URL);
			 //driver.navigate().to(URL);
			driver.manage().window().maximize();
		}
		
			if (browser.contains("IE")) {
				
				ie =1;
				System.setProperty("webdriver.ie.driver", "D://workbench_NBAD//workspace2//Selenium//IEDriver//IEDriverServer.exe");
				
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
				//driver=new InternetExplorerDriver();
				/*driver = new InternetExplorerDriver();*/

				
				//driver=new InternetExplorerDriver();
				 
				driver.get(URL);
				 //driver.navigate().to(URL);
				driver.manage().window().maximize();
			}
		return driver;

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
	
	public static WebDriver sendkeys(WebDriver driver, String element,
			String Values ,String findBy){

		WebElement sendkeyelement = null ;
		
		sendkeyelement = getWebElement(driver, element, findBy);
		sendkeyelement.clear();
		sendkeyelement.sendKeys(Values);

		return driver;

	}
	
	public static void takescreenshot(WebDriver driver,String module,String index,String screenshot_path)
	{
	File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
try {
	FileUtils.copyFile(srcfile, new File("/SIMON_APP_SCREENSHOTS/"+module+"/"+index+"/"+screenshot_path));
} catch (IOException e) {
	e.printStackTrace();	
}

	}
	
	
	public static WebDriver waitUntilNumberOfWindows(WebDriver driver,int noOfWindows,int waitInSecs) {
		
		WebDriverWait driverWait  = new  WebDriverWait(driver, waitInSecs);
		driverWait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindows-ie));
		return driver;
	}
	
	public static WebDriver click(WebDriver driver, String element ,String findBy){

		WebElement clickelement = null ;
		clickelement = getWebElement(driver, element, findBy);
		clickelement.click();

		return driver;
	}
	

	public static WebDriver switchToLatestWindow(WebDriver driver){
		
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		if (winList.size() > 0) {
			String newTab = winList.get(winList.size() - 1);
			// System.out.println("winList: "+winList.size());
			driver.switchTo().window(newTab);
		}
		return driver;
		
		
		/*
		
		threadSleep(2000);
		boolean isException = false;
		String currentWindow = "" ;
		try{
			System.out.println("Before Switching :"+driver.getWindowHandle());
			currentWindow = driver.getWindowHandle();
			}catch(Exception exception){
				isException = true;
				System.out.println("!!!!!!!! current window");
			}
		if (isException ) {
			Set<String> winSet = driver.getWindowHandles();
			List<String> winList = new ArrayList<String>(winSet);
			String newTab = winList.get(winList.size() - 1);
			System.out.println("winList: " + winList.size());
			driver = driver.switchTo().window(newTab);
			currentWindow = driver.getWindowHandle();
			windows = new Stack<>();
			windows.push(currentWindow);
		}else{
			Set<String> handles = driver.getWindowHandles();
			currentWindow = driver.getWindowHandle();
			if(windows.size()<handles.size()){
				//new  window
				String newWindow = getUnmatchedElementFromHandle(windows, handles);
				//for FO that opens two window at a time
				if(newWindow.equals("")){
					
					Set<String> winSet = driver.getWindowHandles();
					List<String> winList = new ArrayList<String>(winSet);
					String newTab = winList.get(winList.size() - 1);
					System.out.println("winList: " + winList.size());
					windows.push(newTab);
					driver = driver.switchTo().window(newTab);
					return driver;
				}
				windows.push(newWindow);
				driver = driver.switchTo().window(newWindow);
				
			}else if(windows.size()>handles.size() && driver.getWindowHandle().equals(windows.peek())){
				//closed the current window
				String immediateParent;
				System.out.println(windows.pop()+"---closed");
				immediateParent = windows.peek();
				driver = driver.switchTo().window(immediateParent);
			}else if(windows.size()==handles.size()){
				//closes a window and opens a window
				String newWindow = getUnmatchedElementFromHandle(windows, handles);
				if(!newWindow.equals("") && !newWindow.equals(currentWindow)){
					System.out.println(windows.pop()+"---closed");
					windows.push(newWindow);
					driver = driver.switchTo().window(newWindow);
				}
					
			}
			for (String windowHandle : handles) {
				// Thread.sleep(10000);
				if (!(windowHandle.equals(currentWindow))) {
					
					driver.switchTo().window(windowHandle);
					System.out.println("Switched to " + driver.getTitle());

				}
			}
			
			
		}
		
		
		System.out.println("-------------------------------------------");
        System.out.println("After Switching :"+driver.getWindowHandle());
        System.out.println(driver.getTitle());
        int count = 0;
        for(String window :windows){
        	System.out.println(++count+" StackWindow : "+window);
        }
        count = 0;
        for(String handle :driver.getWindowHandles()){
        	System.out.println(++count+" HandleWindow : "+handle);
        }
        System.out.println("-------------------------------------------");
        
		return driver;
	*/}
	
	public static WebDriver switchToLatestWindowFO(WebDriver driver) {

		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		if (winList.size() > 0) {
			String newTab = winList.get(winList.size() - 1);
			// System.out.println("winList: "+winList.size());
			driver.switchTo().window(newTab);
		}
		if(driver.getWindowHandle()!=null){
			winSet = driver.getWindowHandles();
			Iterator<String> iterator = winSet.iterator();
			int count = 0;
			while (iterator.hasNext()) {
				String string = (String) iterator.next();
				System.out.println(++count+" "+string);
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
		return driver;
	}
	
	public static String getUnmatchedElementFromHandle(Stack<String> stackStrings, Set<String> handles) {
		
		List<String> stacList = new ArrayList<>(stackStrings);
		List<String> handleList = new ArrayList<>(handles);
		handleList.removeAll(stacList);
		if(handleList.size()==1)
			return handleList.get(0);
		else
			return "";
	}
	
	
	public static void threadSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public static WebDriver	moveTo(WebDriver driver, WebElement element) {
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		return driver;

	}
	
	public static WebDriver performAction(WebDriver driver,String elementValue,String type, String action){
		
		WebElement element = getWebElement(driver, elementValue, type);
		
		action(driver, element, action);
		return driver;
	}
	
	
	public static WebDriver action(WebDriver driver,WebElement wb, String actiontobedone)	{

		Actions action = new Actions(driver);

		if (actiontobedone.contains("MOUSEMOVETOELEMENT")) {

			action.moveToElement(wb).build().perform();
		}

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

	public static WebDriver moveToThisElement(WebDriver driver,String elementValue, String type) {
		
		WebElement element = getWebElement(driver, elementValue, type);	
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		return driver;
	}
	
	public static WebDriver switchToFrameWithWait(WebDriver driver,String frameName) {
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(frameName)));
		return driver;
	}
	
	public static WebDriver switchToFrameWithWait(WebDriver driver,String frameName,int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(frameName)));
		return driver;
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
	
	public static List<WebElement> waitUntilElementsPresent(WebDriver driver,String elementval,String findBy,int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		List<WebElement> elements = null ;
		
		
		
		if(findBy.equalsIgnoreCase("xpath"))
			elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementval)));
		else
			if(findBy.equalsIgnoreCase("id"))
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(elementval)));
			else
				if(findBy.equalsIgnoreCase("class"))
					elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(elementval)));
			else
				if(findBy.equalsIgnoreCase("name"))
					elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(elementval)));
				else
					if(findBy.equalsIgnoreCase("linkText"))
						elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(elementval)));
					else
						if(findBy.equalsIgnoreCase("text")){ //*[contains(text(), 'My Button')]
							String tempXpath ="//*[contains(text(), '"+elementval+"')]"; 
							elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(tempXpath)));
						}
		return elements;
	}
	

	
	public static WebDriver selectValue(WebDriver driver, WebElement dropdown,String text) {
		
		List<WebElement> elements = driver.findElements(By.tagName("option"));
		Iterator<WebElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			WebElement webElement = (WebElement) iterator.next();
			String value = webElement.getText().trim();
			if(value.equalsIgnoreCase(value)||value.startsWith(text)){
				Select select = new Select(dropdown);
				select.selectByVisibleText(webElement.getText());
			}
		}
		
		
		return driver;
	}
	
	public static Properties getProperties(String filename) {
		Properties initProperties = null;
		FileInputStream initFileInputStream = null;
		try {
			initProperties = new Properties();
			initFileInputStream = new FileInputStream(filename);
			initProperties.load(initFileInputStream);

		} catch (FileNotFoundException e) {
			System.out.println("Error InitLoad.properties file not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out
					.println("Error while reading properties from file - InitLoad.properties");

			e.printStackTrace();
		} finally {
			if (initFileInputStream != null) {
				try {
					initFileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return initProperties;
	}
	
	public static WebElement getParent(WebDriver driver, WebElement child) {
		
		WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].parentNode;", child);
		return parent;
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
	


	
	
}
