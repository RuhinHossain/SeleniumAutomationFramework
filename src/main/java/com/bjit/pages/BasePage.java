package com.bjit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bjit.drivers.DriverManager;
import com.bjit.enums.WaitStrategy;
import com.bjit.factories.ExplicitWaitFactory;
import com.bjit.reports.ExtentLogger;

public class BasePage {

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	protected void click(By by, WaitStrategy waitstrategy, String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
		element.click();
		ExtentLogger.pass(elementname+" is Clicked", true);
	}

	protected void sendText(By by, String value, WaitStrategy waitstrategy, String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
		element.sendKeys(value);
		ExtentLogger.pass(value+" is entered successfully into "+elementname+" field", true);
	}
	
	protected void clearText(By by, WaitStrategy waitstrategy){
		WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
		element.clear();
	}
}
