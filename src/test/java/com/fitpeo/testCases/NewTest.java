package com.fitpeo.testCases;

import org.testng.annotations.Test;

import com.fitpeo.baseClass.baseClass;
import com.fitpeo.pages.homepage;
import com.fitpeo.pages.revenueCalculatorPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class NewTest extends baseClass {
	homepage hp;
	revenueCalculatorPage rc;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		launchThebrowser();
	 hp=new homepage(driver);
	 rc=new revenueCalculatorPage(driver);
		
	}

	
	
	
	@Test
	public void f() throws InterruptedException {
		
		hp.checkUserOnHomepage(driver);
		hp.clickOnrevenueCalCulator();
		rc.navigateUptoSliderIsVisible(driver);
		
		rc.adjustTheSlider(driver);
		/* slider gets the value either 816 or 823 -- 
		it doesn't take exact value of slider ==820*/
		
		rc.checkValueInSliderTextFiled();
		
		rc.setValueOfSliderAt560(driver);
		/*after setting value to 560 in slider text-field
		according to that value cursor is not responding, but by using manual
		it works perfectly fine */
		
		rc.selectCptAndCheckTotalRecurringReimbursement(driver);
		/* according to text-field - if we automate & change the value of text-field then 
		 slider is not responding according to value in slider text field*/
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(8000);
		//driver.quit();
	}

}
