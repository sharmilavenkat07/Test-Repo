package org.page.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pack.base.BaseTestNG;

public class HomePageT extends BaseTestNG{
	public HomePageT() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Best Sellers'])[1]")
	public WebElement category;
	@FindBy(xpath = "(//a[text()='Books'])[2]")
	public WebElement book;
	@FindBy(partialLinkText = "I Don't Love You Anymore")
	public WebElement choose;
	@FindBy(xpath="//a[text()='Sell']")
	public WebElement sell;
	@FindBy(xpath = "//a[text()='Mobiles']")
	public WebElement phone;


}
