package com.centurylink.simong_app.pageobjects;

import static com.centurylink.simong_app.weboperations.PageParmDefinitions.MAIN_FRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.centurylink.simong_app.excelread.Parameterization;
import com.centurylink.simong_app.excelread.Readfile;
import com.centurylink.simong_app.excelread.Parameterization;
import com.centurylink.simong_app.weboperations.Simon_Webop;

public class app_existingCustomerSearchPage extends Simon_Webop {

	 app_Login lp = new app_Login();
	 public static app_existingCustomerSearchPage operations = new app_existingCustomerSearchPage();
	app_home home = new app_home();
	WebDriver driver;
	Properties prop = new Properties();
	FileInputStream input = null;
	static Readfile read = new Readfile();
	static List<HashMap<String,String>> mydata = new ArrayList<HashMap<String, String>>();
	
	FrameHandler frame = new FrameHandler();
	Parameterization param = new Parameterization();
	
	public WebDriver ecs_login(String Module,String sheet) throws InterruptedException
	{
		driver= home.login_home(Module,sheet);		
		 return driver;
	}
	
	public void ecs_home(int index,String Module,String sheet) throws InterruptedException
	{
		mydata =  read.data("src/test/resources/SIMONG_INPUT.xls", sheet);
		System.out.println("index :"+index);
		try {
			home.check_customertools(mydata.get(index).get(param.VALIDATE_HOME_PAGE),mydata.get(index).get(param.EXISTING_CUSTOMER),mydata.get(index).get(param.CUSTOMER_TYPE),mydata.get(index).get(param.CUSTOMER_TYPE_FINAL_ACTION),index,Module,sheet);
		} catch (InterruptedException e) {			
			
			System.out.println("Failed to navigate to exisiting customer page !"+e.getMessage());
			operations.takescreenshot(driver, Module, index,"c1_caller_id_load_failed","FAIL");

		}
	}
	
	public void validateECsearchPage(int index,String sheet){
		
		mydata =	read.data("src/test/resources/SIMONG_INPUT.xls", sheet);
		try {
			input = new FileInputStream("identifiers.properties");			
			prop.load(input);						// load a properties file
		} catch (IOException ex) {ex.printStackTrace();}		
		
		frame.loadFrame(driver,MAIN_FRM);
		
		operations.sendkeys(driver, prop.getProperty("banOrTnNo"), mydata.get(index).get(param.ACCOUNT_ID_OR_PHONE_NUMBER), "xpath");
		operations.sendkeys(driver, prop.getProperty("ssnNo"), mydata.get(index).get(param.SSN), "xpath");
		operations.sendkeys(driver, prop.getProperty("taxId"), mydata.get(index).get(param.TAX_ID), "xpath");
		operations.sendkeys(driver, prop.getProperty("orderId"), mydata.get(index).get(param.ORDER_ID), "xpath");
		operations.sendkeys(driver, prop.getProperty("last_name"), mydata.get(index).get(param.EC_LAST_NAME), "xpath");
		operations.sendkeys(driver, prop.getProperty("first_name"), mydata.get(index).get(param.EC_FIRST_NAME), "xpath");
		operations.sendkeys(driver, prop.getProperty("street_number"), mydata.get(index).get(param.EC_SERVICE_ADDRESS_HOUSE_NUMBER), "xpath");
		operations.sendkeys(driver, prop.getProperty("street_name"), mydata.get(index).get(param.EC_SA_STREET_NAME_OR_PO_BOX), "xpath");
		operations.sendkeys(driver, prop.getProperty("city"), mydata.get(index).get(param.EC_SA_CITY), "xpath");
		//operations.sendkeys(driver, prop.getProperty("state"), mydata.get(index).get(param.EC_SA_STATE), "xpath");
		operations.selectValue(driver, prop.getProperty("state"), mydata.get(index).get(param.EC_SA_STATE));
		
		operations.sendkeys(driver, prop.getProperty("zip"), mydata.get(index).get(param.EC_SA_ZIP), "xpath");
		operations.sendkeys(driver, prop.getProperty("billing_street_number"), mydata.get(index).get(param.EC_BILLING_ADDRESS_HOUSE_NUMBER), "xpath");
		operations.sendkeys(driver, prop.getProperty("billing_street_name"), mydata.get(index).get(param.EC_BA_STREET_NAME_OR_PO_BOX), "xpath");
		operations.sendkeys(driver, prop.getProperty("billing_city"), mydata.get(index).get(param.EC_BA_CITY), "xpath");
		//operations.sendkeys(driver, prop.getProperty("billing_state"), mydata.get(index).get(param.EC_BA_STATE), "xpath");
		operations.selectValue(driver, prop.getProperty("billing_state"), mydata.get(index).get(param.EC_BA_STATE));
		operations.sendkeys(driver, prop.getProperty("billing_zip"), mydata.get(index).get(param.EC_BA_ZIP), "xpath");
		operations.sendkeys(driver, prop.getProperty("tfs"), mydata.get(index).get(param.TOLL_FREE), "xpath");
		operations.sendkeys(driver, prop.getProperty("ipProductId"), mydata.get(index).get(param.IP_USER_ID), "xpath");
		
		if(mydata.get(index).get(param.EXISTING_CUSTOMER_SEARCH_FINAL_ACTION).trim().toUpperCase().equals("SEARCH")){
			operations.click(driver, prop.getProperty("searchButton"),"xpath");
		}else if(mydata.get(index).get(param.EXISTING_CUSTOMER_SEARCH_FINAL_ACTION).trim().toUpperCase().equals("CLEAR")){
			operations.click(driver, prop.getProperty("clearButton"), "xpath");
		}else{
			System.out.println("Enter the value for EXISTING_CUSTOMER_SEARCH_FINAL_ACTION !");
		}
		
		if(mydata.get(index).get(param.CLICK_VERIFY_BUTTON).trim().toUpperCase().equals("YES")){
			operations.click(driver, prop.getProperty("verifyAccountButton"), "xpath");
		}		

	}

		
}
	
	
	

