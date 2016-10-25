package com.centurylink.simong_app.pageobjects;

import static com.centurylink.simong_app.weboperations.PageParmDefinitions.BILLING_ADDRESS_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.BILLING_LOWER_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.CONFIGURATIONS_LOWER_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.CUSTOMER_DASHBOARD_LOWER_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.EDIT_CUSTOMER_INFO_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.FEATURE_CONFIG_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.MAIN_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.ORDERING_ACTIONS_LOWER_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.PRODUCT_CONFIG_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.REVIEW_DIALOG_IFRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.SERVICES_LOWER_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.SUMMARY_LOWER_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.SUPPORT_LOWER_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.UNKNOWN_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.VERIFY_LAYER_FRM;
import static com.centurylink.simong_app.weboperations.PageParmDefinitions.Winback_IFRM;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameHandler {

	public void loadDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void loadFrame(WebDriver driver,String theFrametoLoad) {
		
		try {
				
			if (theFrametoLoad.equals(MAIN_FRM)) {
				try {
					
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					Thread.sleep(1000);
					driver.switchTo().frame(0);					
					Thread.sleep(1000);					
					
				} catch (Exception e) {
					System.out.println("frame not found :mainframe");
				}
			} else {
				String xpath = getFrameName(theFrametoLoad);
							
				if (theFrametoLoad.equals(BILLING_ADDRESS_FRM)
									|| theFrametoLoad.equals(PRODUCT_CONFIG_FRM) || theFrametoLoad.equals(FEATURE_CONFIG_FRM) ) {
					loadFrameWithWait(driver,xpath);
				} else {
					if (theFrametoLoad.equals(REVIEW_DIALOG_IFRM)	|| theFrametoLoad.equals(Winback_IFRM)) {
						checkIfOnMainFrame(driver);
						driver.switchTo().frame(xpath);
						Thread.sleep(1000);
					} else if (theFrametoLoad.equals(VERIFY_LAYER_FRM)){
						driver.switchTo().frame(xpath);
					}else {
						checkIfOnMainFrame(driver);
						loadFrameWithWait(driver,xpath);
					}
				}
				
			}
		} catch (Exception e) {
			
			fail("Failed to load the frame " + theFrametoLoad + " "
					+ e.getMessage());
		}

	}

	private void checkIfOnMainFrame(WebDriver driver) throws InterruptedException {
		try {			
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.switchTo().frame(0);					
			Thread.sleep(1000);					
			
		} catch (Exception e) {
			System.out.println("frame not found :mainframe");
		}
	}

	private void loadFrameWithWait(WebDriver driver,String xpath) throws InterruptedException {
		WebDriverWait dWait = new WebDriverWait(driver, 60);
		WebElement frame = dWait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(xpath)));
		driver.switchTo().frame(frame);
		Thread.sleep(500);
	}

	private String getFrameName(String theFrametoLoad) {
		String frameName = "";
		switch (theFrametoLoad) {
		case ORDERING_ACTIONS_LOWER_FRM:
			frameName = "//*[@id='SHOP']/iframe";
			break;
		case CONFIGURATIONS_LOWER_FRM:
			frameName = "//*[@id='SHOP']/iframe";
			break;
		case SUMMARY_LOWER_FRM:
			frameName = "//*[@id='SHOP']/iframe";
			break;
		case REVIEW_DIALOG_IFRM:
			frameName = "reviewDialogIframe";
			break;
		case Winback_IFRM:
			frameName = "winbackFrame";
			break;
		case CUSTOMER_DASHBOARD_LOWER_FRM:
			frameName = "//*[@id='DASHBOARD']/iframe";
			break;
		case BILLING_LOWER_FRM:
			frameName = "//*[@id='BILLING']/iframe";
			break;
		case SERVICES_LOWER_FRM:
			frameName = "//*[@id='SERVICES']/iframe";
			break;
		case SUPPORT_LOWER_FRM:
			frameName = "//*[@id='SUPPORT']/iframe";
			break;
		case BILLING_ADDRESS_FRM:
			frameName = "//*[@id='billingAddressFrame']";
			break;
		case PRODUCT_CONFIG_FRM:
			frameName = "//*[@id='productConfigFrame']";
			break;
			
		case FEATURE_CONFIG_FRM:
			frameName = "//*[@id='featureConfigFrame']";
			break;	
		case EDIT_CUSTOMER_INFO_FRM:
			frameName = "//*[@id='editCustInfoFrame']";
			break;
		case VERIFY_LAYER_FRM:
			frameName = "verifyLayerIframe";
			break;
		}
		return frameName;
	}

}
