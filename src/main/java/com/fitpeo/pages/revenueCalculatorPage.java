package com.fitpeo.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class revenueCalculatorPage {

	@FindBy(xpath = "//p[text()='CPT-99091']")
	private WebElement cpt;

//adjust the slider

	@FindBy(xpath = "//span[@class='MuiSlider-track css-10opxo5']")
	private WebElement slider;
	@FindBy(xpath = "(//input[@value='820'])[1]")
	private WebElement dest;

//check value in slider textfield

	@FindBy(xpath = "//input[@type='number']")
	private WebElement value;

//set value of slider to 560 

	@FindBy(xpath = "//input[@type='number']")
	private WebElement sliderTextField;

	@FindBy(xpath = "//input[@type='range']")
	private WebElement updateValueOfSlider;
	
	
	//select cpt 
	@FindBy(xpath="//span[text()='57']")private WebElement cpt1;
	@FindBy(xpath="//span[text()='19.19']")private WebElement cpt2;
	@FindBy(xpath="//span[text()='63']")private WebElement cpt3;
	@FindBy(xpath="//span[text()='15']")private WebElement cpt4;
	
	@FindBy(xpath="//p[text()='CPT-99457']")private WebElement cpt5;
	@FindBy(xpath="//p[text()='CPT-99487']")private WebElement cpt6;
	
	@FindBy(xpath="//span[text()='Patients should be between 0 to 2000']")private WebElement medical;
	


	WebDriverWait w;
	Actions a;

	public revenueCalculatorPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void navigateUptoSliderIsVisible(WebDriver driver) {

		a = new Actions(driver);
		a.moveToElement(cpt).build().perform();

		Reporter.log("user move upto slider", true);

	}

	public void adjustTheSlider(WebDriver driver) throws InterruptedException {
		Thread.sleep(1500);

		// a.dragAndDropBy(source, 107, 0).build().perform();
		a.clickAndHold(slider).moveByOffset(108, 0).build().perform();

	}

	public void checkValueInSliderTextFiled() {

		String exactValue = value.getAttribute("value");
		String expectedValue = "823";

		Assert.assertEquals(exactValue, expectedValue,
				"if Exact value & expected value is not match then our TC is failed.");

		Reporter.log("check slider value is set to be 823", true);
	}

	public void setValueOfSliderAt560(WebDriver driver) throws InterruptedException {

		w = new WebDriverWait(driver, Duration.ofSeconds(30));

		Thread.sleep(1500);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);

		jse.executeScript("arguments[0]. value='560';", value);
		Reporter.log("check after setting slider value to 560 then slider move accordingly", true);
		Thread.sleep(1500);
		String sliderValue = w.until(ExpectedConditions.elementToBeClickable(updateValueOfSlider)).getText();
		System.out.println(sliderValue);
	}
	
	
	public void selectCptAndCheckTotalRecurringReimbursement(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(1500);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);

		jse.executeScript("arguments[0]. value='820';", value);
		
		a.moveToElement(cpt5).build().perform();
		
		w.until(ExpectedConditions.elementToBeClickable(cpt1)).click();
		w.until(ExpectedConditions.elementToBeClickable(cpt2)).click();
		w.until(ExpectedConditions.elementToBeClickable(cpt3)).click();
		Thread.sleep(2000);
		a.moveToElement(cpt6).build().perform();
		w.until(ExpectedConditions.elementToBeClickable(cpt4)).click();
		
		a.moveToElement(medical).build().perform();
		Thread.sleep(2000);
		jse.executeScript("arguments[0]. value='820';", value);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
