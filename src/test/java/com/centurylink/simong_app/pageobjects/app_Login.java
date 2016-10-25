package com.centurylink.simong_app.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static com.centurylink.simong_app.weboperations.PageParmDefinitions.MAIN_FRM;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.centurylink.simong_app.excelread.Readfile;
import com.centurylink.simong_app.weboperations.Simon_Webop;

public class app_Login extends Simon_Webop {
	
	public static app_Login operations = new app_Login();
//	public static Simon_Webop operations = new Simon_Webop();
	WebDriver driver;
	//SimonWebDriver driver;
	Properties prop = new Properties();
	FileInputStream input = null;
	static Readfile read = new Readfile();
	static List<HashMap<String,String>> mydata = new ArrayList<HashMap<String, String>>();
	FrameHandler frame = new FrameHandler();
	
	public WebDriver app_launch() throws InterruptedException{
		try {input = new FileInputStream("identifiers.properties");
		// load a properties file
		prop.load(input);
	} catch (IOException ex) {
		ex.printStackTrace();
	}
		Thread.sleep(5000);
		return driver = operations.launch(driver, prop.getProperty("URL"), prop.getProperty("Browser"));
		
		
	}
	
	public void login(int i,String Module,String sheet) throws InterruptedException
	{
		mydata =	read.data("src/test/resources/SIMONG_INPUT.xls", sheet);
		try {input = new FileInputStream("identifiers.properties");
			// load a properties file
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
				
	String val1[] = prop.getProperty("userNameTextBoxLoc").toString().split(" ");
	String val2[] = prop.getProperty("passwordTextBoxLoc").split(" ");
	String val3[] = prop.getProperty("enviromentDropDown").split(" ");
	String val4[] = prop.getProperty("loginButtonLoc").split(" ");
	
	
	Thread.sleep(5000);
	
	frame.loadFrame(driver,MAIN_FRM);

	System.out.println("title :"+driver.getTitle().toString());
		
	operations.assert_pagetitle(driver, prop.getProperty("Login_Title"));
	operations.loaded(driver, prop.getProperty("Login_Text"));
	operations.takescreenshot(driver, Module, i,"a1_pre_login_attempt","SUCCESS");
	
	//Login
	System.out.println(mydata.get(i).get("Username"));
	System.out.println(mydata.get(i).get("Password"));
	System.out.println(mydata.get(i).get("Environment"));
	operations.sendkeys(driver, val1[1], mydata.get(i).get("Username"), val1[0]);
	operations.sendkeys(driver, val2[1], mydata.get(i).get("Password"), val2[0]);
	operations.selectValue(driver, val3[1] ,mydata.get(i).get("Environment"));
	operations.takescreenshot(driver, Module, i,"a2_login_attempt","SUCCESS");
	operations.click(driver, val4[1], val4[0]);
	
	operations.implicitwait(driver, 3);
	operations.takescreenshot(driver, Module, i,"a3_post_login_attempt","SUCCESS");
	}
	
	public void logout()

	{
		System.out.println("inside app login logout");
		try {input = new FileInputStream("identifiers.properties");
		// load a properties file
		prop.load(input);
	} catch (IOException ex) {
		ex.printStackTrace();
	}
		try
		{
		String val5[] = prop.getProperty("logoutButtonLoc").split(" ");
		
		//driver.switchTo().defaultContent();
		//operations.click(driver, val5[1], val5[0]);	
		//driver.switchTo().alert().accept();
		}
		catch(Exception e){System.out.println("error occured while loggin out: "+e.getMessage());}
		finally	
		{
			//driver.close();
			driver.quit();
			/*if(prop.getProperty("Browser").toString().trim().equals("CHROME"))
			{operations.runtime_exe("taskkill /F /IM ChromeDriver.exe");}
			if(prop.getProperty("Browser").toString().trim().contains("IE"))
			{operations.runtime_exe("");}*/
		}
	}
	

}
