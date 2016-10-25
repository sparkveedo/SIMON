package com.centurylink.simong_app.stepdef;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import com.centurylink.simong_app.excelread.Parameterization;
import com.centurylink.simong_app.excelread.Readfile;
import com.centurylink.simong_app.pageobjects.app_Login;
import com.centurylink.simong_app.pageobjects.app_callerIdentificationPage;
import com.centurylink.simong_app.pageobjects.app_existingCustomerSearchPage;
import com.centurylink.simong_app.pageobjects.app_home;
import com.centurylink.simong_app.pageobjects.app_searchpage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

	public class simongapp_stepdef {
	public  WebDriver driver;
	
	Readfile read = new Readfile();
	List<HashMap<String,String>> mydata_login = read.data("src/test/resources/SIMONG_INPUT.xls", "APP_LOGIN");
	List<HashMap<String,String>> mydata_home = read.data("src/test/resources/SIMONG_INPUT.xls", "APP_HOME");
	List<HashMap<String,String>> mydata_searchaddress = read.data("src/test/resources/SIMONG_INPUT.xls", "APP_SEARCHADDRESS");
	List<HashMap<String,String>> mydata_newcustomer = read.data("src/test/resources/SIMONG_INPUT.xls", "APP_NEWCUSTOMER");
	List<HashMap<String,String>> mydata_existingcustomer = read.data("src/test/resources/SIMONG_INPUT.xls", "APP_EXISTINGCUSTOMER");
	List<HashMap<String,String>> mydata_newcustomerdetails = read.data("src/test/resources/SIMONG_INPUT.xls", "APP_NEWCUSTOMERDETAILS");
	List<HashMap<String,String>> config = read.data("src/test/resources/SIMONG_INPUT.xls", "APP_CONFIGURATION");
	
	public static Parameterization param = new Parameterization();
	public static app_Login lp = new app_Login();
	public static app_home home = new app_home();
	public static app_callerIdentificationPage cip = new app_callerIdentificationPage();
	public static app_existingCustomerSearchPage ecs = new app_existingCustomerSearchPage();
	public static app_searchpage searchpage = new app_searchpage();
	
	@Given("^application is launched \"([^\"]*)\"$")
	public void application_is_launched(int args) throws InterruptedException {	
		int index = args-1;
		System.out.println("CONFIG :"+config.get(0).get("LOGIN"));
		System.out.println("EXECUTE : "+mydata_login.get(index).get("EXECUTE ?"));
		
		if((mydata_login.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("LOGIN").trim().toUpperCase().equals("YES")){
			driver =lp.app_launch();}
		else
		{
			if(mydata_login.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO"))
			{
					System.out.println("LOGIN SCENARIO NO :"+index+" NOT OPTED TP EXECUTE");
			}
			if(config.get(0).get("LOGIN").trim().toUpperCase().equals("YES")==false)
			{
					System.out.println("LOGIN SCENARIO HAS NOT BEEN OPTED FOR EXECUTION");
			}
		}
	}	
	 
	@Then("^validate login page \"([^\"]*)\"$")
	public void validate_login_page(int args) throws InterruptedException
	{		
		int index = args-1;
		if((mydata_login.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("LOGIN").trim().toUpperCase().equals("YES")){
		lp.login(index,"LOGIN","APP_LOGIN");}
	}
	
	@Given("^User is on the home page \"([^\"]*)\"$")
	public void User_is_on_the_home_page(int args) throws InterruptedException {	
		int index = args-1;
		System.out.println("CONFIG :"+config.get(0).get("HOME"));
		System.out.println("EXECUTE : "+mydata_home.get(index).get("EXECUTE ?"));
		
		if((mydata_home.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("HOME").trim().toUpperCase().equals("YES")){
		home.login_home("HOME","APP_LOGIN");}
		else
		{
			if(mydata_home.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO"))
			{
					System.out.println("HOME SCENARIO NO :"+index+" NOT OPTED TP EXECUTE");
			}
			if(config.get(0).get("HOME").trim().toUpperCase().equals("YES")==false)
			{
					System.out.println("HOME SCENARIO HAS NOT BEEN OPTED FOR EXECUTION");
			}
		}
	}
	
	@Given("^User is on the home page for calleridentification \"([^\"]*)\"$")
	public void User_is_on_the_home_page_for_calleridentification(int args) throws InterruptedException {
		int index = args-1;
		System.out.println("CONFIG :"+config.get(0).get("NEWCUSTOMER"));
		System.out.println("EXECUTE : "+mydata_newcustomer.get(index).get("EXECUTE ?"));
		
		if((mydata_newcustomer.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("NEWCUSTOMER").trim().toUpperCase().equals("YES")){
		cip.ci_login("NEW_CUSTOMER","APP_LOGIN");}
		else
		{
			if(mydata_newcustomer.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO"))
			{
					System.out.println("NEW CUSTOMER SCENARIO NO :"+index+" NOT OPTED TP EXECUTE");
			}
			if(config.get(0).get("NEWCUSTOMER").trim().toUpperCase().equals("YES")==false)
			{
					System.out.println("NEW CUSTOMER SCENARIO HAS NOT BEEN OPTED FOR EXECUTION");
			}
		}
	}
	
	@Given("^User is on the home page for Existing customer page \"([^\"]*)\"$")
	public void User_is_on_the_home_page_for_Existing_customer_page(int args) throws InterruptedException {
		
	int index = args-1;
		System.out.println("CONFIG :"+config.get(0).get("EXISTINGCUSTOMER"));
		System.out.println("EXECUTE : "+mydata_existingcustomer.get(index).get("EXECUTE ?"));
		
		if((mydata_existingcustomer.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("EXISTINGCUSTOMER").trim().toUpperCase().equals("YES")){
		ecs.ecs_login("EXISTING_CUSTOMER","APP_LOGIN");}
		else
		{
			if(mydata_existingcustomer.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO"))
			{
					System.out.println("EXISTING CUSTOMER SCENARIO NO :"+index+" NOT OPTED TP EXECUTE");
			}
			if(config.get(0).get("EXISTINGCUSTOMER").trim().toUpperCase().equals("YES")==false)
			{
					System.out.println("EXISTING CUSTOMER SCENARIO HAS NOT BEEN OPTED FOR EXECUTION");
			}
		}
	}
	
	@Then("^validate home page \"([^\"]*)\"$")
	public void validate_home_page(int args) throws InterruptedException {	
		int index = args-1;

		if((mydata_home.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("HOME").trim().toUpperCase().equals("YES")){
		home.check_customertools(mydata_home.get(index).get(param.VALIDATE_HOME_PAGE),mydata_home.get(index).get(param.EXISTING_CUSTOMER),mydata_home.get(index).get(param.CUSTOMER_TYPE),mydata_home.get(index).get(param.CUSTOMER_TYPE_FINAL_ACTION),index,"HOME","APP_HOME");
		}		
	}
	
	@When("^User is a new customer \"([^\"]*)\"$")
	public void User_is_a_new_customer(int args) {	
		int index = args-1;

		if((mydata_newcustomer.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("NEWCUSTOMER").trim().toUpperCase().equals("YES")){
		cip.ci_home(index,"NEW_CUSTOMER","APP_NEWCUSTOMER");}
	}
	 
	@Then("^validate the caller identification page \"([^\"]*)\"$")
	public void validate_the_caller_identification_page(int args) throws InterruptedException {	
		int index = args-1;
		Thread.sleep(5000);

		if((mydata_newcustomer.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("NEWCUSTOMER").trim().toUpperCase().equals("YES")){
		cip.validateCip(index,"NEW_CUSTOMER","APP_NEWCUSTOMER");}
	}
	 
	@Then("^the user will be on search service address page \"([^\"]*)\"$")
	public void the_user_will_be_on_search_service_address_page(int args) {	
		int index = args-1;
		if((mydata_searchaddress.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("SEARCHADDRESSPAGE").trim().toUpperCase().equals("YES")){
		searchpage.searchpage_isloaded();
		}			
	}
	
	@When("^User is an existing customer \"([^\"]*)\"$")
	public void  User_is_an_existing_customer(int args) throws InterruptedException {			
		int index = args-1;

		if((mydata_existingcustomer.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("EXISTINGCUSTOMER").trim().toUpperCase().equals("YES")){
		ecs.ecs_home(index,"EXISTING_CUSTOMER","APP_EXISTINGCUSTOMER");	}
	}
	 
	@Then("^validate the existing customer page \"([^\"]*)\"$")
	public void validate_the_existing_customer_page(int args) throws InterruptedException {		
		int index = args-1;

		if((mydata_existingcustomer.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("EXISTINGCUSTOMER").trim().toUpperCase().equals("YES")){
		ecs.validateECsearchPage(index,"APP_EXISTINGCUSTOMER");}
	}
	 
	@Given("^User is on the search service address page \"([^\"]*)\"$")
	public void User_is_on_the_search_service_address_page(int args) throws InterruptedException {		
		int index = args-1;
		System.out.println("CONFIG :"+config.get(0).get("SEARCHADDRESSPAGE"));
		System.out.println("EXECUTE : "+mydata_searchaddress.get(index).get("EXECUTE ?"));
		
		if((mydata_searchaddress.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("SEARCHADDRESSPAGE").trim().toUpperCase().equals("YES")){
		searchpage.seachpage_login("SEARCHPAGE","APP_LOGIN");
		searchpage.searchpage_home(index,"SEARCHPAGE","APP_SEARCHADDRESS");
		searchpage.searchpage_calleridentification(index,"SEARCHPAGE","APP_SEARCHADDRESS");	
		}
		else
		{
			if(mydata_searchaddress.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO"))
			{
					System.out.println("SEARCH ADDRESS SCENARIO NO :"+index+" NOT OPTED TP EXECUTE");
			}
			if(config.get(0).get("SEARCHADDRESSPAGE").trim().toUpperCase().equals("YES")==false)
			{
					System.out.println("SEARCH ADDRESS SCENARIO HAS NOT BEEN OPTED FOR EXECUTION");
			}
		}
	}
	
	@And("^check or validate the functionalities of search service address page \"([^\"]*)\"$")
	public void check_or_validate_the_functionalities_of_search_service_address_page(int args) throws IOException {		
		int index = args-1;
		if((mydata_searchaddress.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("SEARCHADDRESSPAGE").trim().toUpperCase().equals("YES")){
		searchpage.searchpage_searchaddresspage(index,"SEARCHPAGE","APP_SEARCHADDRESS");}
	}
		 
	@Then("^the user will be on new customer details page \"([^\"]*)\"$")
	public void the_user_will_be_on_new_customer_details_page(int args) {
		int index = args-1;
		if((mydata_searchaddress.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("SEARCHADDRESSPAGE").trim().toUpperCase().equals("YES")){
			System.out.println("new customer page is loaded");}	
	}
	
	@And("^finally logout \"([^\"]*)\"$")
	public void finally_logout(int args) {	
		int index = args-1;
		if((mydata_login.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("LOGIN").trim().toUpperCase().equals("YES")){
		try {
			Thread.sleep(5000);
			home.logout_home();
		} catch (Exception e) {
			System.out.println("Error catch : "+e.getMessage());
		}
		}
	}
	
	@And("^finally logout home \"([^\"]*)\"$")
	public void finally_logout_home(int args) {	
		int index = args-1;
		if((mydata_home.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("HOME").trim().toUpperCase().equals("YES")){
		try {
			Thread.sleep(5000);
			home.logout_home();
		} catch (Exception e) {
			System.out.println("Error catch : "+e.getMessage());
		}
		}
	}
	 
	@And("^finally logout newcustomer \"([^\"]*)\"$")
	public void finally_logout_newcustomer(int args) {	
		int index = args-1;
		if((mydata_newcustomer.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("NEWCUSTOMER").trim().toUpperCase().equals("YES")){
		try {
			Thread.sleep(5000);
			home.logout_home();
		} catch (Exception e) {
			System.out.println("Error catch : "+e.getMessage());
		}
		}
	}
		
	@And("^finally logout searchaddress \"([^\"]*)\"$")
	public void finally_logout_searchaddress(int args) {	
		int index = args-1;
		if((mydata_searchaddress.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("SEARCHADDRESSPAGE").trim().toUpperCase().equals("YES")){
		try {
			Thread.sleep(5000);
			home.logout_home();
		} catch (Exception e) {
			System.out.println("Error catch : "+e.getMessage());
		}
		}
	}

	@And("^finally logout existingcustomer \"([^\"]*)\"$")
	public void finally_logout_existingcustomer(int args) {	
		int index = args-1;
		if((mydata_existingcustomer.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("EXISTINGCUSTOMER").trim().toUpperCase().equals("YES")){
		try {
			Thread.sleep(5000);
			home.logout_home();
		} catch (Exception e) {
			System.out.println("Error catch : "+e.getMessage());
		}
		}
	}
	
	@And("^finally logout newcustomerdetails \"([^\"]*)\"$")
	public void finally_logout_newcustomerdetails(int args) {	
		int index = args-1;
		if((mydata_newcustomerdetails.get(index).get("EXECUTE ?").trim().toUpperCase().equals("NO")==false) && config.get(0).get("NEWCUSTOMERDETAILS").trim().toUpperCase().equals("YES")){
		try {
			Thread.sleep(5000);
			home.logout_home();
		} catch (Exception e) {
			System.out.println("Error catch : "+e.getMessage());
		}
		}
	}
	
	@Given("^User is on the new customer details page$")
	public void User_is_on_the_new_customer_details_page() {		
					
	}
	 
	@And("^check or validate the functionalities of new customer details page$")
	public void check_or_validate_the_functionalities_of_new_customer_details_page() {		
					
	}
	 
	@Then("^the user will be on ordering actions page$")
	public void the_user_will_be_on_ordering_actions_page() {		
					
	}

}
