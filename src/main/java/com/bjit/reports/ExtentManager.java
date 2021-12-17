package com.bjit.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	private ExtentManager() {
	}

	private static final ThreadLocal<ExtentTest> extent = new ThreadLocal<>();

	static ExtentTest getExtentTest() {
		return extent.get();
	}

	static void setExtentTest(ExtentTest test) {
		extent.set(test);
	}

	static void unload() {
		extent.remove();
	}
}
