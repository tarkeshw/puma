package com.puma.UtillLib;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.puma.UtillLib.IAutoConst;

public abstract class BaseTest implements IAutoConst {

	public WebDriver driver;
	 
	 @BeforeMethod
	 public void openBrowser()
	 {
		 System.setProperty(CHROME_KEY, CHROME_VALUE);
		 driver = new ChromeDriver();
		 driver.get(URL);
		 driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		 driver.manage().window().maximize(); 
	 }
	
	 @AfterMethod
	 public void closeBrowser(){
		 driver.quit();
	
	 }
}
