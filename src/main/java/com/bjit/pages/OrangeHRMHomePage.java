package com.bjit.pages;

import org.openqa.selenium.By;

import com.bjit.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage{

	private final By linkWelcome = By.xpath("//*[@id='welcome']");
	private final By linkLogout = By.xpath("//a[text()='Logout']");

	public OrangeHRMHomePage clickWelcomeLink() {
		click(linkWelcome, WaitStrategy.PRESENCE, "Welcome link");
		return this;
	}

	public OrangeHRMLoginPage clickLogoutLink() {
		click(linkLogout, WaitStrategy.CLICKABLE, "Logout button");
		return new OrangeHRMLoginPage();
	}	
}