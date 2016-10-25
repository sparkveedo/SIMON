package com.centurylink.simong_app.pageobjects;

import static com.centurylink.simong_app.weboperations.PageParmDefinitions.MAIN_FRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.centurylink.simong_app.excelread.Parameterization;
import com.centurylink.simong_app.excelread.Readfile;
import com.centurylink.simong_app.weboperations.Simon_Webop;




public class app_searchpage extends Simon_Webop {
	
	static WebDriver driver;
	static Properties prop = new Properties();
	static FileInputStream input = null;
	static Readfile read = new Readfile();
	static List<HashMap<String,String>> mydata = new ArrayList<HashMap<String, String>>();
	public FrameHandler frame = new FrameHandler();
	//List<HashMap<String,String>> mydata = read.data("src/test/resources/SIMONG_INPUT.xls", "APP_DATA");
	
public static app_home home = new app_home();
public static app_Login login = new app_Login();
public static app_callerIdentificationPage cip = new app_callerIdentificationPage();
public static app_searchpage operations = new app_searchpage();
public static Parameterization param = new Parameterization();

	

public WebDriver seachpage_login(String Module,String sheet) throws InterruptedException
{
	driver= cip.ci_login(Module,sheet);

	 return driver;
}

public void searchpage_home(int index,String Module,String sheet)
{
	cip.ci_home(index,Module,sheet);
}

public void searchpage_calleridentification(int index,String Module,String sheet)
{
	cip.validateCip(index,Module,sheet);
}
	

public void searchpage_isloaded()
{
	
	operations.loaded(driver, "Search Service Address");
}



public void searchpage_basicvalidation()
{
	
	// yet to code
	
}

public void searchpage_field_validation()
{
	// yet to code
}
	
public void searchpage_searchaddresspage(int index,String module,String sheet) throws IOException
{
	
	operations.implicitwait(driver, 3);
	mydata =	read.data("src/test/resources/SIMONG_INPUT.xls", sheet);
		input = new FileInputStream("identifiers.properties");			
		prop.load(input);						
	
	try
	{
	frame.loadFrame(driver,MAIN_FRM);
	operations.implicitwait(driver, 3);
	if(mydata.get(index).get(param.FULL_SERVICE_ADDRESS).isEmpty()==false)
	{
		operations.takescreenshot(driver, module, index, "e1_searchpage_landing", "SUCCESS");
		operations.sendkeys(driver, prop.getProperty("full_service_address"), mydata.get(index).get(param.FULL_SERVICE_ADDRESS), "xpath");
		operations.takescreenshot(driver, module, index, "e2_searchpage_fulladdress", "SUCCESS");
		operations.implicitwait(driver, 3);
		if(mydata.get(index).get(param.CLICK_SEARCH_BUTTON).equals("YES"))
		{
		operations.click(driver, prop.getProperty("search_button"), "xpath");}
		
	}else{
		
		operations.click(driver, prop.getProperty("show_fulladdress_link"), "xpath");
		operations.implicitwait(driver, 3);
		operations.sendkeys(driver, prop.getProperty("house_number"), mydata.get(index).get(param.HOUSE_NUMBER), "xpath");
		operations.implicitwait(driver, 1);
		operations.sendkeys(driver, prop.getProperty("street_name"), mydata.get(index).get(param.STREET_NAME), "xpath");
		operations.implicitwait(driver, 1);
		operations.selectValue(driver, prop.getProperty("unit_type_dropdown"), mydata.get(index).get(param.UNIT_TYPE));
		operations.implicitwait(driver, 1);
		operations.sendkeys(driver, prop.getProperty("unit_no"), mydata.get(index).get(param.UNIT_NO), "xpath");
		operations.implicitwait(driver, 1);
		operations.sendkeys(driver, prop.getProperty("city"), mydata.get(index).get(param.CITY), "xpath");
		operations.implicitwait(driver, 1);
		operations.selectValue(driver, prop.getProperty("state_dropdown"), mydata.get(index).get(param.STATE));
		operations.implicitwait(driver, 1);
		operations.sendkeys(driver, prop.getProperty("zipcode"), mydata.get(index).get(param.ZIP), "xpath");
		operations.implicitwait(driver, 3);
		operations.takescreenshot(driver, module, index, "e3_searchpage_detailed_Address", "SUCCESS");
		if(mydata.get(index).get(param.CLICK_SEARCH_BUTTON).equals("YES"))
		{
		operations.click(driver, prop.getProperty("search_button"), "xpath");}
			
	}
	operations.takescreenshot(driver, module, index, "e4_searchpage_post_search", "SUCCESS");
	operations.implicitwait(driver, 3);
	frame.loadFrame(driver,MAIN_FRM);
	operations.implicitwait(driver, 10);
	operations.waitUntilElementPresent(driver, prop.getProperty("filter_address"), "xpath", 30);
	operations.sendkeys(driver, prop.getProperty("filter_address"), mydata.get(index).get(param.FILTER_ADDRESS), "xpath");	
	operations.implicitwait(driver, 3);
	String countText = String.valueOf(operations.count_ele(driver, prop.getProperty("address_table_radiobutton")));
	operations.asserttrue(driver,operations.get_text(driver, prop.getProperty("address_table_totalnumber")).contains(countText));
	operations.implicitwait(driver, 2);
	operations.click(driver, prop.getProperty("address_table_radiobutton"), "xpath");
	try{System.out.println("ADDRESS IN SEARCH RESULT TABLE : "+operations.get_text(driver, prop.getProperty("address_table_addresstext")));}catch(Exception e){System.out.println(e.getMessage());}
	operations.implicitwait(driver, 2);
	
	try{System.out.println("ADDRESS REUSLT MESSAGE : "+operations.get_text(driver, prop.getProperty("address_result_message")));}catch(Exception e){System.out.println(e.getMessage());}
	try{System.out.println("ADDRESS REUSLT MESSAGE LINK : "+operations.get_text(driver, prop.getProperty("adress_result_message_link")));}catch(Exception e){System.out.println(e.getMessage());}
	operations.takescreenshot(driver, module, index, "e5_searchpage_post_filter", "SUCCESS");
	if(mydata.get(index).get(param.NC_CLICK_VERIFY_BUTTON).trim().equals("YES"))
	{	operations.click(driver, prop.getProperty("searchaddress_verify_button"), "xpath");
	
	operations.implicitwait(driver, 5);
	try{System.out.println("POST ADDRESS VERIFY INFORMATION MESSAGE : "+operations.get_text(driver, prop.getProperty("post_verify_information_text")));}catch(Exception e){System.out.println(e.getMessage());}
	try{System.out.println("POST ADDRESS VERIFY GRID ADDRESS : "+operations.get_text(driver, prop.getProperty("post_verify_grid_address")));}catch(Exception e){System.out.println(e.getMessage());}
	
		try {	System.out.println("POST ADDRESS VERIFY GRID HSI : "+operations.get_text(driver, prop.getProperty("post_verify_grid_HSI")));} catch (Exception e) {	System.out.println("Error catch POST ADDRESS VERIFY GRID HSI : "+e.getMessage()); }
		try {	System.out.println("POST ADDRESS VERIFY GRID PRISM : "+operations.get_text(driver, prop.getProperty("post_verify_grid_prism")));} catch (Exception e) {	System.out.println("Error catch POST ADDRESS VERIFY GRID PRISM : "+e.getMessage()); }


	if(operations.get_text(driver, prop.getProperty("post_verify_grid_prism")).isEmpty()){
		System.out.println("post_verify_grid_prism : No data present to print");
	}else{	System.out.println("POST ADDRESS VERIFY GRID PRISM : "+operations.get_text(driver, prop.getProperty("post_verify_grid_prism")));}
	
	operations.implicitwait(driver, 2);
	operations.takescreenshot(driver, module, index, "e6_searchpage_post_verify", "SUCCESS");
	if(mydata.get(index).get(param.SEARCH_SERVICE_ADDRESS_FINAL_ACTION).trim().equals("APPLY"))
	{operations.click(driver, prop.getProperty("search_apply_button"), "xpath");}
	operations.takescreenshot(driver, module, index, "e7_searchpage_post_apply", "SUCCESS");
	
	}
	else{System.out.println("SEARCH ADDRESS PAGE OPERATION IS NOT COMPLETED (NOT VERIFIED/NOT APPLIED)");}

	operations.takescreenshot(driver, module, index, "e8_searchpage_post_completion", "SUCCESS");
}

catch(Exception e)
{
	operations.takescreenshot(driver, module, index, "searchpage_failed", "FAILED");
}
}
}
