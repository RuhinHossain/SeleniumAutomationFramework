package com.bjit.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bjit.constants.FrameworkConstants;
import com.bjit.enums.CategoryType;

public class ExtentReport {
	public static ExtentReports reports;

	private ExtentReport() {
	}

	public static void initReports() {
		if (Objects.isNull(reports)) {
			reports = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			reports.attachReporter(spark);

			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Selenium Automation Training");
		}
	}

	public static void flushReport() throws IOException {
		if (Objects.nonNull(reports)) {
			reports.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
	}

	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(reports.createTest(testcasename));
	}

	public static void addCategories(CategoryType[] categories) {
		for(CategoryType temp:categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}

	public static void addAuthors(String[] authors) {
		for(String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}
}
