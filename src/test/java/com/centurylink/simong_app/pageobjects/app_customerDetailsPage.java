package com.centurylink.simong_app.pageobjects;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.MAIN_FRM;
import com.centurylink.simong_app.excelread.Parameterization;
import com.centurylink.simong_app.excelread.Readfile;
import com.centurylink.simong_app.weboperations.Simon_Webop;

public class app_customerDetailsPage extends Simon_Webop {

	public static app_customerDetailsPage operations = new app_customerDetailsPage();
	static WebDriver driver;
	Properties prop = new Properties();
	FileInputStream input = null;
	static Readfile read = new Readfile();
	static List<HashMap<String,String>> mydata =  read.data("src/test/resources/SIMONG_INPUT.xls", "APP_DATA");
	FrameHandler frame = new FrameHandler();
	Parameterization param = new Parameterization();
	app_home home = new app_home();
	app_Login login = new app_Login();
	
	
	
	public WebDriver cdp_login(String module,String sheet) throws InterruptedException
	{
		driver= home.login_home(module, sheet);							//---------------------<<<<<<<<<<<<<<
		 return driver;
	}
	
	public void cdp_home(int index,String module,String sheet) throws InterruptedException
	{
		home.check_customertools(mydata.get(index).get(param.VALIDATE_HOME_PAGE),mydata.get(index).get(param.EXISTING_CUSTOMER),mydata.get(index).get(param.CUSTOMER_TYPE),mydata.get(index).get(param.CUSTOMER_TYPE_FINAL_ACTION),index,module,sheet);
	}
	
	
	public void validateCdp(int index){
		mydata =	read.data("src/test/resources/SIMONG_INPUT.xls", "APP_DATA");
		try {
			input = new FileInputStream("identifiers.properties");			
			prop.load(input);						// load a properties file
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	
		frame.loadFrame(driver,MAIN_FRM);
		
		operations.getWebElement(driver,prop.getProperty("cdp_firstName"),"xpath").getAttribute("value").trim().equals(mydata.get(index).get(param.FIRST_NAME));
		operations.getWebElement(driver,prop.getProperty("cdp_lastName"),"xpath").getAttribute("value").trim().equals(mydata.get(index).get(param.LAST_NAME));
		operations.getWebElement(driver,prop.getProperty("cdp_homePhone"),"xpath").getAttribute("value").trim().equals(mydata.get(index).get(param.CONTACT_NUMBER));

		if(!mydata.get(index).get(param.M_FIRST_NAME).isEmpty()){
			operations.sendkeys(driver, prop.getProperty("cdp_firstName"), mydata.get(index).get(param.M_FIRST_NAME), "xpath");
		}
		if(!mydata.get(index).get(param.M_LAST_NAME).isEmpty()){
			operations.sendkeys(driver, prop.getProperty("cdp_lastName"), mydata.get(index).get(param.M_LAST_NAME), "xpath");
		}
		if(!mydata.get(index).get(param.M_MIDDLE_NAME).isEmpty()){
			operations.sendkeys(driver, prop.getProperty("cdp_middleName"), mydata.get(index).get(param.M_MIDDLE_NAME), "xpath");
		}
		if(!mydata.get(index).get(param.M_CONTACT_NUMBER).isEmpty()){
			operations.sendkeys(driver, prop.getProperty("cdp_homePhone"), mydata.get(index).get(param.M_CONTACT_NUMBER), "xpath");
		}
		if(!mydata.get(index).get(param.ADDITIONAL_LINE).isEmpty()){
			operations.sendkeys(driver, prop.getProperty("cdp_additionalLine"), mydata.get(index).get(param.ADDITIONAL_LINE), "xpath");
		}
		if(!mydata.get(index).get(param.EMAIL).isEmpty()){
			operations.sendkeys(driver, prop.getProperty("cdp_email"), mydata.get(index).get(param.EMAIL), "xpath");
		}
		
		if(mydata.get(index).get(param.CUSTOMER_DETAILS_FINAL_ACTION).trim().toUpperCase().equals("APPLY")){			
			operations.click(driver,prop.getProperty("cdp_applyButton"),"xpath" );			
		}else{
			System.out.println("Enter data for Customer Details Final Action");
		}
	}
		
	
	
	
	
}
