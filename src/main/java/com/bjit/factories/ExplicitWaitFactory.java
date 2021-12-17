package com.bjit.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bjit.constants.FrameworkConstants;
import com.bjit.drivers.DriverManager;
import com.bjit.enums.WaitStrategy;

public class ExplicitWaitFactory {

	public static WebElement performExplicitWait(By by, WaitStrategy waitstrategy) {
		WebElement element = null;
		if (waitstrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitlywait())
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitstrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitlywait())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}else if(waitstrategy == WaitStrategy.VISIBLE){
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitlywait())
			.until(ExpectedConditions.visibilityOfElementLocated(by));
		}else if(waitstrategy == WaitStrategy.NONE){
			DriverManager.getDriver().findElement(by);
		}
		return element;
	}
}
