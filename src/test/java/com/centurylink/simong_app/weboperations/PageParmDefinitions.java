package com.centurylink.simong_app.weboperations;

public class PageParmDefinitions {
	
	public static final String SHORT_WAIT_SEC = "ShortPageWait";
	public static final String MEDIUM_WAIT_SEC = "MediumPageWait";
	public static final String LONG_WAIT_SEC = "LongPageWait";
	public static final String EXTRA_LONG_WAIT_SEC = "ExtraLongPageWait";
	public static final String PROGRESS_IMAGE_XPATH = "//*[@id='simonprogressImg']";

	// Field values
	public static final String USER_ID = "UserId";
	public static final String PASSWORD = "PassWord";
	public static final String DB_ENVIROMENT = "DBEvironment";
	public static final String BAN = "Ban";
	public static final String POTS_BAN = "PotsBan";
	public static final String POTS_HSI_BAN = "PotsHsiBan";
	public static final String PRISM_BAN = "PrismBan";
	public static final String DTV_BAN = "DtvBan";
	public static final String CVOIP_BAN = "CvoipBan";
	public static final String CRIS_CONVERTED_BAN = "CrisConvertedBan";
	public static final String BAN_WITH_ORDER = "BanWithOrder";
	public static final String MOVE_BAN = "MoveBan";
	public static final String MOVE_TO_ADDRESS = "MoveToAddress";
	public static final String MOVE_FROM_ADDRESS = "MoveFromAddress";	
	public static final String UPDATE_DIRECTORY_LISTING = "UpdateDirectoryListing";	
	public static final String CUST_TYPE = "CustType";
	public static final String CUST_FIRST_NAME = "CustFirstName";
	public static final String CUST_LAST_NAME = "CustLastName";
	public static final String CUST_CONTACT_NUMBER  = "ContactTN";
	public static final String CUST_CONVERSATION_REMARKS = "ConversationRemark";
	public static final String CUST_CALL_REASON = "CallReason";
	public static final String SERVICE_ADDRESS = "ServiceAddressSimG";
	public static final String CLC_CVOIP_SERVICE_ADDRESS = "ClcCvoipServiceAddress";
	public static final String MARTINS_CVOIP_SERVICE_ADDRESS = "MartensCvoipServiceAddress";
	public static final String PRISM_SERVICE_ADDRESS = "PrismServiceAddress";
	public static final String POTS_HSI_SERVICE_ADDRESS = "PotsHsiServiceAddress";
	public static final String CUST_SUBTYPE = "CustSubType";
	public static final String BUSINESS_TYPE = "BusinessType";
	public static final String BUSINESS_NAME = "BusinessName";
	public static final String ADDITIONAL_LINE = "AdditionalLine";
	public static final String CUST_EMAIL = "CustEmail";
	
	//Scenario input values 
	public static final String DVR_SERVICE = "DVR Service";
	public static final String HD_SERVICE = "HD Service";
	public static final String NBR_TVS = "Number of TVs";
	public static final String SECURITY_SYSTEM = "Security System";
	public static final String DHP_PBB = "DHP PBB";
	public static final String BUNDLE_BREAK_REASON = "Bundle Break Reason";
	public static final String INTRALATA_CARRIER_NAME = "Intralata Carrier Name";
	public static final String INTERLATA_CARRIER_NAME = "Interlata Carrier Name";
	public static final String INTRALATA_REASON_CODE = "Intralata Reason Code";
	public static final String INTERLATA_REASON_CODE = "Interlata Reason Code";
	public static final String FEATURE_SECTION = "Feature Section";
	public static final String ADDITIONAL_FEATURE = "Additional Feature";
	public static final String CUST_SSN = "SSN";
	public static final String CUST_DOB = "Date Of Birth";
	public static final String CUST_OWNS_RENTS = "Customer Owns Or Rents";
	public static final String QUOTED_ETF = "Quoted Early Termination Fees";
	public static final String QUOTED_PRORATED_CHRGS = "Quoted Prorated Charges";
	public static final String RECAP_DONE = "Recap Done";
	public static final String DTV_MONTHLY_CHARGE = "DTV Charges";
	public static final String CPNI_TYPE_CHANGE = "One Time or Perm Change";
	public static final String CPNI_APPROVAL_STATUS = "CPNI Approval Status";
	public static final String CPNI_METHOD_OF_APPROVAL = "Method of Approval";
	public static final String CPNI_AUTHORIZED_PARTY = "Authorized Party";
	public static final String SPECIAL_INSTRUCTIONS = "Special Instructions";
	
