package com.centurylink.simong_app.pageobjects;

import static com.centurylink.simong_app.weboperations.PageParmDefinitions.MAIN_FRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.centurylink.simong_app.excelread.Parameterization;
import com.centurylink.simong_app.excelread.Readfile;
import com.centurylink.simong_app.weboperations.Simon_Webop;

public class app_callerIdentificationPage extends Simon_Webop {

	public static app_callerIdentificationPage operations = new app_callerIdentificationPage();
	WebDriver driver;
	Properties prop = new Properties();
	FileInputStream input = null;
	static Readfile read = new Readfile();
	static List<HashMap<String,String>> mydata = new ArrayList<HashMap<String, String>>();
	FrameHandler frame = new FrameHandler();
	Parameterization param = new Parameterization();
	app_home home = new app_home();
	app_Login login = new app_Login();
	
	
	
	public WebDriver ci_login(String Module,String sheet) throws InterruptedException
	{
		driver= home.login_home(Module,sheet);
	
		 return driver;
	}
	
	public void ci_home(int index,String Module,String sheet)
	{
		mydata =  read.data("src/test/resources/SIMONG_INPUT.xls", sheet);
		try {
			home.check_customertools(mydata.get(index).get(param.VALIDATE_HOME_PAGE),mydata.get(index).get(param.EXISTING_CUSTOMER),mydata.get(index).get(param.CUSTOMER_TYPE),mydata.get(index).get(param.CUSTOMER_TYPE_FINAL_ACTION),index,Module,sheet);
		} catch (InterruptedException e) {			
			e.printStackTrace();
			System.out.println("Failed to navigate to new customer page !");
			operations.takescreenshot(driver, Module, index,"c1_caller_id_load_failed","FAIL");

		}
	}
	
	
	public void validateCip(int column,String Module,String sheet){
		mydata = read.data("src/test/resources/SIMONG_INPUT.xls", sheet);
		try {
			input = new FileInputStream("identifiers.properties");			
			prop.load(input);						// load a properties file
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		String first[] = prop.getProperty("firstName").split(" ");
		String last[] = prop.getProperty("lastName").split(" ");
		String contact[] = prop.getProperty("contactTN").split(" ");
		String remark[] = prop.getProperty("conversationRemarks").split(" ");
		String apply[] = prop.getProperty("applyButton").split(" ");
	
		
		frame.loadFrame(driver,MAIN_FRM);
		operations.sendkeys(driver, first[1], mydata.get(column).get(param.FIRST_NAME), first[0]);
		operations.sendkeys(driver, last[1], mydata.get(column).get(param.LAST_NAME), last[0]);
		operations.sendkeys(driver, contact[1], mydata.get(column).get(param.CONTACT_NUMBER), contact[0]);
		operations.sendkeys(driver, remark[1], mydata.get(column).get(param.WHY_IS_THIS_CUSTOMER_CALLING_TODAY), remark[0]);
		
		if(mydata.get(column).get(param.CALLER_IDENTIFICATION_FINAL_ACTION).trim().toUpperCase().equals("APPLY")){
			operations.takescreenshot(driver, Module, column,"c2_called_id_pre_validation","SUCCESS");
			operations.click(driver, apply[1], apply[0]);
			operations.takescreenshot(driver, Module, column,"c3_called_id_post_validation","SUCCESS");
		}else{
			System.out.println("Enter data for Caller Identification Final Action");
		}
	}
	
}
