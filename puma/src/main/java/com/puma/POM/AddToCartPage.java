package com.puma.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.puma.UtillLib.BasePage;
/**
 * 
 * @author tarkeshwar
 *
 */
public class AddToCartPage extends BasePage {
	@FindBy(xpath="//div[@class='product-name']/h1")
	private WebElement productName;
	@FindBy(xpath="//*[@id=\"old-price-71793\"]")
	private WebElement productPrice;
	@FindBy(xpath="//div[@class='product-size-click-btn']")
	private WebElement productSizeClkBtn;
	@FindBy(xpath="//a[@name='8']/span[contains(.,'8')]")
	private WebElement size;
	@FindBy(xpath="//button[@onclick='productAddToCartForm.submit(this)']")
	private WebElement addToCart;
	@FindBy(xpath="//h2[@class='product-name']/a")
	private WebElement productNameCart;
	@FindBy(xpath="//td[@class='product-cart-price']/span")
	private WebElement productPriceCart;
	
	
	public AddToCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void clkAddToCartBtn()
	{
		productSizeClkBtn.click();
		size.click();
		VerifyElementIsClickable(driver, addToCart);
	}
	public void verifyCartItem()
	{
		verifyElement(driver, productNameCart);
		String expectedName=productName.getText();
		String AtualName=productNameCart.getText();
		Assert.assertEquals(AtualName.toUpperCase(), expectedName.toUpperCase());
	}
}
