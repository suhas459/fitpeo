package com.fitpeo.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class homepage {

@FindBy(xpath="//div[text()='Home']") private WebElement home;
@FindBy(xpath="//div[text()='Revenue Calculator']")private WebElement revenueCalCulator;



WebDriverWait w;
public homepage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	
}
	
	
	public void checkUserOnHomepage(WebDriver driver) {
		
		w=new WebDriverWait(driver, Duration.ofSeconds(30));

		String act = w.until(ExpectedConditions.visibilityOf(home)).getText();
		String exp = "Home";
		
		Assert.assertEquals(act,exp);
		
		Reporter.log("Validate user is on the homepage checking text - home", true);
		
	}
	
	
	public void clickOnrevenueCalCulator() {
		
		w.until(ExpectedConditions.elementToBeClickable(revenueCalCulator)).click();
		
		Reporter.log("user click on the Revenue Calculator", true);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
