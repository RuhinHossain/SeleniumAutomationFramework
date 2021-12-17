package com.bjit.pages;

import org.openqa.selenium.By;

import com.bjit.enums.WaitStrategy;

public final class ERPLoginPage extends BasePage{
	private final By textboxUsername = By.xpath("//input[@id='login' and @type='text']");
	private final By textboxPassword = By.xpath("//input[@id='password' and @type='password']");
	private final By btnLogin = By.xpath("//button[text()='Log in' and @type='submit']");

	public ERPLoginPage enterUserName(String userName) {
		clearText(textboxUsername, WaitStrategy.PRESENCE);
		sendText(textboxUsername, userName, WaitStrategy.PRESENCE, "Username");
		return this;
	}

	public ERPLoginPage enterPassword(String password) {
		clearText(textboxPassword, WaitStrategy.PRESENCE);
		sendText(textboxPassword, password, WaitStrategy.PRESENCE, "Password");
		return this;
	}

	public ERPHomePage clickLoginbtn() {
		click(btnLogin, WaitStrategy.CLICKABLE, "Login button");
		return new ERPHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}
}
