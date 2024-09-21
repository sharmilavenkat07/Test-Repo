package org.page.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pack.base.BaseTestNG;

public class LoginPageT extends BaseTestNG{
	public LoginPageT() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="user-name")
	public WebElement userName;
	@FindBy(id = "password")
	public WebElement passWord;
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement logIn;
}
