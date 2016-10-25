@simongAppUnitTest
Feature: To automate simong application with dynamic input scenarios

@loginpage
Scenario Outline: This cover all the functionalities in login page

	Given application is launched
		Then validate login page "<column>"
		And finally logout
	
	Examples:
	
	| column|
	|	1	|
	|	2	|
	|	3	|
	|	4	|	
	
	
@homepage
Scenario Outline: This cover all the functionalities in home page

	Given User is on the home page  
		Then validate home page "<column>" 
		And finally logout
	
	Examples:
	
	| column|
	|	1	|
	|	2	|	
		
@existingCustomer
Scenario Outline:This cover all the functionalities in existing customer page		
	
		Given User is on the home page 
		When User is an existing customer "<column>" 
		Then validate the existing customer page "<column>" 
		And finally logout
		
	Examples:
	
	| column|
	|	10	|
	|	11	|		
		
		
@newCustomer
Scenario Outline: This cover all the functionalities in caller Identification page		
	
		Given User is on the home page 
		When User is a new customer "<column>" 
		Then validate the caller identification page "<column>" 
#		Then the user will be on search service address page 
		And finally logout
	
	Examples:
	
	| column|
	|	3	|
			
	
@newCustomerSearchServiceAddress
Scenario Outline: This cover all the functionalities in search service address page		
	
	Given User is on the search service address page
		And check or validate the functionalities of search service address page
		Then check the address validation message
		Then the user will be on new customer details page
		And finally logout
	
	Examples:
	
	|		|		
		
@newCustomerDetails
Scenario Outline: This cover all the functionalities in new customer details page		
	
	Given User is on the new customer details page
		And check or validate the functionalities of new customer details page
		Then the user will be on ordering actions page
		And finally logout
		
	Examples:
	
	|		|	
