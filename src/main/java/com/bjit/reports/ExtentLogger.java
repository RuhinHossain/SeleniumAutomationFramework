package com.bjit.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.bjit.enums.ConfigProperties;
import com.bjit.utils.PropertyUtils;
import com.bjit.utils.ScreenshotsUtils;

public final class ExtentLogger {
	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(String message){
		ExtentManager.getExtentTest().info(message);
	}
	
	public static void pass(String message, boolean isScreenshotNeeded){
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64Image()).build());
		}else {
			info(message);
			pass(message);
		}
	}
	
	public static void fail(String message, boolean isScreenshotNeeded){
		if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64Image()).build());
		}else{
			fail(message);
		}
	}
	public static void skip(String message, boolean isScreenshotNeeded){
		if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64Image()).build());
		}else{
			skip(message);
		}
	}
}
