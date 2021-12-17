package com.bjit.pages;

import org.openqa.selenium.By;

import com.bjit.enums.WaitStrategy;

/*
 * Assertions should not be called in page layers
 * All the page methods needs to have some return type
 */
public final class OrangeHRMLoginPage extends BasePage {

	private final By textboxUsername = By.id("txtUsername");
	private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By btnLogin = By.xpath("//input[@id='btnLogin' and @value='LOGIN']");

	public OrangeHRMLoginPage enterUserName(String userName) {
		clearText(textboxUsername, WaitStrategy.PRESENCE);
		sendText(textboxUsername, userName, WaitStrategy.PRESENCE, "Username");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		clearText(textboxPassword, WaitStrategy.PRESENCE);
		sendText(textboxPassword, password, WaitStrategy.PRESENCE, "Password");
		return this;
	}

	public OrangeHRMHomePage clickLoginbtn() {
		click(btnLogin, WaitStrategy.CLICKABLE, "Login button");
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}
}
