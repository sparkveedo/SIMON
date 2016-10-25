package com.centurylink.simong_app.pageobjects;

import static com.centurylink.simong_app.weboperations.PageParmDefinitions.MAIN_FRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.centurylink.simong_app.excelread.Readfile;
import com.centurylink.simong_app.weboperations.Simon_Webop;

public class app_home extends Simon_Webop {
	
	static WebDriver driver;
	static Properties prop = new Properties();
	static FileInputStream input = null;
	static Readfile read = new Readfile();
	static List<HashMap<String,String>> mydata = new ArrayList<HashMap<String, String>>();
	
	public static FrameHandler frame = new FrameHandler();
	
	
public static app_home operations = new app_home();
public static app_Login login = new app_Login();


	public WebDriver login_home(String Module,String sheet) throws InterruptedException
	{
		System.out.println("inside home login");
		 driver = login.app_launch();
		 login.login(0,Module,sheet);
		return driver;
	}
	
	public void logout_home()
	{
		login.logout();
	}
	
	public static void check_presenceofele(String Module, int i) throws InterruptedException
	{
		try {input = new FileInputStream("identifiers.properties");
		// load a properties file
		prop.load(input);
	} catch (IOException ex) {
		ex.printStackTrace();
	}
		
		Thread.sleep(5000);	
		frame.loadDefaultFrame(driver);
		Thread.sleep(5000);	
		 operations.isDisplayed(driver,prop.getProperty("Dealer_Image"));	
		 operations.isDisplayed(driver,prop.getProperty("Dealer_Name"));
		 operations.isDisplayed(driver,prop.getProperty("Dealer_Code"));
		 operations.isDisplayed(driver,prop.getProperty("TimeOut_Warning"));
		 operations.isDisplayed(driver,prop.getProperty("Quick_Link"));
		 operations.isDisplayed(driver,prop.getProperty("My_Dashboard"));
		 operations.isDisplayed(driver,prop.getProperty("My_Followups"));
		 operations.isDisplayed(driver,prop.getProperty("HabdBook_Search"));
		// operations.isDisplayed(driver,prop.getProperty("Where_Mytech"));
		 operations.isDisplayed(driver,prop.getProperty("Simon_Appointment"));
		 
		 Thread.sleep(5000);	
		 frame.loadFrame(driver,MAIN_FRM);
		 Thread.sleep(5000);	
		 operations.isDisplayed(driver,prop.getProperty("My_Followup"));
		 operations.isDisplayed(driver,prop.getProperty("My_CallHistory"));
		 operations.isDisplayed(driver,prop.getProperty("Customer_Tools"));
		 operations.isDisplayed(driver,prop.getProperty("new_customer_button"));
		 operations.isDisplayed(driver,prop.getProperty("existing_customer_button"));
		 
		 operations.takescreenshot(driver, Module, i,"b1_post_home_validation","SUCCESS");
	}
	
	public  void check_quicklinks()
	{
		// yet to code
	}
	
	public  void check_myfollowups()
	{
		// yet to code
	}
	
	public  void check_mycallhistory()
	{
		// yet to code
	}
	
	public  static void check_customertools(String validate_homepage,String Existing_Customer,String CustomerType_value,String CustomerType_FinalAction,int index,String Module,String sheet) throws InterruptedException 
	{
		mydata =  read.data("src/test/resources/SIMONG_INPUT.xls", sheet);
		try {input = new FileInputStream("identifiers.properties");
		// load a properties file
		prop.load(input);
	} catch (IOException ex) {
		ex.printStackTrace();
	}
		
		
		
		if(validate_homepage.trim().equals("YES"))
		{
			try {
				check_presenceofele(Module, index);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
							
				operations.takescreenshot(driver, Module, index,"b1_home_validation_failed","FAIL");
				System.out.println("HOME VALIDATION FALIED :"+e.getMessage());
			}
		}
		
		
		
		frame.loadFrame(driver, MAIN_FRM);
//		System.out.println("inside check customertools");
//		System.out.println("@@@flag :"+Existing_Customer.trim().toUpperCase());
		if(Existing_Customer.trim().toUpperCase().equals("YES"))
		{
			operations.click(driver, prop.getProperty("existing_customer_button"), "xpath");
			operations.takescreenshot(driver, Module, index,"b2_home_inside_existing_customer","SUCCESS");
			operations.loaded(driver, prop.getProperty("Confirm_existing_customer_page"));
			//operations.isDisplayed(driver,prop.getProperty("existing_page_header"));
			
			System.out.println("EXISTING CUSTOMER SELECTED");
			
		}
		else
		{
			
			operations.implicitwait(driver,3);
			operations.click(driver, prop.getProperty("new_customer_button"), "xpath");
			operations.implicitwait(driver,10);
			System.out.println("NEW CUSTOMER SELECTED");
			frame.loadDefaultFrame(driver);
			//operations.implicitwait(driver,3);
			//operations.isDisplayed(driver,prop.getProperty("Customer_Type"));
			operations.implicitwait(driver,5);
			operations.takescreenshot(driver, Module, index,"b3_home_inside_new_customer","SUCCESS");
			WebElement ele =operations.getWebElement(driver, prop.getProperty("Customer_Type_parent"), "xpath");
			
			//operations.nested_web_sel(driver, ele, prop.getProperty("Customer_Type"),CustomerType_value,"SELECT");
			
			
			//operations.selectValue(driver,prop.getProperty("Customer_Type"),CustomerType_value);
			operations.implicitwait(driver,5);
			//System.out.println(" @@@@ok : "+CustomerType_FinalAction.trim().toUpperCase());
			if(CustomerType_FinalAction.trim().toUpperCase().equals("OK"))
			{
			operations.click(driver, prop.getProperty("Customer_Type_Ok"), "xpath");
			System.out.println("CUSTOMER TYPE - OK ");
			Thread.sleep(8000);
			operations.takescreenshot(driver, Module, index,"b4_home_customertype_ok","SUCCESS");
		}else{
				operations.click(driver, prop.getProperty("Customer_Type_Cancel"), "xpath");
				System.out.println("CUSTOMER TYPE - CANCEL");
				operations.takescreenshot(driver, Module, index,"b4_home_customertype_cancel","SUCCESS");
			}
			
			
			
			
		}
		
		
	}
	
}