	//Browsers
	public static final String CHROME = "Chrome";
	public static final String FIREFOX = "FireFox";
	public static final String INTERNET_EXPLORER = "IE";
	public static final String PHANTOM_JS = "PhantomJS";
	public static final String HTML_UNIT = "HtmlUnitDrive";
	public static final String DEFAULT_BROWSER = "DefaultBrowser";
	public static final String BROWSER_RUN_LOCATION = "BrowserRunLocation";
	public static final String BROWSER_REMOTE = "Remote";
	public static final String BROWSER_LOCAL = "Local";
	public static final String BROWSER_SERVER_URL = "BrowserServerUrl";
	
	
	// frames
	public static final String MAIN_FRM = "MainFrame";	
	public static final String ORDERING_ACTIONS_LOWER_FRM = "OrderActionsLowerFrm";
	public static final String CONFIGURATIONS_LOWER_FRM = "ConfigurationsLowerFrm";
	public static final String SUMMARY_LOWER_FRM = "SummaryLowerFrm";
	public static final String PRODUCT_CONFIG_FRM = "productConfigFrame";
	//added by ab31422 	
	public static final String FEATURE_CONFIG_FRM = "featureConfigFrame";
	public static final String REVIEW_DIALOG_IFRM = "ReviewDialogIframe";
	public static final String UNKNOWN_FRM = "UnknownFrm";
	public static final String Winback_IFRM = "winbackFrame";
	public static final String CUSTOMER_DASHBOARD_LOWER_FRM = "CustomerDashboardLowerFrm";
	public static final String BILLING_LOWER_FRM = "BillingLowerFrm";
	public static final String SERVICES_LOWER_FRM = "ServicesLowerFrm";
	public static final String SUPPORT_LOWER_FRM = "SupportLowerFrm";
	public static final String BILLING_ADDRESS_FRM = "BillingAddressFrm";
	public static final String EDIT_CUSTOMER_INFO_FRM = "EditCustomerInfoFrm";
	public static final String VERIFY_LAYER_FRM = "verifyLayerFrm";

	// used by Run Data, constants
	//BROWSER_SERVER_URL
	//DEFAULT_BROWSER
	//DB_ENVIROMENT
	//BAN
	//CUST_TYPE
	//CUST_FIRST_NAME
	//CUST_LAST_NAME
	//SERVICE_ADDRESS
	public static final String ORDER_ID = "orderId";
	public static final String PRODUCT_ID = "prodId";
	
	/*AB65305 - Added new field*/	
	public static final String FILTER_ADDRESS = "filterAddress";
	/*AB62078 - Added new fields for directory listing*/
	public static final String TEST_FIRST_NAME = "NegFirstName";
	public static final String TEST_LAST_NAME = "NegLastName";
	public static final String TEST_LIST_NUMBER = "HouseNo";
	public static final String TEST_LIST_STREET = "StreetName";
	public static final String TEST_LIST_ZIP = "Zip";
	public static final String TEST_LIST_TITLE1 = "Title1";
	public static final String TEST_LIST_TITLE2 = "Title2";
	public static final String TEST_LIST_PLA = "Pla";
	public static final String TEST_LIST_LINEAGE_TITLE = "LineageTitle";
	public static final String TEST_LIST_NICKNAME = "Nickname";
	public static final String TEST_LIST_DESIGNATION = "Designation";
	/*AB62078 - Added new fields for Validation - CIP*/
	public static final String VAL_NAME = "ValName";
	public static final String VAL_CBR = "ValCbr";
	public static final String VAL_CBR_ALPHA = "ValCbrAlpha";
	public static final String VAL_CBR_NO = "ValCbrNo";
	public static final String VAL_REMARKS = "ValRemarks";
	
	
}
