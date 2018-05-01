package com.puma.POM;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.puma.UtillLib.BasePage;
/**
 * 
 * @author tarkeshwar
 *
 */
public class HomePage extends BasePage {

	@FindBy(xpath="//ul[@class='products-grid products-grid--max-4-col first last odd']/li[2]")
	WebElement secondItem;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	/**
	 * 
	 * @param menutype
	 * @param subCatagray
	 * @param options
	 */
	public void naviGateToMenue(String menutype , String subCatagray , String options) {
		Actions a = new Actions(driver);
		String dynamicXpath = "//a[text()='"+subCatagray+"' and contains(@href,'"+menutype+"')]/../../following-sibling::li/a[text()='"+options+"']";

		a.moveToElement(driver.findElement(By.linkText(menutype.toUpperCase()))).perform();
		WebElement element=driver.findElement(By.xpath(dynamicXpath));
		verifyElement(driver, element);
		element.click();
	}
	public void scrollToElementAndClick()
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		 Point y = secondItem.getLocation();
		 j.executeScript("window.scrollTo(0,"+y+")");
		 VerifyElementIsClickable(driver, secondItem);
		 ArrayList<String> lstWindows = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(lstWindows.get(1));
	}
	
	public void verfiyTitle()
	{
		
		verifyTitle(driver, "Buy Sports T-Shirts, Tracks, Running Shoes and Accessories Online - in.puma.com");
	}
	
	public String productText()
	{
		return secondItem.getText();
	}


}
