package com.puma.UtillLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
/**
 * 
 * @author tarkeshwar
 *
 */
public abstract class BasePage implements IAutoConst {
	public WebDriver driver;
	/**
	 * 
	 * @param driver
	 * @param title
	 */
	public void verifyTitle(WebDriver driver,String title)
	{
	
		String ETitle=driver.getTitle();
		Reporter.log(ETitle, true);
		try
		{
			Assert.assertEquals(title, ETitle);
			Reporter.log("Expected title is matching with Actual title", true);
		}
		catch (Exception e) {
			Reporter.log("Actuall title is not matching with Expected title", true);
		}
		
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void verifyElement(WebDriver driver,WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, ETO);
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("The element is visible", true);
		}
		catch (Exception e) {
			Reporter.log("Element still not visible after 50000 ms", true);
		}
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void VerifyElementIsClickable(WebDriver driver,WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, ETO);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Reporter.log("The element is clickable", true);
			element.click();
		}
		catch (Exception e) {
			Reporter.log("Element is still not clickable after 50000 ms", true);
		}
	}

}
