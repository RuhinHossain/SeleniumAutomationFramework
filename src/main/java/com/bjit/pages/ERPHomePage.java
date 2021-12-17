package com.bjit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.bjit.enums.WaitStrategy;

public final class ERPHomePage extends BasePage {
	private final By linkWelcome = By.xpath("//span[text()='MD. Ruhin Hossain Gazi']");
	private final By linkLogout = By.xpath("//a[text()='Log out']");
	private final By dailyReportLink = By.xpath("//*[@id='sidebar']/li[2]/a/img");
	private final By btnCreate = By.xpath("//button[contains(text(),'Create')]");
	private final By linkAddItem = By.xpath("//a[contains(text(),'Add an item')]");
	private final By textfieldStartTime = By.xpath("//input[@name='start_time']");
	private final By textfieldEndTime = By.xpath("//input[@name='end_time']");
	private final By textArea = By.xpath("//textarea[@name='activity_details']");

	public ERPHomePage cliclDailyReportLink() {
		click(dailyReportLink, WaitStrategy.CLICKABLE, "Click on daily report link");
		return this; 
	}

	public ERPHomePage clickcreateBtn(){
		click(btnCreate, WaitStrategy.CLICKABLE, "Create button");
		return this;
	}
	
	public ERPHomePage clickAddItem(){
		click(linkAddItem, WaitStrategy.CLICKABLE, "Add item button");
		return this;
		
	}
	
	public ERPHomePage inputText(String text){
		clearText(textfieldStartTime, WaitStrategy.PRESENCE);
		sendText(textArea, text, WaitStrategy.CLICKABLE, "Input text");
		return this;
	}
	
	public ERPHomePage enterStartTime(String starttime){
		clearText(textfieldStartTime, WaitStrategy.PRESENCE);
		sendText(textfieldStartTime, starttime, WaitStrategy.PRESENCE, "Starttime");
		return this;
	}
	
	public ERPHomePage enterEndTime(String endtime){
		clearText(textfieldEndTime, WaitStrategy.PRESENCE);
		sendText(textfieldEndTime, endtime, WaitStrategy.PRESENCE, "Endtime");
		return this;
	}
	
	public ERPHomePage clickRuhinDropdownLink() {
		click(linkWelcome, WaitStrategy.PRESENCE, "Welcome link");
		return this;
	}

	public ERPLoginPage clickLogoutLink() {
		click(linkLogout, WaitStrategy.CLICKABLE, "Logout button");
		return new ERPLoginPage();
	}
	
	public ERPHomePage alertHandle(){
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
//		DriverManager.getDriver().switchTo().alert().accept();
		return this;
	}
	public String getCreatePageTitle() {
		return getPageTitle();
	}
}
